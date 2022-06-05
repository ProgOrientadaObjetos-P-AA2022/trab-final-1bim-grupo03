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
public class Departamento implements Serializable {

    private Propietario idPropietario2;
    private double precio2;
    private double numeroMetrosCuadrados2;
    private double aliCuotaMensual;
    private double costoTotalDepartamento;
    private Barrio datosBarrio2;
    private Ciudad datosCiudad2;
    private String nombreEdificio;
    private String ubicacionEdificio;
    private Constructora datosConstructora2;

    public Departamento(double a, double b,
            String c, String d) {
        precio2 = a;
        numeroMetrosCuadrados2 = b;
        nombreEdificio = c;
        ubicacionEdificio = d;
    }

    public void establecerDatosPropietario2(Propietario n) {
        idPropietario2 = n;
    }

    public void establecerPrecioMetroCuadrado2(double n) {
        precio2 = n;
    }

    public void establecerNumeroMetrosCuadrados2(double n) {
        numeroMetrosCuadrados2 = n;
    }

    public void establecerAliCuotaMensual() {
        aliCuotaMensual = 0.18;
    }

    public void establecerCostoTotalDepartamento() {
        costoTotalDepartamento = (numeroMetrosCuadrados2 * precio2) + (aliCuotaMensual * 12);
    }

    public void estableceDatosBarrio2(Barrio n) {
        datosBarrio2 = n;
    }

    public void establecerDatosCiudad2(Ciudad n) {
        datosCiudad2 = n;
    }

    public void establecerNombreEdificio(String n) {
        nombreEdificio = n;
    }

    public void establecerUbicacionEdificio(String n) {
        ubicacionEdificio = n;
    }

    public void establecerDatosConstructora2(Constructora n) {
        datosConstructora2 = n;
    }

    public Propietario obtenerDatosPropietario2() {
        return idPropietario2;
    }

    public double obtenerPrecioMetroCuadrado2() {
        return precio2;
    }

    public double obtenerNumeroMetrosCuadrados2() {
        return numeroMetrosCuadrados2;
    }

    public double obtenerAliCuotaMensual() {
        return aliCuotaMensual;
    }

    public double obtenerCostoTotalDepartamento() {
        return costoTotalDepartamento;
    }

    public Barrio obtenerDatosBarrio2() {
        return datosBarrio2;
    }

    public Ciudad obtenerDatosCiudad2() {
        return datosCiudad2;
    }

    public String obtenerNombreEdificio() {
        return nombreEdificio;
    }

    public String obtenerUbicacionEdificio() {
        return ubicacionEdificio;
    }

    public Constructora obtenerDatosConstructora2() {
        return datosConstructora2;
    }

    @Override
    public String toString() {
        String cadena = "DATOS DE LA DEPARTAMENTO\n";
        cadena = String.format("%s\n"
                + "Nombres completos del propietario: %s\n"
                + "Apellidos completos del propietario: %s\n"
                + "Identificacion del propietario: %s\n"
                + "Precio del metro por cuadrado: %.2f\n"
                + "Numero de metros cuadrados: %.2f\n"
                + "Valor de la alicuota mensual: %.2f\n"
                + "Nombre del barrio: %s\n"
                + "Referencia del barrio: %s\n"
                + "Nombre de la ciudad %s\n"
                + "Nombre de la provincia: %s\n"
                + "Nombre de la constructora: %s\n"
                + "Id de la empresa: %s\n",
                cadena,
                obtenerDatosPropietario2().obtenerNombresPropietario(),
                obtenerDatosPropietario2().obtenerApellidosPropietario(),
                obtenerDatosPropietario2().obtenerIdentificacionPropietario(),
                obtenerPrecioMetroCuadrado2(),
                obtenerNumeroMetrosCuadrados2(),
                obtenerAliCuotaMensual(),
                obtenerDatosBarrio2().obtenerNombreBarrio(),
                obtenerDatosBarrio2().obtenerReferencia(),
                obtenerDatosCiudad2().obtenerNombreCiudad(),
                obtenerDatosCiudad2().obtenerNombreProvincia(),
                obtenerDatosConstructora2().obtenerNombreConstructora(),
                obtenerDatosConstructora2().obtenerIDEmpresa());
        return cadena;
    }
}
