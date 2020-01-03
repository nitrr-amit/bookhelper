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


public class UpdatePriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdatePriceServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		System.out.println(id);
		Float price=Float.parseFloat(request.getParameter("price"));
		BookDaoImpl dao=new BookDaoImpl();
		
		if(dao.updateBook_table2(id, user.getEmail_id(),price)){
		
			RequestDispatcher rd=request.getRequestDispatcher("updateImage.jsp");
			request.setAttribute("id",id);
			request.setAttribute("book_name",book_name);
			request.setAttribute("book_author",book_author);
			rd.include(request,response);
			
			
			
		}else{
			System.out.println("error in update image servlet2");
		}
		
	}

	
}
