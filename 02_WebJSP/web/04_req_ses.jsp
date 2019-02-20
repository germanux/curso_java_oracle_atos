<%-- 
    Document   : 04_req_ses
    Created on : 20-feb-2019, 9:26:00
    Author     : Germán Caballero Rodríguez
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%-- https://github.com/germanux/curso_java_oracle_atos --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de peticiones y respuestas JSP</title>
    </head>
    <body>
        <h1>Gestión de peticiones y respuestas JSP</h1>
        <% 
            String nomApell = request.getParameter("nombre_apell");
            String desc = request.getParameter("descripcion");
            String email = request.getParameter("email");
            if (nomApell == null || desc == null || email == null)
            { %>
        <form action="04_req_ses.jsp" method="get">
            <p>Nombre y apellidos:</p>
            <p><input id="nombre_apell" type="text" name="nombre_apell" 
                      autocomplete="true" size="100" maxlength="100"
                       required="true" 
                       placeholder="Introduzca nombre y apellidos"/></p>
            <p>Descripción:</p>
            <p><textarea id="descripcion" name="descripcion" required="true" cols="100" rows="10"
                         placeholder="Introduzca una descripción detallada">                    
            </textarea></p>
            <p>Email:</p>
            <p><input id="email" type="text" name="email" 
                      autocomplete="true" size="100" maxlength="100"
                       required="true" 
                       placeholder="Introduzca su email"/></p>
        </form>
        <%
                if (nomApell != null || desc != null || email != null) {
                    // Lógica de validación
                    if (nomApell != null && nomApell.length() > 1) {
                        if (desc != null && desc.length() > 5) {
                            // Validacion del mail

                        } else {
                            out.println("<h3>Pona una descripción... so vago.</h3>");
                        }
                    } else {
                        %>  <h3>¿Qué pasa, no tienes nombre?</h3>  <%
                    }                
                }
            } // Fin if mostrar FORM
            else {  // Cuando parece que todo está Ok
                FileWriter fileWriter = new FileWriter("./solicitudes.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.printf("Nombre='%s'\nDescripcion='%s'\nE-mail='%s'\n", 
                        nomApell, desc, email);
                printWriter.close();
            }
        %>
    </body>
</html>
