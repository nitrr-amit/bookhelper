package bookhelper.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookhelper.dao.impl.BookDaoImpl;
import bookhelper.pojo.User;
public class ShowAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowAllBookServlet() {
        super();
        
    }

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		 BookDaoImpl dao=new BookDaoImpl();
		 List list=dao.ShowAllBook(user.getEmail_id());
		 if(list!=null){
			 
			 session.setAttribute("list",list);
			 RequestDispatcher rd =request.getRequestDispatcher("showBook.jsp");
			 rd.forward(request,response);
			 
		 }else{
			 System.out.println("the list is empty which is coming from list");
			 
		 }
		 
		 
		
		
	}



}
