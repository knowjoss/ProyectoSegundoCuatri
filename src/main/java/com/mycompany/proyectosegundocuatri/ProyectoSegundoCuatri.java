/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectosegundocuatri;

import javax.swing.JOptionPane;

/**
 *
 * @author Josuni
 */
public class ProyectoSegundoCuatri {
    
    public static void main(String[] args) {        
        
        String opcion = "";

        while (true) {
            opcion = JOptionPane.showInputDialog("""
                                                 === Bienvenidos a Fantasy ===
                                                 1. Entar a Fantasy. 
                                                 2. Salir de Fantasy.
                                                 Digite: 1 o 2:""");

            if ("1".equals(opcion)) {
                Inicialmenu menu = new Inicialmenu();
                menu.comprarEntradas();
                
            } else if ("2".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "Hasta pronto!");
                break;
                
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
            
        }
    }
}