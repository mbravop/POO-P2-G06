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

public class Empleado extends Persona implements Serializable{

    private boolean estado;

    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado) {
        super(cedula, nombre, telefono, email);
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + estado;
    }
    //get
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
    public void setEstado(String s){
        if(s.equals("S")){
            estado=true;
        }else{
            estado=false;
        }
    }
    /*
    Método mostrarEmpleados: Recibe la lista de empleados la cual se itera para ir mostrando la información de cada uno de los empleados en forma de lista (enumerados)
    para que sea fácil escoger alguno
     */
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
        //Creación de objeto empleado
        Empleado empleadoNuevo = new Empleado(cedula, nombre, telefono, email, true);
        empleados.add(empleadoNuevo);

    }

    /*Método editarEmpleado: Recibe la lista de empleados y un entero que nos servirá como índice más adelante: Empezamos tomando el empleado que el usuario seleccionó, 
    después le pedimos los datos que desea cambiar del empleado como el nombre, teléfono, email y si está activo o no, 
    finalmente procedemos a cambiar los datos del empleado escogido con los datos proporcionados por el usuario.*/
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
        if (respuesta.equals("S") || respuesta.equals("s")) {
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

    
    /*
    Método mostrar empledos disponibles, retorna una lista de tipo empleado, para mostrarlo en forma de lista para que
    algún empleado sea escogido.
    */
    public static ArrayList<Empleado> mostrarEmpleadosDisponibles(ArrayList<Cita> citas, ArrayList<Empleado> empleados, String fecha, String hora) {
        //Obtenemos la lista de citas que se realizan en una predeterminada fecha y hora (método en clase Cita)
        ArrayList<Cita> citasNoDisponibles = Cita.verificarCitaFyH(citas, fecha, hora);
        //Creación de lista donde se almacenarán los empleados que no se encuentren en la lista de citas ocupadas.
        ArrayList<Empleado> empleadosDisponibles = new ArrayList<>();
        //Variables para verificar si el empleado tiene estado falso, o aparece alguna vez en la lista de citas ocupadas.
        int falso = 0;
        int contador = 0;

        for (int i = 0; i < empleados.size(); i++) {
            falso = 0;
            contador = 0;
            if (empleados.get(i).isEstado() == false) {
                falso++;
            }
            for (int j = 0; j < citasNoDisponibles.size(); j++) {
                //Si las cédulas del empleado de lista empleado aparece en la lista de citas ocupadas, el contador aumenta.
                if (empleados.get(i).getCedula().equals(citasNoDisponibles.get(j).obtenerEmpleado().getCedula())) {
                    contador++;
                }
            }
            //Si el estado del empleado no es falso, y no aparece ninguna vez. Se añade al empleado a la lista de empleados disponibles
            if (falso == 0 && contador == 0) {
                empleadosDisponibles.add(empleados.get(i));
            }

        }
        return empleadosDisponibles;
    }

    public static ArrayList<Empleado> cargarEmpleados(String ruta){
        ArrayList<Empleado> empleados = new ArrayList<>();
        InputStream input = Cliente.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Empleado e = new Empleado(datos[0], datos[1], datos[2], datos[3], Boolean.parseBoolean(datos[4]));
                empleados.add(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return empleados;
    }
}