<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-29
  Time: 下午2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
提交成功！3s后自动返回。。。。。
<%
    response.setHeader("Refresh","3;URL=intoStudent.jsp");
%>
</body>
</html>
