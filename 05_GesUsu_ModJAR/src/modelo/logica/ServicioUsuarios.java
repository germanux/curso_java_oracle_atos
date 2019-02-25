/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.persistencia.DerbyDBUsuario;

/**
 *
 * @author USUARIO
 */
public class ServicioUsuarios {

    IUsuarioDAO persistencia = new DerbyDBUsuario();
    public enum Resultado { Ok, CamposMal, NoLogin };
    private static final ServicioUsuarios instancia = new ServicioUsuarios();
    private ServicioUsuarios() {}

    public static ServicioUsuarios getInstancia() {
        return instancia;
    }

    public Resultado add(String nom, String strEdad, String email, String passwd) {

        int iEdad = 0;
        if (strEdad.matches("^[1-9][0-9]*$")) {
            try {
                iEdad = Integer.parseInt(strEdad);
                return this.add(nom, iEdad, email, passwd);
            } catch (NumberFormatException ex) {
            }
        }
        return Resultado.CamposMal;
    }

    public Resultado add(String nom, int edad, String email, String passwd) {

        if ( !nom.isEmpty() && edad > 18 && email != "" && passwd != "") {
            Usuario nuevoUsu = new Usuario(0, nom, edad, email, passwd);
            this.persistencia.crear(nuevoUsu);
            return Resultado.Ok;
        } else {
            return Resultado.CamposMal;
        }
    }
    public ArrayList<Usuario> listar() {
        return persistencia.listar();
    }

    public Usuario validacionPasswd(String email, String passwd) {
        ArrayList<Usuario> todosUsuarios = persistencia.listar();
        for (Usuario usuario : todosUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(passwd)) {
                return usuario;
            }
        }
        return null;
    }
}
