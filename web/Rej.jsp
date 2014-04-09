<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>  

    <head>  

        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">  

        <link type="text/css" href="css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet" />  

        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>  

        <script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>  

        <title>Zarejestruj</title>  

    </head>  

    <body>  

        <script>
            $(function() {
                $('input[name=dob]').datepicker();
            });

            $(function() {
                $("input[type=submit], a, button")
                        .button()
                        .click(function(event) {
                                                  });
            });
        </script>  

        <form method="POST" action="UserKontroler" name="frmAddUser"> 
            <ul>
                <li>
                Login: <input  
                        type="text" name="login"  
                        value="<c:out value="${user.login}" />" />   
                </li>
                <li>
                Haslo : <input  
                    type="text" name="haslo"  
                    value="<c:out value="${user.haslo}" />" />   
                </li>
                <li>
                Adres : <input  
                    type="text" name="adres"  
                    value="<c:out value="${user.adres}" />" />   
                </li>
                <li>
                Kod Pocztowy : <input  
                    type="text" name="kodPocztowy"  
                    value="<c:out value="${user.kodPocztowy}" />" />   
                </li>
                <li>
                Telefon : <input  
                    type="text" name="telefon"  
                    value="<c:out value="${user.telefon}" />" />   
                </li>
                <li>
                Imie: <input  
                        type="text" name="imie"  
                        value="<c:out value="${user.imie}" />" />   
                </li>
                <li>
                Nazwisko : <input  
                    type="text" name="nazwisko"  
                    value="<c:out value="${user.nazwisko}" />" /> 
                </li>
                <li>
                   Pesel : <input  
                    type="text" name="pesel"  
                    value="<c:out value="${user.pesel}" />" /> 
                </li>
                <li>
                Data urodzenia : <input  
                        type="text" name="dob"  
                        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" />   
                </li>

                Email : <input type="text" name="email"  
                               value="<c:out value="${user.email}" />" />  
                <li>
                    <input type="submit" name="Rejestruj" value="Submit" />  
                </li>
            </ul>
        </form>  

    </body>  

</html>  
