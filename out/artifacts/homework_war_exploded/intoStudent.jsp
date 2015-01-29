<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-28
  Time: 下午8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
</head>
<body>
<p2>登录成功</p2><br/>
请选择服务项目：<br/>
1.提交作业：<br/>
<form id = "pck6" method="get" action="login">
    <input type="text" name="hid_1">作业编号<br/>
    <input type="text" name="answer1">答案<br/>
    <input type="text" name="owner">序号<br/>
    <input type="submit" value="提交">
</form>
<a href="selectHomework.jsp">2.查看作业分数</a>
</body>
</html>
