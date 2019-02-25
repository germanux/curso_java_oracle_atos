/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modpruebas;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {

    static void mostrarResultado(ServicioUsuarios.Resultado res, String nombre) {
        System.out.print(" - Prueba " + nombre  +": ");
        switch (res) {
            case CamposMal:
                System.out.println("Error Campos Mal");
                break;
            case ErrorDB:
                System.out.println("Error DB");
                break;
            case NoLogin:
                System.out.println("Error No Login");
                break;
            case Ok:
                System.out.println("PRUEBA CORRECTA");
                break;
        }
    }
    static void listar() {
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().obtenerTodos();
        
        System.out.println("ServicioUsuarios.getInstancia().obtenerTodos():");
        todos.stream().forEach((u) -> {
            System.out.println("   - " + u.getId()  
                    + ", " + u.getNombre()
                    + ", " + u.getEdad()
                    + ", " + u.getEmail()  
                    + ", " + u.getPassword());
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando módulo modelo:");
        System.out.println("DATOS NO VÁLIDOS:");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", "10", "", ""),
            "Usuario no válido");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Aaaaaa Aaaa", "20", "xx@xx", ""),
            "Usuario no válido");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", "22", "aaa@aaa.com", ""),
            "Usuario no válido");
        System.out.println("DATOS VÁLIDOS:");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", "22", "aaa@aaa.com", "aaa"),
            "Usuario válido");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Bbbbb Bbbb", "33", "bbb@bbb.com", "bbb"),
            "Usuario válido");
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Cccc Ccccc", "44", "ccc@ccc.com", "ccc"),
            "Usuario válido");
        listar();
        mostrarResultado(
            ServicioUsuarios.getInstancia().add("Cccc Ccccc", "44", "ccc@ccc.com", "ccc"),
            "Usuario REPETIDO");
        Usuario usu = ServicioUsuarios.getInstancia().obtenerUno("ccc@ccc.com");
        mostrarResultado(
            ServicioUsuarios.getInstancia().modificar(usu.getId(), "CcccMM CccccMM", "55", "ccc@ccc.com", "ccc"),
            "modificar CcccMM CccccMM");
        mostrarResultado(
            ServicioUsuarios.getInstancia().eliminar("bbb@bbb.com"),
            "eliminar bbb");
        mostrarResultado(
            ServicioUsuarios.getInstancia().validarLoginUsuario("bbb@bbb.com", "bbb"),
            "validarLoginUsuario bbb");
        listar();
        mostrarResultado(
            ServicioUsuarios.getInstancia().eliminar("aaa@aaa.com"),
            "eliminar aaa");
        mostrarResultado(
            ServicioUsuarios.getInstancia().eliminar("ccc@ccc.com"),
            "eliminar ccc");
    }
    
}
