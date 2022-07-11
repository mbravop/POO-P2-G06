/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Atencion {
    private Cita cita;

    public Atencion(Cita cita) {
        this.cita= cita;
    }

    public Cita getCita() {
        return cita;
    }
    

    @Override
    public String toString() {
        return "Atencion{" + "cita=" + cita + '}';
    }
    
    public static void registrarAtencion(ArrayList<Atencion> atenciones, ArrayList<Cita> citas, String cedula){
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
        
        System.out.println("Ingrese la duración en minutos de la atencion:");
        int duracionAtencion= sc.nextInt();
        sc.nextLine();
        
        Servicio servicioRealizado= citaEscogida.getServicio();
        servicioRealizado.setDuracion(duracionAtencion);
        
        Atencion atencionRealizada = new Atencion(citaEscogida);
        atenciones.add(atencionRealizada);
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
 