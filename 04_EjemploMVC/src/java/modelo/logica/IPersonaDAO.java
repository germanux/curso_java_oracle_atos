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
public interface IPersonaDAO {
    
    boolean guardarPersona(Persona persona);
    
    Persona leerPersona();
}
