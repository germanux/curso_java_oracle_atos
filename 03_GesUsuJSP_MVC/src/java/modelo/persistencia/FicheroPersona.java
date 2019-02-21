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
import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 *//*
public class FicheroPersona implements IUsuarioDAO {
    public static final String FICH =  System.getProperty("user.home") + "/persona.dat";
    
    private final ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();
    @Override
    public boolean crear(Usuario persona) {
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
    @Override
    public Usuario listar() {
        try {
            ObjectInputStream leyendoFich = new ObjectInputStream(
                    new FileInputStream(FICH));
            Usuario p = (Usuario) leyendoFich.readObject();
            leyendoFich.close();                
            return p;
        } catch (Exception ex) {            
            return null;
        }
    }
}
*/