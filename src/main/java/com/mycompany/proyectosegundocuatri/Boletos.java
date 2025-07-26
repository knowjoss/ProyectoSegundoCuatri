/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

/**
 *
 * @author Josuni
 */
import javax.swing.*;

public class Boletos {
    
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

    public void mostrarReporte() {
        if (contadorUsuarios == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }

        String reporte = "=== Reporte de Ventas ===\n";
        for (int i = 0; i < contadorUsuarios; i++) {
            reporte += visitante[i].mostrarInfo() + "\n";
        }

        JOptionPane.showMessageDialog(null, reporte);
    }
}

