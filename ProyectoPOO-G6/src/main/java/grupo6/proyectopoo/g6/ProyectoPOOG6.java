/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grupo6.proyectopoo.g6;
import java.util.Scanner;
import modelo.*;
import java.util.ArrayList;

public class ProyectoPOOG6 {
    
    public static ArrayList<Servicio> servicios;
    public static ArrayList<Empleado> empleados;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Cita> citas;
    public static ArrayList<Atencion> atenciones;
    
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
        Scanner sc = new Scanner(System.in);
        int opcion;
        inicializarSistema();
        
        do {
            System.out.println("M E N U  P R I N C I P A L \n");
            System.out.println(" 1. Servicios \n 2. Empleados \n 3. Clientes \n 4. Citas  \n 5. Atenciones  \n 6. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // SERVICIOS
                    int opcion1;
                    do {
                        System.out.println("\nL I S T A D O   D E   S E R V I C I O S \n");
                        //Metodo mostrar servicios
                        Servicio.mostrarServicios(servicios);
                        System.out.println("----- 1. Agregar Servicios ----- 2. Editar Servicios ----- 3. Eliminar Servicios ----- 4. Menu Principal \n");
                        opcion1 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion1) {
                            case 1:
                                System.out.println("Ingrese la información del servicio");
                                Servicio.agregarServicio(servicios);
                                break;
                            case 2:
                                System.out.print("Ingrese el número del servicio a editar: ");
                                int editar = sc.nextInt();
                                sc.nextLine();
                                Servicio.editarServicio(editar, servicios);
                                break;
                            case 3:
                                System.out.print("Ingrese el número del servicio a eliminar: ");
                                int eliminar = sc.nextInt();
                                sc.nextLine();
                                Servicio.eliminarServicio(eliminar, servicios);
                                break;
                            default:
                                System.out.println("Volviendo... \n");
                        }
                    } while (opcion1 > 0 && opcion1 < 4);
                    break;

                case 2: // EMPLEADOS
                    int opcion2;
                    do {
                        // Método mostrar empleados
                        System.out.println("#   CEDULA ----- NOMBRE ----- TELEFONO ----- EMAIL ----- ESTADO");
                        Empleado.mostrarEmpleados(empleados);
                        System.out.println("----- 1. Agregar empleado ----- 2. Editar empleado ----- 3. Eliminar empleado ----- 4. Menu Principal");
                        opcion2 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese la información del empleado");
                                Empleado.agregarEmpleado(empleados);
                                break;
                            case 2:
                                System.out.println("Ingrese el número del empleado a editar");
                                int editar = sc.nextInt();
                                sc.nextLine();
                                Empleado.editarEmpleado(editar, empleados);
                                break;
                            case 3:
                                System.out.println("Ingrese el número del empleado a eliminar");
                                int eliminar = sc.nextInt();
                                sc.nextLine();
                                Empleado.eliminarEmpleado(eliminar, empleados);
                                break;
                            default:
                                System.out.println("Volviendo... \n");
                        }
                        
                    } while (opcion2 > 0 && opcion2 < 4);
                    break;
                    
                case 3: // CLIENTES
                    int opcion3;
                    do{
                        System.out.println("#   CEDULA ----- NOMBRE ----- TELEFONO ----- EMAIL");
                        //Metodo mostrar clientes
                        Cliente.mostrarClientes(clientes);
                        System.out.println("----- 1. Agregar cliente ----- 2. Editar cliente ----- 3. Menu Principal \n");
                        opcion3 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion3) {
                            case 1:
                                System.out.println("Ingrese la información del cliente");
                                Cliente.agregarCliente(clientes);
                                break;
                            case 2:
                                System.out.print("Ingrese el número del cliente a editar: ");
                                int editar = sc.nextInt();
                                sc.nextLine();
                                Cliente.editarCliente(editar, clientes);
                                break;
                            default:
                                System.out.println("Volviendo... \n");
                        }
                    }while(opcion3 > 0 && opcion3 < 3);
                    break;
                    
                case 4: // CITAS
                    int opcion4;
                    do{
                        //Mostrar citas
                        //Cita.mostrarCitas(citas);
                        System.out.println(" 1. Crear cita\n 2. Eliminar cita\n 3. Consultar citas\n 4. Menu Principal\n");
                        opcion4 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion4){
                            case 1:
                                System.out.println("Ingrese la información para la nueva cita: ");
                                System.out.print("Ingrese fecha de la cita (dd/mm/aaaa): ");
                                String fecha = sc.nextLine();
                                System.out.print("Ingrese hora de la cita (hh:mm): ");
                                String hora = sc.nextLine();
                                ArrayList<Empleado> empleadosDisponibles = Empleado.mostrarEmpleadosDisponibles(citas, empleados, fecha, hora);
                                if(empleadosDisponibles.size()>0){
                                    Cliente clienteCedula = null;
                                    System.out.println("Ingrese el numero de cedula del cliente");
                                    String cedula = sc.nextLine();
                                    clienteCedula = Cliente.buscarCliente(clientes, cedula);
                                    if(clienteCedula!=null){
                                        ArrayList<Servicio> serviciosDisponibles = Servicio.serviciosDisponibles(servicios);
                                        Cita.crearCita(clienteCedula, citas, empleadosDisponibles, serviciosDisponibles, fecha, hora);
                                    }else{
                                        System.out.println("No existe un cliente con esta cedula, intente nuevamente");
                                        break;
                                    }
                                }else{
                                    System.out.println("No es posible crear una cita, no hay empleados disponibles a la hora y fecha deseadas.");
                                    break;
                                }
                                break;
                            case 2:
                                System.out.print("Ingrese el numero de cedula del cliente: ");
                                String cedula = sc.nextLine();
                                Cita.eliminarCita(cedula, citas);
                                
                                break;
                            case 3:
                                System.out.print("Ingrese la fecha(dd/mm/aaaa) para consultar las citas: ");
                                String fechaConsultada= sc.nextLine();
                                Cita.consultarCita(fechaConsultada, citas);
                                break;
                            default:
                                System.out.println("Volviendo... \n");
                        }
                    }while(opcion4 > 0 && opcion4 < 4);
                    break;
                    
                case 5: // ATENCIONES
                    int opcion5;
                    do{
                        if(atenciones.size()>0){
                            for(Atencion a: atenciones){
                            System.out.println(a);
                        }
                        }
                        System.out.println(" 1. Registrar atencion \n 2. Consultar atención \n 3. Menu Principal\n");
                        opcion5 = sc.nextInt();
                        sc.nextLine();
                        switch(opcion5){
                            case 1:
                                System.out.print("Ingrese cédula del cliente: ");
                                String cedula = sc.nextLine();
                                Atencion.registrarAtencion(atenciones, citas, cedula, empleados);
                                break;
                            case 2:
                                //System.out.println("Ingrese información para la consulta");
                                ArrayList<Atencion> atencionesBusqueda = Atencion.consultarAtencion(atenciones);
                                if(atencionesBusqueda.size()==0){
                                    System.out.println("No existen atenciones bajo el parámetro buscado");
                                }else{
                                    System.out.println(atencionesBusqueda);
                                }
                                break;
                            default:
                                System.out.println("Volviendo...\n");
                        }
                    }while(opcion5 > 0 && opcion5 < 3);
                    break;
                    
                default:
                    System.out.println("Cerrando sesión");
            }

        } while (opcion>0 && opcion<6);
    }
}