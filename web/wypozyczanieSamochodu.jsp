<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AutoRent - Wypozyczalnia Samochodów</title>
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

        <script>
            $(document).ready(function() {
                $("#rezerwacjaB").click(function() {
                    alert("Aby rezerwowac samochody zaloguj sie ");

                });
            });

        </script>


    </head>
    <body>
        <div id = 'container'>
            <div id='header'>
                <div id= 'logo'> 
                
                </div>
                <div id='pasekLogowania'>
                </div>
                <div id="panelLogowania">
                    <div id="panelLogowaniaNaglowek"><p>Logowanie</p></div>


                            <div>
                                <label>Login:</label>
                                <input type="text" name="login" />
                            </div>
                            <div>
                                <label>Haslo: <a href="forgot_password.html" rel="forgot_password" class="zapomnianeHaslo"> Zapomniales hasla? </a> </label>
                                <input type="password" name="haslo" />
                            </div>
                            <div class="bottom">
                                <input type="SUBMIT" name="Logowanie" value="ZALOGUJ">
                                <a href="register.html" rel="register" class="linkform"> Nie masz jeszcze konta? Zarejestruj sie</a>
                                <div class="clear"></div>
                            </div>
                        </fieldset>
                    </form>

                </div>
            </div>
            <div id='menuPoziome'>
                <div id='rezerwacjaB'> <p>REZERWUJ </p></div>
                <div class='przyciskMenu'> <a href="Samochody.jsp"><p>SAMOCHODY</p></a> </div>
                <div class='przyciskMenu'>  <a href="Samochody.jsp"><p>OFERTA</p></a> </div>
                <div class='przyciskMenu'> <p>LOKALIZACJA</p> </div>
                <div class='przyciskMenu'> <p>USLUGI</p> </div>
                <div class='przyciskMenu'> <p>NAGRODY</p> </div>
                <div class='przyciskMenu'> <p>DLA FIRM</p> </div>
            </div>
            <div id="srodek">
                <div class='linia'> </div>
                <div id="srodekNaglowek">
                    <div id="srodekZnacznik"> </div>
                    <p>REZERWACJA</p>
                </div>
                <div class='linia'> </div>
                <div id="srodekTresc">   
                    <c:set var="obliczanieKwoty" scope="session" value="${obliczanieKwoty}"/>      
                    <c:set var="daneKlient" scope="session" value="${daneKlient}"/>
                    <c:set var="wypozyczanySamochod" scope="session" value="${wypozyczanySamochod}"/>
                    <c:choose>
                        <c:when test="${obliczanieKwoty == 0}">
                            <c:set var="dataWypozyczenia" scope="session" value="${aktualnaData}"/>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${obliczanieKwoty == 1}">
                            <c:set var="doZaplaty" scope="session" value="${doZaplaty}"/>
                            <c:set var="dataWypozyczenia" scope="session" value="${dataWypozyczenia}"/>
                            <c:set var="dataZwrotu" scope="session" value="${dataZwrotu}"/>
                        </c:when>
                    </c:choose>

                    <c:set var="idSamochodu" scope="session" value="${idSamochodu}"/>
                    <c:set var="jakieId" scope="session" value="${jakieId}"/>



                    <h2 align="center">${wypozyczanySamochod.getMarka()} ${wypozyczanySamochod.getModel()} </h2>
                    <div class="imgSamochodu">
                        <img src="ZdjecieZBazy?id=${wypozyczanySamochod.getId()}">
                        
                    </div>
                         <div id="cenaKolo">
                        <div id="cena">${wypozyczanySamochod.getCenaDoba()}</div> <img src="img/zl24.png">

                    </div>
                    <div class ='wyposazenie'>

                        <ol class="rectangle-list">

                            <c:forEach items="${wyposazenie}" var="item">
                                <li><a href="#">${item}</a><li>
                                </c:forEach>
                        </ol>

                    </div>  

                   


                        <div id="ramkaWypozyczenie">
                    <div class ='wypozyczanie'>
                        <c:choose>
                            <c:when test="${obliczanieKwoty == 0}">
                                <form action="RentKontroler" method="POST">

                                    <c:choose>
                                        <c:when test="${doZaplaty != null}">
                                            <h2>Aktualnie do zaplaty mamy ${doZaplaty}</h2>  
                                        </c:when>
                                    </c:choose>
                                   
                                    <div class="datyWypozyczenieSamochodu">
                                    <table>
                                        <tr>
                                            <td>Wypozyczenie: </td><td><input type="date" name="dataWypozyczenia" value="${dataWypozyczenia}"></td>
                                        </tr>
                                       
                                        <tr>  
                                            <td>Zwrot: </td><td><input type="date" name="dataZwrotu"  value="${dataZwrotu}"></td>
                                        </tr>
                                    </table>
                                    </div>
                                        
                                    <div class="zatwierdzWypozyczenieSamochodu">
                                    <input type="submit" name="wypozyczSamochod" value="Zatwierdz">
                                    </div>
                                </form>
                            </c:when>
                        </c:choose>   
                         </div>
                        </div>
                    </div>	
                </div>
            </div>

    </body>
</html>
