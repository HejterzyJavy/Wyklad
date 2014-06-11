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

        <title>Przypomnij Haslo</title>  

    </head>  

    <body>  
        <div class="tytulRejestracja">
        <h2>Wpisz login oraz e-mail podany przy rejestracji a hasło zostanie wysłane na twoją poczte</h2>
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
        <div class="formularzPrzypomnienia">
        <form method="POST" action="UserKontroler" name="zapomnialemHasla">  
            <table>
            
                <tr>
                <td>Login: </td> 
                    <td><input  
                        type="text" name="podanyLogin"  
                        value="<c:out value="${user.login}" />" />   
                    </td>
                </tr>
                <tr><td> </td></tr>
               <tr>
                   <td>Email : </td>
               <td><input type="text" name="podanyEmail"  
                               value="<c:out value="${user.email}" />" /> 
               </td>
               </tr>
                </table>
               <div class="zatwierdzPrzypomnienieHasla">
               <input type="submit" name="zapomnialemHasla" value="Zatwierdz" /> 
               </div>
               <div class="powrotLogowanie">
               <input type="submit" name="powrotLogowanie" value="POWRÓT" /> 
               </div>
               
        </form> 
        <c:set var="komunikatPrzypomnienie" scope="session" value="${komunikatPrzypomnienie}"/>  
        <div class="komunikatPrzypomnienie">
        <h3>${komunikatPrzypomnienie}</h3>
        </div>  
</div>
          
    </body>  

</html>  
