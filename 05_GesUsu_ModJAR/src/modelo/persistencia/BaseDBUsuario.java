/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;
import util.Constantes;

/**
 *
 * @author USUARIO
 */
public class BaseDBUsuario implements IUsuarioDAO {
    protected String conexionDB;
    protected String usuarioDB;
    protected String passwordDB;
    protected String tablaDB;
    
    @Override
    public boolean crear(Usuario persona) {

        try (Connection con = DriverManager.getConnection(
                conexionDB, usuarioDB, passwordDB )) {
            
            String squery  = "INSERT INTO " + tablaDB + " (Nombre, Edad, email, password) VALUES(" 
                        + "'" + persona.getNombre() + "', "
                        + persona.getEdad() + ", '" + persona.getEmail() + "', '" + persona.getPassword() + "')";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(squery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Usuario> obtenerTodos() {
        try (Connection con = DriverManager.getConnection(
                conexionDB, usuarioDB, passwordDB )) {
            
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            String squery = "SELECT id, nombre, edad, email, password FROM " + tablaDB + "";
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
    public Usuario obtenerUno(Integer id) {
        try (Connection con = DriverManager.getConnection(
                conexionDB, usuarioDB, passwordDB )) {
            
            Usuario usu = null;
            String squery = "SELECT nombre, edad, email, password FROM " + tablaDB + " WHERE Id=" + id;
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
    public Usuario obtenerUno(String email) {
        try (Connection con = DriverManager.getConnection(
                conexionDB, usuarioDB, passwordDB )) {
            
            Usuario usu = null;
            String squery = "SELECT id, nombre, edad, email, password FROM " + tablaDB + " WHERE email= '" + email + "'";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                // String email = res.getString("email");
                String password = res.getString("password");
                usu = new Usuario(id, nombre, edad, email, password);
            }
            return usu;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean eliminar(String email) {
        try (Connection con = DriverManager.getConnection(
          conexionDB, usuarioDB, passwordDB )) {
            
            String squery = "DELETE FROM " + tablaDB + " WHERE email=?";            
            PreparedStatement stmt = con.prepareStatement(squery);
            stmt.setString(1, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean modificar(Usuario usuario) {
        try (Connection con = DriverManager.getConnection(
          conexionDB, usuarioDB, passwordDB )) {
            
            String squery = "UPDATE " + tablaDB + " SET nombre=?, edad=?, email=?, password=? WHERE id=?";       
            PreparedStatement stmt = con.prepareStatement(squery);
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setInt(5, usuario.getId());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
