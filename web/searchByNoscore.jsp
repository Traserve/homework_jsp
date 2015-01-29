<%@ page import="jdbcTest.Dao.HomeworkDao" %>
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 上午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看未批改的学生</title>
</head>
<body>
<%=HomeworkDao.searchByNoscore()%>
<form id = "pck2" method="get" action="/login">
    <% if (request.getAttribute("cuowu1")!=null){
    %>
    输入错误！请重新输入。<br/>
    <%}%>
    <input type="radio" name="stuid" value="1">1.查看指定学生的未被批改的作业。<br/>
    <input type="radio" name="stuid" value="2">2.查看学生信息。<br/>
    <input type="text" name="stuid1" >：学号<br/>
    <input type="submit" value="查看">
    <a href="intoTeacher.jsp">返回</a>
</form>
</body>
</html>
