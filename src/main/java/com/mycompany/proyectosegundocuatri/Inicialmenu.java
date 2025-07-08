/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

import javax.swing.JOptionPane;

/**
 *
 * @author Josuni
 */
public class Inicialmenu {
    
    public String opcion;
    
    public void comprarEntradas() {    
        
        while(true) {
            
            opcion = JOptionPane.showInputDialog("""
                                                 === Para el ingreso, por favor, compre su entrada. ===
                                                 1. Pase normal: $1000. 
                                                 2. Pase especial: $1500. 
                                                 3. Volver al menú de inicio. 
                                                 Digite: 1 o 2:""");        
            if ("1".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "A");
                
            } else if ("2".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "B");
                
            } else {
                JOptionPane.showMessageDialog(null, "Volviendo al menú de inicio");
                break;
            }      
            
            
        }
    }
}
