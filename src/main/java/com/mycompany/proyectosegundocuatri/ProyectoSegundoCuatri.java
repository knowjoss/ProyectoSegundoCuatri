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
        
        Boletos sistemaBoletos = new Boletos();
        
        while (true) {
            opcion = JOptionPane.showInputDialog("""
                                                 === Bienvenidos a Fantasy ===
                                                 1. Entar a Fantasy. 
                                                 2. Salir de Fantasy.
                                                 Digite: 1 o 2:""");
            

            if ("1".equals(opcion)) {
                String seleccion = JOptionPane.showInputDialog("Por favor digite: \n" +
                                                               "'1' Si eres visitante.\n" +
                                                               "'2' Si eres Empleado.");
                
                
            
            if (seleccion == null) {
            JOptionPane.showMessageDialog(null, "Proceso cancelado por el usuario");
            return;
            }
        
        int opcionRol = Integer.parseInt(seleccion);
        Usuarios usuarios = null;
        
        if (opcionRol == 1) {
            usuarios = new Usuarios("Visitante", 1);
        } else if (opcionRol == 2) {
            usuarios = new Usuarios("Empleado", 2);
            
        }
        
        if (usuarios != null) {
            
            if (usuarios.getRol() == 1) {
                int menu_Visitante = Integer.parseInt (JOptionPane.showInputDialog(" --- Menú de Visitante --- \n" + 
                                                                                   "1. Comprar boletos.\n" + 
                                                                                   "2. Reporte.\n" + 
                                                                                   "3. Parqueo.\n" +
                                                                                   "4. Salir"));
                
                if (menu_Visitante == 1) {
                    sistemaBoletos.comprarEntradas();
                } 
                
                if (menu_Visitante == 2){
                    sistemaBoletos.mostrarReporte();

                } 
                
                if(menu_Visitante==3){
                    Parqueo parqueo=new Parqueo(); //Mover al apartado de Boletos para ligar al reporte de ventas 
                    parqueo.menuParqueo();
                    
                }
          
               
            } else if (usuarios.getRol()==2) {
                int menu_Empleado = Integer.parseInt (JOptionPane.showInputDialog("""
                                                                                  --- Menú de Empleado --- 
                                                                                  1. Gestionar atracciones
                                                                                  2. Ver reportes
                                                                                  3. Gestionar parqueo"""));
                
                if(menu_Empleado==1){
                    Atracciones atracciones= new Atracciones();
                    atracciones.menuAtracciones();
                }
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