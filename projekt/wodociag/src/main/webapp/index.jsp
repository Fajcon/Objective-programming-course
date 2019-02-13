<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <LINK rel="StyleSheet" href="${pageContext.request.contextPath}/CSS/style.css" type="text/css">
  </head>
  <body>
    <div id = "all">
      <div id="menu">
        <form class="menu" action="addNode" method="POST">
          <input type="submit" value="Dodaj wezel"/>
        </form>
        <form class="menu" action="viewNodes" method= "GET">
          <input type="submit" value="Mapa"/>
        </form>
        <form class="menu" action="newNetwork" method= "GET">
          <input type="submit" value="Stworz nowa siec"/>
        </form>
      </div>
      <div id="content">

      </div>
    </div>
  </body>
</html>
