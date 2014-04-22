<%-- 
    Document   : Wypozyczanie
    Created on : 2014-04-22, 11:57:25
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
           <table align="center" >
          <c:forEach var="cars" items="${Cars}" >
          <tr>
          <td><input type="checkbox" value="${cars.getId()}" name="${cars.getId()}"></td>
          <td>${cars.getMarka()}</td><td>${cars.model}</td><td>${cars.rocznik}</td>
          </tr>
          <c:set var="ilosc" scope="session" value="${cars.getId()}"/>
          </c:forEach>
          </table>
          <c:choose>
              <c:when test="${ilosc > 0}">
             <div align="center">
                  <input type="submit" value="zatwierdz"  name="zatwierdzUsun">
            </div>  
            </c:when>
         </c:choose>
        
        
    </body>
</html>
