/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class EscrituraArchivoSecuencial {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Propietario> datosPropietario;
    private Propietario registroPropietario;

    public EscrituraArchivoSecuencial(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosPropietario();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosPropietario().size() > 0) {
                for (int i = 0; i < obtenerDatosPropietario().size(); i++) {
                    establecerRegistroPropietario(obtenerDatosPropietario().get(i));
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

    public void establecerRegistroPropietario(Propietario b) {
        registroPropietario = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroPropietario);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosPropietario() {
        LecturaArchivoSecuencial l
                = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerPropietario();
        datosPropietario = l.obtenerPropietario();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> obtenerDatosPropietario() {
        return datosPropietario;
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
