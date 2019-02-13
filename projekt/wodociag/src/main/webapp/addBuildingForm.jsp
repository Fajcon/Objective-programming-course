<!DOCTYPE html>
<html>
    <head>
        <LINK rel="StyleSheet" href="${pageContext.request.contextPath}/CSS/style.css" type="text/css">
        <title>Form input</title>
        <meta charset="utf-8">
    </head>
    <body>
        <div id="all">
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
            <div id = "content">
                <form action="addNode" method="POST">
                    Dodaj wezel: <br/>
                    ID wezla: <br/>
                    <input type="text" name="ID" /> <br/>
                    Szerokosc geograficzna:<br/>
                    <input type="number" step="0.000001" lang="en" name="positionX" /> <br/>
                    Wysokosc geograficzna:<br/>
                    <input type="number" step="0.000001" lang="en" name="positionY" /> <br/>
                    Wysokosc npm:<br/>
                    <input type="number" name="altitude" /> <br/>
                    Przwidywane zuzycie (l):<br/>
                    <input type="number" name="water" /> <br/>
                    Adres:<br/>
                    <input type="text" name="adres"/> <br/>
                    Id poprzedniego wezla:<br/>
                    <input type="text" name="prevID"/> <br/>
                    <input type="submit" value="Add" />
                </form>
            </div>
        </div>
    </body>
</html>