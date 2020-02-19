<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.body{
background:#ececed;
}
</style>
<title>File Upload to Database Demo</title>
</head>
<body>
	<center>
		<h1>File CSV Upload</h1>
		<h3>Please Chose a CSV File</h3>
		<form action="./upload" method="post" enctype="multipart/form-data">
    
    <input type="file" name="file" accept=".csv,text/csv" />
    <input type="submit" />
</form>

	</center>
</body>
</html>