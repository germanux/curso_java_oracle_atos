/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public interface IUsuarioDAO {
    
    boolean crear(Usuario persona);
    
    ArrayList<Usuario> listar();
    Usuario obtenerUno(int id);
    Usuario obtenerUno(String email);
    boolean eliminar(int id);
    boolean eliminar(String email);
    boolean modificar(Usuario persona);
}
