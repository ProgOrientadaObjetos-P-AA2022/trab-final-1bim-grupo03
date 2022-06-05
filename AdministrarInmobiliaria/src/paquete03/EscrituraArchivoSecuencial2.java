/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class EscrituraArchivoSecuencial2 {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Barrio> datosBarrio;
    private Barrio registroBarrio;

    public EscrituraArchivoSecuencial2(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosBarrio();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosBarrio().size() > 0) {
                for (int i = 0; i < obtenerDatosBarrio().size(); i++) {
                    establecerRegistroBarrio(obtenerDatosBarrio().get(i));
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

    public void establecerRegistroBarrio(Barrio b) {
        registroBarrio = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroBarrio);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosBarrio() {
        LecturaArchivoSecuencial2 l
                = new LecturaArchivoSecuencial2(obtenerNombreArchivo());
        l.establecerBarrio();
        datosBarrio = l.obtenerBarrio();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Barrio> obtenerDatosBarrio() {
        return datosBarrio;
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
