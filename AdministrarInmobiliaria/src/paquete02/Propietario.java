/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.io.Serializable;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Propietario implements Serializable {

    private String nombresPropietario;
    private String apellidosPropietario;
    private String identificacionPropietario;

    public Propietario(String nomPropietario, String apePropietario, String id) {
        nombresPropietario = nomPropietario;
        apellidosPropietario = apePropietario;
        identificacionPropietario = id;
    }

    public void establecerNombresPropietario(String a) {
        nombresPropietario = a;
    }

    public void establecerApellidosPropietario(String b) {
        apellidosPropietario = b;
    }

    public void establecerIdentificacionPropietario(String c) {
        identificacionPropietario = c;
    }

    public String obtenerNombresPropietario() {
        return nombresPropietario;
    }

    public String obtenerApellidosPropietario() {
        return apellidosPropietario;
    }

    public String obtenerIdentificacionPropietario() {
        return identificacionPropietario;
    }
}
