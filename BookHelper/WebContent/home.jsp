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
   if(user!=null){
	   response.sendRedirect("main.jsp");
   }

%>
  <div class="bgimage">
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <li id="homeid">HOME</li>
                    
                      <a href="http://www.nitrr.ac.in/"><li >NIT Campus</li></a>	
                    <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>					 
			   </ul>
			   
	      </div>
	 
	 </div>
	 
	 <div class="text">
	 
	  <h3>Need a Book in NIT Campus...???? </h3>
	  <h3>Don't worry....Go for..</h4>
	  <h1>BOOK-HELPER</h1>
	  <button id="loginButton"><a href="login.jsp" style="color:black;text-decoration:none">login</a></button>
	  <button id="registerButton"><a href="signup.jsp" style="color:black;text-decoration:none">register</a></button>
	 </div>
  
  
  
  </div>

</body>
</html>
