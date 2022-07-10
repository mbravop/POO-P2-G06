/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Servicio {

    private String nombreServicio;
    private int duracion;
    private double precio;
    private boolean estado;

    //Constructor
    public Servicio(String nS, int d, double p, boolean e) {
        nombreServicio = nS;
        duracion = d;
        precio = p;
        estado = e;
    }

    // getter
    public int getDuracion() {
        return duracion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return nombreServicio + "     " + duracion + "     " + precio + "     " + estado;
    }

    //Método Mostrar Servicios
    public static void mostrarServicios(ArrayList<Servicio> servicios) {
        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ". " + servicios.get(i).toString());
        }
    }

    //Método Agregar Servicio
    public static void agregarServicio(ArrayList<Servicio> servicios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la duración en minutos: ");
        int tiempo = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        Servicio servicioNuevo = new Servicio(nombre, tiempo, precio, true);
        servicios.add(servicioNuevo);
    }

    //Método Editar Servicio
    public static void editarServicio(int indiceEditar, ArrayList<Servicio> servicios) {
        Scanner sc = new Scanner(System.in);
        Servicio servicioEditar = servicios.get(indiceEditar - 1);
        System.out.println("Ingrese la información corregida");
        System.out.println("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.println("Duracion en minutos: ");
        int tiempoNuevo = sc.nextInt();
        sc.nextLine();
        System.out.println("Precio: ");
        double precioNuevo = sc.nextDouble();
        sc.nextLine();
        System.out.println("El servicio está activo? S/N");
        String respuesta = sc.nextLine();
        boolean actividad;
        if (respuesta.equals("S")) {
            actividad = true;
        } else {
            actividad = false;
        }
        servicioEditar.nombreServicio = nombreNuevo;
        servicioEditar.duracion = tiempoNuevo;
        servicioEditar.precio = precioNuevo;
        servicioEditar.estado = actividad;
    }

    //Método Eliminar Servicio
    public static void eliminarServicio(int indiceEliminar, ArrayList<Servicio> servicios) {
        Servicio servicioEliminar = servicios.get(indiceEliminar - 1);
        servicioEliminar.estado = false;
    }
    
    public static ArrayList<Servicio> serviciosDisponibles(ArrayList<Servicio> servicios){
        ArrayList <Servicio> serviciosDisponibles = new ArrayList<>();
        for(Servicio s: servicios){
            if(s.estado){
                serviciosDisponibles.add(s);
            }
        }
        return serviciosDisponibles;
    }
}
