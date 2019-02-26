/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.logica.ServicioUsuarios;
import util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicioUsuarios.Resultado resultado;
        String strId = request.getParameter("id");
        int id = strId != null && !strId.isEmpty() ? Integer.parseInt(strId) : -1;
        String nom = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String p_email = request.getParameter("email");
        String p_password = request.getParameter("password");

        String ck_email = Utilidades.getCookie(request, "email");
        String ck_password = Utilidades.getCookie(request, "password");

        // Seleccionar los campos login de los parámetros o de las cookies
        String email = p_email != null && !p_email.isEmpty() ? p_email : ck_email;
        String password = p_password != null && !p_password.isEmpty()
                ? p_password : ck_password;

        Usuario usuario = null;
        if (ServicioUsuarios.getInstancia().validarLoginUsuario(email, password)
                == ServicioUsuarios.Resultado.Ok) {
            usuario = ServicioUsuarios.getInstancia().obtenerUno(email);
            // Usuario se está loquendo bien; creamos y enviamos las cookies al navegador
            Cookie cookie_email = new Cookie("email", email);
            Cookie cookie_password = new Cookie("password", password);
            response.addCookie(cookie_email);
            response.addCookie(cookie_password);
            switch (request.getMethod()) {
                case "GET":
                    if (email.isEmpty()) {  // Si no pide usuario, listamos todos
                        request.getRequestDispatcher("listar.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
                case "POST":    // Simulación servicio web
                    String metodo = request.getParameter("method"); // Campo INPUT hidden
                    switch (metodo) {
                        case "PUT": // Modificar
                            ServicioUsuarios.getInstancia().modificar(id, nom, edad, email, password);
                            request.getRequestDispatcher("listar.jsp").forward(request, response);
                            break;
                        case "DELETE":
                            ServicioUsuarios.getInstancia().eliminar(email);
                            request.getRequestDispatcher("listar.jsp").forward(request, response);
                            break;
                    }
                    break;
            }
        } else { // SIN Login
            switch (request.getMethod()) {
                case "POST":    // Es el registro, viene de registrarse.jsp
                    resultado = ServicioUsuarios.getInstancia().add(nom, edad, email, password);
                    switch (resultado) {
                        case Ok:
                            usuario = ServicioUsuarios.getInstancia().obtenerUno(email);
                            request.getSession().setAttribute("usuario", usuario);  // Guardamos JavaBean
                            request.getRequestDispatcher("registrado.jsp").forward(request, response);
                            break;
                        case CamposMal:
                            request.getSession().setAttribute("mensajeError", "Los campos no son correctos");
                            request.getRequestDispatcher("registrarse.jsp").forward(request, response);
                            break;
                        case ErrorDB:
                            request.getSession().setAttribute("mensajeError", "Error en BBDD");
                            request.getRequestDispatcher("registrarse.jsp").forward(request, response);
                            break;
                    }
                    break;
                default:    // SI intenmos loguearnos, o cualquier otra cosa y el login ha fallado...
                    request.getSession().setAttribute("mensajeError", "Login inválido");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
