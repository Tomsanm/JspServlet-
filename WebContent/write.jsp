<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <title>博主管理</title>
  <link rel="stylesheet" href="res/layui/css/layui.css"   media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">后台管理</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
        
        
        <img src="res/img/header.png" >
       
          
          欢迎~
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree">
        
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">微语</a>
          <dl class="layui-nav-child">
            <dd><a href="page/whisper/write.jsp">写微语</a></dd>
            <dd><a href="page/whisper/manage.jsp">微语管理</a></dd>
            <dd><a href="page/whisper/comment.jsp">评论管理</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">留言</a>
          <dl class="layui-nav-child">
            <dd><a href="page/leaDel.jsp ">留言管理</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">关于</a>
          <dl class="layui-nav-child">
            <dd><a href=" page/about.jsp">关于管理</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="page/user.jsp">用户管理</a>
        </li>
      </ul>
    </div>
  </div>
  
  
  <div class="layui-body" style="padding: 15px;">
    <!-- 内容主体区域 -->
    <!-- <div style="padding: 15px;">内容主体区域</div> -->
    
  	
  	<form action="/Blog_Project/com/blog/servlet/Article_in_servlet" >
  	
  		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    		<legend>添加文章</legend>
		</fieldset> 
		<input type=text name="article_title"><br>
		<br>
		<div class="layui-form-item layui-form-text"  >
   			 <div class="layui-input-block" style="margin-left: 0px;">
     		 <textarea name="t1"  placeholder="请输入内容" class="layui-textarea"></textarea>
   		 	 </div>
  		</div>

    	
    	<input type="submit" value="上传文章" />

	</form>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © Tomsan 个人博客  2019
  </div>
</div>
<script src="res/layui/layui.js"></script>



<script>
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,url: '/upload/'
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#demo1').attr('src', result); //图片链接（base64）
      });
    }
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
    }
    ,error: function(){
      //演示失败状态，并实现重传
      var demoText = $('#demoText');
      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
      demoText.find('.demo-reload').on('click', function(){
        uploadInst.upload();
      });
    }
  });  
  //拖拽上传
  upload.render({
    elem: '#test10'
    ,url: '/upload/'
    ,done: function(res){
      console.log(res)
    }
  });
});
</script>




<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>