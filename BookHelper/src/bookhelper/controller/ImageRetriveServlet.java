package bookhelper.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookhelper.util.DbUtil;

public class ImageRetriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ImageRetriveServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println("---- "+id);
		
		String  img=request.getParameter("img");
		System.out.println("---- "+img);
		
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs  = null;
		ServletOutputStream sos = null;
		//String strng="image1";
		try{
			 con = DbUtil.getConnection();
			 String sql="select * from bh_image_table where id=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1,id);
			 rs  = pstmt.executeQuery();
			 
		   if(rs.next()) {
			   System.out.println("record found");
			   System.out.println(rs.getString("email_id"));
			   InputStream fis = rs.getBinaryStream(img);
			 
			    System.out.println(fis.hashCode());
			   sos=response.getOutputStream();
			   
			   byte[] buffData=new byte[1024*1024];
			   
			   int readLength;
			   while( (readLength = fis.read(buffData))!=-1){
					  sos.write(buffData, 0, readLength);
				  }   
			    
			//   RequestDispatcher rd=request.getRequestDispatcher("imageShow.jsp");
			  // rd.forward(request, response);
		   }
		}catch(SQLException e){
		   System.out.println("DataBase error "+ e.getMessage());
		   e.printStackTrace();
		}catch(IOException e){
			System.out.println("IO ERROR "+ e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
		   System.out.println("ERROR 1"+ e.getMessage());
		   e.printStackTrace();
		}finally{
				if(con!=null){
				   try{
				      con.close();
				   }catch(Exception e){
				     System.out.println("connection closing problem " +e.getMessage());
				   }
				}
				
				 
		}//finally

	}
}
