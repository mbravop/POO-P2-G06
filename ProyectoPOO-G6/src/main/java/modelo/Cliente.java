/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Scanner;
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
    
    public static void agregarCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        //Datos Cliente
        System.out.println("Ingrese la cédula del cliente: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el telefono del cliente: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el email del cliente: ");
        String email = sc.nextLine();
        //Datos Representante
        System.out.println("Ingrese la cédula del representante: ");
        String cedulaR = sc.nextLine();
        System.out.println("Ingrese el nombre del representante: ");
        String nombreR = sc.nextLine();
        System.out.println("Ingrese el telefono del representante: ");
        String telefonoR = sc.nextLine();
        System.out.println("Ingrese el email del representante: ");
        String emailR = sc.nextLine();
        
        Persona representante= new Persona(cedulaR,nombreR,telefonoR,emailR);
        Cliente clienteNuevo = new Cliente(representante, cedula,nombre,telefono,email);
        clientes.add(clienteNuevo);
    }
    
    public static void editarCliente(int indiceEditar, ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        Cliente clienteEditar = clientes.get(indiceEditar-1);
        System.out.println("Ingrese la información corregida");
        System.out.println("Cedula: ");
        String cedulaNueva = sc.nextLine();
        System.out.println("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.println("Telefono: ");
        String telefonoNuevo = sc.nextLine();
        System.out.println("Email: ");
        String emailNuevo = sc.nextLine();
        
        clienteEditar.setCedula(cedulaNueva);
        clienteEditar.setNombre(nombreNuevo);
        clienteEditar.setTelefono(telefonoNuevo);
        clienteEditar.setEmail(emailNuevo);
    }
}
