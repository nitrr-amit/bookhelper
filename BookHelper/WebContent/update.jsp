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
                    <a href="about.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>	
                     	 
			   </ul>
			   
	      </div>
	 </div>
	 <%
	   String book_name=request.getParameter("book_name");
	 String book_author=request.getParameter("book_author");
	 Integer id=Integer.parseInt(request.getParameter("id"));
	 System.out.println(id+"  "+book_author);
	 
	 
	 %>
	
	
	  <div class="form">
			
		<form action="UpdatePriceServlet" method="post" >
			
			<legend style="color:black;">UPDATE BOOK DETAILS</legend>
			<br>
			<input type="hidden" name="id" value="<%=id%>">
			Book Name:
			<input type="text" name="book_name" value="<%=book_name%>" autofocus required readonly>
			<br>
			Author Name:
			<input type="text" name="book_author" value="<%=book_author%>" autofocus required readonly>
			<br>
			
			Price:
			<input type="number" step="0.01" name="price"  required>
			<br>
			
			<input type="submit" value="update" style="float:right;color:black;">
			
			
		</form> 
	</div>
	
	
  
  </div>

</body>
</html>
