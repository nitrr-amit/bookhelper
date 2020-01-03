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
                     <li ><a href="home.jsp" style="color:white;text-decoration:none">HOME</a></li>
                      <a href="http://www.nitrr.ac.in/"><li >NIT Campus</li></a>	
                    <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>		 					 
			   </ul>
			   
	      </div>
	 
	 </div>
	 
	 <%
	    String registration_error=(String)request.getAttribute("registration_error");
	   if(registration_error!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=registration_error %></h2>
	 <%} %>
	 
	 <div class="form">
			
		<form action="EmailVerificationServlet" method="post" >
			
			<legend style="color:yellow;">Register</legend>
			<br>
			Name:
			<input type="text" name="name" autofocus required>
			<br>
			Mobile Number:
			<input type="text" name="mobile"  required>
			<br>
			Email ID:<br>
			 <input type="email" name="email_id" required autofocus
			 
			 
			 	style=" width: 100%;
		  padding: 5px 5px;
		  margin: 8px 0;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		  font-size:16px;"
			 
			 
			 
			 >
			  
			 <br>
			Password:
			<!-- <input type="password" name="password"  required> --> 
			<input type="password"  name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
			<br>
			<input type="submit" value="verify EmailId>>" style="float:right;">
			
	
		</form> 
	</div>
  
  </div>

</body>
</html>
