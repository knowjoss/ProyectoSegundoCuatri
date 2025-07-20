/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.segundo_avance;

import javax.swing.JOptionPane;

/**
 *
 * @author willu
 */
public class Segundo_avance {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "--- Bienvenido al parque de diversiones Fantasy ---");
        String seleccion = JOptionPane.showInputDialog("Por favor, digita '1' si eres visitante o '2' si eres Empleado");
        
        
        if (seleccion == null) {
            JOptionPane.showMessageDialog(null, "Proceso cancelado por el usuario");
            return;
            
        }
        
        int opcionRol = Integer.parseInt(seleccion);
        Usuarios usuarios = null;
        
        if (opcionRol == 1) {
            usuarios = new Usuarios("Visitante", 1);
        } else if (opcionRol == 2) {
            usuarios = new Usuarios("Empleado",2);
            
        }
        
        if (usuarios != null) {
            
            JOptionPane.showMessageDialog(null, "Has ingresado como : " + usuarios.getNombre_rol() + " ("+ usuarios.getRol() + ")");
            if (usuarios.getRol() == 1) {
                String menu_Visitante = JOptionPane.showInputDialog(" --- menu de Visitante --- " + "1. Comprar boletos\n" + "2. Ver atracciones\n" + "3. Ver parqueo");
          
               
            } else if (usuarios.getRol()==2) {
                String menu_Empleado = JOptionPane.showInputDialog(" --- menu de Visitante --- " + "1. Gestionar atracciones\n" + "2. Ver reportes\n" + "3. Gestionar parqueo");
  
            }
       } else {
            JOptionPane.showMessageDialog(null, "Opcion no valida. Deber elegir '1' o '2'.");
        }
        
        
       
        
        
     
        
        
      
        
        
        
        
        
  
        
      
    }
}
