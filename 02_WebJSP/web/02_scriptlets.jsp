<%-- 
    Document   : 02_scriptlets
    Created on : 19-feb-2019, 16:59:50
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptlet de JSP</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <%= dameTitulo("Scriptlet de JSP") %> 
        <%
            int numero = 7, factorial = 1;
            for (int i = numero; i > 1; i--) {
                factorial *= i;
            }
        %>
        <%-- Monstrar en negrita el número y el resultado --%>
        <p style="font-size: 20px; color: green;">
            EL factorial de <span style="font-weight: bold;">
                <%= numero %>
             </span>
             <%= " es <span style=\"font-weight: bold;\">" + factorial 
                     + "</span>"%>
        </p>
    </body>
</html>
