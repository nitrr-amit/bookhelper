<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link href="stylsheets/form.css" rel="stylesheet">


</head>
<body>
  <div class="bgimage">
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <a href="home.jsp" style="color:white;text-decoration:none"><li >HOME</li></a>
                     <a href="http://www.nitrr.ac.in/"><li >NIT Campus</li></a>	
                    <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>					 
			   </ul>
			   
	      </div>
	 
	 </div>
	 
	 <%
	 	String msg=(String)request.getAttribute("signup_msg");
	   if(msg!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=msg %></h2>
	 <%} %>
	 <%
	    String msg2=(String)request.getAttribute("user_already_exist");
	   if(msg2!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=msg2 %></h2>
	 <%} %>
	 
	  <%
	    String password_error=(String)request.getAttribute("password_error");
	   if(password_error!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=password_error %></h2>
	 <%} %>
	 
	 
	 
	 <%
	    String logout_msg=request.getParameter("logout_msg");
	   if(logout_msg!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=logout_msg %></h2>
	 <%} %>
	 <div class="form">
			
		<form action="LoginServlet" method="post" >
			
			<legend style="color:yellow;">Login</legend>
			<br>
			Email ID:
			<input type="text" name="email_id" autofocus required>
			<br>
			Password:
			<input type="password" name="password"  required>
			<br>
			
			<input type="submit" value="next >>" style="float:right;">
			
				<p1 style="color:white; font-size:20px;">Not registered??<a href="signup.jsp" style="color:white ; font-size:22px;"> SignUp</a></p1>
		</form> 
	</div>
  
  </div>

</body>
</html>
