<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table, th, td {
  border: 1px solid black;
  
}
input{
font-weight:bold;
}
</style>
<title>Message</title>
</head>
<body>
	<center>
	  <h3><a href="${pageContext.request.contextPath}">&#x2190 Go back to Home Page</a></h3>
	<table>
   <%=request.getAttribute("Message")%>
	</table>
<h2><%=request.getAttribute("Message2")%></h2>
 <div>
	 <form action="./fetch_uers" method="post" >
    
    <h3>Click the button below to fetch all users From database</h3>
    <input type="submit" value="View All Uers"/>
    </form> 
</div>
	</center>
</body>
</html>