<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.logica.ServicioUsuarios"%>
<%@include file="head.jsp" %>
<%! ArrayList<Usuario> todosUsuarios;%>
<% todosUsuarios = ServicioUsuarios.getInstancia().listar();%>
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Formulario JSP de login</h1> 
        <% if ( error!= null &&  !error.isEmpty()) { %>
            <h3 style="color: red"><%= error %></h3>
            <%  session.setAttribute("mensajeError", "");
         } %>
        <h1>Todos los usuarios</h1>
        <table border="2">
            <% for (Usuario usu : todosUsuarios) {%>
                <tr><td><%= usu.getId()%></td>
                    <td><%= usu.getNombre()%></td>
                    <td><%= usu.getEmail()%></td>
                    <td><%= usu.getEdad()%></td>
                    <td><%= usu.getPassword()%></td>
                </tr>
            <% }%>
        </table>
    </body>
</html>