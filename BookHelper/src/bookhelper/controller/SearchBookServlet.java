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
import bookhelper.pojo.Book;
import bookhelper.pojo.User;
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchBookServlet() {
        super();
        
    }

	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session=request.getSession();
		//User user=(User)session.getAttribute("user");
		RequestDispatcher rd = null;
		String search_by=request.getParameter("search_by");
		String value=request.getParameter("value");
		System.out.print("--------------------------"+search_by);
		System.out.print("---------------------------------------------"+value);
		BookDaoImpl dao=new BookDaoImpl();
		Book book=null;
		
		if(search_by.trim().equalsIgnoreCase("book_name")){
			book=dao.searchBook2ByBookName(value);
			System.out.println("value come to book name");
		}else{
			book=dao.searchBook2ByBookAuthor(value);
			System.out.println("value come to book name");
		}
		
		
		if(book!=null){
			List<Book> list=dao.ShowAllBook2(book);
			if(list.size()>=1){
				System.out.println("list size"+list.size());
				
				//HttpSession session=request.getSession();
			
				 rd =request.getRequestDispatcher("showAllBySearch.jsp");
				 request.setAttribute("list",list);
				 rd.forward(request, response);
				
			}else{
				System.out.println("No record found in the list");
				String msg="No record found";
				response.getWriter().print("<h1>No book available...</h1>");
				request.setAttribute("no_record_of_book",msg);
				//rd.forward(request,response);
				
			      }
		}else{
			
			System.out.println("book doesnot exist");
			String msg="No record found";
			response.getWriter().print("<h1>No book available...</h1>");
			request.setAttribute("no_record_of_book",msg);
			//rd.forward(request,response);
			
		}
		
	}

}
