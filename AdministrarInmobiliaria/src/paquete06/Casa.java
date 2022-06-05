/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Casa implements Serializable {

    private Propietario idPropietario;
    private double precio;
    private double numeroMetrosCuadrados;
    private double costoTotalCasa;
    private Barrio datosBarrio;
    private Ciudad datosCiudad;
    private int cuartos;
    private Constructora datosConstructora;

    public Casa(Propietario a, double b, double c, Barrio d, Ciudad e, int f, 
            Constructora g) {
        idPropietario = a;
        precio = b;
        numeroMetrosCuadrados = c;
        datosBarrio = d;
        datosCiudad = e;
        cuartos = f;
        datosConstructora = g;
    }

    public Casa(double h, double i, int j) {
        precio = h;
        numeroMetrosCuadrados = i;
        cuartos = j;
    }

    public void establecerDatosPropietario(Propietario s) {
        idPropietario = s;
    }

    public void establecerPrecioMetroCuadrado(double s) {
        precio = s;
    }

    public void establecerNumeroMetrosCuadrados(double s) {
        numeroMetrosCuadrados = s;
    }

    public void establecerCostoTotalCasa() {
        costoTotalCasa = numeroMetrosCuadrados * precio;
    }

    public void establecerDatosBarrio(Barrio s) {
        datosBarrio = s;
    }

    public void establecerDatosCiudad(Ciudad s) {
        datosCiudad = s;
    }

    public void establecerNumeroCuartos(int s) {
        cuartos = s;
    }

    public void establecerDatosConstructora(Constructora s) {
        datosConstructora = s;
    }

    public Propietario obtenerDatosPropietario() {
        return idPropietario;
    }

    public double obtenerPrecioMetroCuadrado() {
        return precio;
    }

    public double obtenerNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public double obtenerCostoTotalCasa() {
        return costoTotalCasa;
    }

    public Barrio obtenerDatosBarrio() {
        return datosBarrio;
    }

    public Ciudad obtenerDatosCiudad() {
        return datosCiudad;
    }

    public int obtenerNumeroCuartos() {
        return cuartos;
    }

    public Constructora obtenerDatosConstructora() {
        return datosConstructora;
    }

    @Override
    public String toString() {
        String cadena = "DATOS DE LA CASA\n";
        cadena = String.format("%s\n"
                + "Nombres completos del propietario: %s\n"
                + "Apellidos completos del propietario: %s\n"
                + "Identificacion del propietario: %s\n"
                + "Precio del metro por cuadrado: %.2f\n"
                + "Numero de metros cuadrados: %.2f\n"
                + "Nombre del barrio: %s\n"
                + "Referencia del barrio: %s\n"
                + "Nombre de la ciudad %s\n"
                + "Nombre de la provincia: %s\n"
                + "Nombre de la constructora: %s\n"
                + "Id de la empresa: %s\n",
                cadena,
                obtenerDatosPropietario().obtenerNombresPropietario(),
                obtenerDatosPropietario().obtenerApellidosPropietario(),
                obtenerDatosPropietario().obtenerIdentificacionPropietario(),
                obtenerPrecioMetroCuadrado(),
                obtenerNumeroMetrosCuadrados(),
                obtenerDatosBarrio().obtenerNombreBarrio(),
                obtenerDatosBarrio().obtenerReferencia(),
                obtenerDatosCiudad().obtenerNombreCiudad(),
                obtenerDatosCiudad().obtenerNombreProvincia(),
                obtenerDatosConstructora().obtenerNombreConstructora(),
                obtenerDatosConstructora().obtenerIDEmpresa());
        return cadena;
    }
}
