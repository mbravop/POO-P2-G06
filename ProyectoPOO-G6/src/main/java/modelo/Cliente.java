/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author mbravop
 */
public class Cliente extends Persona{
    //atributo
    private Persona datosRepresentante;

    @Override
    public String toString() {
        return super.toString();
    }

    public Cliente(Persona datosRepresentante, String cedula, String nombre, String telefono, String email) {
        super(cedula, nombre, telefono, email);
        this.datosRepresentante = datosRepresentante;
    }
    

    //metodos
    public static void mostrarClientes(ArrayList<Cliente> clientes){
        for(int i=0; i < clientes.size(); i++){
            System.out.println((i+1)+". "+ clientes.get(i).toString());
        }
    }
    
    public void agregarCliente(){
        
    }
    
    public void editarCliente(String nombre, String telefono, String email){
        
    }
}
