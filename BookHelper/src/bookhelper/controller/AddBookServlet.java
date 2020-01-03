package bookhelper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookhelper.dao.impl.BookDaoImpl;
import bookhelper.pojo.Book;
import bookhelper.pojo.User;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddBookServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String email_id=user.getEmail_id();
		String book_name=request.getParameter("book_name").toLowerCase().trim();
		String book_author=request.getParameter("book_author").toLowerCase().trim();
      
		 
		 
		 String strprice=request.getParameter("price");
		 float price  = Float.parseFloat(strprice);
		 
		 Book book =new Book();
		 
		 book.setPrice(price);
		
		 BookDaoImpl dao=new BookDaoImpl();
		 
		 Integer id=dao.searchBook(book_name, book_author);
		 
		 
		 if(id!=null){
			 book.setId(id);
			 if(dao.searchBook_table2(id,email_id)){//search for book is already added or not
				 String msg="book already added please go to your book list";
				 RequestDispatcher rd =request.getRequestDispatcher("AddBook.jsp");
				 request.setAttribute("book_found_table2", msg);
				 rd.forward(request, response);
				 
			 }else{
				 if(dao.addBook_table2(book,email_id)){
		            	System.out.println("book added succesffully");

		            	String msg="book added sucessfully";
		            	 RequestDispatcher rd =request.getRequestDispatcher("addBookImage.jsp");
						 request.setAttribute("book_added_table2", msg);
						 request.setAttribute("id",book.getId());
						 rd.forward(request, response);
		            }else{
		            	
		            	System.out.println("Error in book adding");
		            }
			 }
		 }else{
			 if(dao.addBook_table1(book_name, book_author)){
				 id=dao.searchBook(book_name, book_author);
				 
				 book.setId(id);
				 if(dao.searchBook_table2(id,email_id)){
					 String msg="book already added please go to your book list";
					 RequestDispatcher rd =request.getRequestDispatcher("AddBook.jsp");
					 request.setAttribute("book_found_table2", msg);
					 rd.forward(request, response);
					 
				 }else{
					 if(dao.addBook_table2(book,email_id)){
			            	System.out.println("book added succesffully");

			            	String msg="book added sucessfully";
			            	 RequestDispatcher rd =request.getRequestDispatcher("addBookImage.jsp");
							 request.setAttribute("book_added_table2", msg);
							 request.setAttribute("id",book.getId());
							 rd.forward(request, response);
			            }else{
			            	
			            	System.out.println("Error in book adding");
			            }
				 }
			 } 
		 }
	
	}

}
