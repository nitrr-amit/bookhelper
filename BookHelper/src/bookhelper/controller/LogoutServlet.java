package bookhelper.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null){
			session.invalidate();
			System.out.println("logout successfully");
			String msg="LOGGED OUT SUCCESSFULLY";
			response.sendRedirect("login.jsp?logout_msg="+msg);
		}else{
		  System.out.println("you are already logged out");
			
		}
		
		
	}

}

	

