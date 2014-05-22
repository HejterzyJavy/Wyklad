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
                 <h3>Rejestracja: <input type="text" name="rejestracja"></h3>
                    
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
                
                
                <br>
            
                <input type="checkbox" name="naped" value="4x4">Naped 4 x 4
                <br>
                <input type="checkbox" name="centralny_zamek" value="centralny_zamek">centralny zamek
                <br>
                <input type="checkbox" name="czujnik_deszczu" value="czujnik_deszczu">czujnik deszczu
                <br>
                <input type="checkbox" name="czujnik_parkowania" value="czujnik_parkowania">czujnik parkowania
                <br>
                <input type="checkbox" name="el_lusterka" value="el_lusterka">elektryczne lusterka
                <br>
                <input type="checkbox" name="el_szyby" value="el_szyby">elektryczne szyby
                <br>
                <input type="checkbox" name="klimatyzacja" value="klimatyzacja">klimatyzacja
                <br>
                <input type="checkbox" name="komputer_pokladowy" value="komputer_pokladowy">komputer pokladowy
                <br>
                <input type="checkbox" name="pod_przed_szyba" value="pod_przed_szyba">podgrzewana przednia szyba
                <br>
                
                <input type="checkbox" name="pod_fotele" value="pod_fotele">podgrzewana fotele
                <br>
                <input type="checkbox" name="radio" value="radio">radio
                <br>
                <input type="checkbox" name="system_nawigacji" value="system_nawigacji">system nawigacji
                <br>
                <input type="checkbox" name="skorzana_tapicerka" value="skorzana_tapicerka">skorzana tapicerka
                <br>
                <input type="checkbox" name="tempomat" value="tempomat">tempomat
                <br>
                <input type="checkbox" name="wsp_kierownicy" value="wsp_kierownicy">wspomgaganie kierownicy
                <br>
                <input type="checkbox" name="kontrola_antyposlizgowa" value="kontrola_antyposlizgowa">kontrola antyposlizgowa
                <br>
                <input type="checkbox" name="autoalarm" value="autoalarm">autoalarm
               
                <br>
                <input type="checkbox" name="blok_skrzyni_biegow" value="blok_skrzyni_biegow">blok skrzyni biegow
                <br>
                <input type="checkbox" name="esp" value="esp">elektroniczny program stabilizacji
                <br>
                <input type="checkbox" name="immobiliser" value="immobiliser">immobiliser
                <br>
                <input type="checkbox" name="poduszki_powietrzne" value="poduszki_powietrzne">poduszki powietrzne
                <br>
                <input type="checkbox" name="alufelgi" value="alufelgi">alufelgi
                <br>
                <input type="checkbox" name="bagaznik_na_dachu" value="bagaznik_na_dachu">bagaznik na dachu
                <br>
                <input type="checkbox" name="hak" value="hak">hak
                <br>
                <input type="checkbox" name="ksenony" value="ksenony">ksenony
                <br>
                <input type="checkbox" name="przyc_szyby" value="przyc_szyby">przyciemniane szyby
                <br>
                <input type="checkbox" name="szyberdach" value="szyberdach">szyberdach
                <br>
                <br>
                
                <input type="date" name="rozpoczecieOc" value="rozpoczecieOc">data rozpoczecia OC
                <input type="date" name="ZakonczenieOc" value="ZakonczenieOc">data zakonczenia OC
          
                <br>
                <br>
                <input type="date" name="rozpoczecieAc" value="rozpoczecieAc">data rozpoczecia AC
                <input type="date" name="ZakonczenieAc" value="ZakonczenieAc">data zakonczenia AC
                <br>
                <input type="file" name="pliczek" />
                <input type="submit" name="zatwierdzSamochod" value="zatwierdz">
            </form>
        
  
    </body>
</html>
