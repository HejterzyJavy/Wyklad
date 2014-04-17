<%-- 
    Document   : Samochody
    Created on : 2014-04-17, 04:17:10
    Author     : Karol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <div class='przyciskG' id='pLogowania'> <a href="Log.jsp">LOGOWANIE</a> </div>
        			<div class='przyciskG' id='pRejestracja'> REJESTRACJA </div>
        		</div>
        		<div id="panelLogowania">
        			<div id="panelLogowaniaNaglowek"><p>Logowanie</p></div>
        			
					<form class="formularzLogowania"  method="POST" action="UserKontroler">
						<fieldset>
							
						<div>
							<label>Login:</label>
							<input type="text" name="login" />
						</div>
						<div>
							<label>Haslo: <a href="forgot_password.html" rel="forgot_password" class="zapomnianeHaslo"> Zapomniałeś hasła? </a> </label>
							<input type="password" name="haslo" />
						</div>
						<div class="bottom">
							<input type="SUBMIT" name="Logowanie" value="ZALOGUJ">
							<a href="register.html" rel="register" class="linkform"> Nie masz jeszcze konta? Zarejestruj się</a>
							<div class="clear"></div>
						</div>
						</fieldset>
					</form>

				</div>
        	</div>
        	<div id='menuPoziome'>
        		<div id='rezerwacjaB'> <p>REZERWUJ</p></div>
        		<div class='przyciskMenu'> <p>SAMOCHODY</p> </div>
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
					<p>SAMOCHODY</p>
				</div>
				<div class='linia'> </div>
				<div id="srodekTresc">
                                    <div align="center">
                                        <form align="center" action="CarKontroler" method="POST">
                                            <input type="submit" value="Wyswietl wszystkie samochody" name="oferta">
                                            
                                        </form>
                                    </div>
                                     <div class='linia'> </div>
                       
                                     <c:forEach var="cars" items="${Cars}" >
                                         <div class="kwadrat">
                                             <p>Marka:${cars.marka}</p>
                                              <p>Model:${cars.model}</p>
                                              <p>Rocznik:${cars.rocznik}</p>
                                         </div>
                                     </c:forEach>
                                    
                                   
    
                                    
                                    
                                </div>
        		
        	</div>
        </div>

        

    </body>
</html>

