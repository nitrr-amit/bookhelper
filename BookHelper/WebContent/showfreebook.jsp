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
	
  <div style="overflow:scroll;">
     <div class="menu">
	      <div class="leftmenu">
	          <h4>BOOK-HELPER</h4>
	      </div>
	      <div class="rightmenu">
	           <ul>
                     <a href="main.jsp" ><li >HOME</li></a>
                     <li>ABOUT</li>
                    <li>CONTACT</li>
                     	 
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
		 <table>
			<tr>
			    <th>book name</th>
			    <th>book author</th>
			
			    <th>when added</th>
			    <th>image</th>
			    <th>BUY NOW</th>
			</tr>
	 <%
		List<Book> list=(List)session.getAttribute("list");
		if(list!=null){
			
			for(int i=1;i<=list.size();i++){ 
			Book book=list.get(i-1);
	 %>
	
		  	<tr>
		  		<td style="padding:15px;"><%=book.getBook_name()%></td>
		    	<td><%= book.getBook_author()%></td>

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
		    	<td><a href="buy.jsp	" > <button >BUY NOW</button></a>
		    	
		    	 </td>
		  	</tr>
	 		<%} %>
  		<%} %>
  		</table>
	</div>
  </div>
	
</body>
</html>
