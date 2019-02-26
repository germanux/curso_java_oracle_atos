<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>
<%@page import="modelo.Usuario" %>
<%@page import="modelo.logica.ServicioUsuarios" %>
<%@page import="java.util.ArrayList" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String error = (String) session.getAttribute("mensajeError");
%>
<h2>Aplicación Gestión MVC JSP</h2>
<nav>
    <a href="index.jsp">Inicio</a>
    <% if (usuario != null) { %>
        <a href="listar.jsp">Listar</a>   
        <a href="eliminar.jsp">Eliminar</a>
        <form action="usuarios.do" style="display: inline-block">
            <input id="email" name="email" type="hidden" value="LOGOUT"/>
            <input TYPE="submit" value="Salir"/>
        </form>
    <% } else { %>
        <a href="login.jsp">Login</a>
        <a href="registrarse.jsp">Registrarse</a>
    <% } %>
 </nav>
<% if (error != null && !error.isEmpty()) { %>
    <h3 style="color: red"> <%= error %> </h3>
    <% session.removeAttribute("mensajeError");
} %>