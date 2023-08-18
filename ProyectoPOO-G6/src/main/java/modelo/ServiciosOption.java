/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static grupo6.proyectopoo.g6.ProyectoPOOG6.servicios;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class ServiciosOption extends MenuOption {

    Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        int opcion = 0;
        switch (opcion) {
            case 1: // CLASE    SERVICIOS
                int opcion1;
                do {
                    System.out.println("\n↓↓↓ L I S T A D O   D E   S E R V I C I O S ↓↓↓\n");
                    System.out.println("#   NOMBRE ----- DURACIÓN ----- PRECIO ----- ESTADO");
                    //Metodo mostrar servicios
                    Servicio.mostrarServicios(servicios);
                    System.out.println("\n----- 1. Agregar Servicios ----- 2. Editar Servicios ----- 3. Eliminar Servicios ----- 4. Menu Principal");
                    opcion1 = sc.nextInt();
                    sc.nextLine();

                } while (opcion1 > 0 && opcion1 < 4);
                break;
        }

    }
}
