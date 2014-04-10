<%-- 
    Document   : Oferta
    Created on : 2014-04-10, 21:20:22
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta</title>
    </head>
    <body>
        <h1 align="center">OFERTA</h1>
        
        <div align="center">
        <form align="center" action="CarKontroler" method="POST">
            <input type="submit" value="Wyswietl całą oferte" name="oferta">
            <input type="submit" value="Wyswietl wybrana marke" name="marka">
            <input type="submit" value="Wyswietl wybrany model" name="model">
        </form>
        </div>
      
          <table align="center" >
          <c:forEach var="cars" items="${Cars}" >
          <tr>
          <td>${cars.marka}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
          </tr>
          </c:forEach>
          </table>
    
    
    </body>
</html>
