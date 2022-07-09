
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <title>叩丁健康 - 后台登录</title>
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">

    <style>
        .logo-name{
            color:#e6e6e6;
            font-size: 60px;
            font-weight: 800;
            margin-bottom: 10px;
            letter-spacing: 0
        }
        .form-control1{
            width: 60%;
            display: inline;
            right: 0;
        }
        .img-thumbnail{
            margin-left: 15px;
            /*position:absolute;*/
            top : 0;
            right: 20px;
        }
    </style>
    <script>
        var f = ${f}
        if(f == "1"){
            alert("密码错误或验证码错误")
        }
    </script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h2 class="logo-name"><a href="http://www.wolfcode.cn">WolfCode</a></h2>

        </div>
        <h3>叩丁健康后台管理系统</h3>

        <form class="m-t" role="form" action="/dologin" method="post">
            <span style="color: red">${errMsg} </span>
            <div class="form-group">
                <input type="username" class="form-control" placeholder="用户名" name="username" id="username" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码"  name="password" id="password" required="">
            </div>
            <div class="form-group">
                <input type="text" name="code" id="code" class="form-control form-control1" placeholder="验证码" required="">
                <img width="95" src="/verifycode" class="img-thumbnail" id="verifycode"/>
            </div>

            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

        </form>
    </div>
</div>
<script src="/js/jquery.min63b9.js?v=2.1.4"></script>
<script src="/js/bootstrap.min14ed.js?v=3.3.6"></script>
</body>
<script>
//点击验证图片，重新生成验证码
	$(function(){
		//获取验证码的img标签，添加点击事件
		$("#verifycode").click(function(){
			//改变img标签的src，重新发送请求
			this.src = "/verifycode?"+new Date().getMilliseconds();
			})

	})
</script>






























</html>
