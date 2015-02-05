
<%--
  Created by IntelliJ IDEA.
  User: online
  Date: 15-1-26
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<!--
GET提交和POST提交的区别？
1.
get提交，提交的信息都显示在地址栏中。
post提交，提交的信息不显示在地址栏中。

2.
get提交，对于敏感的数据信息不安全
post提交 对于敏感信息安全
3.
get提交，对于大叔据不行，因为地址栏存储体积有限
post提交，可以提交大数据

4.
get提交，将信息封装到了请求消息的请求行中。
post提交，将信息封装到了请求体中。
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>主界面</title>
    <script type="text/javascript">
        function _change(){
            /*
            1.得到img元素
            2.修改其src为/verfi
             */
            var imgEle=document.getElementById("img");
            imgEle.src ="/verfi?a="+new Date().getTime();
        }
    </script>
</head>
<body>
<form id="form1" method="post" action="login">

    <img border="0" src="img/437.jpg" width="100%" height="100%"
         style='position: absolute;left:0px;top:0px;z-index: -1'/><br/>
    <table width="100" height="100%" align="center">
        　　
        <tr>
            　　
            <td>
                <div align="center">
                    <table width=275 height=200 border="1" bordercolor="#ff00ff" cellspacing="0" cellpadding="0">

                        <tr>
                            <td align="center" valign="middle">
                                <font color="#7fff00">请选择登录方式:</font>
                            </td>
                        <tr>
                            <td>
                                <font color="#FF0000">1.教师登录。</font>
                                <input type="radio" name="login" value="1">
                            </td>
                        </tr>
                        <td>
                            <font color="#FF0000">2.学生登录。</font>
                            <input type="radio" name="login" value="2"><br/>
                            <font color="#FF0000">输入学号</font><br/>
                            <% if (request.getAttribute("cuowu") != null) {
                            %>
                            <font color="#FF0000">输入错误！请重新输入。</font><br/>
                            <%}%>
                            <input type="password" name="sid"><br/>
                            请输入验证码<br/>
                            <input type="text" name="verfi" size="3">
                            <img  id ="img" src="/verfi">
                            <a href="javascript:_change()">换一张</a>
                        </td>
                        <tr>
                            <td>
                                <input type="submit" value="登录">
                            </td>
                        </tr>
                    </table>
                </div>
                　　
            </td>
            　　
        </tr>
        　　
    </table>
</form>

</body>
</html>
