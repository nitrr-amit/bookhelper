<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link rel="stylesheet"  type="text/css" href="stylsheets/form.css"> 



</head>
<body>

	
  <div class="bgimage2">
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <li ><a href="main.jsp" style="color:white;text-decoration:none">HOME</a></li>   
                     <li><a href="LogoutServlet" style="text-decoration:none;color:white;">LOGOUT</a></li>
                     <li>ABOUT</li>
                    <li>CONTACT</li>
                     	 
			   </ul>
			   
	      </div>
	 </div>
	 
	
	
	
	  <div class="form">
			
		<form action="UpdateImageServlet" method="post" enctype="multipart/form-data">
			
			<legend style="color:black;">Update Image</legend>
			<br>
			<% Integer id=(Integer)request.getAttribute("id"); %>
			<% String book_name=(String)request.getAttribute("book_name"); %>
			<% String book_author=(String)request.getAttribute("book_author");  System.out.println("-------updateimage.jsp"+id);%>
             
              
			<input type="hidden" name="id" value="<%=id%>">
			
			IMAGE 1::
			<input type="file" name="image1" required>
			<br>
			<br>
			IMAGE 2::
			<input type="file" name="image2" required>
			<br>
			<br>
			IMAGE 3::
			<input type="file" name="image3" reqired>
			<br>
			<br>
			<input type="submit" value="UPDATE" style="float:right;color:black;">
			
			
		</form> 
	</div>
	
	
  
  </div>

</body>
</html>
