
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

        <c:set var="czyZalogowany" scope="session" value="${czyZalogowany}"/>
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
                        
        		<div id='rezerwacjaB'><a href="Samochody.jsp"><p>REZERWUJ</p></a> </div>
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
                               <input type="submit" value="akceptuj wypozyczenia" name="akceptujWypozyczenia" style="height: 45px; width: 300px">   
                               <br>
                               <br>
                               <input type="submit" value="wyswietl nie zwrocone samochody"  name="nieZwrocone" style="height: 45px; width: 300px">
                               
                               </form>
         <c:set var="ilosc" scope="session" value="${0}"/>   
        <form action="CarKontroler" method="POST">    
             <br>
             <input type="submit" value="dodaj samochod" name="dodaj"  style="height: 45px; width: 300px">
             <br>
             <br>
             <input type="submit" value="usun samochod"  name="usun" style="height: 45px; width: 300px">
             <br>
             <br>
             <input type="submit" value="edytuj przebieg samochodu"  name="edit" style="height: 45px; width: 300px">
             <br>
             <br>
             <input type="submit" value="przyjmij samochody"  name="przyjmijSamochody" style="height: 45px; width: 300px">
             <br>
             <br>
             <input type="submit" value="przedluz OC/AC"  name="przedluzenie" style="height: 45px; width: 300px">
             <br>
             <br>
             <input type="submit" value="okresy rozliczeniowe"  name="rozliczenia" style="height: 45px; width: 300px">
        </form>
               <br>
               <br>                     
                 <form action="RentKontroler" method="POST">    
        <table align="center" >
          <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
          <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
          <c:forEach var="rents" items="${Rents}" >
            
          <tr>             
          <td>${rents.getIdWypozyczenie()} &nbsp &nbsp</td><td>${rents.getTmpImie()}&nbsp &nbsp </td><td>&nbsp &nbsp ${rents.getTmpNazwisko()}</td>
          <td>&nbsp &nbsp ${rents.getTmpMarka()}</td><td>&nbsp &nbsp ${rents.getTmpModel()}</td>
          <td>&nbsp &nbsp ${rents.getDoZaplaty()}</td><td>&nbsp &nbsp akceptuje<input type="radio" value="zaakceptowane" name="akc${rents.getIdWypozyczenie()}"</td>
          <td>&nbsp &nbsp nie akceptuje<input type="radio" value="odrzucone" name="akc${rents.getIdWypozyczenie()}"</td>
          <td><input type="text" value="${rents.getOpis()}" name="${rents.getIdWypozyczenie()}"></td>
          </tr>
          <c:set var="wyswietlanieAkceptacja" scope="session" value="${wyswietlanieAkceptacja}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${wyswietlanieAkceptacja >0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="akceptuj">
            </div>  
            </c:when>
         </c:choose>
           
        </form>
        
     
          
                     <form action="RentKontroler" method="POST">    
        <table align="center" >
          <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
          <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
          <c:forEach var="historia" items="${Historia}" >
            
          <tr>             
          <td>${historia.getIdWypozyczenie()} &nbsp &nbsp</td><td>${historia.getTmpImie()}&nbsp &nbsp </td>
          <td>&nbsp &nbsp ${historia.getTmpNazwisko()}</td>
          <td>&nbsp &nbsp ${historia.getTmpMarka()}</td><td>&nbsp &nbsp ${historia.getTmpModel()}</td>
          <td>&nbsp &nbsp ${historia.getDoZaplaty()}</td><td>&nbsp &nbsp ${historia.getDataWypozyczenia()}</td>
          <td>&nbsp &nbsp ${historia.getDataZwrotu()} </td>
          
             <c:choose>
              <c:when test="${historia.getZakonczono()==1}">
             <td>&nbsp &nbsp zlecenie zakonczone </td>
            </c:when>
         </c:choose>
          
               <c:choose>
              <c:when test="${historia.getZakonczono()==0}">
             <td>&nbsp &nbsp zlecenie w trakcie </td>
            </c:when>
         </c:choose>
          
          </tr>
          <c:set var="wyswietlanieAkceptacja" scope="session" value="${wyswietlanieAkceptacja}"/>
          </c:forEach>
          </table>
           
        </form>
          
          
          
          
          
          
          
        
        
        
        <form action="CarKontroler" method="POST">    
        <table align="center" >
          <c:forEach var="cars" items="${Edit}" >
          <tr>
          <td>${cars.getMarka()}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
           <td><input type="text" value="${cars.getPrzebieg()}" name="${cars.getId()}"></td>
          </tr>
          <c:set var="wyswietlEdycje" scope="session" value="${wyswietlEdycje}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${wyswietlEdycje > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzEdytuj">
            </div>  
            </c:when>
         </c:choose>
           
        </form>
        
           
          
        <form action="CarKontroler" method="POST">    
            <c:set var="wyswietlanieRozliczenia" scope="session" value="${wyswietlanieRozliczenia}"/>
            <br>
          <table align="center" >
          <c:forEach var="listaOplat" items="${listaOplat}" >
          <tr>
          <td>&nbsp &nbsp${listaOplat.getIdOplaty()}</td><td>&nbsp &nbsp${listaOplat.getRozpoczecieOc()}</td><td>&nbsp &nbsp${listaOplat.getZakonczenieOc()}</td>
          <td>&nbsp &nbsp${listaOplat.getRozpoczecieAc()}</td><td>&nbsp &nbsp${listaOplat.getZakonczenieAc()}</td>
          </tr>
          </c:forEach>
          </table>

         </form>
        
          
          
          
        <form action="CarKontroler" method="POST">    
        <table align="center" >
          <c:forEach var="cars" items="${Cars}" >
          <tr>
          <td><input type="checkbox" value="${cars.getId()}" name="${cars.getId()}"></td>
          <td>${cars.getMarka()}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
          </tr>
          <c:set var="wyswietlUsun" scope="session" value="${wyswietlUsun}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${wyswietlUsun > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzUsun">
            </div>  
            </c:when>
         </c:choose>        
        </form>
          
          
          <c:set var="wyswietlPrzyjmij" scope="session" value="${wyswietlPrzyjmij}"/>
          <form action="CarKontroler" method="POST">    
          <table align="center" >
          <c:forEach var="przyjmij" items="${przyjmij}" >
          <tr>
          <td><input type="checkbox" value="${przyjmij.getId()}" name="${przyjmij.getId()}"></td>
          <td>${przyjmij.getMarka()}&nbsp &nbsp &nbsp &nbsp</td><td>${przyjmij.model}&nbsp &nbsp &nbsp &nbsp</td><td>${przyjmij.rocznik}</td>
          </tr>
          
          </c:forEach>
          </table>
              
          <c:choose>
              <c:when test="${wyswietlPrzyjmij > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzPrzyjmij">
            </div>  
            </c:when>
           </c:choose>
           
          </form>
          
          
          
        </div>
        </div>
        </div>



    </body>
</html>