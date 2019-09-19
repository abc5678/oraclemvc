<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table>
	<thead>
		<tr><th>no</th><th>ename</th><th>job</th><th>date</th></tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${list }">
		<tr>
			<td><c:out value="${item.empno }"></c:out></td>
			<td><a href="detail/${item.empno }"><c:out value="${item.ename }"></c:out></a></td>
			<td><c:out value="${item.job }"></c:out></td>
			<td><c:out value="${item.hiredate }"></c:out></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<br>

<a href="insert">입력</a>


<form method="get" action="list?currpage=${page.currPage }">
	<select name="search">
		<option value="empno">사원번호</option>
		<option value="ename">사원명</option>
		<option value="job">직무</option>
	</select>
	<input type="text" name="searchtxt">
	<input type="submit" value="검색">
</form>
<br>

<c:if test="${page.prev }">
	<a href="list?currPage=${page.startBlock-1}&search=${search }&searchtxt=${searchtxt }"><c:out value="이전"></c:out></a>
</c:if>

<c:forEach var="p" begin="${page.startBlock }" end="${page.endBlock }">
	<a href="list?currpage=${p}&search=${search }&searchtxt=${searchtxt }"><c:out value="${p }"></c:out></a>
</c:forEach>

<c:if test="${page.next }">
	<a href="list?currPage=${page.endBlock+1}&search=${search }&searchtxt=${searchtxt }"><c:out value="다음"></c:out></a>
</c:if>

</body>
</html>