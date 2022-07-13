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
    public Cita(Cliente cliente, Empleado empleado, Servicio servicio, String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.empleado = empleado;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    @Override
    public String toString() {
        String cadena = "Fecha: " + fecha + " Hora: "+ hora + " Empleado: " + empleado.getCedula() +" "+ empleado.getNombre() + " Cliente: " + cliente.getCedula() + " " + cliente.getNombre() + " Servicio: " + servicio.getNombreServicio();
        return cadena;
    }
    
    
    public static void mostrarCitas(ArrayList<Cita> citas){
        for(Cita c: citas){
            System.out.println(c.toString());
        }
    }
    
    public static void crearCita(Cliente clienteCedula, ArrayList<Cita> citas, ArrayList<Empleado> empleadosDisponibles, ArrayList<Servicio> servicios, String fecha, String hora){
        Scanner sc = new Scanner(System.in);
        
        
        
        System.out.println("Se muestran los empleados disponibles para la fecha y hora solicitada. ");
        int i =0;
        for(Empleado e: empleadosDisponibles){
            
            System.out.println((1+i)+" "+e.toString());
            i++;
        }
        
        System.out.println("Seleccione el numero del empleado para la cita: ");
        int indiceEmpleado = sc.nextInt();
        sc.nextLine();
        
        Empleado empleadoEscogido = empleadosDisponibles.get(indiceEmpleado-1);
        
        System.out.println("Se muestran los servicios disponibles ");
        Servicio.mostrarServicios(servicios);
        System.out.println("Seleccione el numero del servicio para la cita: ");
        int indiceServicio = sc.nextInt();
        sc.nextLine();
        
        Servicio servicioEscogido = servicios.get(indiceServicio-1);
       
        Cita citaNueva = new Cita(clienteCedula, empleadoEscogido, servicioEscogido, fecha, hora);
        citas.add(citaNueva);
        
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
    
    
    public static void eliminarCita(String cedula, ArrayList<Cita>citas){
        ArrayList<Cita> citaPersona = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        for (Cita c: citas){
            if (c.cliente.getCedula().equals(cedula)){
                citaPersona.add(c);
                System.out.println((1+contador)+ ". "+c);
                contador +=1;
            }
        }
        System.out.println("Qué cita de la lista desea eliminar?");
        int indiceEliminar = sc.nextInt();
        sc.nextLine();
        citas.remove(citaPersona.get(indiceEliminar-1));
        citaPersona.remove(indiceEliminar -1);
        
    }
    
    public static void consultarCita(String fecha, ArrayList<Cita> citas){
        int contador= 0;
        for (Cita c: citas){
            if (c.fecha.equals(fecha)){
                System.out.println((1+contador)+". "+c);
                contador++;
            }
        }
        
        
    }
     
}
