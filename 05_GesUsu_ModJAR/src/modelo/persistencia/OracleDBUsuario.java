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

public class OracleDBUsuario  extends BaseDBUsuario {

    public OracleDBUsuario() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            this.conexionDB = Constantes.CONEX_ORACLE_DB;
            this.usuarioDB =  Constantes.USUARIO_ORACLE_DB;
            this.passwordDB = Constantes.PASSWD_ORACLE_DB;
        } catch (Exception ex) {
            Logger.getLogger(OracleDBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
