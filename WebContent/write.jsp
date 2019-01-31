<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String name = (String) session.getAttribute("uname");
if (name==null){response.sendRedirect("/Blog_Project/login.jsp");}
%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<base href=" <%=basePath%>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>创作工作室</title>
  <link rel="stylesheet" href="res/layui/css/layui.css"   media="all">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="bootstrap/css/nav_no_content.css">
  
  
</head>


<body class="layui-layout-body">

<nav class="navbar navbar-default navbar-fixed-top" role="navigation"  >

    <div class="container" >
        <!--小屏幕的导航按钮和logo-->
        <div class="navbar-header">
        <button type="button" class="navbar-toggle"  data-toggle="collapse"   data-target="#nav-all">  <!-- 为了小窗口下点击按钮出现选项-->
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!--小屏幕的导航按钮和logo-->
        <a href="index.html" class="navbar-brand">写博客</a>
        </div>
        <!--导航-->
        <div class="collapse navbar-collapse" id="nav-all">
            <ul class="nav navbar-nav navbar-right">
            <li><img src="res/img/header.jpg" height="40px" width="40px"></li>
             
            <li><a href="#"><%=name %>的博客</a></li>
               
                <li> <a href="pressSuccess.jsp">查看刚刚发表博客</a></li>
                <li><a href="#">个人中心</a></li>
                <li><a href="invalidate.jsp">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
  
  <div id="content" >
  	<form action="/Blog_Project/com/blog/servlet/Article_in_servlet" >
  	
  		
    		<legend>添加文章</legend>
		
		<input type=text  placeholder="文章标题"  name="article_title"><br>
		<br>
		<div class="layui-form-item layui-form-text"  >
   			 <div class="layui-input-block" style="margin-left: 0px;">
     		 <textarea name="t1"  placeholder="请输入内容" class="layui-textarea"></textarea>
   		 	 </div>
  		</div>

    	
    	<input type="submit" value="发表文章" />

	</form>
  </div>
  
 <!--底部-->
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div style="text-align:center">
        版权所有 CopyRight  <br>京备字号  邮编 1000044
    </div>
</nav>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script><!-- 引入jquery文件 因为bootstrap依赖它-->
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>