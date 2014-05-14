<%-- 
    Document   : panelLogowania
    Created on : 2014-05-14, 00:17:21
    Author     : Karol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="panelLogowania">
    <div id="panelLogowaniaNaglowek"><p>Logowanie</p></div>



    <form class="formularzLogowania"  method="POST" action="UserKontroler">
        <fieldset>

            <div>
                <label>Login:</label>
                <input type="text" name="login" />
            </div>
            <div>
                <label>Haslo: <a href="forgot_password.html" rel="forgot_password" class="zapomnianeHaslo"> Zapomniałeś hasła? </a> </label>
                <input type="password" name="haslo" />
            </div>
            <div class="bottom">
                <input type="SUBMIT" name="Logowanie" value="ZALOGUJ">
                <a href="register.html" rel="register" class="linkform"> Nie masz jeszcze konta? Zarejestruj się</a>
                <div class="clear"></div>
            </div>
        </fieldset>
    </form>
</div>
