
package bookhelper.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import bookhelper.dao.BookDao;
import bookhelper.pojo.Book;
import bookhelper.pojo.User;
import bookhelper.util.DbUtil;

public class BookDaoImpl implements BookDao{

	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer searchBook(String book_name,String book_author){
		
		Integer id=null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table where book_name=? and book_author=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,book_name);
			pstmt.setString(2,book_author);
	      rs = pstmt.executeQuery();
	      if(rs.next()){
				 id=rs.getInt("id");
				
			}else{
				System.out.println("error in UserDaoImpl.addUser or book not exist");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;

	}
	
	public boolean addBook_table1(String book_name,String book_author){
		boolean result=false ;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DbUtil.getConnection();
			String sql="insert into  bh_book_table(id,book_name,book_author) values(bh_seq.nextval,?,?)";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,book_name);
			pstmt.setString(2,book_author);
			int r = pstmt.executeUpdate();
			if(r==1){ 
				result=true;
			}else{
				System.out.println("error in add Book");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

}
	
	public boolean addBook_table2(Book book,String email_id){
		boolean result=false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DbUtil.getConnection();
			String sql="insert into  bh_book_table2(id,email_id,price,when_added,approved,rating) values(?,?,?,sysdate,'no',0)";
			pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1,book.getId());
			pstmt.setString(2,email_id);
			pstmt.setFloat(3,book.getPrice());
			
			
			int r = pstmt.executeUpdate();
			if(r==1){ 
				result=true;
			}else{
				System.out.println("error in add Book table2");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
	
	public boolean searchBook_table2(Integer id,String email_id){
		boolean result=false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table2 where id=? and email_id=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,email_id);
			
	     rs = pstmt.executeQuery();
	      if(rs.next()){ 
		       result=true;
		  }else{
				System.out.println("error in book search 2");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
		
	public List<Book> ShowAllBook(String email_id){
		List<Book> list=new ArrayList<Book>();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table2 where email_id=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,email_id);
	      rs = pstmt.executeQuery();
	      while(rs.next()){
				Integer id=rs.getInt("id");
				Float price=rs.getFloat("price");
				
				Date date=rs.getDate("when_added");
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
				 String when_added=sdf.format(date);
				 
				 Book book=new Book();
				 book.setId(id);
				 book.setPrice(price);
				 book.setWhen_added(when_added);
				 
				 
				String sql2="select * from bh_book_table where id=?";
				 pstmt  = con.prepareStatement(sql2);
				 pstmt.setInt(1,book.getId());
			     rs2 = pstmt.executeQuery();
			     
			     if(rs2.next()){
			    	 String book_name=rs2.getString("book_name");
			    	 String book_author=rs2.getString("book_author");
                       
			    	 book.setBook_name(book_name);
			    	 book.setBook_author(book_author);
			         }		 
			     
				list.add(book);
				
			}
		//end of try block
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	
	}//end of show all book
	
	public boolean updateBook_table2(Integer id,String email_id,Float price){
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result=false;
		try{
			con = DbUtil.getConnection();
			String sql="update bh_book_table2 set price=? where email_id=? and id=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setFloat(1,price);
			pstmt.setString(2,email_id);
			pstmt.setInt(3,id);
			
	     int update = pstmt.executeUpdate();
	      if(update==1){ 
		       result=true;
		  }else{
				System.out.println("price does   not updated");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
		
	}
	
	public boolean  deleteBook_table(Integer id,String email_id){
		
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result1=false;
		boolean result2=false;
		boolean result=false;
		try{
			con = DbUtil.getConnection();
			String sql="delete from bh_book_table2 where id=? and email_id=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,email_id);
	        int del = pstmt.executeUpdate();
			      if(del==1){
						result1=true;
						
			      } else{
			    	  
			    	  System.out.println("errror in delete book table2");
			      }
				 
				String sql2="delete from bh_image_table where id=? and email_id=?";
				 pstmt  = con.prepareStatement(sql2);
				 pstmt.setInt(1,id);
				 pstmt.setString(2,email_id);
			     int del2 = pstmt.executeUpdate();
			     
			    if(del2==1){
			    	 result2=true;
			      }else{
				   System.out.println("error in bh_image table");
				   
			      }		 
			  if(result1&result2){
				  result=true;
				  
			  } else{
				  System.out.println("error in result1 and result2");
			  }  
				
			
		//end of try block
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
		
		
		
		
	}
	public Book searchBook2ByBookName(String book_name){
          Book book=null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			con = DbUtil.getConnection();
			System.out.println("--------------------------------------");
			String sql="select * from bh_book_table where lower(book_name) like lower(\'%"+book_name+"%\')";
			System.out.println("book name"+book_name);
			pstmt  = con.prepareStatement(sql);
			
			
	      rs = pstmt.executeQuery();
	      if(rs.next()){
	    	  book_name=rs.getString("book_name");
	    	  System.out.println("hre the book name-----"+book_name);
	    	  String book_author=rs.getString("book_author");
	    	  System.out.println("hre the book author-----"+book_author);
				Integer id=rs.getInt("id");
				System.out.print("here id is =="+id);
				book=new Book();
				book.setBook_name(book_name);
				book.setBook_author(book_author);
				book.setId(id);
				
			}else{
				System.out.println("error in UserDaoImpl.search user by book name or book not exist");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;

	}
	
	
	public   Book searchBook2ByBookAuthor(String book_author){
		   
Book book=null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table where lower(book_author) like lower(\'%"+book_author+"%\')";
			pstmt  = con.prepareStatement(sql);
			
			
	      rs = pstmt.executeQuery();
	      if(rs.next()){
	    	  book_author=rs.getString("book_author");
	    	  String book_name=rs.getString("book_name");
	    	  
				Integer id=rs.getInt("id");
				book=new Book();
				book.setBook_name(book_name);
				book.setBook_author(book_author);
				book.setId(id);
				
				
			}else{
				System.out.println("error in.search user by book author or book not exist");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
 
	
	   }
	
	public List<Book> ShowAllBook2(Book book){
		List<Book> list=new ArrayList<Book>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table2 where id=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1,book.getId());
	      rs = pstmt.executeQuery();
	      while(rs.next()){
			   Integer id=rs.getInt("id");
				Float price=rs.getFloat("price");
				String seller_email_id=rs.getString("email_id");
				
				Date date=rs.getDate("when_added");
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
				 String when_added=sdf.format(date);
				 
				 Book book2 = new Book();
				 book2.setBook_name(book.getBook_name());
				 book2.setBook_author(book.getBook_author());
				 
				 book2.setId(id);
				 book2.setPrice(price);
				 book2.setWhen_added(when_added);
				 book2.setSeller_email_id(seller_email_id);
				 
				 
				String sql2="select * from BookHelper_user_table where email_id=?";
				 pstmt  = con.prepareStatement(sql2);
				 pstmt.setString(1,book2.getSeller_email_id());
			     rs2 = pstmt.executeQuery();
			     
			     if(rs2.next()){
			    	 String seller_name=rs2.getString("name");
			    	 String seller_mobile=rs2.getString("mobile");
	                   
			    	 book2.setSeller_name(seller_name);
			    	 book2.setSeller_mobile(seller_mobile);
			         }		 
			     
				list.add(book2);
				
			}
		//end of try block
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}//end of show all book

 public List<Book> ShowAllFreeBook(){
	 List<Book> list=new ArrayList<Book>();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from bh_book_table2 where price=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setFloat(1,(float)0.0);
	      rs = pstmt.executeQuery();
	      while(rs.next()){
				Integer id=rs.getInt("id");
				String email_id=rs.getString("email_id");
				//Float price=rs.getFloat("price");
				
				Date date=rs.getDate("when_added");
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
				 String when_added=sdf.format(date);
				 
				 Book book=new Book();
				 book.setId(id);
				 book.setSeller_email_id(email_id);
				 //book.setPrice(price);
				 book.setWhen_added(when_added);
				 
				 
				String sql2="select * from bh_book_table where id=?";
				 pstmt  = con.prepareStatement(sql2);
				 pstmt.setInt(1,book.getId());
			     rs2 = pstmt.executeQuery();
			     
			     if(rs2.next()){
			    	 String book_name=rs2.getString("book_name");
			    	 String book_author=rs2.getString("book_author");
                    
			    	 book.setBook_name(book_name);
			    	 book.setBook_author(book_author);
			         }		 
			     
				list.add(book);
				
			}
		//end of try block
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	
  }
	
	
		
}

//end
	


