/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Atencion implements Serializable{
    private Cita cita;
    private int tiempoAtencion;
    private Empleado empleado;
    public String nombreCliente;
    public String nombreEmpleado;
    public String nombreServicio;
    public String fechaAtencion;
    
    private static final long serialVersionUID = 6529685098267757691L;
    
    //Constructor para clase Atención
    public Atencion(Cita cita, int atencion, Empleado empleado) {
        this.cita= cita;
        this.tiempoAtencion = atencion;
        this.empleado = empleado;
    }
     
    //Getter de la cita relacionada a la atención 
    public Cita getCita() {
        return cita;
    }
    
    public String getNombreCliente(){
        return cita.getCliente();
    }
    public String getNombreEmpleado(){
        return empleado.getNombre();
    }
    public String getNombreServicio(){
        return cita.getServicio();
    }
    public int getTiempoAtencion(){
        return tiempoAtencion;
    }
    
    public String getFechaAtencion(){
        return cita.getFecha();
    }

    @Override
    public String toString() {
        return "Servicio: " + cita.obtenerServicio().getNombreServicio()+" | Realizado por: "+empleado.getCedula() + " " +empleado.getNombre()+ " | Cliente: " + cita.obtenerCliente().getCedula() + " " + cita.obtenerCliente().getNombre() + " | Duracion: " + tiempoAtencion + " minutos.";
    }
    
    
    //Método para registrar una atencion el cual recibe un arreglo de atenciones,citas y empleados, y la cédula del cliente
    
    public static void registrarAtencion(ArrayList<Atencion> atenciones, ArrayList<Cita> citas, String cedula, ArrayList<Empleado> empleados){
        ArrayList<Cita> citaPersona = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        //Se muestran las citas tienen relaciacionada una atención filtrando por medio de la cédula del cliente
        for (Cita c: citas){
            Cliente clienteCita = c.obtenerCliente();
            String cedulaCliente = clienteCita.getCedula();
            if (cedulaCliente.equals(cedula)){
                citaPersona.add(c);
                System.out.println((1+contador)+ ". "+c);
                contador +=1;

            }
        }
        // Si el cliente cuenta con citas agendadas, se pregunta por cuál de ellas se desea registrar la atención
        if(contador!=0){
            System.out.print("¿Qué cita desea confirmar la atención? ");
            int citaConfirmada= sc.nextInt();
            sc.nextLine();
            
            Cita citaEscogida= citaPersona.get(citaConfirmada-1);
            System.out.println(citaEscogida);
            System.out.print("Ingrese la duración en minutos de la atencion: ");
            int duracionAtencion= sc.nextInt();
            sc.nextLine();
            
            //Se verifica si el empleado que dio la atencion es el mismo que agendo la cita
            System.out.print("El empleado asignado a la cita realizó la atención? S/N ");
            String respuesta = sc.nextLine();
            //En de caso de que sea el mismo empleado, se crea la atención con el mismo empleado
            if(respuesta.equals("S") || respuesta.equals("s")){
                Atencion atencionRealizada = new Atencion(citaEscogida, duracionAtencion, citaEscogida.obtenerEmpleado());
                atenciones.add(atencionRealizada);
                System.out.println("Atención registrada exitosamente.");
            }
            /*En caso de ser distintos empleados, se muestran los empleados disponibles y se hace escoger el empleado que desee
            Y se crea la atención con otro empleado
            */
            else{
                System.out.println("Empleados: ");
                Empleado.mostrarEmpleados(empleados);
                System.out.print("Ingrese el número del empleado que realizó la atención: ");
                int indiceEmpleado = sc.nextInt();
                sc.nextLine();
                Empleado empleadoAtencion = empleados.get(indiceEmpleado-1);
                Atencion atencionCambio = new Atencion(citaEscogida, duracionAtencion, empleadoAtencion);
                atenciones.add(atencionCambio);
                System.out.println("Atención registrada exitosamente.");
            }
        }
        //En caso de que no existan citas filtrando con la cédula del cliente, se muestra el mensaje por pantalla
        else{
            System.out.println("Este numero de cédula no tiene citas, no se puede registar una atención.");
        }
        
    }
    
    /* Método para consultar las atenciones el cual recibe el arreglo de atenciones y retorna las atenciones filtradas por 
    el número de cédula del cliente o del empleado que realizo la atencion o la fecha en que se realizó la atención    
    */
    public static ArrayList<Atencion> consultarAtencion(ArrayList<Atencion> atenciones){
        Scanner sc= new Scanner(System.in);
        ArrayList<Atencion> atencionesBusqueda = new ArrayList<>();
        System.out.println("Ingrese una fecha(dd/mm/aaaa), su cedula o la cedula del empleado que lo atendio:");
        String buscador= sc.nextLine();
        //iterando el arreglo de atenciones para obtener los atributos de cada atención
        for(int i=0; i<atenciones.size();i++){
            Atencion atencion= atenciones.get(i);
            String cedula= atencion.getCita().obtenerCliente().getCedula();
            String fecha= atencion.getCita().getFecha();
            String cedulaEmpleado= atencion.getCita().obtenerEmpleado().getCedula();
            // filtrando por fecha o cédula del cliente o del empleado
            if (buscador.equals(cedula) || buscador.equals(fecha) || buscador.equals(cedulaEmpleado)){
                atencionesBusqueda.add(atencion);
            }
        }
        return atencionesBusqueda;
    }
    
    public static ArrayList<Atencion> cargarAtenciones(String ruta){
        ArrayList<Atencion> atenciones = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            atenciones = (ArrayList<Atencion>) oi.readObject();
        }catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return atenciones;
    }
}
 