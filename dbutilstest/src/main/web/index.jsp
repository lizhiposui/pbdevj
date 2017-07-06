<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"  contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录系统</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/doLogin.action" method="post">
      <table border="1" width="50%" align="center" style="margin-top: 150px">
          <tr>
              <th width="35%" align="right">用户名:</th>
              <td width="30%">
                  <input type="text" name="username">
              </td>

              <td></td>
          </tr>
          <tr>
              <th align="right">密&nbsp;&nbsp;码:</th>
              <td>
                  <input type="password" name="password">
              </td>
              <td></td>
          </tr>
          <tr>
              <td colspan="3" align="center">
                  <input type="submit" value="登录">
              </td>
          </tr>
      </table>
  </form>
    
  </body>
</html>
