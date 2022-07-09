<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>检查项编辑</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script src="/js/jquery.min63b9.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min14ed.js?v=3.3.6"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>检查项编辑</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="editForm" method="post" action="/checkItem/saveOrUpdate">
                        <input type="hidden" id="itemId" name="itemId" value="${checkItem.itemId}">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="itemCode">检查项编码：</label>
                            <div class="col-sm-8">
                                <input id="itemCode" name="itemCode" class="form-control" type="text" value="${checkItem.itemCode}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="itemName">检查项名称：</label>
                            <div class="col-sm-8">
                                <input id="itemName" name="itemName" class="form-control" type="text" value="${checkItem.itemName}" aria-required="true" aria-invalid="false" class="valid" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" >适用性别：</label>
                            <div class="col-sm-8">
                                <label>
                                    <input id="itemSex1" name="itemSex"  type="radio" value="1"> 男
                                </label>
                                <label>
                                    <input id="itemSex2" name="itemSex"  type="radio" value="2"> 女
                                </label>
                                <label>
                                    <input id="itemSex3" name="itemSex"  type="radio" value="3"> 不限
                                </label>
                                <script>
                                    $("input[value='${checkItem.itemSex}']").prop("checked",true)
                                </script>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="itemAge">适用年龄：</label>
                            <div class="col-sm-8">
                                <input id="itemAge" name="itemAge" class="form-control" type="text" value="${checkItem.itemAge}" required>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="itemPrice">价格：</label>
                            <div class="col-sm-8">
                                <input id="itemPrice" name="itemPrice" class="form-control" type="text" value="${checkItem.itemPrice}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="itemType">检查类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="itemType" name="itemType">
                                    <option value="1">检查</option>
                                    <option value="2">检验</option>
                                </select>
                            </div>
                            <script>
                                $("select[name='itemType']").val(${checkItem.itemType})
                            </script>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="attention">注意事项：</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="attention" name="attention" >${checkItem.attention}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="remark">说明：</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="remark" name="remark">${checkItem.remark}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

