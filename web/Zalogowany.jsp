<%-- 
    Document   : Zalogowany
    Created on : 2014-04-09, 17:29:11
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Zostales zalogowany</h1>
        
        <div align="center">
        <form  action="UserKontroler" method="POST">
        <input type="submit" name="Oferta" value="Oferta">
        <input type="submit" name="Promocje" value="Promocje">
        <input type="submit" name="Sprzedaz" value="Sprzedaż">
        
        </form>
        </div>
        
    </body>
</html>
