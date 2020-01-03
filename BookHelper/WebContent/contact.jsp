<%@page import="bookhelper.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link rel="stylesheet"  type="text/css" href="stylsheets/form.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}
</style>


</head>
<body>

  <div class="#">
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <a href="home.jsp" ><li >HOME</li></a>
                    
                      <a href="http://www.nitrr.ac.in/"><li >NIT Campus</li></a>	
                    <a href="about2.jsp"><li >ABOUT</li></a>
                     <a href="contact.jsp"><li >CONTACT</li></a>					 
			   </ul>
			   
	      </div>
	 
	 </div>
	 
	 <h2>"TEAM MEMBERS"</h2>
<p></p>
<br>

<div class="row">
  <div class="column">
    <div class="card">
      <img src="akristpic.JPG" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Aakrist Arjun</h2>
        <p class="title">Database & Backend Designer</p>
        <p>Student of MCA NITRR  BATCH: 2017-20</p>
        <p>Email id : a.arjun5438@gmail.com</p>
        <p>Roll no: 17223001</p>
         <p>Mobile no.:  8404973134 </p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="B612_20170429_183827.jpg" alt="Mike" style="width:100%">
      <div class="container">
        <h2>AMIT KUMAR</h2>
        <p class="title">Full Stack Developer(Team-Leader)</p>
        <p>Student of MCA NITRR BATCH: 2017-20</p>
        <p>Email id: amitkumarbargaway123@gmail.com</p>
        <p>Roll no: 17223008</p>
        <p>Mobile no.:  9031513545 </p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="mohit_baghel.jpeg" alt="John" style="width:100%">
      <div class="container">
        <h2>Mohit Baghel</h2>
        <p class="title">Front-End Designer</p>
        <p>Student of MCA NITRR Batch: 2017-20</p>
        <p>Email id : mohitbaghel@gmail.com</p>
        <p>Roll no: 17223033</p>
        <p>Mobile No. : 7441107029</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
</div>
  
  
  
  </div>

</body>
</html>
