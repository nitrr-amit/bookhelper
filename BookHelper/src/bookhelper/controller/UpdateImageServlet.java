package bookhelper.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bookhelper.dao.impl.BookDaoImpl;
import bookhelper.pojo.User;
import bookhelper.util.DbUtil;


public class UpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateImageServlet() {
        super();
        
    }

	
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isUploadSuccess =false;
		  
      //Integer id=Integer.parseInt(request.getParameter("id"));// this method not work
		
		Integer id=null;
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		  
				String fileName=null;
				long fileSize1=0;
				long fileSize2=0;
				long fileSize3=0;
				InputStream  is1  =null;
				InputStream  is2  =null;
				InputStream  is3  =null;
				
			 //    id=null;
		
				if(ServletFileUpload.isMultipartContent(request)){
					
					 List<FileItem> fileItemList=null; 
					 
					 try {
						 fileItemList =new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
						 FileItem selecteFileItem = fileItemList.get(0);
						 
						 if(selecteFileItem.isFormField()==true){//means simple data is coming
							 id=Integer.parseInt(selecteFileItem.getString());
						 }
						 
						 
						 selecteFileItem = fileItemList.get(1); //1st blob field
						 if(selecteFileItem.isFormField()==false){//means blob or clob
							 fileSize1 = selecteFileItem.getSize();
							 is1 = selecteFileItem.getInputStream();
						 }
						 
						 selecteFileItem = fileItemList.get(2);
						 if(selecteFileItem.isFormField()==false){//means blob or clob
							 fileSize2 = selecteFileItem.getSize();
							 is2 = selecteFileItem.getInputStream();
						 }
						 
						 selecteFileItem = fileItemList.get(3);
						 if(selecteFileItem.isFormField()==false){//means blob or clob
							 fileSize3 = selecteFileItem.getSize();
							 is3 = selecteFileItem.getInputStream();
						 }
						 
							 Connection con  = null;
							 PreparedStatement pstmt  = null;
							 
							 try{
								 con = DbUtil.getConnection();
								 String sql="update bh_image_table set image1=?,image2=?,image3=? where id=? and email_id=?";
										 
								 pstmt = con.prepareStatement(sql);
								
								pstmt.setBinaryStream(1,is1, (int)fileSize1);
								pstmt.setBinaryStream(2,is2, (int)fileSize2);
								pstmt.setBinaryStream(3,is3, (int)fileSize3);
								pstmt.setInt(4,id);
								pstmt.setString(5,user.getEmail_id());
							    int r =pstmt.executeUpdate();
							    if(r==1){
							    	isUploadSuccess =true;
							    }
							 }catch(Exception e){
								 response.getWriter().print("Error "+ e.getMessage());;
								 e.printStackTrace();
							 }finally{
								 try {
									 DbUtil.closeConnection(con);
								} catch (SQLException e) {
									response.getWriter().print("Error "+ e.getMessage());;
									e.printStackTrace();
								} 
								 
							 }//finally
						
					} catch (FileUploadException e) {
						e.printStackTrace();
					}
					 
				}//is multipart request
				
					
					response.setContentType("text/html");
					response.getWriter().print("<a href='AddBook.jsp'>back to home</a>");
				if(isUploadSuccess){
					response.getWriter().print("<h1>updated successfully</h1>");
				}else{
					response.getWriter().print("upload failed");
					
				}	
					
		
		
		
	 


	}//end of post

}
