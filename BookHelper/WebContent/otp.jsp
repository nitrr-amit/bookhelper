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
                     <li>ADMIN</li>	
                     <li>ABOUT</li>
                     <li>CONTACT</li> 					 
			   </ul>
			   
	      </div>
	 
	 </div>
	 
	 <%
	    String msg=(String)request.getAttribute("otp_error_msg");
	   if(msg!=null){
	 %>
	 <h2 style="margin-left:27%;font-size:30px;color:#58584f;float:left;"><%=msg%></h2>
	 <%} %>
	 
	 <div class="form">
			
		<form action="SignUpServlet" method="post" >
			
			<legend style="color:yellow;">Enter otp send to your email</legend>
			<br>
			
			OTP:
			<input type="text" name="user_otp" autofocus required>
			
			
			<input type="submit" value="verify" style="float:right;">
			
	
		</form> 
	</div>
  
  </div>

</body>
</html>
