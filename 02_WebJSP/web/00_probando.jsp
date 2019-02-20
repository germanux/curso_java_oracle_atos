<%-- 
    Document   : 00_probando
    Created on : 19-feb-2019, 16:30:06
    Author     : USUARIO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <%= dameTitulo("Probando JSP") %>                
        <%
            double num = Math.random();
            if (num > 0.8) {
        %>
        <h2>¡Que tengas un buen día!</h2>
        <% } else { %>
        <h2>Bueno, la vida continua...</h2>
        <% } %>
        <p><%= num %></p>        
        <a href="00_probando.jsp"><h3>Prueba de nuevo</h3></a>
    </body>
</html>
