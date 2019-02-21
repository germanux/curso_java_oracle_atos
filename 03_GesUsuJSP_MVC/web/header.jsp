<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>

<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String error = (String) session.getAttribute("mensajeError");
%>
<h2>Aplicación Gestión MVC JSP</h2>
<nav>
    <a href="index.jsp">Inicio</a>
    <% if (usuario != null) {  %>
        <a href="listar.jsp">Listar</a>   
        <a href="eliminar.jsp">Eliminar</a> 
    <% } else { %>
        <a href="login.jsp">Login</a>
        <a href="registrarse.jsp">Registrarse</a>
    <% }  %>
</nav>
