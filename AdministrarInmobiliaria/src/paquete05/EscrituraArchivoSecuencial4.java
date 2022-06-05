/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class EscrituraArchivoSecuencial4 {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Constructora> datosConstructora;
    private Constructora registroConstructora;

    public EscrituraArchivoSecuencial4(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosConstructora();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosConstructora().size() > 0) {
                for (int i = 0; i < obtenerDatosConstructora().size(); i++) {
                    establecerRegistroConstructora(obtenerDatosConstructora().get(i));
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

    public void establecerRegistroConstructora(Constructora b) {
        registroConstructora = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroConstructora);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosConstructora() {
        LecturaArchivoSecuencial4 l
                = new LecturaArchivoSecuencial4(obtenerNombreArchivo());
        l.establecerConstructora();
        datosConstructora = l.obtenerConstructora();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerDatosConstructora() {
        return datosConstructora;
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
