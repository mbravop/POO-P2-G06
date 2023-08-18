/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static grupo6.proyectopoo.g6.ProyectoPOOG6.atenciones;
import static grupo6.proyectopoo.g6.ProyectoPOOG6.citas;
import static grupo6.proyectopoo.g6.ProyectoPOOG6.empleados;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class AtencionesOption extends MenuOption {

    Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        int opcion = 0;

        switch (opcion) {
            case 5: // CLASE    ATENCIONES
                int opcion5;
                do {
                    System.out.println("↓↓↓ M E N Ú  D E  A T E N C I O N E S ↓↓↓");
                    System.out.println("\n 1. Registrar atencion \n 2. Consultar atención \n 3. Menu Principal");
                    opcion5 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion5) {
                        case 1:
                            //METODO REGISTRAR ATENCIÓN RELACIONADA A UNA CITA NO ATENDIDA
                            System.out.print("Ingrese cédula del cliente: ");
                            String cedula = sc.nextLine();
                            ArrayList<Cita> citasNoRealizadas = Cita.citasNoAtendidas(citas, atenciones);
                            Atencion.registrarAtencion(atenciones, citasNoRealizadas, cedula, empleados);
                            break;
                        case 2:
                            //METODO CONSULTAR ATENCION
                            //System.out.println("Ingrese información para la consulta");
                            ArrayList<Atencion> atencionesBusqueda = Atencion.consultarAtencion(atenciones);
                            //En caso que el arreglo de atencionesBusqueda esté vacio, se muestra el mensaje por pantalla
                            if (atencionesBusqueda.size() == 0) {
                                System.out.println("No existen atenciones bajo el parámetro buscado");
                            } //En caso que el arreglo tenga elementos se imprime dicha lista de atenciones
                            else {
                                int contadorAtencion = 0;
                                System.out.println("Listado de atenciones para el parámetro buscado");
                                for (Atencion a : atencionesBusqueda) {
                                    System.out.println((contadorAtencion + 1) + ". " + a);
                                }
                            }
                            break;
                        default:
                            System.out.println("Volviendo...\n");
                    }
                } while (opcion5 > 0 && opcion5 < 3);
                break;
            //SALIENDO DEL MENÚ DEL SISTEMA    
            default:
                System.out.println("Cerrando sesión");
        }
    }

}
