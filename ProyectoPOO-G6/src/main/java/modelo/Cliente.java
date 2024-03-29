/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona{
    //atributo
    private Persona datosRepresentante;

    @Override
    public String toString() {
        return super.toString();
    }
    
    //Constructor
    public Cliente(Persona datosRepresentante, String cedula, String nombre, String telefono, String email) {
        super(cedula, nombre, telefono, email);
        this.datosRepresentante = datosRepresentante;
    }
    

    //Método Mostrar Clientes
    public static void mostrarClientes(ArrayList<Cliente> clientes){
        for(int i=0; i < clientes.size(); i++){
            System.out.println((i+1)+". "+ clientes.get(i).toString());
        }
    }
    //Método Agregar Cliente el cual 
    public static void agregarCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        //Datos Cliente
        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el telefono del cliente: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = sc.nextLine();
        //Datos Representante
        System.out.print("Ingrese la cédula del representante: ");
        String cedulaR = sc.nextLine();
        System.out.print("Ingrese el nombre del representante: ");
        String nombreR = sc.nextLine();
        System.out.print("Ingrese el telefono del representante: ");
        String telefonoR = sc.nextLine();
        System.out.print("Ingrese el email del representante: ");
        String emailR = sc.nextLine();
        //Creacion de objetos de tipo Persona(representante) y Cliente
        Persona representante= new Persona(cedulaR,nombreR,telefonoR,emailR);
        Cliente clienteNuevo = new Cliente(representante, cedula,nombre,telefono,email);
        clientes.add(clienteNuevo);
    }
    //Método Editar Cliente el cual actualiza los datos del cliente que se desee
    public static void editarCliente(int indiceEditar, ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        //Datos a cambiar
        Cliente clienteEditar = clientes.get(indiceEditar-1);
        System.out.println("Ingrese la información corregida");
        System.out.print("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.print("Telefono: ");
        String telefonoNuevo = sc.nextLine();
        System.out.print("Email: ");
        String emailNuevo = sc.nextLine();
        
        //Actualizar Cliente
        clienteEditar.setNombre(nombreNuevo);
        clienteEditar.setTelefono(telefonoNuevo);
        clienteEditar.setEmail(emailNuevo);
    }
    
    /*Método para buscar un cliente por medio de la cédula y el arreglo de los clientes del sistema
    El cual es utilizado para crear una cita y asignarle el atributo de tipo Cliente, cliente escogido
    */
    public static Cliente buscarCliente(ArrayList<Cliente> clientes, String cedula){
        Cliente clienteEscogido = null;
        for(Cliente c: clientes){
            if(c.getCedula().equals(cedula)){
                clienteEscogido = c;
            }
        }
        return clienteEscogido;
    }
}
