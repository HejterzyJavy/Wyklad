<%-- 
    Document   : panelPracownika
    Created on : 2014-04-18, 12:22:53
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="skryptPanelPracownika.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="ilosc" scope="session" value="${0}"/>
        <div align="center">
            <h1>PANEL PRACOWNIKA</h1>    
             <form action="CarKontroler" method="POST">    
             <input type="submit" value="dodaj samochod" name="dodaj">
             <input type="submit" value="usun samochod"  name="usun">
             
        </form>
        </div>
        
        <form action="CarKontroler" method="POST">    
        <table align="center" >
          <c:forEach var="cars" items="${Cars}" >
          <tr>
          <td><input type="checkbox" value="${cars.getId()}" name="${cars.getId()}"></td>
          <td>${cars.getMarka()}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
          </tr>
          <c:set var="ilosc" scope="session" value="${cars.getId()}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${ilosc > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzUsun">
            </div>  
            </c:when>
         </c:choose>
           
        </form>
          
    </body>
</html>
