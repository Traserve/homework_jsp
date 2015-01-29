<%@ page import="jdbcTest.Dao.HomeworkDao" %>
<%@ page import="jdbcTest.Dao.StudentDao" %>
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body><%
    HttpSession hs = request.getSession();
%>
<%=HomeworkDao.searchByOwner(StudentDao.getOwner((String)hs.getAttribute("sid")))%>
<a href="intoStudent.jsp">返回</a>
</body>
</html>
