<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회 화면</title>
</head>
<body>
	<h1>사용자 상세정보</h1>
	<ul>
		<li>${userKey.userId}</li>
		<li>${userKey.name}</li>
		<li>${userKey.gender}</li>
		<li>${userKey.city}</li>
	</ul>
</body>
</html>