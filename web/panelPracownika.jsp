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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div align="center">
            <h1>PANEL PRACOWNIKA</h1>    
             <form action="CarKontroler" method="POST">    
             <input type="submit" value="dodaj samochod" name="dodaj">
             <input type="submit" value="usun samochod" name="usun">
        </form>
        </div>
        
        <table align="center" >
          <c:forEach var="cars" items="${Cars}" >
          <tr>
          <td><input type="checkbox" value="${cars.przebieg}" name="iden"></td>
          <td>${cars.marka}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
          </tr>
          </c:forEach>
          <input type="submit" value="zatwierdz" name="zatwierdzUsun">
          </table>
        
    </body>
</html>
