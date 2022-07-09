<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22-1-5
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="/">Home</a></li>
    <li><a href="login.jsp">登录页面</a></li>
    <li><a href="stu-add.jsp">学生注册</a></li>
    <li><a href="/stuList">学生列表</a></li>
</ul>
<h1>学生列表</h1>
<hr/>
<form action="/stuList" method="post">
    <input type="text" name="keyword" placeholder="学号或者姓名查询">
    <input type="submit" value="查询">
    <a href="/stu-add.jsp">新增</a>
</form>

<table class="table table-striped">
    <caption>条纹表格布局</caption>
    <thead>
    <tr>
        <th>id</th>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="v" items="${list}">
        <tr>
            <td>${v.id}</td>
            <td>${v.stuNo}</td>
            <td>${v.stuName}</td>
            <td>${v.password}</td>
            <td>${v.age}</td>
            <td><a href="/stuUpdate?id=${v.id}">修改</a> | <a href="/stuDelete?id=${v.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
