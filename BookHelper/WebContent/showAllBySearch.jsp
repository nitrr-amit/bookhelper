<%@page import="bookhelper.pojo.User" %> 
<%@page import="bookhelper.pojo.Book" %> 
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<title>  </title>
<link rel="stylesheet"  type="text/css" href="style.css"> 
<link rel="stylesheet"  type="text/css" href="stylsheets/form.css"> 
<link rel="stylesheet"  type="text/css" href="stylsheets/imageShow.css"> 

</head>
<style>
	*{
	
	box-sizing:border-box;
}
	
.zoom{
	float:left;
	padding:0px;
	background-color:transparent;
	transiton:transform .2s;
	width:90px;
	height:90px;
	margin:0 auto;
	margin-left:5px;
	margin-right:5px;
}
.zoom:hover{
	
	-ms-transform:scale(1.5);
	-webkit-transform:scale(1.5);
	transform:scale(3.5);
}
</style>
<body>

	<%
	 	User user=(User)session.getAttribute("user");
	%>
	
  <div >
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <a href="main.jsp" ><li >HOME</li></a>
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
	 
	 <div style="float:left; margin-top:5%; margin-left:5%;width:90%; height:80%;">
	 <% String msg=(String)request.getAttribute("no_record_of_book");
	   if(msg==null){
		   List<Book> list=(List)request.getAttribute("list");
		   Book book=list.get(0);
		  %>
	     BOOK NAME: <%=book.getBook_name()%><br>
		 BOOK AUTHOR: <%=book.getBook_author()%>
		 <table>
			<tr>
			    <th>book Id</th>
			    <th>price</th>
			    <th>Seller name</th>
			     <th>Seller mobile</th>
			    <th>Seller email_id</th>
			     <th>when added</th>
			     
			    <th>image</th>
			    <th>BUY NOW</th>

			</tr>
	 <%
	
			for(int i=1;i<=list.size();i++){ 
		  book=list.get(i-1);
	 %>
	
		  	<tr>
		  		<td style="padding:15px;"><%=book.getId()%></td>
		    	<td><%= book.getPrice()%></td>
		   		<td><%=book.getSeller_name()%></td>
		   		<td><%=book.getSeller_mobile()%></td>
		   		<td><%=book.getSeller_email_id()%></td>
		    	<td><%=book.getWhen_added()%></td>
		    	<td>
		    		<div style="width:120%; height:100%">
				    	<div class="zoom">	
					    	<img  src="ImageRetriveServlet?id=<%=book.getId()%>&img=image1"  style="width:100%;max-width:100%">
					    </div>
					    <div class="zoom">
					    	<img  src="ImageRetriveServlet?id=<%=book.getId()%>&img=image2"  style="width:100%;max-width:100%">
						</div>
						<div class="zoom">
							<img  src="ImageRetriveServlet?id=<%=book.getId()%>&img=image3"  style="width:100%;max-width:100%">
						</div>	
		    		</div>
		    	</td>
		    	<td> <a href="buy.jsp" style="text-decoration:none;color:blue;"> BUY NOW </a></td>
		    	
		  	</tr>
	 		<%}%>
  		
  		</table>
  	<%}else{%>
  		<p style="float:left;font-size:25px;margin-left:40px;margin-top:3%;"><%=msg.toUpperCase()%>
  		<%}%>
	</div>
  </div>
	
</body>
</html>
