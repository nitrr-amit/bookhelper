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
                     <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>
                     	 
			   </ul>
			   
	      </div>
	 </div>
	 
	 <%String msg=(String)request.getAttribute("book_found_table2");
	    if(msg!=null){
	 %>
	 <%=msg.toUpperCase()
	 
	 %>
	 <%} %>
	
	
	  <div class="form">
			
		<form action="ImageUploadDbServlet" method="post" enctype="multipart/form-data">
			
			<legend style="color:black;">ADD BOOK Images</legend>
			<br>
			<% Integer id=(Integer)request.getAttribute("id"); %>

			<input type="hidden" name="id" value="<%= id %>">
			
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
			<input type="submit" value="ADD" style="float:right;color:black;">
			
			
		</form> 
	</div>
	
	
  
  </div>

</body>
</html>
