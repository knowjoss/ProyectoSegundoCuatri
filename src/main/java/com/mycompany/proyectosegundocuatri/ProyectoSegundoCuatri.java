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
                int menu_Visitante = Integer.parseInt (JOptionPane.showInputDialog(" --- menu de Visitante --- " + "1. Comprar boletos\n" + "2. Ver atracciones\n" + "3. Ver parqueo"));
                
                if (menu_Visitante == 1) {
                    Inicialmenu menu = new Inicialmenu();
                    menu.comprarEntradas();
                    break;
                    
                    
                }
          
               
            } else if (usuarios.getRol()==2) {
                String menu_Empleado = JOptionPane.showInputDialog(" --- menu de Visitante --- " + "1. Gestionar atracciones\n" + "2. Ver reportes\n" + "3. Gestionar parqueo");
  
            }
       } else {
            JOptionPane.showMessageDialog(null, "Opcion no valida. Deber elegir '1' o '2'.");
        }
    
            } else if ("2".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "Hasta pronto!");
                break;
                
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
            
        }
        
    }
}