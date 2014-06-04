
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
        <script src="js/vendor/jquery-ui-1.10.4.custom.min.js"></script>


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
                        <input type="submit" value="akceptuj wypozyczenia" name="akceptujWypozyczenia"  >   
                        <input type="submit" value="Historia firmy"  name="nieZwrocone"  >
                    </form>
                    
                    <c:set var="ilosc" scope="session" value="${0}"/>   
                    <form action="CarKontroler" method="POST">    
                        <input type="submit" value="dodaj samochod" name="dodaj"   >
                        <input type="submit" value="usun samochod"  name="usun"  >
                        <input type="submit" value="edytuj przebieg samochodu"  name="edit"  >
                        <input type="submit" value="przyjmij samochody"  name="przyjmijSamochody"  >
                        <input type="submit" value="przedluz OC"  name="przedluzenieOC"  >
                        <input type="submit" value="przedluz AC"  name="przedluzenieAC"  >
                        <input type="submit" value="konczace ubezpieczenia"  name="koniecUbezpieczen"  >
                    </form>
                    <br>
                    <br>                     
                    <form action="RentKontroler" method="POST">    
                        <table align="center" >
                            <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
                            <c:set var="wyswietlNaglowkiAkceptacja" scope="session" value="${0}"/>
                            <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
                            <c:forEach var="rents" items="${Rents}" >           
                                    <c:choose>
                                        <c:when test="${wyswietlNaglowkiAkceptacja<1}">
                                            <tr> <td>Numer Zlec. &nbsp &nbsp</td><td>Imie &nbsp &nbsp</td><td>&nbsp &nbsp Nazwisko</td><td>&nbsp &nbsp Marka</td><td>&nbsp &nbsp Model</td><td>&nbsp &nbsp Do zaplaty</td>
                                               </tr>
                                                <c:set var="wyswietlNaglowkiAkceptacja" scope="session" value="${1}"/>
                                    </c:when>
                                    </c:choose> 
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
                                 <div class='zatwierdzPracownik'>
                                    <input  type="submit" value="zatwierdz"  name="akceptuj">
                                </div>
                            </c:when>
                        </c:choose>

                    </form>



                    <form action="RentKontroler" method="POST">    
                        <table align="center" >
                            <c:set var="daneSamochod" scope="session" value="${Cars2}"/>
                            <c:set var="wyswietlNaglowkiHistoria" scope="session" value="${0}"/>
                            <c:set var="daneUzytkownicy" scope="session" value="${Users}"/>
                            <c:forEach var="historia" items="${Historia}" >
                                
                                     <c:choose>
                                        <c:when test="${wyswietlNaglowkiHistoria<1}">
                                            <tr> <td>Numer Zlec. &nbsp &nbsp</td><td>Imie &nbsp &nbsp</td><td>&nbsp &nbsp Nazwisko</td><td>&nbsp &nbsp Marka</td><td>&nbsp &nbsp Model</td>
                                                <td>&nbsp &nbsp Do zaplaty</td><td>&nbsp &nbsp Data Wypozyczenia</td><td>&nbsp &nbsp Data Zwrotu</td><td>&nbsp &nbsp Status</td>
                                               </tr>
                                                <c:set var="wyswietlNaglowkiHistoria" scope="session" value="${1}"/>
                                    </c:when>
                                    </c:choose> 
                                
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
                        <c:set var="wyswietlNaglowkiEdycja" scope="session" value="${0}"/>
                        <table align="center" >
                            <c:forEach var="cars" items="${Edit}" >
                                
                                 <c:choose>
                                        <c:when test="${wyswietlNaglowkiEdycja<1}">
                                            <tr> <td>Marka</td><td> Model</td><td>Rocznik</td><td>&nbsp &nbsp &nbsp &nbsp Rejestracja</td>
                                                <td>&nbsp &nbsp &nbsp &nbsp  Aktualny Przebieg</td>
                                               </tr>
                                                <c:set var="wyswietlNaglowkiEdycja" scope="session" value="${1}"/>
                                    </c:when>
                                    </c:choose> 
                                
                                
                                
                                <tr>
                                    <td>${cars.getMarka()}&nbsp &nbsp &nbsp &nbsp</td><td>${cars.model}&nbsp &nbsp &nbsp &nbsp</td><td>${cars.rocznik}</td>
                                    <td>&nbsp &nbsp &nbsp &nbsp ${cars.rejestracja}</td>
                                    <td>&nbsp &nbsp &nbsp &nbsp<input type="text" value="${cars.getPrzebieg()}" name="${cars.getId()}"></td>
                                </tr>
                                <c:set var="wyswietlEdycje" scope="session" value="${wyswietlEdycje}"/>
                            </c:forEach>
                        </table>
                        <c:choose>
                            <c:when test="${wyswietlEdycje > 0}">
                                <div class ='zatwierdzPracownik'>
                                    <input type="submit" value="zatwierdz"  name="zatwierdzEdytuj">
                                </div>  
                            </c:when>
                        </c:choose>

                    </form>



                    <form action="CarKontroler" method="POST">
                        <c:set var="wyswietlNaglowki" scope="session" value="${1}"/>
                        <c:set var="wyswietlanieRozliczenia" scope="session" value="${wyswietlanieRozliczenia}"/>
                        <br>
                        <table align="center" border="3" >

                            <c:forEach var="listaOplat"  items="${listaOplat}"  >

                                <c:choose>
                                    <c:when test="${wyswietlNaglowki > 0}">
                                        <tr><td> &nbsp ID Oplaty </td> <td> &nbsp Rozpoczecie OC </td> <td> &nbsp Zakonczenie OC </td><td> &nbsp Rozpoczecie AC </td>
                                            <td> &nbsp Zakonczenie AC </td><td> &nbsp&nbsp Marka </td><td> &nbsp&nbsp Model </td><td> &nbsp&nbsp Rejestracja </td></tr>
                                            <c:set var="wyswietlNaglowki" scope="session" value="${0}"/>
                                        </c:when>
                                    </c:choose>

                                <tr>
                                    <td>&nbsp &nbsp${listaOplat.getIdOplaty()}</td><td>&nbsp &nbsp${listaOplat.getRozpoczecieOc()}</td><td>&nbsp &nbsp${listaOplat.getZakonczenieOc()}</td>
                                    <td>&nbsp &nbsp${listaOplat.getRozpoczecieAc()}</td>  <td>&nbsp &nbsp${listaOplat.getZakonczenieAc()}</td><td>&nbsp &nbsp${listaOplat.getTmpMarkaSamochodu()}</td>
                                    <td>&nbsp &nbsp${listaOplat.getTmpModelSamochodu()}</td><td>&nbsp &nbsp${listaOplat.getTmpRejestracjaSamochodu()}</td>
                                </tr>
                            </c:forEach>
                        </table>

                    </form>


                    <form action="CarKontroler" method="POST">
                        <c:set var="wyswietlNaglowkiOC" scope="session" value="${1}"/>
                        <c:set var="listaOC" scope="session" value="${listaOC}"/>
                        <c:set var="wyswietlListeOC" scope="session" value="${wyswietlListeOC}"/>
                        <c:set var="wyswietlZmianaOC" scope="session" value="${wyswietlZmianaOC}"/>
                        <br>
                        <table align="center" border="3" >

                            <c:forEach var="listaOplat"  items="${listaOC}"  >

                                <c:choose>
                                    <c:when test="${wyswietlListeOC > 0}">

                                        <c:choose>
                                            <c:when test="${wyswietlNaglowkiOC > 0}">
                                                <tr><td> &nbsp ID </td> <td> &nbsp Rozpoczecie OC </td> <td> &nbsp Zakonczenie OC </td>
                                                    <td> &nbsp&nbsp Marka </td><td> &nbsp&nbsp Model </td><td> &nbsp&nbsp Rejestracja </td>
                                                    <td> &nbsp&nbsp Nowy Poczatek OC </td><td> &nbsp&nbsp Nowy Koniec OC </td></tr>
                                                    <c:set var="wyswietlNaglowkiOC" scope="session" value="${0}"/>
                                                </c:when>
                                            </c:choose>

                                        <tr>
                                            <td>&nbsp &nbsp${listaOplat.getIdOplaty()}</td><td>&nbsp &nbsp${listaOplat.getRozpoczecieOc()}</td><td>&nbsp &nbsp${listaOplat.getZakonczenieOc()}</td>
                                            <td>&nbsp &nbsp${listaOplat.getTmpMarkaSamochodu()}</td><td>&nbsp &nbsp${listaOplat.getTmpModelSamochodu()}</td><td>&nbsp &nbsp${listaOplat.getTmpRejestracjaSamochodu()}</td>
                                            <td>&nbsp &nbsp<input type="date" style="width:170px;" name="pocz${listaOplat.getIdOplaty()}" value="${listaOplat.getZakonczenieOc()}"  ></td>
                                            <td>&nbsp &nbsp<input type="date" style="width:170px;" name="kon${listaOplat.getIdOplaty()}" ></td>
                                           
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>

                        <div align="center">
                            <c:choose>
                                <c:when test="${wyswietlZmianaOC > 0}">
                                    <div class ='zatwierdzPracownik'>
                                        <input type="submit" value="zatwierdz"  name="zatwierdzZmianaOC">
                                    </div>  
                                </c:when>
                            </c:choose>
                        </div>
                    </form>



                    <form action="CarKontroler" method="POST">
                        <c:set var="wyswietlNaglowkiAC" scope="session" value="${1}"/>
                        <c:set var="listaAC" scope="session" value="${listaAC}"/>
                        <c:set var="wyswietlListeAC" scope="session" value="${wyswietlListeAC}"/>
                        <c:set var="wyswietlZmianaAC" scope="session" value="${wyswietlZmianaAC}"/>
                        <br>
                        <table align="center" border="3" >

                            <c:forEach var="listaOplat"  items="${listaAC}"  >
                                <c:choose>
                                    <c:when test="${wyswietlListeAC > 0}">

                                        <c:choose>
                                            <c:when test="${wyswietlNaglowkiAC > 0}">
                                                <tr><td> &nbsp ID</td> <td> &nbsp Rozpoczecie AC </td> <td> &nbsp Zakonczenie AC </td>
                                                    <td> &nbsp&nbsp Marka </td><td> &nbsp&nbsp Model </td><td> &nbsp&nbsp Rejestracja </td>
                                                    <td> &nbsp&nbsp Nowy Poczatek AC </td><td> &nbsp&nbsp Nowy Koniec AC </td></tr>
                                                    <c:set var="wyswietlNaglowkiAC" scope="session" value="${0}"/>
                                                </c:when>
                                            </c:choose>

                                        <tr>
                                            <td>&nbsp &nbsp${listaOplat.getIdOplaty()}</td><td>&nbsp &nbsp${listaOplat.getRozpoczecieAc()}</td><td>&nbsp &nbsp${listaOplat.getZakonczenieAc()}</td>
                                            <td>&nbsp &nbsp${listaOplat.getTmpMarkaSamochodu()}</td><td>&nbsp &nbsp${listaOplat.getTmpModelSamochodu()}</td><td>&nbsp &nbsp${listaOplat.getTmpRejestracjaSamochodu()}</td>
                                            <td>&nbsp &nbsp<input type="date" style="width:170px;" name="pocz${listaOplat.getIdOplaty()}" value="${listaOplat.getZakonczenieAc()}"></td>
                                            <td>&nbsp &nbsp<input type="date" style="width:170px;" name="kon${listaOplat.getIdOplaty()}" ></td>
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>

                        <div align="center">
                            <c:choose>
                                <c:when test="${wyswietlZmianaAC > 0}">
                                    <div class ='zatwierdzPracownik'>
                                        <input type="submit" value="zatwierdz"  name="zatwierdzZmianaAC">
                                    </div>  
                                </c:when>
                            </c:choose>
                        </div>
                    </form>  




                    <form action="CarKontroler" method="POST">
                        <c:set var="wyswietlNaglowkiUbezpieczenia" scope="session" value="${1}"/>
                        <c:set var="listaAC" scope="session" value="${listaAC}"/>
                        <c:set var="wyswietlListeKoniec" scope="session" value="${wyswietlListeKoniec}"/>

                        <c:set var="count" value="0" scope="page" />
                        <br>
                        <table align="center" border="3" >

                            <c:forEach var="listaUbezpieczen"  items="${listaUbezpieczen}"  >
                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <c:set var="jakasZmienna" scope="session" value="${count}"/> 
                                <c:choose>
                                    <c:when test="${wyswietlListeKoniec > 0}">

                                        <c:choose>
                                            <c:when test="${wyswietlNaglowkiUbezpieczenia > 0}">
                                                <tr><td> &nbsp&nbsp Marka </td><td> &nbsp&nbsp Model </td><td> &nbsp&nbsp Rejestracja </td>
                                                    <td> &nbsp&nbsp Koniec OC  </td><td> &nbsp&nbsp Koniec AC </td></tr>
                                                    <c:set var="wyswietlNaglowkiUbezpieczenia" scope="session" value="${0}"/>
                                                </c:when>
                                            </c:choose>

                                        <tr>
                                            <td>&nbsp &nbsp${listaUbezpieczen.getTmpMarkaSamochodu()}</td>
                                            <td>&nbsp &nbsp${listaUbezpieczen.getTmpModelSamochodu()}</td>
                                            <td>&nbsp &nbsp${listaUbezpieczen.getTmpRejestracjaSamochodu()}</td>
                                            <td>&nbsp &nbsp${listaUbezpieczen.getDoKoncaOc()}

                                            </td>
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </form>  





                    <form action="CarKontroler" method="POST">    
                        <c:set var="wyswietlNaglowkiUsun" scope="session" value="${1}"/>
                        <table align="center" >
                            <c:forEach var="cars" items="${Cars}" >
                                <c:choose>  
                                <c:when test="${wyswietlNaglowkiUsun > 0}">      
                                                <tr><td>&nbsp &nbsp &nbsp &nbsp</td><td>  Marka &nbsp &nbsp &nbsp &nbsp</td><td>  Model &nbsp &nbsp &nbsp &nbsp</td><td>  Rocznik &nbsp &nbsp &nbsp &nbsp</td>
                                                    <td>&nbsp Rejestracja  </td></tr>
                                                    <c:set var="wyswietlNaglowkiUsun" scope="session" value="${0}"/>
                                          </c:when>
                                          </c:choose> 
                                            
                                <tr>
                                    <td><input type="checkbox" value="${cars.getId()}" name="${cars.getId()}"></td>
                                    <td>${cars.getMarka()} &nbsp &nbsp &nbsp &nbsp</td><td>${cars.model}&nbsp &nbsp &nbsp &nbsp</td><td>${cars.rocznik}</td>
                                    <td>&nbsp &nbsp &nbsp  ${cars.getRejestracja()}</td>
                                </tr>
                                <c:set var="wyswietlUsun" scope="session" value="${wyswietlUsun}"/>
                            </c:forEach>
                        </table>
                        <c:choose>
                            <c:when test="${wyswietlUsun > 0}">
                                <div class ='zatwierdzPracownik'>
                                    <input type="submit" value="zatwierdz"  name="zatwierdzUsun">
                                </div>
                            </c:when>
                        </c:choose>        
                    </form>


                    <c:set var="wyswietlPrzyjmij" scope="session" value="${wyswietlPrzyjmij}"/>
                    <c:set var="wyswietlNaglowkiPrzyjmij" scope="session" value="${1}"/>
                    <form action="CarKontroler" method="POST"> 
                        <br>
                        <br>
                        <table align="center" >
                            <c:forEach var="przyjmij" items="${przyjmij}" >
                                
                                   <c:choose>  
                                <c:when test="${wyswietlNaglowkiPrzyjmij > 0}">      
                                                <tr><td>&nbsp &nbsp &nbsp &nbsp</td><td>  Marka &nbsp &nbsp &nbsp &nbsp</td><td>  Model &nbsp &nbsp &nbsp &nbsp</td><td>  Rocznik &nbsp &nbsp &nbsp &nbsp</td>
                                                    <td>&nbsp Rejestracja  </td></tr>
                                                    <c:set var="wyswietlNaglowkiPrzyjmij" scope="session" value="${0}"/>
                                          </c:when>
                                          </c:choose> 
                                
                                <tr>
                                    <td><input type="checkbox" value="${przyjmij.getId()}" name="${przyjmij.getId()}"></td>
                                    <td>${przyjmij.getMarka()}&nbsp &nbsp &nbsp &nbsp</td><td>${przyjmij.getModel()}&nbsp &nbsp &nbsp &nbsp</td><td>${przyjmij.getRocznik()}&nbsp &nbsp &nbsp &nbsp</td>
                                    <td>${przyjmij.getRejestracja()}</td>
                                </tr>

                            </c:forEach>
                        </table>

                        <c:choose>
                            <c:when test="${wyswietlPrzyjmij > 0}">
                                <div class ='zatwierdzPracownik'>
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
