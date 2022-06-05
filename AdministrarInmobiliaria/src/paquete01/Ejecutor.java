/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Locale;
import java.util.Scanner;
import paquete02.EscrituraArchivoSecuencial;
import paquete02.LecturaArchivoSecuencial;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete03.EscrituraArchivoSecuencial2;
import paquete03.LecturaArchivoSecuencial2;
import paquete04.Ciudad;
import paquete04.EscrituraArchivoSecuencial3;
import paquete04.LecturaArchivoSecuencial3;
import paquete05.Constructora;
import paquete05.EscrituraArchivoSecuencial4;
import paquete05.LecturaArchivoSecuencial4;
import paquete06.Casa;
import paquete06.Departamento;
import paquete06.EscrituraArchivoSecuencialCasa;
import paquete06.EscrituraArchivoSecuencialDepartamento;
import paquete06.LecturaArchivoSecuencialCasa;
import paquete06.LecturaArchivoSecuencialDepartamento;

/**
 *
 * @author Leonardo Chuquimarca y José Guerrero
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        String archivoPropietarios = "datos/propietarios.data";
        String archivoBarrios = "datos/barrios.data";
        String archivoCiudades = "datos/ciudades.data";
        String archivoConstructoras = "datos/constructoras.data";
        String archivoDepartamentos = "datos/departamentos.data";
        String archivoCasas = "datos/casas.data";

        System.out.println("INMOBILIARA NUEVO HOGAR");
        int numeroSalida;

        String nombres;
        String apellidos;
        String identificacion;

        String nombreBarrio;
        String nombreReferencia;

        String nombreCiudad;
        String nombreProvincia;

        String nombreConstructora;
        String id;

        String idPropietario_buscar;
        String nombreReferencia_buscar;
        String nombreProvincia_buscar;
        String idempresa_buscar;
        double precio;
        double numeroMetroCuadrado;
        int cuartos;

        String idPropietario_buscar2;
        String nomReferencia_buscar2;
        String nomProvincia_buscar2;
        String idempresa_buscar2;
        double precio2;
        double numeroMetroCuadrado2;
        String nombreEdificio;
        String ubiEdificio;

        boolean bandera = true;
        while (bandera) {
            System.out.println("-------------------------");
            System.out.println("");
            System.out.println("OPCIONES");
            System.out.printf("Ingrese 1 para ingresar los datos de la ciudad\n"
                    + "Ingrese 2 para ingresar los datos del barrio\n"
                    + "Ingrese 3 para ingresar los datos de la constructora\n"
                    + "Ingrese 4 para ingresar los datos del propietario\n"
                    + "Ingrese 5 para ingresar los datos de la casa\n"
                    + "Ingrese 6 para ingresar los datos del departamento\n");

            System.out.print("INGRESE EL NÚMERO: ");
            int n = entrada.nextInt();
            if (n == 1) {
                System.out.println("\nINGRESANDO LOS DATOS DE LA CIUDAD");
                System.out.println("-------------");
                System.out.print("Ingrese el nombre de la ciudad: ");
                entrada.nextLine();
                nombreCiudad = entrada.nextLine();
                System.out.print("Ingrese el nombre de la provincia: ");
                nombreProvincia = entrada.nextLine();

                Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);

                EscrituraArchivoSecuencial3 archivo1
                        = new EscrituraArchivoSecuencial3(archivoCiudades);
                archivo1.establecerRegistroCiudad(ciudad);
                archivo1.establecerSalida();
                archivo1.cerrarArchivo();

                LecturaArchivoSecuencial3 lectura1
                        = new LecturaArchivoSecuencial3(archivoCiudades);
                lectura1.establecerCiudad();
                System.out.printf("\n%s\n", lectura1);
            } else {
                if (n == 2) {
                    System.out.println("\nINGRESANDO LOS DATOS DEL BARRIO");
                    System.out.println("-------------");
                    System.out.print("Ingrese el nombre del barrio: ");
                    entrada.nextLine();
                    nombreBarrio = entrada.nextLine();
                    System.out.print("Ingrese la referencia del Barrio: ");
                    nombreReferencia = entrada.nextLine();

                    Barrio barrio = new Barrio(nombreBarrio, nombreReferencia);

                    EscrituraArchivoSecuencial2 archivo2
                            = new EscrituraArchivoSecuencial2(archivoBarrios);
                    archivo2.establecerRegistroBarrio(barrio);
                    archivo2.establecerSalida();
                    archivo2.cerrarArchivo();

                    LecturaArchivoSecuencial2 lectura2
                            = new LecturaArchivoSecuencial2(archivoBarrios);
                    lectura2.establecerBarrio();
                    System.out.printf("\n%s\n", lectura2);
                } else {
                    if (n == 3) {
                        System.out.println("\nINGRESANDO LOS DATOS DE LA CONSTRUCTORA");
                        System.out.println("-------------");
                        System.out.print("Ingrese el nombre de la constructora: ");
                        entrada.nextLine();
                        nombreConstructora = entrada.nextLine();
                        System.out.print("Ingrese el id de la empresa: ");
                        id = entrada.nextLine();

                        Constructora constructora = new Constructora(nombreConstructora, id);

                        EscrituraArchivoSecuencial4 archivo3
                                = new EscrituraArchivoSecuencial4(archivoConstructoras);
                        archivo3.establecerRegistroConstructora(constructora);
                        archivo3.establecerSalida();
                        archivo3.cerrarArchivo();

                        LecturaArchivoSecuencial4 lectura3
                                = new LecturaArchivoSecuencial4(archivoConstructoras);
                        lectura3.establecerConstructora();
                        System.out.printf("\n%s\n", lectura3);
                    } else {
                        if (n == 4) {
                            System.out.println("\nINGRESANDO LOS DATOS DEL PROPIETARIO");
                            System.out.println("-------------");
                            System.out.print("Ingrese sus nombres completos: ");
                            entrada.nextLine();
                            nombres = entrada.nextLine();
                            System.out.print("Ingrese sus apellidos completos: ");
                            apellidos = entrada.nextLine();
                            System.out.print("Ingrese su número de identificación: ");
                            identificacion = entrada.nextLine();

                            Propietario propietario = new Propietario(nombres, apellidos, identificacion);

                            EscrituraArchivoSecuencial archivo4
                                    = new EscrituraArchivoSecuencial(archivoPropietarios);
                            archivo4.establecerRegistroPropietario(propietario);
                            archivo4.establecerSalida();
                            archivo4.cerrarArchivo();

                            LecturaArchivoSecuencial lectura4
                                    = new LecturaArchivoSecuencial(archivoPropietarios);
                            lectura4.establecerPropietario();
                            System.out.printf("\n%s\n", lectura4);
                        } else {
                            if (n == 5) {
                                System.out.println("\nINGRESANDO LOS DATOS DE LA CASA");
                                System.out.println("--------------");
                                System.out.print("Ingrese la identificacion del Propietario: ");
                                entrada.nextLine();
                                idPropietario_buscar = entrada.nextLine();
                                System.out.print("Ingrese la referencia del Barrio: ");
                                nombreReferencia_buscar = entrada.nextLine();
                                System.out.print("Ingrese el nombre de la Provincia: ");
                                nombreProvincia_buscar = entrada.nextLine();
                                System.out.print("Ingrese el ID de la Empresa: ");
                                idempresa_buscar = entrada.nextLine();
                                System.out.print("Ingrese el precio por cada metro cuadrado: ");
                                precio = entrada.nextDouble();
                                System.out.print("Numero de metros cuadrados de la casa: ");
                                numeroMetroCuadrado = entrada.nextDouble();
                                System.out.print("Numero de cuartos de la Casa: ");
                                cuartos = entrada.nextInt();

                                Casa casa = new Casa(precio, numeroMetroCuadrado, cuartos);
                                casa.establecerCostoTotalCasa();

                                EscrituraArchivoSecuencialCasa archivo5
                                        = new EscrituraArchivoSecuencialCasa(archivoCasas);
                                archivo5.establecerRegistroCasa(casa);
                                archivo5.establecerSalida();
                                archivo5.cerrarArchivo();

                                LecturaArchivoSecuencialCasa lectura5
                                        = new LecturaArchivoSecuencialCasa(archivoCasas);
                                lectura5.establecerCasa();
                                System.out.printf("\n%s\n", lectura5);

                                try {
                                    LecturaArchivoSecuencial4 lecturaPropietario4
                                            = new LecturaArchivoSecuencial4(archivoConstructoras);
                                    lecturaPropietario4.establecerIdentificador(idempresa_buscar);
                                    lecturaPropietario4.establecerConstructoraRegistrada();
                                    idempresa_buscar = lecturaPropietario4.
                                            obtenerConstructoraRegistrada().obtenerNombreConstructora();
                                    if (idempresa_buscar != null) {
                                        System.out.print(idempresa_buscar + " \n\n ");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nConstructora no encontrada\n");
                                }
                                try {
                                    LecturaArchivoSecuencial2 lecturaPropietario2
                                            = new LecturaArchivoSecuencial2(archivoBarrios);
                                    lecturaPropietario2.establecerIdentificador(nombreReferencia_buscar);
                                    lecturaPropietario2.establecerBarrioRegistrado();
                                    nombreReferencia_buscar = lecturaPropietario2.
                                            obtenerBarrioRegistrado().obtenerNombreBarrio();
                                    if (nombreReferencia_buscar != null) {
                                        System.out.print(nombreReferencia_buscar + " \n\n ");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nBarrio no encontrado\n");
                                }
                                try {
                                    LecturaArchivoSecuencial lecturaPropietario
                                            = new LecturaArchivoSecuencial(archivoPropietarios);
                                    lecturaPropietario.establecerIdentificador(
                                            idPropietario_buscar);
                                    lecturaPropietario.establecerPropietarioRegistrado();
                                    idPropietario_buscar = lecturaPropietario.
                                            obtenerPropietarioRegistrado().
                                            obtenerNombresPropietario();
                                    if (idPropietario_buscar != null) {
                                        System.out.print("\n"
                                                + idPropietario_buscar + " \n ");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nPropietario no encontrado\n");
                                }
                                try {
                                    LecturaArchivoSecuencial3 lecturaPropietario3
                                            = new LecturaArchivoSecuencial3(archivoCiudades);
                                    lecturaPropietario3.establecerIdentificador(nombreProvincia_buscar);
                                    lecturaPropietario3.establecerCiudadRegistrada();
                                    nombreProvincia_buscar = lecturaPropietario3.
                                            obtenerCiudadRegistrada().obtenerNombreCiudad();
                                    if (nombreProvincia_buscar != null) {
                                        System.out.print(nombreProvincia_buscar + " \n\n ");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nCiudad no encontrada\n");
                                }
                                System.out.printf("\nNumeros de Cuartos: %d\n"
                                        + "Costo total de la casa: $%.2f\n", casa.obtenerNumeroCuartos(),
                                        casa.obtenerCostoTotalCasa());
                            } else {
                                if (n == 6) {
                                    System.out.println("\nINGRESANDO LOS DATOS DEL DEPARTAMENTO");
                                    System.out.println("--------------");
                                    System.out.print("Ingrese la identificacion del Propietario: ");
                                    entrada.nextLine();
                                    idPropietario_buscar2 = entrada.nextLine();
                                    System.out.print("Ingrese la referencia del barrio: ");
                                    nomReferencia_buscar2 = entrada.nextLine();
                                    System.out.print("Ingrese el nombre de la provincia: ");
                                    nomProvincia_buscar2 = entrada.nextLine();
                                    System.out.print("Ingrese el ID de la Empresa: ");
                                    idempresa_buscar2 = entrada.nextLine();
                                    System.out.print("Ingrese el precio por cada metro cuadrado: ");
                                    precio2 = entrada.nextDouble();
                                    System.out.print("Numero de metros cuadrados del departamento: ");
                                    numeroMetroCuadrado2 = entrada.nextDouble();
                                    System.out.print("Numero el nombre del edificio: ");
                                    nombreEdificio = entrada.nextLine();
                                    System.out.println("Ingrese la ubicación del edificio");
                                    ubiEdificio = entrada.nextLine();

                                    Departamento departamento = new Departamento(precio2,
                                            numeroMetroCuadrado2, nombreEdificio, ubiEdificio);
                                    departamento.establecerCostoTotalDepartamento();

                                    EscrituraArchivoSecuencialDepartamento archivo6
                                            = new EscrituraArchivoSecuencialDepartamento(archivoDepartamentos);
                                    archivo6.establecerRegistroDepartamento(departamento);
                                    archivo6.establecerSalida();
                                    archivo6.cerrarArchivo();

                                    LecturaArchivoSecuencialDepartamento lectura6
                                            = new LecturaArchivoSecuencialDepartamento(archivoDepartamentos);
                                    lectura6.establecerDepartamento();
                                    System.out.printf("\n%s\n", lectura6);

                                    try {
                                        LecturaArchivoSecuencial2 lecturaPropietario2
                                                = new LecturaArchivoSecuencial2(archivoBarrios);
                                        lecturaPropietario2.establecerIdentificador(nomReferencia_buscar2);
                                        lecturaPropietario2.establecerBarrioRegistrado();
                                        nomReferencia_buscar2 = lecturaPropietario2.
                                                obtenerBarrioRegistrado().obtenerNombreBarrio();
                                        if (nomReferencia_buscar2 != null) {
                                            System.out.print(nomReferencia_buscar2 + " \n\n ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nBarrio no encontrado\n");
                                    }
                                    try {
                                        LecturaArchivoSecuencial4 lecturaPropietario4
                                                = new LecturaArchivoSecuencial4(archivoConstructoras);
                                        lecturaPropietario4.establecerIdentificador(idempresa_buscar2);
                                        lecturaPropietario4.establecerConstructoraRegistrada();
                                        idempresa_buscar2 = lecturaPropietario4.
                                                obtenerConstructoraRegistrada().obtenerNombreConstructora();
                                        if (idempresa_buscar2 != null) {
                                            System.out.print(idempresa_buscar2 + " \n\n ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nConstructora no encontrada\n");
                                    }
                                    try {
                                        LecturaArchivoSecuencial lecturaPropietario
                                                = new LecturaArchivoSecuencial(archivoPropietarios);
                                        lecturaPropietario.establecerIdentificador(
                                                idPropietario_buscar2);
                                        lecturaPropietario.establecerPropietarioRegistrado();
                                        idPropietario_buscar2 = lecturaPropietario.
                                                obtenerPropietarioRegistrado().
                                                obtenerNombresPropietario();
                                        if (idPropietario_buscar2 != null) {
                                            System.out.print("\n"
                                                    + idPropietario_buscar2 + " - ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nPropietario no encontrado\n");
                                    }
                                    try {
                                        LecturaArchivoSecuencial3 lecturaPropietario3
                                                = new LecturaArchivoSecuencial3(archivoCiudades);
                                        lecturaPropietario3.establecerIdentificador(nomProvincia_buscar2);
                                        lecturaPropietario3.establecerCiudadRegistrada();
                                        nomProvincia_buscar2 = lecturaPropietario3.
                                                obtenerCiudadRegistrada().obtenerNombreCiudad();
                                        if (nomProvincia_buscar2 != null) {
                                            System.out.print(nomProvincia_buscar2 + " \n\n ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("\nCiudad no encontrada\n");
                                    }
                                    System.out.printf("Nombre del edificio: %s\n"
                                            + "Ubicacion del edificio: %s\n"
                                            + "Costo total del departamento: $%.2f\n",
                                            departamento.obtenerNombreEdificio(),
                                            departamento.obtenerUbicacionEdificio(),
                                            departamento.obtenerCostoTotalDepartamento());
                                } else {
                                    System.out.println("FUERA DE RANGO");
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Ingrese 10 si no desea agregar mas datos al archivo");
            numeroSalida = entrada.nextInt();
            if (numeroSalida == 10) {
                bandera = false;
            }
        }
        System.out.println("");
    }
}
