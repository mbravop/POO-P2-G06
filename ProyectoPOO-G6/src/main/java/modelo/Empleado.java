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
public class Empleado extends Persona {

    private boolean estado;

    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado) {
        super(cedula, nombre, telefono, email);
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + "     "+estado;
    }

    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).toString());
        }
    }

    public static void agregarEmpleado(ArrayList<Empleado> empleados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cédula del empleado: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el telefono del empleado: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el email del empleado: ");
        String email = sc.nextLine();

        Empleado empleadoNuevo = new Empleado(cedula, nombre, telefono, email, true);
        empleados.add(empleadoNuevo);

    }

    public static void editarEmpleado(int indiceEditar, ArrayList<Empleado> empleados) {
        Scanner sc = new Scanner(System.in);
        Empleado empleadoEditar = empleados.get(indiceEditar - 1);
        System.out.println("Ingrese la información corregida");
        System.out.println("Nombre: ");
        String nombreNuevo = sc.nextLine();
        System.out.println("Telefono: ");
        String telefonoNuevo = sc.nextLine();
        System.out.println("Email: ");
        String emailNuevo = sc.nextLine();
        System.out.println("Estado: ");

        System.out.println("El empleado está activo? S/N");
        String respuesta = sc.nextLine();
        boolean actividad;
        if (respuesta.equals("S")) {
            actividad = true;
        } else {
            actividad = false;
        }
        empleadoEditar.setNombre(nombreNuevo);
        empleadoEditar.setTelefono(telefonoNuevo);
        empleadoEditar.setEmail(emailNuevo);
        empleadoEditar.estado = actividad;
    }

    public static void eliminarEmpleado(int indiceEliminar, ArrayList<Empleado> empleados) {
        Empleado empleadoEliminar = empleados.get(indiceEliminar - 1);
        empleadoEliminar.estado = false;
    }

}
