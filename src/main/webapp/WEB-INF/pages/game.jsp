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


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jQuery2-1-1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mtgcounter.css" >


<script type="text/javascript">


</script>

<body>

    <div class="container" role="main">

        <c:forEach items="${game.players}" var="player">

            <div class="col-xs-6 playerInfo"> <div class="row"> <div class="col-xs-12"><p class="playerName"> ${player.username} </p></div></div><div class="row"><div class="col-xs-12" ><p class="playerHp" id="hp' + newPlayer.id + '">${player.hp}</p></div></div>
            <div class="row"> <div class="col-xs-12 text-center"><button class="btn-danger btn-sm subtractHp'+ newPlayer.id +'">-</button> <input type="text" id="changeHP" placeholder="1" value="1"/> <button class="btn-success btn-sm addHp'+ newPlayer.id +'">+</button></div></div> </div>


             </c:forEach>

    </div>

<table>



</table>



</body>
</html>
