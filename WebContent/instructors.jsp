<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor</title>
</head>
<body>
	<h1>Instructors:</h1>
	
	<br/>
	
	<c:forEach items="${instructors}" var="instructor">
		<label>First Name</label>
		<span>${instructor.firstName}</span>
		
		<br/>
		
		<label>Age</label>
		<span>${instructor.age}</span>
		
		<hr/>
		
		<br/>
	</c:forEach>
	
</body>
</html>