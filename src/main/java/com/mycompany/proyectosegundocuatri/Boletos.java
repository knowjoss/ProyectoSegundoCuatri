/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

/**
 *
 * @author Josuni
 */
import javax.swing.JOptionPane;

public class Boletos {
    
    private Atracciones atracciones;
    private RegistroSubida[] registrosSubidas = new RegistroSubida[100];
    private int contadorSubidas = 0;

    public Boletos(Atracciones atracciones) {
       this.atracciones = atracciones;
    }
    
    private Visitante[] visitante = new Visitante[30]; // máximo 30 usuarios a registrar para el reporte
    private int contadorUsuarios = 0;

    public void comprarEntradas() {
        if (contadorUsuarios >= visitante.length) { 
            JOptionPane.showMessageDialog(null, "Ya no se pueden registrar más usuarios.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String cedula = JOptionPane.showInputDialog("Ingrese su cédula:");

        int precioNino = 2000;
        int precioAdulto = 3500;
        int precioAdultoMayor = 2500;
        
        int cantNino = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de boletos para Niño (₡" + precioNino + "):"));
        int cantAdulto = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de boletos para Adulto (₡" + precioAdulto + "):"));
        int cantAdultoMayor = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de boletos para Adulto Mayor (₡" + precioAdultoMayor + "):"));

        int total = (cantNino * precioNino) + (cantAdulto * precioAdulto) + (cantAdultoMayor * precioAdultoMayor);

        JOptionPane.showMessageDialog(null, "Total a pagar: ₡" + total);

        visitante[contadorUsuarios] = new Visitante(nombre, cedula, total);
        contadorUsuarios++;
        
    }

   public void irAtracciones() {
    if (contadorUsuarios == 0) {
        JOptionPane.showMessageDialog(null, "Usuario no encontrado, debe comprar un boleto primero.");
        return;
    }

    String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
    String cedulaIngresada = JOptionPane.showInputDialog("Ingrese su cédula:");

    Visitante visitanteActual = null;

    for (int i = 0; i < contadorUsuarios; i++) {
        if (visitante[i].getNombre().equalsIgnoreCase(nombreIngresado) &&
            visitante[i].getCedula().equalsIgnoreCase(cedulaIngresada)) {
            visitanteActual = visitante[i];
            break;
        }
    }

    if (visitanteActual == null) {
        JOptionPane.showMessageDialog(null, "Usuario no encontrado o sin boleto registrado.");
        return;
    }

    // Construir mensaje con lista de atracciones
    String mensaje = "Seleccione una atracción para subirse:\n";
    for (int i = 0; i < atracciones.getContador(); i++) {
        mensaje += (i + 1) + ". " + atracciones.getLista()[i].getNombre() + "\n";
    }

    String entrada = JOptionPane.showInputDialog(mensaje);
    if (entrada == null || entrada.equals("")) {
        JOptionPane.showMessageDialog(null, "Opción inválida.");
        return;
    }

    int opcion = 0;
    try {
        opcion = Integer.parseInt(entrada);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
        return;
    }

    if (opcion < 1 || opcion > atracciones.getContador()) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
        return;
    }

    Atraccion atraccionElegida = atracciones.getLista()[opcion - 1];
    atraccionElegida.incrementarSubida();

    // Guardar registro de subida para este visitante y atracción
    boolean encontrado = false;
    for (int i = 0; i < contadorSubidas; i++) {
        if (registrosSubidas[i].nombreVisitante.equalsIgnoreCase(visitanteActual.getNombre()) &&
            registrosSubidas[i].nombreAtraccion.equalsIgnoreCase(atraccionElegida.getNombre())) {
            registrosSubidas[i].veces++;
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        if (contadorSubidas < registrosSubidas.length) {
            registrosSubidas[contadorSubidas] = new RegistroSubida(visitanteActual.getNombre(), atraccionElegida.getNombre());
            contadorSubidas++;
        }
    }

    JOptionPane.showMessageDialog(null, visitanteActual.getNombre() + " se subió a: " + atraccionElegida.getNombre());
}

    
    public void mostrarReporte() {
        if (contadorUsuarios == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }

        String reporte = "Reporte de Ventas\n";
        for (int i = 0; i < contadorUsuarios; i++) {
            reporte += visitante[i].mostrarInfo() + "\n";
        }

        JOptionPane.showMessageDialog(null, reporte);
    }
    public void mostrarReporteUsuarios(){
        if (contadorUsuarios==0){
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }
        for (int i=0; i< contadorUsuarios;i++){
            Visitante v=visitante[i];
            JOptionPane.showMessageDialog(null,"Reporte de visitas de Usuarios"+"\n"+"Nombre:"+v.getNombre()+"\n"+"Cedula:" +v.getCedula());
            for(int j=0;j<atracciones.getContador();j++){
                Atraccion a=atracciones.getLista()[j];
                JOptionPane.showMessageDialog(null,"Nombre:"+a.getNombre()+":"+a.getContadorSubidas()+" veces");
            }
        }
        
    }
        
    private class RegistroSubida {
    String nombreVisitante;
    String nombreAtraccion;
    int veces;

    RegistroSubida(String nombreVisitante, String nombreAtraccion) {
        this.nombreVisitante = nombreVisitante;
        this.nombreAtraccion = nombreAtraccion;
        this.veces = 1;
    }
}

}

