<%-- 
    Document   : 07_clases
    Created on : 20-feb-2019, 17:25:26
    Author     : USUARIO
--%>

<%@page import="com.webjsp.ModelosDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <%= dameTitulo("Llamando a objeto Java") %> 
        <h3><%= new ModelosDatos().getDatos() %> </h3>
    </body>
</html>
