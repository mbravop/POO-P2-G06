package proyectopersonal.bingo_cs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.nio.channels.Pipe;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;



public class Bingo implements Initializable {
    public ArrayList<Integer> numeros;
    public int aciertos;
    public int fallos;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    Thread t;
    
    
    @FXML
    private BorderPane BingoBorderPane;

    @FXML
    private GridPane GridPane;

    @FXML
    private Label Label00;

    @FXML
    private Label Label01;

    @FXML
    private Label Label02;

    @FXML
    private Label Label03;

    @FXML
    private Label Label10;

    @FXML
    private Label Label11;

    @FXML
    private Label Label12;

    @FXML
    private Label Label13;

    @FXML
    private Label Label20;

    @FXML
    private Label Label21;

    @FXML
    private Label Label22;

    @FXML
    private Label Label23;

    @FXML
    private Label Label30;

    @FXML
    private Label Label31;

    @FXML
    private Label Label32;

    @FXML
    private Label Label33;

    @FXML
    private Label Label40;

    @FXML
    private Label Label41;

    @FXML
    private Label Label42;

    @FXML
    private Label Label43;

    @FXML
    private Label Tiempo;
    
    @FXML
    private Button finishButton;

    @FXML
    private Label numeroAzarLabel;
    
    AudioClip sonidoError = new AudioClip(this.getClass().getResource("/Musica/sonidoErrorxd.mp3").toExternalForm());
    
    AudioClip sonidoFondo = new AudioClip(this.getClass().getResource("/Musica/paraElisa.mp3").toExternalForm());
    
    AudioClip sonidoAcierto = new AudioClip(this.getClass().getResource("/Musica/musicaAciertodefi.m4a").toExternalForm());
    
    AudioClip sonidoCelebracion = new AudioClip(this.getClass().getResource("/Musica/sonidoAplausos.mp3").toExternalForm());
  

    public String tiempoRealizado;
    public void iniciarTiempo(){
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
                        Tiempo.setText(tiempoRealizado);
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
    }

    
    
    private void verificar(Label label, int x, int y) {
        Random rd= new Random();
        int indice= rd.nextInt(3)+1;
        try{
            if ((label.getText().equals(numeroAzarLabel.getText())) && (numeros.size() > 0) ){
                
                sonidoAcierto.setVolume(0.10);
                sonidoAcierto.play();
                numeros.remove(Integer.valueOf(Integer.parseInt(numeroAzarLabel.getText())));
                int i= (int)(Math.random()*numeros.size());
                numeroAzarLabel.setText(String.valueOf(numeros.get(i)));
                //System.out.println("Son iguales");
                label.setVisible(false);
                GridPane.add(new ImageView(new Image("imagenes/"+indice+".gif",100,100,true,false)),x,y);
                aciertos++;
                
                //mostrarWarning();
                
              
            }else {
                sonidoError.setVolume(1);
                sonidoError.play();
                fallos++;
               
                Alert alerta= new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("ERROR");
                alerta.setContentText("La opcion escogida es incorrecta\n Vuelva a intentarlo");
                alerta.showAndWait();
                
            }
           //System.out.println(fallos);
           //System.out.println(aciertos);
        }catch(Exception e){ 
            t.interrupt();
            sonidoFondo.stop();
            sonidoCelebracion.setVolume(0.1);
            sonidoCelebracion.play();
            GridPane.add(new ImageView(new Image("imagenes/4.gif",100,100,true,false)),x,y);
            Alert alerta= new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Información");
            alerta.setContentText("!Felicidades!\n Ha ganado el juego\n" +" su tiempo fue: " +(minutos <10? "0":"")+minutos+":"+(segundos < 10? "0":"")+segundos+"\n tuvo "+fallos+" fallos");
            alerta.showAndWait();
            
            
        }
        
        
    }
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        //llenar el gridpane
        llenarGridPane();
        sonidoFondo.setVolume(0.10);
        sonidoFondo.play();
        

        Label00.setOnMouseClicked((click) -> verificar(Label00,0,0));
        Label01.setOnMouseClicked((click) -> verificar(Label01,0,1));
        Label02.setOnMouseClicked((click) -> verificar(Label02,0,2));
        Label03.setOnMouseClicked((click) -> verificar(Label03,0,3));
        Label10.setOnMouseClicked((click) -> verificar(Label10,1,0));
        Label11.setOnMouseClicked((click) -> verificar(Label11,1,1));
        Label12.setOnMouseClicked((click) -> verificar(Label12,1,2));
        Label13.setOnMouseClicked((click) -> verificar(Label13,1,3));
        Label20.setOnMouseClicked((click) -> verificar(Label20,2,0));
        Label21.setOnMouseClicked((click) -> verificar(Label21,2,1));
        Label22.setOnMouseClicked((click) -> verificar(Label22,2,2));
        Label23.setOnMouseClicked((click) -> verificar(Label23,2,3));
        Label30.setOnMouseClicked((click) -> verificar(Label30,3,0));
        Label31.setOnMouseClicked((click) -> verificar(Label31,3,1));
        Label32.setOnMouseClicked((click) -> verificar(Label32,3,2));
        Label33.setOnMouseClicked((click) -> verificar(Label33,3,3));
        Label40.setOnMouseClicked((click) -> verificar(Label40,4,0));
        Label41.setOnMouseClicked((click) -> verificar(Label41,4,1));
        Label42.setOnMouseClicked((click) -> verificar(Label42,4,2));
        Label43.setOnMouseClicked((click) -> verificar(Label43,4,3));
        
        int i= (int)(Math.random()*numeros.size());
        numeroAzarLabel.setText(String.valueOf(numeros.get(i)));
                
        GridPane.setGridLinesVisible(true);
       
        finishButton.setOnAction(e -> System.exit(0));
        
        }
        
    private void mostrarWarning(){
        Alert alerta= new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Información");
        alerta.setContentText("!Felicidades!\n Escogio la respuesta correcta");
        alerta.showAndWait();
    }    
       
    private ArrayList<Integer> aleatorios(){
        ArrayList<Integer> numeros= new ArrayList<>();
        for(int i=1; i<21; i++){
            numeros.add(i);
        }
        Collections.shuffle(numeros);
        return numeros;
    }
    
      
    
    private void llenarGridPane(){
        iniciarTiempo();
        
        numeros= aleatorios();
        Label00.setText(String.valueOf(numeros.get(0)));
        Label01.setText(String.valueOf(numeros.get(1)));
        Label02.setText(String.valueOf(numeros.get(2)));
        Label03.setText(String.valueOf(numeros.get(3)));
        Label10.setText(String.valueOf(numeros.get(4)));
        Label11.setText(String.valueOf(numeros.get(5)));
        Label12.setText(String.valueOf(numeros.get(6)));
        Label13.setText(String.valueOf(numeros.get(7)));
        Label20.setText(String.valueOf(numeros.get(8)));
        Label21.setText(String.valueOf(numeros.get(9)));
        Label22.setText(String.valueOf(numeros.get(10)));
        Label23.setText(String.valueOf(numeros.get(11)));
        Label30.setText(String.valueOf(numeros.get(12)));
        Label31.setText(String.valueOf(numeros.get(13)));
        Label32.setText(String.valueOf(numeros.get(14)));
        Label33.setText(String.valueOf(numeros.get(15)));
        Label40.setText(String.valueOf(numeros.get(16)));
        Label41.setText(String.valueOf(numeros.get(17)));
        Label42.setText(String.valueOf(numeros.get(18)));
        Label43.setText(String.valueOf(numeros.get(19)));
    }
    
    /* ArrayList<Bingo> partidaBingo = new ArrayList<>();
     
     public void escribirArchivo(ArrayList<Bingo> partidasBingo){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(App.pathBingo,false));
            for(Bingo pb: partidasBingo){
                escritor.write(pb.toString()+"\n");
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error escribiendo la partida de bingo");
        }
    }*/
       
     
   

    
}
