
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <script type="text/javascript" src="skryptOferta.js"></script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AutoRent - Wypożyczalnia Samochodów</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/formularz.css">
        
        
        
        <script src="js/vendor/modernizr-2.7.1.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>');</script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
        <script src="js/vendor/jquery-ui-1.10.4.custom.min.js"> </script>
    </head>
    <body>

        <div id = 'container'>
        	<div id='header'>
        		<div id= 'logo'> </div>
        		<div id='pasekLogowania'>
                            
                            <div class='przyciskG' id='pLogowania' name="wyloguj"> 
                                <form action="UserKontroler" method="POST">
                                <input type="submit" name="wylogowanie" value="WYLOGUJ"> 
                                </form>
                                </div>
                                
                                
        		</div>
        	
        	</div>
        	<div id='menuPoziome'>
        		<div id='rezerwacjaB'> <p>REZERWUJ</p></div>
                        <div class='przyciskMenu'> <a href="Samochody.jsp"><p>SAMOCHODY</p></a> </div>
        		<div class='przyciskMenu'> <p>OFERTA</p> </div>
        		<div class='przyciskMenu'> <p>LOKALIZACJA</p> </div>
        		<div class='przyciskMenu'> <p>USŁUGI</p> </div>
        		<div class='przyciskMenu'> <p>NAGRODY</p> </div>
        		<div class='przyciskMenu'> <p>DLA FIRM</p> </div>
        	</div>
        	<div id="srodek">
        		<div class='linia'> </div>
				<div id="srodekNaglowek">
					<div id="srodekZnacznik"> </div>
					<p>PANEL PRACOWNIKA</p>
				</div>
				<div class='linia'> </div>
				<div align="center" id="srodekTresc"> 
                                
                               <form action="RentKontroler" method="POST">
                               <input type="submit" value="akceptuj wypozyczenia" name="akceptujWypozyczenia">    
                               </form>
         <c:set var="ilosc" scope="session" value="${0}"/>   
        <form action="CarKontroler" method="POST">    
             <input type="submit" value="dodaj samochod" name="dodaj">
             <input type="submit" value="usun samochod"  name="usun">
             <input type="submit" value="edytuj przebieg samochodu"  name="edit">
        </form>
                                    
                 <form action="RentKontroler" method="POST">    
        <table align="center" >
            <c:set var="wyswietlanieAkceptacja" scope="session" value="${wyswietlanieAkceptacja}"/>
          <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
          <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
          <c:forEach var="rents" items="${Rents}" >
              <tr>
                  to jest zawartosc tej zmiennej ${jakas}
              </tr>
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
              <c:when test="${wyswietlanieAkceptacja ==1}">
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
                        
                                    
        </div>
        </div>
        </div>

        

    </body>
</html>