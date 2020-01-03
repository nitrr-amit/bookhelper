package bookhelper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookhelper.dao.impl.BookDaoImpl;
import bookhelper.pojo.User;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		BookDaoImpl dao=new BookDaoImpl();
		
		
		if(dao.deleteBook_table(id,user.getEmail_id())){
			RequestDispatcher rd =request.getRequestDispatcher("ShowAllBookServlet");
			 rd.forward(request, response);
			
			
			
		}else{
			
			System.out.println("error in deleting delete servlet");
		}
	}

	
}
