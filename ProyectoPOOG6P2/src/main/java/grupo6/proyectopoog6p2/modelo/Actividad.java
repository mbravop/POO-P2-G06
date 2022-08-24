/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;

/**
 *
 * @author mbravop
 */
public class Actividad {
    private Cliente cliente;
    private String tiempo;
    private int fallos;
    
    public Actividad(Cliente cliente, String tiempo, int fallos){
        this.cliente = cliente;
        this.tiempo = tiempo;
        this.fallos = fallos;
    }
}
