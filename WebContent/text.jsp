<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试</title>

<!-- Ajax 的使用      -->
<script type="text/javascript">
function getData(){
	// 创建 Ajax  对象
	var ajax;
	ajax = new XMLHttpRequest();
	// 当Ajax对象正在工作时发生状态改变就会触发 这个函数的执行
	ajax.onreadystatechange=function(){
		if (ajax.readyState==4){// 当响应状态为4的时候，可以获取到达的数据了  注意大小写
			alert("进入第四次接受");
			if (ajax.status==200){
				alert("状态码： 200");
				var result = ajax.responseText;
				var mydiv = document.getElementById("mydiv");
				mydiv.innerText= result;
				}
			else if (ajax.status==404){
				alert("状态码： 404");
				var mydiv = document.getElementById("mydiv");
				mydiv.innerText= "资源未找到";
				}
			else {
				alert("状态码： 其他");
				var mydiv = document.getElementById("mydiv");
				mydiv.innerText= "服务器内部错误";}
		}
	}
	// 启动发送
	ajax.open("get", "Aaa");  // 请求方式和 请求地址
	ajax.send(null);// post 方式这里填 send的内容  
	
	alert("你是等待还是先执行我呢？")
}
</script>

<style type="text/css">
#mydiv{
height:100px;
width:200px;
border:solid 2px;
}
</style>
</head>

<body>
  
<button onclick="getData()">测试</button>

<div id="mydiv" >
</div>


</body>
</html>