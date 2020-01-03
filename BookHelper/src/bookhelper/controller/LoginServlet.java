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


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=null;
		
		String email_id=request.getParameter("email_id");
		String password=request.getParameter("password");
		
		
		user =new User(email_id,password);
		
		UserDaoImpl dao=new UserDaoImpl();
		
		if(dao.isUserExist(user)){
			
             user=dao.loginValidation(email_id, password);
			
			 if(user!=null){
				 System.out.println("login successful;");
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("main.jsp");
				
			}else{
				
				String msg= email_id+" password is incorrect";
				 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				 request.setAttribute("password_error", msg);
				 rd.forward(request, response);
			}
			
		}else{
			
			String msg="User"+user.getEmail_id()+" is not registered..So first please register";
			 RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			 request.setAttribute("registration_error", msg);
			 rd.forward(request, response);
			
			
		}
		
	
		
	}	
	

}
