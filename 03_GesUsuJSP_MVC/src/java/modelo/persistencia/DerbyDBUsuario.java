/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;
import util.Constantes;

/**
 *
 * @author USUARIO
 */
public class DerbyDBUsuario implements IUsuarioDAO {

    public DerbyDBUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(DerbyDBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean crear(Usuario persona) {

        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            String squery = "SELECT COUNT(Id) as ultId FROM usuario";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int ultId = res.getInt("ultId");
                ultId++; // Nuestro autoincrement
                squery = "INSERT INTO usuario (Id, Nombre, Edad, email, password) VALUES(" 
                        + ultId + ", '" + persona.getNombre() + "', "
                        + persona.getEdad() + ", '" + persona.getEmail() + "', '" + persona.getPassword() + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(squery);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Usuario> listar() {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            String squery = "SELECT id, nombre, edad, email, password FROM Usuario";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            while (res.next()) { 
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                String email = res.getString("email");
                String password = res.getString("password");
                Usuario usu = new Usuario(id, nombre, edad, email, password);
                listaUsuarios.add(usu);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Usuario obtenerUno(int id) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DERBY_DB,Constantes.USUARIO_DERBY_DB,Constantes.PASSWD_DERBY_DB )) {
            
            Usuario usu = null;
            String squery = "SELECT nombre, edad, email, password FROM Usuario WHERE Id=" + id;
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                String email = res.getString("email");
                String password = res.getString("password");
                usu = new Usuario(id, nombre, edad, email, password);
            }
            return usu;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
