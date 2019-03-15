<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회 화면</title>
</head>
<body>
	<h1>사용자 목록</h1>
	<table>
		<tr>
			<th>사용자 ID</th>
			<th>사용자 Name</th>
			<th>사용자 Gender</th>
			<th>사용자 City</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
		  		<td>${user.userId}</td>
		  		<td>${user.name}</td>
		  		<td>${user.gender}</td>
		  		<td>${user.city}</td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>