/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class Atencion {
    private Cliente cliente;
    private Empleado empleado;
    private Servicio servicio;
    private int duracion;

    public Atencion(Cliente cliente, Empleado empleado, Servicio servicio, int duracion) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.duracion = duracion;
    }
    
    public static void registrarAtencion(ArrayList<Atencion> atenciones, Cliente cliente, int duracion, Empleado empleado, Servicio servicio){
        
    }
    
    public static void consultarAtencion(String buscador, ArrayList<Atencion> atenciones){
        
    }
    
 }