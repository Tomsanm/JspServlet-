<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册账号</title>
</head>
<body>

<form action="/Blog_Project/com/blog/servlet/Registerservlet">
用户名称<input type="text" name="uname"/><br>
输入密码<input type="password" name="upwd"/><br>
确认密码<input type="password" name="upwdcheck"/><br>
输入您的性别 <input type="text" name="usex"/><br>
输入您的邮箱<input type="text" name="uemail"/><br>

<input type="submit" value="提交" >





</form>
</body>
</html>