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
                    <p>DODAJ SAMOCHÓD</p>
                </div>
                <div class='linia'> </div>
                <div id="srodekTresc">
                    <div id="srodekPrzyciski">
                   
                        
                      
                    </div>
                
                    <div class='linia'> </div>
          <form  action="CarKontroler" method="POST" enctype="multipart/form-data">
                <div >
                    <table>
                        <col width="180">
                        <tr>
                            <td> <h3>Rejestracja: </h3></td><td><input type="text" name="rejestracja"></td>
                      </tr>
                <tr>      
                <td><h3>marka samochodu: </h3></td> <td><input type="text"  name="firma"></td>
                </tr>
                <tr>  
                <td><h3>model samochodu: </h3></td> <td><input type="text" name="model"></td>
                </tr>
                <tr>  
                <td><h3>rok produkcji: </h3></td><td><input type="text" name="rokProdukcji"></td>
                </tr>
                <tr>  
                    <td><h3>Rodzaj paliwa:</h3></td><td><input type="radio" name="paliwo" value="Olej napedowy">Olej napędowy</td>
                    <td> <input type="radio" name="paliwo" value="Benzyna">Benzyna</td>                
                </tr>
                
               <tr>  
                   <td> <h3>Moc silnika: </h3></td> <td> <input type="text" name="mocSilnika"></td>
               </tr>
               
                <tr>  
                <td><h3>Przebieg: </h3></td><td><input type="text" name="przebieg"></td>
                </tr>
                
                <tr>  
                <td><h3>Pojemnosc: </h3></td><td><input type="text" name="pojemnosc"></td>
                </tr>
                <tr> 
                <td><h3>Skrzynia biegow:</h3></td>
                <td><input type="radio" name="skrzynia" value="Automatyczna">Automatyczna</td>
                <td><input type="radio" name="skrzynia" value="Manualna">Manualna</td>
                </tr>
                <tr> 
                <td><h3>Typ Nadwozia: </h3></td><td><input type="text" name="typNadwozia"></td>
                </tr>
                <tr> 
                <td><h3>Cena za dobe: </h3></td><td><input type="text" name="cenaDoba"></td>
                </tr>
                <tr>
                <tr><td></td><td><h3>&nbsp WYPOSAZENIE </h3></td><td></td></tr>
                <td><input type="checkbox" name="naped" value="4x4">Naped 4 x 4</td>
                <td><input type="checkbox" name="centralny_zamek" value="centralny_zamek">centralny zamek</td>
                <td><input type="checkbox" name="czujnik_deszczu" value="czujnik_deszczu">czujnik deszczu</td>
               </tr>
                
               <tr> 
               <td><input type="checkbox" name="czujnik_parkowania" value="czujnik_parkowania">czujnik parkowania </td>
               <td><input type="checkbox" name="el_lusterka" value="el_lusterka">elektryczne lusterka </td>
               <td><input type="checkbox" name="el_szyby" value="el_szyby">elektryczne szyby </td>
               </tr>
                
               <tr>
                   <td><input type="checkbox" name="klimatyzacja" value="klimatyzacja">klimatyzacja </td>  
                   <td><input type="checkbox" name="komputer_pokladowy" value="komputer_pokladowy">komputer pokladowy </td>  
                   <td><input type="checkbox" name="pod_przed_szyba" value="pod_przed_szyba">pod. przednia szyba </td>  
               </tr>
                <tr>
                    <td><input type="checkbox" name="pod_fotele" value="pod_fotele">podgrzewana fotele </td>
                    <td><input type="checkbox" name="radio" value="radio">radio </td>
                    <td><input type="checkbox" name="system_nawigacji" value="system_nawigacji">system nawigacji </td>
                </tr>
                
                <tr>
                    <td><input type="checkbox" name="skorzana_tapicerka" value="skorzana_tapicerka">skorzana tapicerka </td>  
                    <td><input type="checkbox" name="tempomat" value="tempomat">tempomat</td> 
                    <td><input type="checkbox" name="wsp_kierownicy" value="wsp_kierownicy">wspomgaganie</td> 
                </tr>
                <tr>
                    <td><input type="checkbox" name="kontrola_antyposlizgowa" value="kontrola_antyposlizgowa">k. antyposlizgowa </td>
                    <td> <input type="checkbox" name="autoalarm" value="autoalarm">autoalarm </td>
                    <td> <input type="checkbox" name="blok_skrzyni_biegow" value="blok_skrzyni_biegow">blok skrzyni biegow </td>
                </tr>
                <tr>
                    <td> <input type="checkbox" name="esp" value="esp">ESP </td>
                    <td> <input type="checkbox" name="immobiliser" value="immobiliser">immobiliser </td>
                    <td> <input type="checkbox" name="poduszki_powietrzne" value="poduszki_powietrzne">poduszki powietrzne </td>
                </tr>
      
                <tr>
                    <td><input type="checkbox" name="alufelgi" value="alufelgi">alufelgi</td>    
                    <td><input type="checkbox" name="bagaznik_na_dachu" value="bagaznik_na_dachu">bagaznik na dachu </td>
                    <td><input type="checkbox" name="hak" value="hak">hak </td>
                </tr>
                
                <tr>
                    <td><input type="checkbox" name="ksenony" value="ksenony">ksenony </td>
                    <td><input type="checkbox" name="przyc_szyby" value="przyc_szyby">przyciemniane szyby </td>
                    <td><input type="checkbox" name="szyberdach" value="szyberdach">szyberdach </td>
                </tr>
                <tr>
                    
                    <td><input type="date" name="rozpoczecieOc" value="rozpoczecieOc">rozpoczecia OC </td>
                    <td><input type="date" name="ZakonczenieOc" value="ZakonczenieOc">zakonczenia OC </td>
                </tr>
                <tr>
                    <td><input type="date" name="rozpoczecieAc" value="rozpoczecieAc">rozpoczecia AC </td>
                    <td><input type="date" name="ZakonczenieAc" value="ZakonczenieAc">zakonczenia AC </td>
                </tr>
             
                
                <tr>
                    <td> <input type="file" name="pliczek" /> </td>
                </tr>
          
                  <tr>
                    <td><input type="submit" name="zatwierdzSamochod" value="zatwierdz"></td>
                </tr>
                
            </form>
                    </table>
            </div>


                </div>

            </div>
        </div>


    </body>
</html>

