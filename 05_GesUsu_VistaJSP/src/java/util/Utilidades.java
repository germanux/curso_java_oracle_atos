/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author USUARIO
 */
public class Utilidades {
    public static String getCookie(HttpServletRequest request, String nombre) {
        Cookie[] cks = request.getCookies();
        for (Cookie ck : cks) {
            if (ck.getName().equals(nombre))
                return ck.getValue();
        }
        return "";
    }
}
