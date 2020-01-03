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


public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      HttpSession session=request.getSession();
	      User user=(User)session.getAttribute("temp_user");
		  
	     String user_otp=request.getParameter("user_otp");
	     String otp=(String)session.getAttribute("otp");
	     
	   if(user_otp.equalsIgnoreCase(otp)){     
		
		   
		     UserDaoImpl dao=new UserDaoImpl();
		
			  if(dao.addUser(user)){
				String msg="you are successfully registered..";
		        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("signup_msg",msg);
		      rd.forward(request,response);
			    }else{
				System.out.println("error msg in signup");
			}
		}else{
			System.out.println("Otp is not matched");
		}
		
	}//end of do post

}
