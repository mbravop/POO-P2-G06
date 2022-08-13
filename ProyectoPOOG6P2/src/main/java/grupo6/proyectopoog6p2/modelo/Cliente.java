/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona implements Serializable{
    //atributo
    private String datosRepresentante;

    @Override
    public String toString() {
        return datosRepresentante+";"+super.toString();
    }

    public String getDatosRepresentante() {
        return datosRepresentante;
    }

    public void setDatosRepresentante(String datosRepresentante) {
        this.datosRepresentante = datosRepresentante;
    }
    
    //Constructor
    public Cliente(String datosRepresentante, String cedula, String nombre, String telefono, String email) {
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
        System.out.print("Ingrese la cédula y nombre del representante: ");
        String cedulaNombreR = sc.nextLine();
 
        //Creacion de objetos de tipo Persona(representante) y Cliente
        Cliente clienteNuevo = new Cliente(cedulaNombreR, cedula, nombre, telefono, email);
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
    
    public static ArrayList<Cliente> cargarClientes(String ruta) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        InputStream input = Cliente.class.getClassLoader().getResourceAsStream(ruta);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                clientes.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return clientes;
    }
}
