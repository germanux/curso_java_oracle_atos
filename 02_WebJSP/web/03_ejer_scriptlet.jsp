<%-- 
    Document   : 03_ejer_scriptlet
    Created on : 19-feb-2019, 17:13:25
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tablas de multiplicar</title>
    </head>
    <body>
        <h1>Tablas de multiplicar</h1>
        
        <%-- Muestra un Tabla con sus TRs, TDs,
    de la tabla de multiplicar del 7 con JSP --%>
        <h2>tabla de multiplicar del 7 con JSP</h2>
        <% out.println("<h3>Evitar usar HTML en texto Java</h3>"); %>
        
        <% for (int n = 1; n <= 10; n++ ) { %>
        
        <table style="border-width: 4px; border-style: double; display: inline-block;">
            <th>
                <td>Tabla del <%= n %> </td>
            </th>
            <% for (int i = 1; i <= 10; i++ ) { %>
            <tr>
                <td><%= n %> por</td>
                <td><%= i %></td>
                <td>es <%= i * n %> </td>
            </tr>
            <% } %>
        </table>
        
        <% } %>
        
        
    </body>
</html>
