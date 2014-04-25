
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
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
					<p>WITAJ</p>
				</div>
				<div class='linia'> </div>
				<div align="center" id="srodekTresc"> 
                                
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
                        
                                    
        </div>
        </div>
        </div>

        

    </body>
</html>