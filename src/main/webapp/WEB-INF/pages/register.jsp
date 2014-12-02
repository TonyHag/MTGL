<%--
  Created by IntelliJ IDEA.
  User: eirikskogland
  Date: 02.12.14
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>Register</h1>

<form action="/login" method="post">
    <table>
        <tr> <td>Username: </td> <td><input type="text" name="username"></td></tr>
        <tr> <td>Password: </td> <td><input type="password" name="password1"></td></tr>
        <tr> <td>Re-type password: </td> <td><input type="password" name="password2"></td></tr>
        <tr> <td>email: </td> <td><input type="email" name="email"></td></tr>
        <tr> <td> <input type="submit" value="Register"> </td> </tr>
    </table>

</form>

</body>
</html>
