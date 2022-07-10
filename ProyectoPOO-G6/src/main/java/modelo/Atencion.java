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
    /*
    public static void registrarAtencion(ArrayList<Atencion> atenciones, ArrayList<Cita> citas, String cedula){
        ArrayList<Cita> citaPersona = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        for (Cita c: citas){
            
            Cliente clienteCita= c.getCliente();
            if (c.getCedula().equals(cedula)){
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
        
        //Servicio servicioRealizado= citaEscogida.getServicio();
        //servicioRealizado.setDuracion(duracionAtencion);
        
    }
    */
    public static void consultarAtencion(String buscador, ArrayList<Atencion> atenciones){
                  
    }
    
 }