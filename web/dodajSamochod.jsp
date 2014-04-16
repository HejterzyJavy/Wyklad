<%-- 
    Document   : dodajSamochod
    Created on : 2014-04-17, 00:09:56
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <form align="center" action="CarKontroler" method="POST">
                <div>
                <h3>Wpisz marke samochodu: <input type="text"  name="firma"></h3>
                
                </div>
                <h3>Wpisz model samochodu:  <input type="text" name="model"></h3>
               
                <h3>Wpisz rok produkcji: <input type="text" name="rokProdukcji"></h3>
                
                <h3>Rodzaj paliwa:</h3>
                <input type="radio" name="paliwo" value="olej napedowy">olej
                <input type="radio" name="paliwo" value="benzyna">benzyna
                <h3>Moc silnika:  <input type="text" name="mocSilnika"></h3>
               
                <h3>Przebieg:<input type="text" name="przebieg"></h3>
                
                <h3>Pojemnosc: <input type="text" name="pojemnosc"></h3>
                
                <h3>Skrzynia biegow:</h3>
                <input type="radio" name="skrzynia" value="automatyczna">Male
                <input type="radio" name="skrzynia" value="manualna">Female
                
                <h3>Typ Nadwozia: <input type="text" name="typNadwozia"></h3>
                
                <h3>Podaj sciezke do zdjecia: <input type="text" name="sciezka"></h3>
                
            </form>
        
  
    </body>
</html>
