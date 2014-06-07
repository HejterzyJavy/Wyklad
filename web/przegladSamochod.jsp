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
        <link rel="stylesheet" href="css/blitzer/jquery-ui-1.10.4.custom.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/formularz.css">




        <script src="js/vendor/modernizr-2.7.1.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>');</script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
        <script src="js/vendor/jquery-ui-1.10.4.custom.min.js"></script>



    </head>
    <body>
        <c:set var="czyZalogowany" scope="session" value="${czyZalogowany}"/>
        <c:set var="ktoZalogowany" scope="session" value="${ktoZalogowany}"/>
        <c:set var="wyslanoEmail" scope="session" value="${wyslanoEmail}"/>


        <c:choose>
            <c:when test="${ktoZalogowany == 1}">


            </c:when>
        </c:choose>


        <div id = 'container'>
            <div id='header'>
                <div id= 'logo'> </div>

                <c:choose>
                    <c:when test="${czyZalogowany == 0}">
                        <div id='pasekLogowania'>
                            <div class='przyciskG' id='pLogowania'> <a href="Log.jsp">LOGOWANIE</a> </div>
                            <div class='przyciskG' id='pRejestracja'> REJESTRACJA </div>
                        </div>


                    </c:when>
                </c:choose>

                <c:choose>
                    <c:when test="${czyZalogowany == 1}">
                         <div class='przyciskG' id='pLogowania' name="wyloguj"> 
                                <form action="UserKontroler" method="POST">
                                <input type="submit" name="wylogowanie" value="WYLOGUJ"> 
                                </form>
                                </div>  

                    </c:when>
                </c:choose>


            </div>
           
            <div id="srodek">
                <div class='linia'> </div>
                <div id="srodekNaglowek">
                    <div id="srodekZnacznik"> </div>
                    <p>SAMOCHODY</p>
                </div>
                <div class='linia'> </div>
                <div id="srodekTresc">
                    <div id="srodekPrzyciski">
                   
                        
                      
                    </div>
                
                    <div class='linia'> </div>

                    <c:forEach var="cars" items="${Cars}" >

                        <div class="kwadrat">
                        <img src="ZdjecieZBazy?id=${cars.id}" />
                              
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

                    <c:choose>
                        <c:when test="${wyslanoEmail == 1}">
                            <h2 align="center">Na emaila zostanie wyslana informacja na temat zlecenia</h2> 

                        </c:when>
                    </c:choose>



                </div>

            </div>
        </div>


    </body>
</html>

