/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Servicio implements Serializable{

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

    // getters
    public int getDuracion() {
        return duracion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }
    // setter
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public double getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public String getEstado(){
        if(estado){
            return "S";
        }else{
            return "N";
        }
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(String s){
        if(s.equals("S")){
            estado=true;
        }else{
            estado=false;
        }
    }
    
    

    @Override
    public String toString() {
        return nombreServicio + ";" + duracion + ";" + precio + ";" + estado;
    }

    //Método Mostrar Servicios : Recibiendo el ArrayList donde estan todos los servicios, lo iteramos con un "for" y lo mostramos uno a uno.
    public static void mostrarServicios(ArrayList<Servicio> servicios) {
        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ". " + servicios.get(i).toString());
        }
    }

    /*Método Agregar Servicio: Recibiendo la lista de Servicios, procedemos a pedirle al usuario los datos del servicio como el nombre, el tiempo de duración y el precio,
    después de obtener los datos procedemos a crear el servicio con los datos recibidos y lo añadimos al Arraylist de servicios que recibimos en el método.
    */
    public static void agregarServicio(ArrayList<Servicio> servicios) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la duración en minutos: ");
        int tiempo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        Servicio servicioNuevo = new Servicio(nombre, tiempo, precio, true);
        servicios.add(servicioNuevo);
    }

    /*Método Editar Servicio : Recibe un entero el cual nos servirá como índice-1 de la lista de servicios que previamente se muestran por pantalla, también recibe la lita de Servicios.
    Empezamos obteniendo el servicio a editar, procedemos a pedirle al usuario los nuevos datos corregidos del servicio que está editando,
    finalmente reemplazamos loo nuevos datos en el servicio que estamos editando.
    */
    public static void editarServicio(int indiceEditar, ArrayList<Servicio> servicios) {
        Scanner sc = new Scanner(System.in);
        Servicio servicioEditar = servicios.get(indiceEditar - 1);
        System.out.println("Ingrese la información corregida");
        System.out.print("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.print("Duracion en minutos: ");
        int tiempoNuevo = sc.nextInt();
        sc.nextLine();
        System.out.print("Precio: ");
        double precioNuevo = sc.nextDouble();
        sc.nextLine();
        System.out.print("El servicio está activo? S/N: ");
        String respuesta = sc.nextLine();
        boolean actividad;
        if (respuesta.equals("S") || respuesta.equals("s")) {
            actividad = true;
        } else {
            actividad = false;
        }
        servicioEditar.nombreServicio = nombreNuevo;
        servicioEditar.duracion = tiempoNuevo;
        servicioEditar.precio = precioNuevo;
        servicioEditar.estado = actividad;
    }

    /*Método Eliminar Servicio: Recibe un entero el cual nos servirá como índice-1 de lista impresa previamente, también recibe la lita de servicios.
    Recibimos el indice del servicio que se desea eliminar y cambiamos su estado a "false" para denotar que el servicio se eliminó
    */
    public static void eliminarServicio(int indiceEliminar, ArrayList<Servicio> servicios) {
        Servicio servicioEliminar = servicios.get(indiceEliminar - 1);
        servicioEliminar.estado = false;
    }
    
    /*Método extra serviciosDisponibles añadido por nosotros para poder optimizar el programa: Recibe la lita de servicios.
    Empezamos creando una nueva lista llamada "serviciosDisponibles de clase Servicios" en la cual añadiremos los servicios con estado "true" 
    de la lista de serivicios, finalmente retornamos la lista de "serviciosDisponibles" para poder utilizarla luego en el programa.
    */    
    public static ArrayList<Servicio> serviciosDisponibles(ArrayList<Servicio> servicios){
        ArrayList <Servicio> serviciosDisponibles = new ArrayList<>();
        for(Servicio s: servicios){
            if(s.estado){
                serviciosDisponibles.add(s);
            }
        }
        return serviciosDisponibles;
    }
    
    public static ArrayList<Servicio> cargarServicios(String ruta){
        ArrayList<Servicio> servicios = new ArrayList<>();
        InputStream input = Servicio.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Servicio s = new Servicio(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]), Boolean.parseBoolean(datos[3]));
                servicios.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return servicios;
    }
}
