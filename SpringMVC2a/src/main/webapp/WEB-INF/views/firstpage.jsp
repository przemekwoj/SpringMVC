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
	
		<h2>blog na  temat</h2>
		<br>
		<h2>${subject}</h2>
	<div class="leftbox">
		<br>
		<a target="_blank" href="${pageContext.request.contextPath}/youtube">youtube</a>
		<br>
		<c:if test="${not empty lists2}">
			<c:url var="forum" value="forum"/>
    		<c:forEach items="${lists2}" var="lists2">
       		<a href="${pageContext.request.contextPath}/${forum}/${lists2}">${lists2}</a>
       		<br>
			</c:forEach>
		</c:if>
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
		<input type="submit" value="edit" name="edit" >
	</div>
	<div>
		<input type="submit" value="logout" name="logout" >
	</div>
	</center>
	</form>
</body>
</html>