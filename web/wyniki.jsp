<%-- 
    Document   : wyniki
    Created on : 2014-03-26, 00:38:02
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<h1 align="center">JSP z rekomendacjami dotyczącymi piwa</h1>
<p>
<%
Integer jak=(Integer)request.getAttribute("jak");   
String wynikLogowania=(String)request.getAttribute("styles");
out.print(jak+" "+wynikLogowania);

%>
</body>
</html>