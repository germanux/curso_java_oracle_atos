<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Aplicación Gestión MVC JSP</h2>
<nav>
    <a href="index.jsp">Inicio</a>
    <c:catch var="exepcion">        
        <jsp:useBean id="usuario" type="modelo.Usuario" scope="session">
            <jsp:getProperty property="*" name="usuario"/>
            <jsp:getProperty property="id" name="usuario"/>
            <jsp:getProperty property="email" name="usuario"/>
        </jsp:useBean>
        <a href="usuarios.do">Listar</a>
        <a href="listarsql.jsp">Listar SQL</a>
        <a href="eliminar.jsp">Eliminar</a>
        <form action="usuarios.do" style="display: inline-block">
            <input id="email" name="email" type="hidden" value="LOGOUT"/>
            <input TYPE="submit" value="Salir"/>
        </form>
    </c:catch>
    <c:if test="${not empty exepcion}">
        <a href="login.jsp">Login</a>
        <a href="registrarse.jsp">Registrarse</a>
    </c:if>
 </nav>
<c:if test="${sessionScope.mensajeError != null}">
    <h3 style="color: orange"> ${ sessionScope.mensajeError } </h3>
    <c:remove var="mensajeError" scope="session"/>
</c:if>
<%--
    // Usuario usuario = (Usuario) session.getAttribute("usuario");
    String error = (String) session.getAttribute("mensajeError");
if (error != null && !error.isEmpty()) { %>
    <h3 style="color: red"> <%= error %> </h3>
    <% session.removeAttribute("mensajeError");
}
--%>