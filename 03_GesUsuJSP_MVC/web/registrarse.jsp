<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Formulario JSP de registro</h1> 
        <% if (  error!= null && !error.isEmpty()) { %>
            <h3 style="color: red"><%= error %></h3>
            <%  session.setAttribute("mensajeError", "");
         } %>
        <form name="form1" method="post" action="./usuarios.do">

            <table border="1">
                <tr><td>Nombre:</td><td>
                        <input type="text" name="nombre" id="nombre" size="25" value=""/>  </td></tr>
                <tr><td>Edad:</td><td>
                        <input type="number" name="edad" id="edad" value=""/>  </td></tr> 
               <tr><td>Email</td><td>
                        <input type="email" name="email" id="email" value=""/>  </td></tr> 
                <tr><td>Contraseña</td><td>
                    <input type="password" name="password" id="password" value=""/>  </td></tr> 
            </table>
            <input type="submit" value="Regisrar"/>
        </form>
    </body>
</html>