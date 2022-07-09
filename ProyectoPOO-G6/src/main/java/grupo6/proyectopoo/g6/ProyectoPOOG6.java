/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grupo6.proyectopoo.g6;
import java.util.Scanner;

public class ProyectoPOOG6 {

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        
        boolean salir= false;
        int opcion;
        System.out.println("Menú del Sistema");
        while(!salir){
            System.out.println("1.Servicios");
            System.out.println("2.Empleados");
            System.out.println("3.Clientes");
            System.out.println("4.Citas");
            System.out.println("5.Atenciones");
            System.out.println("6.Salir");
            
            System.out.println("Seleccione la opción que desee:");
            opcion= sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Servicios");
                    break;
                case 2:
                    System.out.println("Empleados");
                    break;
                case 3:
                    System.out.println("Clientes");
                    break;
                case 4:
                    System.out.println("Citas");
                    break;
                case 5:
                    System.out.println("Atenciones");
                    break;
                case 6:
                    salir= true; 
                    break;
                default:
                    System.out.println("Seleccion un número entre 1 y 6");
            }
        }
        System.out.println("Ha salido del menú");
        sc.close();
    }
}       
