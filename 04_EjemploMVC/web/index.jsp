<%-- 
    Document   : index
    Created on : 21-feb-2019, 9:44:53
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <form action="procesar.do" method="GET">
            Nombre: <input id="nombre" type="text" name="nombre"/><br/>
            Edad: <input id="edad" type="text" name="edad"/><br/>
            <input type="submit" value="Enviar datos"/>
        </form>
    </body>
</html>
