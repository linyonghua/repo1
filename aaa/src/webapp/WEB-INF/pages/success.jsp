<%--
  Created by IntelliJ IDEA.
  User: Mr Lin
  Date: 2019/7/6
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
收到了
-- ${requestScrope}
<form action="user/update" method="post">
    姓名：<input type="text" name="username" value="${ user.username }"><br>
    密码：<input type="text" name="password" value="${ user.password }"><br>
    <%--金额：<input type="text" name="money" value="${ user.money }"><br>--%>
    <%--<input type="submit" value="提交">--%>


</form>
<c:forEach items="${ users }" var="user">
    ${ user.username }
</c:forEach>
</body>
</html>
