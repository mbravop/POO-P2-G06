/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class Servicio {
    private String nombreServicio;
    private int duracion;
    private double precio;
    private boolean estado;
    
    public Servicio(String nS, int d, double p, boolean e){
        nombreServicio=nS;
        duracion=d;
        precio=p;
        estado=e;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return nombreServicio + "     " + duracion + "     " + precio + "     " + estado;
    }
    
    public static void mostrarServicios(ArrayList<Servicio> servicios){
        for(int i=0; i < servicios.size(); i++){
            System.out.println((i+1)+". "+ servicios.get(i).toString());
        }
    }
    
    public void agregarServicio(){
        
    }
    
    public void editarServicio(String nS, int d, double p){
        nombreServicio=nS;
        duracion=d;
        precio= p;
    }
    
    public void eliminarServicio(){
        if (estado){
            estado=false;
        }
    }
}