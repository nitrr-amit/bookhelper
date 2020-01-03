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
              	
                    <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>		
			   </ul>
			   
	      </div>
	      
	 
	 </div>
	 <div class="menu2">
	 		<a href="LogoutServlet" style="text-decoration:none;"><button class="logoutbutton">LOGOUT</button></a>
	 		<%if(user!=null){ %>
           	<div style="float:right;line-height:25px; margin-right:25px;"><h4 style="color:yellow;">WELCOME <%= user.getName().toUpperCase() %></h4></div>        
			<%}
			
		 %>	
	      </div>
	  <div class="form">
			
		<form action="#" >
			
			<legend style="color:black;">your payment is successfull:</legend>
			<br>
						   
			Seller will connect to you shortly...
			
		</form> 
	</div>
	
	
  
  </div>

</body>
</html>
