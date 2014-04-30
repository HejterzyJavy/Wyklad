<%-- 
    Document   : wypozyczanieSamochodu
    Created on : 2014-04-30, 19:22:29
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
        <c:set var="wypozyczanySamochod" scope="session" value="${wypozyczanySamochod}"/>
        <c:set var="aktualnaData" scope="session" value="${aktualnaData}"/>
        <c:set var="idSamochodu" scope="session" value="${idSamochodu}"/>
        <c:set var="jakieId" scope="session" value="${jakieId}"/>
        
        <h1>last id ${ostatniId} idKlient ${jakieId}  idsamochod ${idSamochodu}  ${aktualnaData}  ${wypozyczanySamochod.getMarka()}  ${wypozyczanySamochod.getModel()} ${wypozyczanySamochod.getCenaDoba()}</h1>
        <form action="RentKontroler" method="POST">
            <input type="date" name="dataWypozyczenia" value="${aktualnaData}">
            <input type="date" name="dataZwrotu">
            <input type="submit" name="obliczKwote" value="Oblicz Kwote">
            <input type="submit" name="wypozycSamochod" value="Zatwierdz">
        </form>
    </body>
</html>
