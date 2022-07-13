/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Atencion {
    private Cita cita;
    private int tiempoAtencion;
    private Empleado empleado;

    public Atencion(Cita cita, int atencion, Empleado empleado) {
        this.cita= cita;
        this.tiempoAtencion = atencion;
        this.empleado = empleado;
    }

    public Cita getCita() {
        return cita;
    }

    @Override
    public String toString() {
        return "Realizado por: "+empleado.getCedula() + " " +empleado.getNombre()+ " Cliente: " + cita.getCliente().getCedula() + " " + cita.getCliente().getNombre() + " Duracion: " + tiempoAtencion + " minutos.";
    }
    
    
    
    public static void registrarAtencion(ArrayList<Atencion> atenciones, ArrayList<Cita> citas, String cedula, ArrayList<Empleado> empleados){
        ArrayList<Cita> citaPersona = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        for (Cita c: citas){
            Cliente clienteCita = c.getCliente();
            String cedulaCliente = clienteCita.getCedula();
            if (cedulaCliente.equals(cedula)){
                citaPersona.add(c);
                System.out.println((1+contador)+ ". "+c);
                contador +=1;

            }
        }
        
        System.out.println("¿Qué cita desea confirmar la atención?");
        int citaConfirmada= sc.nextInt();
        sc.nextLine();
        Cita citaEscogida= citaPersona.get(citaConfirmada-1);
        
        System.out.println(citaEscogida);
        System.out.println("Ingrese la duración en minutos de la atencion:");
        int duracionAtencion= sc.nextInt();
        sc.nextLine();
        
        System.out.println("El empleado asignado a la cita realizó la atención? S/N");
        String respuesta = sc.nextLine();
        if(respuesta.equals("S")){
            Atencion atencionRealizada = new Atencion(citaEscogida, duracionAtencion, citaEscogida.getEmpleado());
            atenciones.add(atencionRealizada);
        }else{
            System.out.println("Empleados: ");
            Empleado.mostrarEmpleados(empleados);
            System.out.println("Ingrese el número del empleado que realizó la atención");
            int indiceEmpleado = sc.nextInt();
            sc.nextLine();
            Empleado empleadoAtencion = empleados.get(indiceEmpleado-1);
            Atencion atencionCambio = new Atencion(citaEscogida, duracionAtencion, empleadoAtencion);
            atenciones.add(atencionCambio);
        }
        
    }
    
    public static void consultarAtencion(ArrayList<Atencion> atenciones){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese una fecha(dd/mm/aaaa), su cedula o la cedula del empleado que lo atendio:");
        String buscador= sc.nextLine();
        for(int i=0; i<atenciones.size();i++){
            Atencion atencion= atenciones.get(i);
            String cedula= atencion.getCita().getCliente().getCedula();
            String fecha= atencion.getCita().getFecha();
            String cedulaEmpleado= atencion.getCita().getEmpleado().getCedula();
            if (buscador.equals(cedula) || buscador.equals(fecha) || buscador.equals(cedulaEmpleado)){
                System.out.println(atencion);
            }
        }
    }
}
 