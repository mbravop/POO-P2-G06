/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mbravop
 */
public class Cita {
    private String fecha;
    private String hora;
    private Empleado empleado;
    private Cliente cliente;
    private Servicio servicio;

    //Constructor
    public Cita(String fecha, String hora, Empleado empleado, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    //Metodos
    
    public static void crearCita(ArrayList<Cita> citas, ArrayList<Empleado> empleados, ArrayList<Servicio> servicios){
     Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese fecha de la cita (dd/mm/aaaa): ");
        String fecha = sc.nextLine();
        System.out.println("Ingrese hora de la cita (hh:mm): ");
        String hora = sc.nextLine();
        
        Empleado.mostrarEmpleados(empleados);
        
        System.out.println("Seleccione : ");
       // String fecha = sc.nextLine();  
    }
    
    public static ArrayList<Cita> verificarCitaFyH(ArrayList<Cita> citas, String fecha, String hora){
        ArrayList<Cita> citaNoDisponible = new ArrayList<>();
        
        for (Cita c: citas){
            if (c.fecha.equals(fecha) && c.hora.equals(hora)){
                citaNoDisponible.add(c);
                
            }
        }
        return citaNoDisponible;
        
    }
  
}
