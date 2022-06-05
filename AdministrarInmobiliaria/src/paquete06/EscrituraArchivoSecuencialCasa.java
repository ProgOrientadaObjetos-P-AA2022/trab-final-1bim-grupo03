/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class EscrituraArchivoSecuencialCasa {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Casa> datosCasa;
    private Casa registroCasa;

    public EscrituraArchivoSecuencialCasa(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosCasa();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosCasa().size() > 0) {
                for (int i = 0; i < obtenerDatosCasa().size(); i++) {
                    establecerRegistroCasa(obtenerDatosCasa().get(i));
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

    public void establecerRegistroCasa(Casa b) {
        registroCasa = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCasa);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosCasa() {
        LecturaArchivoSecuencialCasa l
                = new LecturaArchivoSecuencialCasa(obtenerNombreArchivo());
        l.establecerCasa();
        datosCasa = l.obtenerCasa();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> obtenerDatosCasa() {
        return datosCasa;
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
