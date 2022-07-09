<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2022/2/8
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">

    <title>学生管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>修改学生信息</h1>
<form class="form-signin" action="/stuAdd" method="post">
    <h2 class="form-signin-heading">请输入信息</h2>
    <label for="inputstuno" class="sr-only">学号</label>
    <input type="text" name="stuNo" id="inputstuno" class="form-control" placeholder="请输入学号" required autofocus>
    <label for="inputstuname" class="sr-only">姓名</label>
    <input type="text" name="stuName" id="inputstuname" class="form-control" placeholder="姓名" required autofocus>
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="请输入密码" required>
    <label for="inputage" class="sr-only">年龄</label>
    <input type="text" name="age" id="inputage" class="form-control" placeholder="年龄" required autofocus>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me">记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
</form>
</body>
</html>
