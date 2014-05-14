
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <script>
               $(document).ready(function(){
               $("#rezerwacjaB").click(function(){
               alert("Aby rezerwowac samochody zaloguj sie ");
	
               });
               });
            
        </script>
        
        
    </head>
    <body>

        <div id = 'container'>
        	<div id='header'>
        		<div id= 'logo'> </div>
        		<%@ include file="includes/pasekLogowania.jsp" %>
        		<%@ include file="includes/panelLogowania.jsp" %>
        	</div>
        	<%@ include file="includes/menuPoziome.jsp" %>
        	<div id="srodek">
        		<div class='linia'> </div>
				<div id="srodekNaglowek">
					<div id="srodekZnacznik"> </div>
					<p>SAMOCHODY</p>
				</div>
				<div class='linia'> </div>
				<div id="srodekTresc"> </div>
        		
        	</div>
        </div>


    </body>
</html>
