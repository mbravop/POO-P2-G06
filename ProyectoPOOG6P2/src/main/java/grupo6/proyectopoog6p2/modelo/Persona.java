/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Persona {
    //Atributos
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
 
    //Constructor de clase Persona
    public Persona(String cedula, String nombre, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    //Setters & Getters
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Método ToString
    @Override
    public String toString() {
        return cedula + "     " + nombre + "     " + telefono + "     " + email;
    }
    
    public static ArrayList<Persona> cargarPersonas(String ruta) {
        ArrayList<Persona> personas = new ArrayList<>();
        InputStream input = Persona.class.getClassLoader().getResourceAsStream(ruta);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Persona p = new Persona(datos[0], datos[1], datos[2], datos[3]);
                personas.add(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return personas;
    }
}