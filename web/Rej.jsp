<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>  

    <head>  

        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">  
        <link rel="stylesheet" href="css/formularz.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css">
        <link type="text/css" href="css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet" />  

        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>  

        <script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>  

        <title>Zarejestruj</title>  

    </head>  

    <body>  
        <div class="tytulRejestracja">
        <h1>REJESTRACJA</h1>
        </div>
        
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
        <div class="formularzRejestracji">
        <form method="POST" action="UserKontroler" name="frmAddUser">  
            <table>
            
                <tr>
                <td>Login: </td> 
                    <td><input  
                        type="text" name="login"  
                        value="<c:out value="${user.login}" />" />   
                    </td>
                </tr>
                
                <tr>
                <td>Haslo :</td> 
                <td><input  
                    type="text" name="haslo"  
                    value="<c:out value="${user.haslo}" />" /> 
                </td> 
                </tr>
                <tr>
                    <td>Adres :</td> 
                <td><input  
                    type="text" name="adres"  
                    value="<c:out value="${user.adres}" />" />  
                </td> 
                </tr>
                <tr>
                <td>Kod Pocztowy :</td> 
                <td><input  
                    type="text" name="kodPocztowy"  
                    value="<c:out value="${user.kodPocztowy}" />" />   
                </td> 
                </tr>
                <tr>
                    <td>Telefon : </td>
                <td><input  
                    type="text" name="telefon"  
                    value="<c:out value="${user.telefon}" />" />   
                </td>
                </tr>
                <tr>
                    <td>Imie: </td>
                    <td><input  
                        type="text" name="imie"  
                        value="<c:out value="${user.imie}" />" />   
                    </td>
               </tr>
               <tr>
                   <td>Nazwisko : </td>
               <td><input  
                    type="text" name="nazwisko"  
                    value="<c:out value="${user.nazwisko}" />" /> 
               </td>    
               </tr>
               <tr>
                   <td>Pesel :</td>
               <td><input  
                    type="text" name="pesel"  
                    value="<c:out value="${user.pesel}" />" /> 
               </td>
               </tr>
               <tr>
                   <td> Data urodzenia : </td>
               <td><input  
                        type="text" name="dob"  
                        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> 
               </td>
               </tr>
               <tr>
                   <td>Email : </td>
               <td><input type="text" name="email"  
                               value="<c:out value="${user.email}" />" /> 
               </td>
               </tr>
                </table>
               <div class="zakonczRejestracje">
               <input type="submit" name="Rejestruj" value="Zatwierdz" /> 
               </div>
        </form>  
</div>
    </body>  

</html>  
