/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Constantes;
/**
 *
 * @author USUARIO
 */
public class DerbyDBUsuario extends BaseDBUsuario {

    public DerbyDBUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            this.conexionDB = Constantes.CONEX_DERBY_DB;
            this.usuarioDB =  Constantes.USUARIO_DERBY_DB;
            this.passwordDB = Constantes.PASSWD_DERBY_DB;
            this.tablaDB = "usuario";
        } catch (Exception ex) {
            Logger.getLogger(DerbyDBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
