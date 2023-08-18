/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static grupo6.proyectopoo.g6.ProyectoPOOG6.clientes;
import java.util.Scanner;

/**
 *
 * @author alexc
 */
public class ClienteOption extends MenuOption{
    Scanner sc= new Scanner(System.in);
    @Override
    public void execute() {
        int opcion = 0;
        switch(opcion){
            case 3: // CLASE    CLIENTES
                    int opcion3;
                    do{
                        System.out.println("\n↓↓↓ L I S T A  D E  C L I E N T E S ↓↓↓");
                        System.out.println("#   CEDULA ----- NOMBRE ----- TELEFONO ----- EMAIL");
                        //Metodo mostrar clientes
                        Cliente.mostrarClientes(clientes);
                        System.out.println("\n----- 1. Agregar cliente ----- 2. Editar cliente ----- 3. Menu Principal");
                        opcion3 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion3) {
                            case 1:
                                //METODO AGREGAR CLIENTE
                                System.out.println("Ingrese la información del cliente");
                                Cliente.agregarCliente(clientes);
                                break;
                            case 2:
                                //METODO EDITAR CLIENTE
                                System.out.print("Ingrese el número del cliente a editar: ");
                                int editar = sc.nextInt();
                                sc.nextLine();
                                Cliente.editarCliente(editar, clientes);
                                break;
                            default:
                                System.out.println("Volviendo... \n");
                        }
                    }while(opcion3 > 0 && opcion3 < 3);
                    break;
        }
    }
    
}
