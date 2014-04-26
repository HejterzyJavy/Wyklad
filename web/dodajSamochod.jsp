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
            <form  action="CarKontroler" method="POST" enctype="multipart/form-data">
                <div>
                <h3>marka samochodu: <input type="text"  name="firma"></h3>
                
                </div>
                <h3>model samochodu:  <input type="text" name="model"></h3>
               
                <h3>rok produkcji: <input type="text" name="rokProdukcji"></h3>
                
                <h3>Rodzaj paliwa:</h3>
                <input type="radio" name="paliwo" value="Olej napedowy">Olej napędowy
                <input type="radio" name="paliwo" value="Benzyna">Benzyna
                <h3>Moc silnika:  <input type="text" name="mocSilnika"></h3>
               
                <h3>Przebieg:<input type="text" name="przebieg"></h3>
                
                <h3>Pojemnosc: <input type="text" name="pojemnosc"></h3>
                
                <h3>Skrzynia biegow:</h3>
                <input type="radio" name="skrzynia" value="Automatyczna">Automatyczna
                <input type="radio" name="skrzynia" value="Manualna">Manualna
                
                <h3>Typ Nadwozia: <input type="text" name="typNadwozia"></h3>
                
                <h3>Cena za dobe: <input type="text" name="cenaDoba"></h3>
                
                <input type="file" name="pliczek" />
                
                <input type="submit" name="zatwierdzSamochod" value="zatwierdz">
            </form>
        
  
    </body>
</html>
