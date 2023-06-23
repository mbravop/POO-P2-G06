/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author joelorrala
 */
public class controlTime {
    
    private static String tiempoRealizado;
    
    private static int segundos = 0;
    private static int minutos = 0;
    private static int horas = 0;
    static Thread t;
    

    public static String iniciarTiempo(Label label){
        t = new Thread(){
            @Override
            public void run() {
                while(!Thread.interrupted()){
                    segundos++;
                    if (segundos == 60){
                        minutos ++;
                        segundos = 0;
                    }
                    if (minutos == 60){
                        horas ++;
                        minutos = 0;
                    }
                    if (horas == 24){
                        horas =0;
                    }
                    tiempoRealizado = "Tiempo "+(horas < 10? "0":"")+horas+":"+(minutos <10? "0":"")+minutos+":"+(segundos < 10? "0":"")+segundos;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label.setText(tiempoRealizado);
                        }
                     });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    
                }
    
               
           }
           
        };
        t.start();   
        return tiempoRealizado;
    }

}
