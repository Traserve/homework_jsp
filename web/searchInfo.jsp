<%@ page import="jdbcTest.Dao.StudentDao" %>
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 上午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%=StudentDao.searchInfo()%>
<a href="intoTeacher.jsp">返回</a>
</body>
</html>
