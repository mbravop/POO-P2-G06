/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grupo6.proyectopoo.g6;
import java.util.Scanner;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @group  Grupo #6 - POO
 * @author Mauricio Bravo, Dereck Santander, Carlos Salazar
 */

public class ProyectoPOOG6 {
    
    //ATRIBUTOS DEL MAIN
    public static ArrayList<Servicio> servicios;
    public static ArrayList<Empleado> empleados;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Cita> citas;
    public static ArrayList<Atencion> atenciones;
    
    //METODO INICIALIZAR SISTEMA
    public static void inicializarSistema(){
        //Inicializa el sistema con al menos un empleado, dos clientes, tres servicios, 2 citas sin atender, 1 atención.
        empleados = new ArrayList<>();
        empleados.add(new Empleado("0908070605", "Carlos", "2840329","@espol", true));
        empleados.add(new Empleado("1029384756","Fernando", "1203201","@terapia", true));
        
        Persona representanteprueba1 = new Persona("0910203040","Dereck","2203190","@correo1");
        Persona representanteprueba2 = new Persona("1122334455","Edu","245060","@correo2");
        
        clientes = new ArrayList<>();
        clientes.add(new Cliente(representanteprueba1,"0987654321","Mauricio Bravo","12345", "@espol"));
        clientes.add(new Cliente(representanteprueba2,"1234567890","Carlos Salazar","289031","@fiec"));
        
        
        servicios = new ArrayList<>();
        servicios.add(new Servicio("Terapia de Lenguaje",60,30.00,true));
        servicios.add(new Servicio("Terapia de Psicopedagógica",45,40.00,true));
        servicios.add(new Servicio("Terapia cognitiva",40,25.00,true));
         
        citas = new ArrayList<>();
        //Cita atendida
        citas.add(new Cita(clientes.get(0),empleados.get(0),servicios.get(0),"13/10/2022","10:00"));
        //Citas sin atender
        citas.add(new Cita(clientes.get(1),empleados.get(1),servicios.get(1),"15/10/2022","09:00"));
        citas.add(new Cita(clientes.get(0),empleados.get(1),servicios.get(2),"17/10/2022","18:00"));
        
        atenciones = new ArrayList<>();
        //Atencion de la cita 1
        atenciones.add(new Atencion(citas.get(0),20,empleados.get(0)));
        
    }
    
    public static void main(String[] args) {
        List<MenuOption> menuOptions = new ArrayList<>();
        menuOptions.add(new ServiciosOption());
        menuOptions.add(new EmpleadosOption());
        menuOptions.add(new AtencionesOption());
        menuOptions.add(new CitasOption());
        menuOptions.add(new ClienteOption());
        Scanner sc = new Scanner(System.in);
        int opcion;
        inicializarSistema();
        //Menú del Sistema
        do {
            System.out.println("M E N U  P R I N C I P A L \n");
            System.out.println(" 1. Servicios \n 2. Empleados \n 3. Clientes \n 4. Citas  \n 5. Atenciones  \n 6. Salir");
            opcion = sc.nextInt();
            if (opcion >= 1 && opcion <= menuOptions.size()) {
                menuOptions.get(opcion - 1).execute();
            } else if (opcion == 6) {
                System.out.println("Cerrando sesión");
            } else {
                System.out.println("Opción no válida");
            }
         

        } while (opcion>0 && opcion<6);
    }
}