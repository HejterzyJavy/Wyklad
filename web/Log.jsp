
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><body>
<h1 align="center">LOGOWANIE</h1>
<form method="POST" action="UserKontroler">
    <table align="center">
        <tr>
            <td>Podaj swoj login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Podaj swoje haslo:</td>
            <td><input type="password" name="haslo"></td>
        </tr>
    </table>
<br><br>
<center>
    <input type="SUBMIT" name="Logowanie" value="ZALOGUJ">
</center>
</form>
</body></html>