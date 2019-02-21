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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.logica.IPersonaDAO;

/**
 *
 * @author USUARIO
 */
public class JavaJDPersona implements IPersonaDAO {

    public JavaJDPersona() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(JavaJDPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean guardarPersona(Persona persona) {

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB",
                "usuario", "usuario")) {
            String squery = "SELECT COUNT(Id) as ultId FROM Persona";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int ultId = res.getInt("ultId");
                ultId++; // Nuestro autoincrement
                squery = "INSERT INTO Persona (Id, Nombre, Edad) VALUES(" + ultId + ", '" + persona.getNombre() + "', "
                        + persona.getEdad() + ")";
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
    public Persona leerPersona() {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB",
                "usuario", "usuario")) {
            String squery = "SELECT nombre, edad FROM Persona ORDER BY id DESC";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) {   // Cogemos cualquier persona (última o la primera...)
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                return new Persona(nombre, edad);
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
