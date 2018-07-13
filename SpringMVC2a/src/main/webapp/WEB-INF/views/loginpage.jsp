<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringMVC2a/firstpage" method="post">
	<center>
		name: <input type="text" name="name">
		<br>
		surname: <input type="text" name="surname">
		<br>
		email: <input type="text" name="email">
		<br>
		
		<input type="submit"  name="createaccount" value="creat account" >
		<input type="submit"  name="login" value="login">
		<br>
		${info}
	</center>
	</form>
	
</body>
</html>