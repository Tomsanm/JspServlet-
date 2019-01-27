<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登录</title>
</head>
<body>
<form action="/Blog_Project/com/blog/servlet/Loginservlet">

用户名：<input type="text" name="uname"><br>
密码：<input type="password" name="upwd">
<br>
<input type="submit" value="登录">
<input type="reset" name="btn" value="重置"><br>
</form>
还没有账号？ <a href="register.jsp">立即注册</a>
</body>
</html>