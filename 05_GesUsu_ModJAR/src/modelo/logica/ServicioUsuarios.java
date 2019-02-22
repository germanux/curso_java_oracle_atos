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

    public enum Resultado {

        Ok, CamposMal, NoLogin
    };
    private static final ServicioUsuarios instancia = new ServicioUsuarios();

    private ServicioUsuarios() {
    }

    public static ServicioUsuarios getInstancia() {
        return instancia;
    }

    public Usuario obtenerUno(String email) {
        return persistencia.obtenerUno(email);
    }

    public Usuario validarUsuario(int id, String nom, String strEdad, String email, String passwd) {
        int iEdad = 0;
        if (!nom.isEmpty() && !strEdad.isEmpty() && email != "" && passwd != "") {
            if (strEdad.matches("^[1-9][0-9]*$")) {
                try {
                    iEdad = Integer.parseInt(strEdad);
                    if (iEdad > 18) {
                        if (email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")) {
                            return new Usuario(id, nom, iEdad, email, passwd);
                        }
                    }
                } catch (NumberFormatException ex) {
                }
            }
        }
        return null;
    }

    public Resultado add(String nom, String strEdad, String email, String passwd) {
        Usuario nuevoUsu = validarUsuario(0, nom, strEdad, email, passwd);
        if (nuevoUsu != null) {
            if (this.persistencia.crear(nuevoUsu)) {
                return Resultado.Ok;    
            }
        }
        return Resultado.CamposMal;
    }

    public Resultado modificar(int id, String nom, String strEdad, String email, String passwd) {

        Usuario nuevoUsu = validarUsuario(id, nom, strEdad, email, passwd);
        if (nuevoUsu != null) {
            if (this.persistencia.modificar(nuevoUsu)) {
                return Resultado.Ok;    
            }
        }
        return Resultado.CamposMal;
    }

    public ArrayList<Usuario> listar() {
        return persistencia.listar();
    }

    public Usuario validacionPasswd(String email, String passwd) {

        Usuario usuario = persistencia.obtenerUno(email);
        if (usuario != null && usuario.getPassword().equals(passwd)) {
            return usuario;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return persistencia.eliminar(id);
    }

    public boolean eliminar(String email) {
        return persistencia.eliminar(email);
    }
}
