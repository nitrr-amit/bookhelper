<%@page import="bookhelper.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link rel="stylesheet"  type="text/css" href="stylsheets/form.css"> 



</head>
<body>

	<%
	 	User user=(User)session.getAttribute("user");
	%>
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
	 <div class="menu2">
	 		<a href="LogoutServlet" style="text-decoration:none;"><button class="logoutbutton">LOGOUT</button></a>
	 		<%if(user!=null){ %>
           	<div style="float:right;line-height:25px; margin-right:25px;"><h4 style="color:yellow;">WELCOME <%= user.getName().toUpperCase() %></h4></div>        
			<%} else{%>
			
			<%	response.sendRedirect("home.jsp"); %>
			
			<%} %>	
	      </div>
	  <div class="form">
			
		<form action="SearchBookServlet" method="post">
			
			<legend style="color:black;">Search the book:</legend>
			<br>
			<p style="color:white;font-weight:bold;font-size:30px;margin-left:30%" >search by</p>
			<select style="width:100%;margin-top:7px;padding:5px;font-size:15px;" name="search_by">
			    <option value="book_name">BOOK NAME</option>
			    <option value="book_author">BOOK Author</option>
		   </select>
			  <br><br> 
			Book Name:
			<input type="text" name="value" autofocus required>
			<br>
			
			
			<input type="submit" value="SEARCH" style="float:right;color:black;">
			
			
		</form> 
	</div>
	
	
  
  </div>

</body>
</html>
