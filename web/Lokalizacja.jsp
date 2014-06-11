
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
   
                            
                              
                                              
        		</div>
        	
        	</div>
        	<div id='menuPoziome'>
                        
        		<div id='rezerwacjaB'><a href="Samochody.jsp"><p>REZERWUJ</p></a> </div>
                        <div class='przyciskMenu'> <a href="Samochody.jsp"><p>SAMOCHODY</p></a> </div>
        		<div class='przyciskMenu'> <p>OFERTA</p> </div>
        		<div class='przyciskMenu'> <a href="Lokalizacja.jsp"><p>LOKALIZACJA</p> </div>
        		<div class='przyciskMenu'> <p>USŁUGI</p> </div>
        		<div class='przyciskMenu'> <p>NAGRODY</p> </div>
        		<div class='przyciskMenu'> <p>DLA FIRM</p> </div>
        	</div>
        	<div id="srodek">
        		<div class='linia'> </div>
				<div id="srodekNaglowek">
					<div id="srodekZnacznik"> </div>
					<p>Dane Kontaktowe</p>
                                                                            
        </div>
                        <br>
                        <div class="kontakt" >
     <img src="img/siedziba_xl" alt="Tu podaj tekst alternatywny" />
          Wypożyczalnia Samochodów AutoRent:              
          Aleja Tysiąclecia Państwa Polskiego 7, Kielce   
          tel: 234543345
          </div>
        </div>
        </div>



    </body>
</html>
