/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class LecturaArchivoSecuencial4 {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructora;
    private String identificador;
    private String nombreArchivo;
    private Constructora constructoraRegistrada;

    public LecturaArchivoSecuencial4(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerConstructora() {
        constructora = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructora.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public void establecerIdentificador(String c) {
        identificador = c;
    }

    public void establecerConstructoraRegistrada() {
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    System.out.println(registro.obtenerIDEmpresa());
                    if (registro.obtenerIDEmpresa().
                            equals(identificador)) {
                        constructoraRegistrada = registro;
                        break;
                    }

                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Constructora> obtenerConstructora() {
        return constructora;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdentificador() {
        return identificador;
    }

    public Constructora obtenerConstructoraRegistrada() {
        return constructoraRegistrada;
    }

    @Override
    public String toString() {
        String cadena = "Datos de la constructora\n";
        for (int i = 0; i < obtenerConstructora().size(); i++) {
            Constructora c = obtenerConstructora().get(i);
            cadena = String.format("%s(%d)\nNombre de la constructora: %s\n"
                    + "Id de la empresa: %s\n",
                    cadena,
                    i + 1,
                    c.obtenerNombreConstructora(),
                    c.obtenerIDEmpresa());
        }

        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
