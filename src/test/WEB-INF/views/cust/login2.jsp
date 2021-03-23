<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/login">
	<h1>Custom Login Page</h1><hr/>
	<h2><c:out value="${error}" /></h2>
	<h2><c:out value="${logout}" /></h2><hr/>
	<h2></h2>
	<table>
	<tr>
		<td>아이디:</td>
		<td><input type="text" id="username" name="username" value="admin0" ></td>
	</tr>	
	<tr>
		<td>비밀번호:</td>
		<td><input type="password" id="password" name="password" value="pw0"/></td>
	</tr>
	<tr>
	<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}" >
	<td><input type="checkbox" name="remember-me">Remember ME</td>
		<td><input type="submit" value="로그인" /></td>
	</tr>
	
	</table>
</form>
</body>
</html>