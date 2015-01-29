<%@ page import="jdbcTest.Dao.HomeworkDao" %>
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%=HomeworkDao.searchBySidNoscore(Integer.parseInt((String)request.getAttribute("stuid2")))%><br/>
<p1>进行批改</p1>
<form id = "pck4" method="get" action="login">
    <input type="text" name="hid">作业号<br/>
    <input type="text" name="score">成绩<br/>
    <input type="submit" name="提交">
    <a href="searchByNoscore.jsp">返回</a>
</form>

</body>
</html>
