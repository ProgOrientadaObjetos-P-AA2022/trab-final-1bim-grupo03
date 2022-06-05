/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class EscrituraArchivoSecuencial3 {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Ciudad> datosCiudad;
    private Ciudad registroCiudad;

    public EscrituraArchivoSecuencial3(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosCiudad();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosCiudad().size() > 0) {
                for (int i = 0; i < obtenerDatosCiudad().size(); i++) {
                    establecerRegistroCiudad(obtenerDatosCiudad().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String a) {
        nombreArchivo = a;
    }

    public void establecerRegistroCiudad(Ciudad b) {
        registroCiudad = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCiudad);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosCiudad() {
        LecturaArchivoSecuencial3 l
                = new LecturaArchivoSecuencial3(obtenerNombreArchivo());
        l.establecerCiudad();
        datosCiudad = l.obtenerCiudad();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ciudad> obtenerDatosCiudad() {
        return datosCiudad;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        }
    }
}
