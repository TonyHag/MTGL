<%--
  Created by IntelliJ IDEA.
  User: eirikskogland
  Date: 03.12.14
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game</title>
</head>
<body>

<table>

    <c:forEach items="${game.players}" var="player">
        <tr><td>${player.username}</td> <td>${player.hp}</td></tr>
    </c:forEach>

</table>



</body>
</html>
