/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.io.Serializable;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Barrio implements Serializable {

    private String barrio;
    private String referencia;

    public Barrio(String a, String b) {
        barrio = a;
        referencia = b;
    }

    public void establecerNombreBarrio(String c) {
        barrio = c;
    }

    public void establecerReferencia(String d) {
        referencia = d;
    }

    public String obtenerNombreBarrio() {
        return barrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
}
