<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link href="stylsheets/form.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>


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
	<h2>Billing Form</h2>

<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="finalpage.jsp">
      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name (as per given in site)</label>
            <input type="text" id="fname" name="firstname" placeholder="first name" required>
            <label for="email"><i class="fa fa-envelope"></i> Email (as per given in site)</label>
            <input type="text" id="email" name="email" placeholder="amit@example.com" required>
            <label for="adr"><i class="fa fa-address-card-o"></i> Address (college address)</label>
            <input type="text" id="adr" name="address" placeholder="NIT raipur hostel -h" required>
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="raipur" required>

            <div class="row">
              <div class="col-50">
                <label for="state">College Enrollment no</label>
                <input type="text" id="state" name="state" placeholder="enrollment no" required>
              </div>
              <div class="col-50">
                <label for="zip">College Roll no.</label>
                <input type="text" id="zip" name="zip" placeholder="1733009" required>
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="Amit kumar" required>
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="9999-0000-8888-3333" required>
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September" required>
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2022" required>
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352" required>
              </div>
            </div>
          </div>
          
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr" required> Shipping address same as billing
        </label>
        <input type="submit" value="proceed for the payment" >
      </form>
    </div>
  </div>
  
</div>
	
  
 

</body>
</html>
