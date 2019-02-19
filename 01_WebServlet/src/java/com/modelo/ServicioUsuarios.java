/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ServicioUsuarios {
    private static ServicioUsuarios instancia;
    private final ArrayList<Usuario>  usuarios;    
    private ServicioUsuarios() {
        this.usuarios = new ArrayList<Usuario>();
    }    
    public static ServicioUsuarios getInstancia() {
        if (instancia == null) instancia = new ServicioUsuarios();
        return instancia;
    }
    public boolean addUser(String nom, int edad, String email, String passwd) {
        Usuario nuevoUsu = new Usuario(nom, edad, email, passwd);
        this.usuarios.add(nuevoUsu);
        return true;
    }
    public boolean validacionPasswd(String email, String passwd) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(passwd)) {
                return true;
            }
        }
        return false;
    }
}
