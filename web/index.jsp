<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-26
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>主界面</title>
  </head>
  <body>
          <form id = "form1" method = "get" action="login">

          ******************作业管理系统******************<br/>
                  请选择登录方式：<br/>
                  1.教师登录。<input type ="radio" name = "login" value="1"><br/>
                  2.学生登录。<input type ="radio" name = "login" value="2"><br/>
                  学号登录：<br/>
              <% if (request.getAttribute("cuowu")!=null){
              %>
              输入错误！请重新输入。<br/>
              <%}%>

          <input type ="text" name = "sid" ><br/>
          <input type="submit" value ="提交">
          </form>

  </body>
</html>
