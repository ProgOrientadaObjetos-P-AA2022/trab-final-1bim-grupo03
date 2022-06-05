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
public class EscrituraArchivoSecuencialDepartamento {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Departamento> datosDepartamento;
    private Departamento registroDepartamento;

    public EscrituraArchivoSecuencialDepartamento(String Archivo) {
        nombreArchivo = Archivo;
        establecerDatosDepartamento();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (obtenerDatosDepartamento().size() > 0) {
                for (int i = 0; i < obtenerDatosDepartamento().size(); i++) {
                    establecerRegistroDepartamento(obtenerDatosDepartamento().get(i));
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

    public void establecerRegistroDepartamento(Departamento b) {
        registroDepartamento = b;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroDepartamento);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerDatosDepartamento() {
        LecturaArchivoSecuencialDepartamento l
                = new LecturaArchivoSecuencialDepartamento(obtenerNombreArchivo());
        l.establecerDepartamento();
        datosDepartamento = l.obtenerDepartamento();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Departamento> obtenerDatosDepartamento() {
        return datosDepartamento;
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
