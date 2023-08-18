/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static grupo6.proyectopoo.g6.ProyectoPOOG6.citas;
import static grupo6.proyectopoo.g6.ProyectoPOOG6.clientes;
import static grupo6.proyectopoo.g6.ProyectoPOOG6.empleados;
import static grupo6.proyectopoo.g6.ProyectoPOOG6.servicios;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class CitasOption extends MenuOption {

    Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        int opcion = 0;
        switch (opcion) {
            case 4: // CLASE    CITAS
                int opcion4;
                do {
                    System.out.println("\n↓↓↓ M E N Ú  D E  C I T A S ↓↓↓");
                    System.out.println("\n 1. Crear cita\n 2. Eliminar cita\n 3. Consultar citas\n 4. Menu Principal");
                    opcion4 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion4) {
                        case 1:
                            //METODO CREAR CITA
                            System.out.println("Ingrese la información para la nueva cita");
                            System.out.print("Ingrese fecha de la cita (dd/mm/aaaa): ");
                            String fecha = sc.nextLine();
                            System.out.print("Ingrese hora de la cita (hh:mm): ");
                            String hora = sc.nextLine();
                            Cliente clienteCedula = null;
                            System.out.print("Ingrese el numero de cedula del cliente: ");
                            String cedula = sc.nextLine();
                            clienteCedula = Cliente.buscarCliente(clientes, cedula);

                            if (clienteCedula != null) {
                                ArrayList<Empleado> empleadosDisponibles = Empleado.mostrarEmpleadosDisponibles(citas, empleados, fecha, hora);
                                if (empleadosDisponibles.size() > 0) {
                                    ArrayList<Servicio> serviciosDisponibles = Servicio.serviciosDisponibles(servicios);

                                    int empleadoIndex = 1;
                                    int servicioIndex = 1; // Determine which service to assign

                                    Cita nuevaCita = new Cita(clienteCedula, empleadosDisponibles.get(empleadoIndex), serviciosDisponibles.get(servicioIndex), fecha, hora);
                                    citas.add(nuevaCita);
                                    System.out.println("Cita creada exitosamente.");
                                } else {
                                    System.out.println("No es posible crear una cita, no hay empleados disponibles a la hora y fecha deseadas.");
                                }
                            } else {
                                System.out.println("No existe un cliente con esta cedula, intente nuevamente");
                            }
                            break;
                        case 2:
                            //METODO ELIMINAR CITA
                            System.out.print("Ingrese el numero de cedula del cliente: ");
                            String cedula = sc.nextLine();
                            Cita.eliminarCita(cedula, citas);
                            break;
                        case 3:
                            //METODO CONSULTAR CITA POR MEDIO DE LA FECHA
                            System.out.print("Ingrese la fecha(dd/mm/aaaa) para consultar las citas: ");
                            String fechaConsultada = sc.nextLine();
                            Cita.consultarCita(fechaConsultada, citas);
                            break;
                        default:
                            System.out.println("Volviendo... \n");
                    }
                } while (opcion4 > 0 && opcion4 < 4);

                break;
        }

    }
}
