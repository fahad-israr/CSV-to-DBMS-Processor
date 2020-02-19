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
</style>
<title>Home</title>
</head>
<body>
	<center>
	<h3><a href="${pageContext.request.contextPath}">&#x2190 Go to Home Page</a></h3>
	<h2>List of all users available</h2>
	<table>
   <%=request.getAttribute("Message")%>
	</table>
<h2><%=request.getAttribute("Message2")%></h2>
	</center>
</body>
</html>