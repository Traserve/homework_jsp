<%@ page import="jdbcTest.Dao.HomeworkDao" %>
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 上午9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%=HomeworkDao.searchBySid((String)request.getAttribute("stuid2"))%>
<a href="searchByNoscore.jsp">返回</a>
</body>
</html>
