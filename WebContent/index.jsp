<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
background:#ececed;
}
div{
border: 1px solid #000;
padding:2px;
margin:4px;
}
</style>
<title>File Upload to Database Demo</title>
</head>
<body>
	<center>
	<div>
		<h1> CSV File Upload</h1>
		<h3>Please Chose a CSV File to upload</h3>
		<form action="./upload" method="post" enctype="multipart/form-data">
    
    <input type="file" name="file" accept=".csv,text/csv" />
    <input type="submit" />
	</form>
	</div>
	<div>
	
	<h3>Click below to View all users in the  database</h3>
	 <form action="./fetch_uers" method="post" >
    
    
    <input type="submit" value="Fetch All Users"/>
    </form> 
    </div>
	</center>
</body>
</html>