package bookhelper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookhelper.dao.impl.UserDaoImpl;
import bookhelper.pojo.User;
import bookhelper.util.EmailUtil;
import bookhelper.util.OtpGenerator;

public class EmailVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EmailVerificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session=request.getSession();
		User user=null;
		//User user=(User)session.getAttribute("temp_user");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String email_id=request.getParameter("email_id");
		String password=request.getParameter("password");
		
		 user =new User(name,mobile,email_id,password);

		UserDaoImpl dao=new UserDaoImpl();
		if(dao.isUserExist(user)){
			String msg="User"+user.getEmail_id()+" is already registered";
		 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		 request.setAttribute("user_already_exist", msg);
		 rd.forward(request, response);
		}else{
		  session.setAttribute("temp_user",user);
		 
		  
		  String msg=""+ OtpGenerator.generateOtp();
		   String subject="email verification otp";
		    if(EmailUtil.sendEmail(email_id, msg, subject)){
			session=request.getSession();
			session.setAttribute("otp",msg);
			 RequestDispatcher rd=request.getRequestDispatcher("otp.jsp");
			 rd.forward(request,response);
		     }else{
			
			System.out.println("email sending problem");
		         }
	          }
	}
}
