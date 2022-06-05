/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

import java.io.Serializable;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Ciudad implements Serializable{

    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String a, String b) {
        nombreCiudad = a;
        nombreProvincia = b;
    }

    public void establecerNombreCiudad(String c) {
        nombreCiudad = c;
    }

    public void establecerNombreProvincia(String d) {
        nombreProvincia = d;
    }

    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
}
