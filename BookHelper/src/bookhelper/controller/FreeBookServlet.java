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

/**
 * Servlet implementation class FreeBookServlet
 */
public class FreeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBookServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDaoImpl dao=new BookDaoImpl();
		List<Book> list=dao.ShowAllFreeBook();
		if(list!=null){
		HttpSession session=request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("showfreebook.jsp");
		rd.forward(request,response);
		
			
			
		}
		
	}

}
