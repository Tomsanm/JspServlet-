<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/sigin.css">
</head>
<body>

<a href="index.jsp">返回首页</a>

<% 
Cookie[] cookies=null;
cookies = request.getCookies();
//out.println("前端接收到的cookie长度是："+cookies.length);
String uname="";
String password="";
String ck="";
for(Cookie cookie:cookies){
	// 提取密码
	// out.println("查看Cookie键值对："+cookie.getName()+" : "+cookie.getValue());
	if (cookie.getName().equals("upwd")){
		 password = cookie.getValue();
		// out.println("查看pwd"+password);
	}
	// 提取ck
	if (cookie.getName().equals("ck")){
		 ck = cookie.getValue();
		// out.println("ck"+ck);
	}
}

%>


<div class="container">

    <form class="form-signin"  action="/Blog_Project/com/blog/servlet/Loginservlet">  
    
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only"></label>
        <!--  <input type="text" name="uname" class="form-control" placeholder="用户名或手机号"  required autofocus>   -->
        
        <input type="text" name="uname" class="form-control" placeholder="用户名或手机号"  required autofocus>
        
        <label for="inputPassword" class="sr-only">密码</label>
      <!--   <input type="password" name="upwd" value=<%=password %> class="form-control" placeholder="密码" required> -->
      
       <input type="password" name="upwd"  class="form-control"  value=<%=(ck==null?"":password) %> >
        <div class="checkbox">
            <label>
                <input name="ck" type="checkbox" value="1"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录 </button>
    </form>

</div> <!-- /container -->




<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script><!-- 引入jquery文件 因为bootstrap依赖它-->
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>










