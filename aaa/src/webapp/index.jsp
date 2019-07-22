<%--
  Created by IntelliJ IDEA.
  User: Mr Lin
  Date: 2019/7/6
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>springmvc</title>
    <script src="js/jquery.min.js"></script>
</head>
<%--引入jquery框架--%>

<body>
<h3>你点一下</h3>
<a href="/hh?password=123&username=zhangsan">hhh</a>
<form action="/hh" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户账号：<input type="text" name="password" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    用户号：<input type="text" name="name" /><br/>
    用户余额：<input type="text" name="account.money" /><br/>
    用户余额：<input type="text" name="list[0].name" /><br/>


    <input type="submit" value="提交" id="aaa"/>
    <input id="json" type="text" name="name">
</form>
<a href="/cc?password=123&username=zhangsan">模拟数据库</a>
<a href="/voidHello?password=123&username=zhangsan">模拟voidHello</a>
<a href="/getModelAndView?password=123&username=zhangsan">模拟getModelAndView</a>
<a href="/geterror">模拟geterror</a>

<script>
    <%--&lt;%&ndash;加载完后执行&ndash;%&gt;--%>
    $(function () {
        // &lt;%&ndash;异步请求&ndash;%&gt;
        $("#json").blur(function () {
            $.ajax({
                //请求路径
                contentType:"application/json;charset:utf-8",
                url:"/getajax",
                //请求参数
                data:'{"username":"zhangsan","password":"123"}',
// --                   yuqifhz
                dataType:"json",
                //请求方式
                type:"post",
                success:function (data) {
                    alert(data);
                }

            });
        });

    });
</script>
<form action="/uploadFile" method="post" enctype="multipart/form-data">
    文件<input type="file" name="upload">
    <input type="submit" name="上传文件">
</form>
</body>
</html>
