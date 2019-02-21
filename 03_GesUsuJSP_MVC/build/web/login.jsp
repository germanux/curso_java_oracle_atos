<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@page import="util.Utilidades"%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Formulario JSP de registro</h1> 
        <% if ( error!= null && !error.isEmpty()) { %>
            <h3 style="color: red"><%= error %></h3>
            <%  session.setAttribute("mensajeError", "");
         } %>
        <form name="form1" method="get" action="./usuarios.do">
            <table border="1">
               <tr><td>Email</td><td>
                       <input type="email" name="email" id="email" value="<%= Utilidades.getCookie(request, "email") %>"/>  </td></tr> 
                <tr><td>Contraseña</td><td>
                    <input type="password" name="password" id="password" value="<%= Utilidades.getCookie(request, "password") %>"/>  </td></tr> 
            </table>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>