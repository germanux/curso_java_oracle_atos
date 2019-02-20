<%-- 
    Document   : 06_cookies_form.jsp
    Created on : 20-feb-2019, 16:19:43
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario cookies JSP</title>
    </head>
    <body>
        <h1>Formulario cookies JSP</h1>
        <form action="06_cookies.jsp" method="GET">
            Nombre: <input  id="nombre" type="text" name="nombre"/> <br/>
            Apellidos: <input  id="apellidos" type="text" name="apellidos"/> <br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
