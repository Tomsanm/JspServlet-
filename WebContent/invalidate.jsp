<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<div id="content">
<h1  align="center" >您已成功注销！</h1>
</div>
<% 
session.invalidate();
%>
</body>
</html>