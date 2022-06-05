/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

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
public class LecturaArchivoSecuencial3 {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;
    private String identificador;
    private String nombreArchivo;
    private Ciudad ciudadRegistrada;

    public LecturaArchivoSecuencial3(String n) {
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

    public void establecerCiudad() {
        ciudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudad.add(registro);
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

    public void establecerCiudadRegistrada() {
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    System.out.println(registro.obtenerNombreProvincia());
                    if (registro.obtenerNombreProvincia().
                            equals(identificador)) {
                        ciudadRegistrada = registro;
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

    public ArrayList<Ciudad> obtenerCiudad() {
        return ciudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdentificador() {
        return identificador;
    }

    public Ciudad obtenerCiudadRegistrada() {
        return ciudadRegistrada;
    }

    @Override
    public String toString() {
        String cadena = "Datos de la ciudad\n";
        for (int i = 0; i < obtenerCiudad().size(); i++) {
            Ciudad b = obtenerCiudad().get(i);
            cadena = String.format("%s(%d)\nNombre de la ciudad: %s\n"
                    + "Nombre de la ciudad: %s\n",
                    cadena,
                    i + 1,
                    b.obtenerNombreCiudad(),
                    b.obtenerNombreProvincia());
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
