/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_gesusu_modprueba;

import java.time.Clock;
import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando Modulo de Modelo");
        // Datos no válidos
        ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", 10, "", "");
        ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", 20, "aaaa@aaa", "aaa");
        ServicioUsuarios.getInstancia().add("Bbbbbb Bbbbbbb", 10, "aaa@aaa.aaa", "aaa");
        ServicioUsuarios.getInstancia().add("Bbbbbb Bbbbbbb", 20, "aaa@aaa.aaa", "");
        listar();
        // Datos válidos
        ServicioUsuarios.getInstancia().add("Aaaaa Aaaa", 30, "aaa@aaa.aaa", "aaa");
        ServicioUsuarios.getInstancia().add("Bbbbbb Bbbbbbb", 40, "bbb@bbb.bbb", "bbb");
        ServicioUsuarios.getInstancia().add("Ccccc Cccccc", 40, "ccc@ccc.ccc", "ccc");
        // Datos no válidos
        ServicioUsuarios.getInstancia().add("Ccccc Cccccc", 40, "ccc@ccc.ccc", "ccc");
        listar();
        
        ServicioUsuarios.getInstancia().eliminar("ccc@ccc.ccc");
        Usuario u =  ServicioUsuarios.getInstancia().obtenerUno("bbb@bbb.bbb");
        ServicioUsuarios.getInstancia().eliminar(u.getId());   
        listar();     
    }
   static void listar() {
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().listar();
        
        System.out.println("Mostrando usuarios: ");
        for (Usuario u : todos) {
            System.out.println("   - " + u.getId() + ", " + 
                    u.getNombre()+ ", " + 
                    u.getEdad()+ ", <" + 
                    u.getEmail()+ ">, " + 
                    u.getPassword());
        }
    }
}
