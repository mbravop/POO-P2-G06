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

/**
 *
 * @author mbravop
 */
public class Actividad implements Serializable {
    private Cliente cliente;
    private String actividad;
    private String fecha;
    private String tiempo;
    private int fallos;

    public String getCliente() {
        return cliente.getNombre();
    }

    public String getActividad() {
        return actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTiempo() {
        return tiempo.split(" ")[1];
    }

    public int getFallos() {
        return fallos;
    }
    
    
    
    public Actividad(Cliente cliente, String actividad, String fecha, String tiempo, int fallos){
        this.cliente = cliente;
        this.actividad = actividad;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.fallos = fallos;
    }
    
    public static ArrayList<Actividad> cargarActividades(String ruta){
        ArrayList<Actividad> actividades = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            actividades = (ArrayList<Actividad>) oi.readObject();
        }catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return actividades;
    }
}
