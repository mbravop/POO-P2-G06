/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static grupo6.proyectopoo.g6.ProyectoPOOG6.empleados;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class EmpleadosOption extends MenuOption {

    Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        int opcion = 0;
        switch (opcion) {
            case 2: // CLASE    EMPLEADOS
                int opcion2;
                do {
                    System.out.println("\n ↓↓↓ L I S T A  D E  E M P L E A D O S ↓↓↓");
                    System.out.println("#   CEDULA ----- NOMBRE ----- TELEFONO ----- EMAIL ----- ESTADO");
                    Empleado.mostrarEmpleados(empleados);
                    System.out.println("\n----- 1. Agregar empleado ----- 2. Editar empleado ----- 3. Eliminar empleado ----- 4. Menu Principal");
                    opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
                        case 1:
                            //METODO AGREGAR EMPLEADO
                            System.out.println("Ingrese la información del empleado");
                            Empleado.agregarEmpleado(empleados);
                            break;
                        case 2:
                            //METODO EDITAR EMPLEADO
                            System.out.print("Ingrese el número del empleado a editar: ");
                            int editar = sc.nextInt();
                            sc.nextLine();
                            Empleado.editarEmpleado(editar, empleados);
                            break;
                        case 3:
                            //METODO ELIMINAR EMPLEADO
                            System.out.print("Ingrese el número del empleado a eliminar: ");
                            int eliminar = sc.nextInt();
                            sc.nextLine();
                            Empleado.eliminarEmpleado(eliminar, empleados);
                            break;
                        default:
                            System.out.println("Volviendo... \n");
                    }

                } while (opcion2 > 0 && opcion2 < 4);
                break;
        }

    }
}
