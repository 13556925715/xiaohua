<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>套餐列表</title>
    <link rel="../shortcut icon" href="favicon.ico">
    <link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script src="../js/jquery.min63b9.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min14ed.js?v=3.3.6"></script>

    <script src="/js/plugins/twbsPagination/jquery.twbsPagination.min.js"></script>

    <script src="../js/plugins/iCheck/icheck.min.js"></script>
    <script>
        var f = ${f}
        if(f == "1"){
            alert("无法删除，因为有其他数据依赖")
        }
    </script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content">
                <div class="row">
                    <form class="form-inline" action="/setmeal/list?qo.keyword=keyword" method="post">
                        <div class="form-group">

                            <input type="text" class="form-control" id="keyword" name="keyword"
                                   value="${qo.keyword}" placeholder="请输入编码/名称/助记码">
                        </div>
                        <button id="btn_query" class="btn btn-primary" href="/"><span
                                class="glyphicon glyphicon-search"></span>
                            查询
                        </button>
                        <div class="form-group">
                            <a href="/setmeal/input" class="btn btn-success btn_redirect" data-url="adduser.html">
                                <span class="glyphicon glyphicon-plus"></span> 添加
                            </a>
                        </div>
                    </form>

                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>套餐编码</th>
                            <th>套餐名称</th>
                            <th>助记码</th>
                            <th>适用性别</th>
                            <th>适用年龄</th>
                            <th>说明</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.list}" var="entity" varStatus="entityStatus">
                            <tr>
                                <td>${entityStatus.count}</td>
                                <td>${entity.setmealCode}</td>
                                <td>${entity.setmealName}</td>
                                <td>${entity.helpcode}</td>
                                <td>${entity.setmealSex}</td>
                                <td>${entity.setmealAge}</td>
                                <td>${entity.remark}</td>
                                <td>
                                    <a class="btn btn-info btn-xs btn-input"
                                       href="/setmeal/input?setmealId=${entity.setmealId}">
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a href="/setmeal/delete?setmealId=${entity.setmealId}"
                                       class="btn btn-danger btn-xs btn-delete">
                                        <span class="glyphicon glyphicon-trash"></span> 删除
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
                <%@include file="../common/page.jsp"%>
            </div>
        </div>
    </div>

</div>
</div>


<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({
            checkboxClass: "icheckbox_square-green",
            radioClass: "iradio_square-green",
        })
    });
</script>
</body>
</html>
