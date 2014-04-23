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
            <form action="RentKontroler" method="POST">
              <input type="submit" value="akceptuj wypozyczenia" name="akceptujWypozyczenia">    
            </form>
            
             <form action="CarKontroler" method="POST">    
             <input type="submit" value="dodaj samochod" name="dodaj">
             <input type="submit" value="usun samochod"  name="usun">
             <input type="submit" value="edytuj przebieg samochodu"  name="edit">
        </form>
        </div>
        
        <c:set var="licznik" scope="session" value="${0}"/>
         <form action="RentKontroler" method="POST">    
        <table align="center" >
          <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
          <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
          <c:forEach var="rents" items="${Rents}" >
          <tr>
              
          <td>${rents.getIdWypozyczenie()}</td><td>${daneUzytkownicy.get(rents.getIdUser()).getImie()}</td>
          <td>${daneUzytkownicy.get(rents.getIdUser()).getNazwisko()}</td>
          <td>${daneSamochod.get(rents.getIdSamochod()).getMarka()}</td>
          <td>${daneSamochod.get(rents.getIdSamochod()).getModel()}</td>
          <td>${daneSamochod.get(rents.getIdSamochod()).getRocznik()}</td>
          <td>${rents.getDoZaplaty()}</td><td>akceptuje<input type="radio" value="zaakceptowane" name="akc${rents.getIdWypozyczenie()}"</td>
          <td>nie akceptuje<input type="radio" value="odrzucone" name="akc${rents.getIdWypozyczenie()}"</td>
           <td><input type="text" value="${rents.getOpis()}" name="${rents.getIdWypozyczenie()}"></td>
          </tr>
          <c:set var="ilosc3" scope="session" value="${rents.getIdWypozyczenie()}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${ilosc3 > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="akceptuj">
            </div>  
            </c:when>
         </c:choose>
           
        </form>
        
        
        
        
        
        <form action="CarKontroler" method="POST">    
        <table align="center" >
          <c:forEach var="cars" items="${Edit}" >
          <tr>
          <td>${cars.getMarka()}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
           <td><input type="text" value="${cars.getPrzebieg()}" name="${cars.getId()}"></td>
          </tr>
          <c:set var="ilosc2" scope="session" value="${cars.getId()}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${ilosc2 > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzEdytuj">
            </div>  
            </c:when>
         </c:choose>
           
        </form>
        
        
        
        
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
