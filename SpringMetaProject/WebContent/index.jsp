<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
	<h1>사용자 관리</h1>
	<form action="getUser.do" method="get">
		사용자ID : <input type="text" name="userid">
		<input type="submit" value="조회">
	</form>
	<hr>
	<form action="getUserList.do" method="get">
		<input type="submit" value="전체조회">
	</form>
	
	<form action="insertUserForm.do" method="get">
		<input type="submit" value="사용자 등록">
	</form>
</body>
</html>