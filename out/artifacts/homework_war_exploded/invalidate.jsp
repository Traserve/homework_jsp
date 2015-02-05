<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-2-4
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
请稍候
<%
    session.invalidate();
        /**
         * 这里有注销的作用：
         * 清空session
         */
    response.setHeader("Refresh","2;URL=index.jsp");
%>
</body>
</html>
