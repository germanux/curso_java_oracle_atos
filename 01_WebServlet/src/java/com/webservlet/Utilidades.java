/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author USUARIO
 */
public class Utilidades {
    
    public static String comprobarParam(
            HttpServletRequest req, 
            PrintWriter out, 
            String par) {
        String valor = req.getParameter(par);
        if (valor.equals("")) {
            out.println("<h2>El parámetro " 
                + par 
                + " no puede estar vacío.");
            return "";
        } else {
            return valor;
        }
    }
}
