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
public class Empleado extends Persona {

    private boolean estado;

    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado) {
        super(cedula, nombre, telefono, email);
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + "     "+estado;
    }

    public boolean isEstado() {
        return estado;
    }
    
    /*Método mostrarEmpleados: Recibe la lista de empleados la cual se itera desde el índice 0 de la lista para ir mostrando la información de cada unod de los empleados uno por uno mediante la suma de 1 en el índice*/
    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).toString());
        }
    }
    
     /*Método agregarEmpleado: Recibe la lista de empleados. Empezamos pidiendole al usuario los datos del nuevo empleado que desea agregar (cédula, nombre, teléfono e email),
    finalmente creamos un objeto empleado con los datos que el usuario proporcionó y lo añadimos a la lista de empleados.  */
    
    public static void agregarEmpleado(ArrayList<Empleado> empleados) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cédula del empleado: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el telefono del empleado: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese el email del empleado: ");
        String email = sc.nextLine();

        Empleado empleadoNuevo = new Empleado(cedula, nombre, telefono, email, true);
        empleados.add(empleadoNuevo);

    }
    
    /*Método editarEmpleado: Recibe la lista de empleados y un entero que nos servirá como índice más adelante: Empezamos tomando el empleado que el usuario seleccionó, 
    después le pedimos los datos que desea cambiar del empleado como el nombre, teléfono, email y si está activo o no, 
    finalmente procedemos a cambiar los datos del empleado escogido con los daots proporcionados por el usuario.*/
   
    public static void editarEmpleado(int indiceEditar, ArrayList<Empleado> empleados) {
        Scanner sc = new Scanner(System.in);
        Empleado empleadoEditar = empleados.get(indiceEditar - 1);
        System.out.println("Ingrese la información corregida");
        System.out.print("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.print("Telefono: ");
        String telefonoNuevo = sc.nextLine();
        System.out.print("Email: ");
        String emailNuevo = sc.nextLine();
        System.out.print("El empleado está activo? S/N: ");
        String respuesta = sc.nextLine();
        boolean actividad;
        if (respuesta.equals("S")) {
            actividad = true;
        } else {
            actividad = false;
        }
        empleadoEditar.setNombre(nombreNuevo);
        empleadoEditar.setTelefono(telefonoNuevo);
        empleadoEditar.setEmail(emailNuevo);
        empleadoEditar.estado = actividad;
    }
    
    /*Método eliminarEmpleado: Recibe la lista de empleados y un entero que nos servirá como índice más adelante: Tomamos el empleados seleccionado según su índice y cambiamos su estados a "False"*/
    
    public static void eliminarEmpleado(int indiceEliminar, ArrayList<Empleado> empleados) {
        Empleado empleadoEliminar = empleados.get(indiceEliminar - 1);
        empleadoEliminar.estado = false;
    }
    
    /*Método mostrarEmpleadosDisponibles: Recibe la lista de empleados, la lista de citas, un String fecha y un String hora. Empezamos creando la lista de citas no disponibles la cual llamaremos "citasNoDisponibles", después una lista de empleados disponibles, un contador que llamaremos "falso"
    y un contador llamado "contador". Después con un for iteramos la lista de empleados y junto con el if vemos cuáles de los empleados de la lista tienen su estado "Falso"; mientras un objeto de la lista empleados  
    tenga en su estado falso nuestro contador llamado "falso" aumentara en +1, después paralelamente iteraremos la lista llamada "citasNoDisponibles" y con un if revisaremos si la cedula de un empleado 
    de la lista empleados se encuentra en la liste de citasNoDisponibles, sabiendo que si esto se cumple nuestro contador "contador" aumentará en +1.
    finalmente con un "if" concluiremos que todo empleado que haga que siempre los contadores "falso" y "contador" sean iguales a 0 significará que están disponibles, por esa razoón
    estos empleados serán añadidos a la lista de empleadosDisponibles conluyendo así con un "return" de la lista empleadosDisponibles para usarla luego en el código.
    */

    public static ArrayList<Empleado> mostrarEmpleadosDisponibles(ArrayList<Cita> citas, ArrayList<Empleado> empleados, String fecha, String hora){
        ArrayList<Cita> citasNoDisponibles = Cita.verificarCitaFyH(citas,fecha,hora);
        ArrayList<Empleado> empleadosDisponibles = new ArrayList<>();
        
        int falso = 0;
        int contador = 0;
        
        for(int i=0; i<empleados.size(); i++){
            falso = 0;
            contador =0;
            if(empleados.get(i).isEstado()==false){
                    falso++;
                }
            for(int j=0; j< citasNoDisponibles.size(); j++){
                
                if(empleados.get(i).getCedula().equals(citasNoDisponibles.get(j).getEmpleado().getCedula())){
                    contador++;
                }
            }
            if(falso==0 && contador ==0){
                empleadosDisponibles.add(empleados.get(i));
            }
               
        }
        return empleadosDisponibles;
    }
        
}
    

