<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringMVC2a/addInscription" method="Post">
	<center>
	
		<h2>blog na dowolny temat</h2>
		<br>
		<h2>Welcome :)</h2>
	<div class="leftbox">
		filmweb
		<br>
		<a target="_blank" href="youtube">youtube</a>
		<br>
		welcomepage
	</div>
	<div class="leftbox">
		<br>
		<c:if test="${not empty lists}">
    		<c:forEach items="${lists}" var="lists">
       		${lists}
       		<br>
			</c:forEach>
		</c:if>
		<br>
		<textarea rows="10" cols="40" name="content"></textarea>
		<input type="submit" value="edit" name="edit">
	</div>
	</center>
	</form>
</body>
</html>