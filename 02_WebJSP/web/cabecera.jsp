<%-- 
    Document   : cabecera
    Created on : 20-feb-2019, 16:50:26
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header><h1>Ejemplos JSP curso Java</h1></header>
<nav>
    <% String[] urls = {"00_probando.jsp", "01_expresiones.jsp", "02_scriptlets.jsp", 
        "03_ejer_scriptlet.jsp", "04_req_ses.jsp", "05_sesiones.jsp", "06_cookies_form.jsp"};
     String[] nombres = {"Probar", "Expresiones", "Scriptlets", 
        "Ejercicio Scriptlets", "Petición y respuesta", "Sesiones", "Cookies"};
     
     for (int i = 0; i < urls.length; i++) {
    %>
            <a href="<%= urls[i] %>"><%= nombres[i] %></a>
    <%  }   %>
</nav>

<%!
    private String dameTitulo(String titulo) {
        return "<h2 style='color: green;'> " + titulo + " </h2>";
    }
%>