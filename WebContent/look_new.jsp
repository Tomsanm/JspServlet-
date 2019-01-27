<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刚发表的博文</title>
</head>
<body>
您的博文标题：
<% String title =(String) request.getAttribute("title") ;%>

<%=title %>
<br>
<p>您的博文内容：</p>
<% String content =(String) request.getAttribute("content");%>
<%=content %>
</body>
</html>