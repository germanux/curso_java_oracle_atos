/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    // Lista, HashMap
    private Persona persona;
    
    public enum TipoResultado {OK, SIN_VALORES, EDAD_MAL};
    
    public boolean validarDatosPersona(String nombre, String edad) {
        return nombre.equals("") || edad.equals("");
    }
    public boolean validarEdad(String edad) {
       return edad.matches("^[0-9]+$");
    }
    public TipoResultado guardarPersona(String nombre, String edad) {
        if (validarDatosPersona(nombre, edad)) {
            if (validarEdad(edad)) {
                int iEdad = Integer.parseInt(edad);
                this.persona = new Persona(nombre, iEdad);
                return TipoResultado.OK;
            } else {
                return TipoResultado.EDAD_MAL;
            }
        } else {
                return TipoResultado.SIN_VALORES;
        }
    }
    public Persona getPersona() {
        return persona;
    }
}
