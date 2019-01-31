<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章发表成功</title>
</head>
<body>
恭喜您 ， 文章发表成功~

<form action="/Blog_Project/com/blog/servlet/Review_servlet">

输入需要查看文章的序号(输入-1可以查看刚刚发表的文章) ： <input name="select_id" type="text" style="width:15px;height:10px" >
<input type="submit" value="查看">

</form>
</body>
</html>