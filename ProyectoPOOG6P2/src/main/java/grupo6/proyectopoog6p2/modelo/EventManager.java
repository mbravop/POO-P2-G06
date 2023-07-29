/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelorrala
 */
public class EventManager {
    private static List<AtencionListener> observadores = new ArrayList<>();
    public void agregarObservador(AtencionListener observador) {
        observadores.add(observador);
    }
    
    public void eliminarObservador(AtencionListener observador){
        observadores.remove(observador);
    }
    
    public static void notificarObservadores(Atencion atencion) {
        for (AtencionListener observador : observadores) {
            observador.nuevaAtencionRegistrada(atencion);
        }
    }
}
