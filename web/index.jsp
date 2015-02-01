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
  <%HttpSession hs = request.getSession();
      hs.setAttribute("sid","");%>
  <body>
          <form id = "form1" method = "get" action="login">

          <img border="0" src="img/437.jpg" width="100%" height="100%" style='position: absolute;left:0px;top:0px;z-index: -1' /><br/>
              <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                      <td  align="center" valign="middle">
                          <font color="#7fff00">请选择登录方式:</font><br/>
                          <font color="#FF0000">1.教师登录。</font>
                          <input type ="radio" name = "login" value="1"><br/>
                          <font color="#FF0000">2.学生登录。</font>
                          <input type ="radio" name = "login" value="2"><br/>
                          <font color="#FF0000">输入学号</font><br/>
                          <% if (request.getAttribute("cuowu")!=null){
                          %>
                          <font color="#FF0000">输入错误！请重新输入。</font><br/>
                          <%}%>
                          <input type ="password" name = "sid" ><br/>
                          <input type="submit"  value ="登录">
                      </td>
                  </tr>
              </table>

          </form>

  </body>
</html>
