<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>

<form method="post" action="result">
	<ul>
		<li>
			<label for="empno">번호</label>
			<input type="number" id="empno" name="empno">
		</li>
		<li>
			<label for="ename">이름</label>
			<input type="text" id="ename" name="ename">
		</li>
		<li>
			<label for="job">직무</label>
			<input type="text" id="job" name="job">
		</li>
		<li>
			<label for="hiredate">입사일</label>
		</li>
	</ul>

</form>

</body>
</html>