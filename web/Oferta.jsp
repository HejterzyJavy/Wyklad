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
        <script type="text/javascript" src="skryptOferta.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta</title>
    </head>
    <body>
        <h1 align="center">WITAJ</h1>
        
        <div align="center">
        <form align="center" action="CarKontroler" method="POST">
            <input type="submit" value="Wyswietl całą oferte" name="oferta">
            <div id="paczka">
            <input id="usun" type="button" value="Wyswietl wybrana marke" onclick="dodaj_element('paczka');" />
            </div>
            
            <div id="paczka2">
            <input id="usun2" type="button" value="Wyswietl wybrany rocznik" onclick="dodaj_element2('paczka2');" />
            </div>
           
        </form>
            
            <form align="center" action="RentKontroler" method="POST">
                 <input type="submit" value="Wypożycz samochód" name="wypozyczenie">
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
