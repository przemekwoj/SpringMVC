<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Insert title here</title>

	<script type="text/javascript">
	function doSearch(){
		$.getJSON("looseSearch.do",function(data){
				$('#opinions').text('');
				for(var index in data)
					{
					$('#opinions').append(data[index] + '</br>');
					}
			});
	}
		doSearch();
		setInterval(function(){doSearch()},2000);
	
	</script>
</head>
<body>

	<form action="/SpringMVC2a/addInscription" method="Post">
	
	<div id="wrapper1">
	
		<div class="title">
			<h2>blog na  temat</h2>
			<br>
			<h2>${subject}</h2>
		</div>
		<div class="logout">
			<input type="submit" value="logout" name="logout" >
		</div>
		
	</div>
	
	<div id="wrapper2">
	
		<div class="forum">
			Inne fora:
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
			<br>
			<input type="submit" value = "addPost" name="addPost"/>
		</div>
		
		<div id="opinions" class="post">
			<c:if test="${not empty lists}">
    			<c:forEach items="${lists}" var="lists">
       				${lists}
       			<br>
				</c:forEach>
			</c:if>
			<br>
		</div>
		
	</div>
	
	<div id = "wrapper3">
	
		<div class="textfield">
			<textarea rows="10" cols="40" name="content"></textarea>
			<input type="submit" value="edit" name="edit" >
		</div>
		
	</div>
	
	</form>
</body>
</html>