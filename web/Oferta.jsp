
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
        <script type="text/javascript" src="skryptOferta.js"></script>
        
        
        <script src="js/vendor/modernizr-2.7.1.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>');</script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
        <script src="js/vendor/jquery-ui-1.10.4.custom.min.js"> </script>

        
    </head>
    <body>
        <c:set var="wyswietlWypozycz" scope="session" value="${1}"/>
        <c:set var="wyswietlWyborRoku" scope="session" value="${1}"/>
        <c:set var="wyswietlZakresRoku" scope="session" value="${0}"/>
        <c:set var="wyswietlMarke" scope="session" value="${1}"/>
        <c:set var="wyswietlWyborMarki" scope="session" value="${0}"/>
        <c:set var="czyZalogowany" scope="session" value="${czyZalogowany}"/>
        <c:set var="ktoZalogowany" scope="session" value="${ktoZalogowany}"/>
        
        <div id = 'container'>
        	<div id='header'>
        		<div id= 'logo'> </div>
        		<div id='pasekLogowania'>
                         
                              <c:choose>
                              <c:when test="${ktoZalogowany==1}">  
                                   <form action="UserKontroler" method="POST">
                                    <input class="przyciskWyloguj" type="submit"  name="panelPracownika" value="PANEL"> 
                                </form>  
                                   </c:when>
                                    </c:choose> 
   
                             <c:choose>
                              <c:when test="${czyZalogowany==1}">  
                                <form action="UserKontroler" method="POST">
                                    <input class="przyciskWyloguj" type="submit"  name="wylogowanie" value="WYLOGUJ"> 
                                </form>
                                  </c:when>
                                    </c:choose> 
                                              
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
					<p>PANEL KLIENTA edytowany</p>
                                  
                              
                              <form align="center" action="CarKontroler" method="POST">
                                <c:set var="wyswietlWyborRoku" scope="session" value="${wyswietlWyborRoku}"/>
                                <c:set var="wyswietlZakresRocznika" scope="session" value="${wyswietlZakresRocznika}"/>
                                <c:set var="wyswietlMarke" scope="session" value="${wyswietlMarke}"/>
                                <c:set var="wyswietlWyborMarki" scope="session" value="${wyswietlWyborMarki}"/>  
                                <c:set var="wyswietlWypozycz" scope="session" value="${wyswietlWypozycz}"/>  
                              
                                
                                    
                                <div class="panelKlienta">
                              <c:choose>
                              <c:when test="${wyswietlWypozycz==1}">    
                              <input type="submit" value="Wyswietl Wszystkie samochody" name="oferta">    
                              </c:when>
                              </c:choose>  
                                </div>
                              
                                     <c:choose>
                                      <c:when test="${wyswietlMarke==1}">
                                  <input type="submit" value="Wyswietl Wybrana Marke" name="wybranoMarke">  
                                     </c:when>
                                    </c:choose> 
                              
                                  
                                       <c:choose>
                                      <c:when test="${wyswietlWyborMarki==1}">
                                          <br>
                                          <br>       
                                   <div class="daneMarka">
                                   <form  action="CarKontroler" method="POST">
                                   <label > Wybierz marke: </label>
                                   <input type="text"  name="pole" value="tutaj wpisz marke">  
                                   </div>
                                   <div class="zatwierdzKlient">
                                   <input type="submit" value="zatwierdz" name="marka">  
                                   </div>
                                          </form>
                                     </c:when>
                                    </c:choose> 
                                      
                                     
                                  
                              
                                       <c:choose>
                                      <c:when test="${wyswietlWyborRoku==1}">
                                  <input type="submit" value="Wyswietl Wybrany rocznik" name="wybranoRocznik">  
                                     </c:when>
                                    </c:choose> 
                                  
                                    <c:choose>
                                      <c:when test="${wyswietlZakresRocznika==1}">
                                          <br>
                                          <br>
                                          <div class="daneMarka">
                                  <input type="text" value="OD" name="rokOd">           
                                  <input type="text" value="DO" name="rokDo">   
                                  </div>
                                  <div class="zatwierdzKlient">
                                  <input type="submit" value="zatwierdz" name="rocznik">  
                                  </div>
                                     </c:when>
                                    </c:choose> 
                              
                              </form>
                              
                                
                             <form align="center" action="RentKontroler" method="POST">
                             </form>
                                
                             </div>
                                        
                                         <c:forEach var="cars" items="${Cars}" >
                                         
                                         <div class="kwadrat">
                                             
                                             <c:choose>
                                             <c:when test="${czyZalogowany == 1}">
                                             <form method="POST" action="RentKontroler" >
                                             <input type="image" name="jakiSamochod" value="${cars.id}" src="ZdjecieZBazy?id=${cars.id}" alt="Submit" width="250" height="250">
                                             </form>
                                             </c:when>
                                             </c:choose>
                                             
                                                  <c:choose>
                           <c:when test="${czyZalogowany == 0}">
                      
                            <img src="ZdjecieZBazy?id=${cars.id}" />
                        
                           </c:when>
                             </c:choose>
           
                                             <div class="opisSamochodu">
                                              <p>Marka: ${cars.marka}</p>
                                              <p>Model: ${cars.model}</p>
                                              <p>Rocznik: ${cars.rocznik}</p>
                                              <p>Rodzaj paliwa: ${cars.rodzajPaliwa}</p>
                                              <p>Moc silnika: ${cars.mocSilnika}</p>
                                              <p>Przebieg: ${cars.przebieg}</p>
                                              <p>Skrzynia biegow: ${cars.skrzyniaBiegow}</p>
                                              <p>Cena/24h: ${cars.cenaDoba}</p>

                                              
                                             </div>

                                         </div>
                                     </c:forEach>
                     
             
                                                                        
        </div>
        </div>
        </div>
        
        <div class="infoKlient" >
  <c:choose>
    <c:when test="${wyslanoEmail == 1}">
         <h2 align="center">Na adres e-mail podany przy rejestracji zostanie przeslana informacja na temat zlecenia.</h2> 
    </c:when>
 </c:choose>
       </div>
         
    </body>
</html>