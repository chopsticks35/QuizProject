<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions</title>
</head>
<body>
	<h1>Quiz Questions:</h1>
	<form action="Quiz.do" method="POST">

		<h2>${questions}</h2>


		<c:forEach items="${answers}" var="quizAnswer">
			<span>${QuizAnswer.text}</span>
			<input type="radio" name="" value="${answers}" />

			<br />

		</c:forEach>

		<input type="submit" />
	</form>

</body>
</html>