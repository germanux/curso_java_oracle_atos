/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class FicheroPersona {
    public static final String FICH = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\curso_java_oracle_atos.git\\04_EjemploMVC\\persona.dat";
    
    public static boolean guardarPersona(Persona persona) {
        try {
            ObjectOutputStream escribFich = new ObjectOutputStream(
                    new FileOutputStream(FICH ));
            escribFich.writeObject(persona);
            escribFich.close();                
            return true;
        } catch (Exception ex) {            
            return false;
        }
    }
    public static Persona leerPersona() {
        try {
            ObjectInputStream leyendoFich = new ObjectInputStream(
                    new FileInputStream(FICH));
            Persona p = (Persona) leyendoFich.readObject();
            leyendoFich.close();                
            return p;
        } catch (Exception ex) {            
            return null;
        }
    }
}
