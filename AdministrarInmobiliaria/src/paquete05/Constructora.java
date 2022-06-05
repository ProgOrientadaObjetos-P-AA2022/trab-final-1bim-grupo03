/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String idEmpresa;

    public Constructora(String a, String b) {
        nombreConstructora = a;
        idEmpresa = b;
    }

    public void establecerNombreConstructora(String c) {
        nombreConstructora = c;
    }

    public void establecerIDEmpresa(String d) {
        idEmpresa = d;
    }

    public String obtenerNombreConstructora() {
        return nombreConstructora;
    }

    public String obtenerIDEmpresa() {
        return idEmpresa;
    }
}
