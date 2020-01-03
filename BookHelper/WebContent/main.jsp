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
                     <a href="main.jsp" ><li >HOME</li></a>
                      <a href="about2.jsp"><li >ABOUT</li></a>
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
	 
	 
	 <div style="height:100%; width:30%">
	 	<button class="buttonmain"><a href="AddBook.jsp" style="color:black;text-decoration:none;font-size:22px;">ADD BOOK</a></button>
	 	<button class="buttonmain"><a href="searchbook.jsp" style="color:black;text-decoration:none;font-size:22px;">SEARCH BOOK</a></button>
	 	<button class="buttonmain"><a href="ShowAllBookServlet" style="color:black;text-decoration:none;font-size:22px;">SHOW ALL BOOK</a></button>
	 	<button class="buttonmain"><a href="DonateBook.jsp" style="color:black;text-decoration:none;font-size:22px;">DONATE BOOK</a></button>
	 	<button class="buttonmain"><a href="FreeBookServlet" style="color:black;text-decoration:none;font-size:22px;">FREE BOOKS</a></button>
	 </div>
	
  
  </div>

</body>
</html>
