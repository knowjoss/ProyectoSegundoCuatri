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
        Atracciones atracciones = new Atracciones(); 
        Parqueo parqueo = new Parqueo(); 

        while (true) {
            opcion = JOptionPane.showInputDialog("""
                ⭐ ¡Bienvenidos a Fantasy, el mejor parque de diversiones! ⭐
                ⭐ Estamos encantados de tenerte aquí. ⭐
                ⭐ ¿Qué deseas hacer hoy? ⭐
                1. Entrar a Fantasy.
                2. Salir de Fantasy.
                Digite: 1 o 2:""");

            if (opcion == null || "2".equals(opcion)) {
                JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
                return; // Sale del programa
            }

            if ("1".equals(opcion)) {
                String seleccion = JOptionPane.showInputDialog("Por favor digite: \n" +
                                                              "'1' Si eres visitante.\n" +
                                                              "'2' Si eres empleado.");

                if (seleccion == null) {
                    continue; // Regresa al menú de bienvenida, para que no se devuelva hasta el menu de bienvenida
                }

                if ("1".equals(seleccion)) {
                    
                    while (true) {
                        String menuVisitanteStr = JOptionPane.showInputDialog("--- Menú de Visitante ---\n" +
                                                                             "1. Comprar boletos.\n" +
                                                                             "2. Recibo.\n" + //Se podria añadir como para que el usuario vea lo que compro
                                                                             "3. Parqueo.\n" +
                                                                             "4. Salir");
                        
                        if (menuVisitanteStr == null || "4".equals(menuVisitanteStr)) {
                            break; 
                        }

                        
                        switch (menuVisitanteStr) {
                            case "1":
                                sistemaBoletos.comprarEntradas();
                                break;
                            case "2":
                                sistemaBoletos.mostrarReporte();
                                break;
                            case "3":
                                parqueo.menuParqueo();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                                break;
                        }
                    }
                } else if ("2".equals(seleccion)) {
                  
                    while (true) {
                        String menuEmpleadoStr = JOptionPane.showInputDialog("""
                            --- Menú de Empleado --- 
                            1. Gestionar atracciones
                            2. Ver reportes
                            3. Gestionar parqueo 
                            4. Salir
                            """);
                       
                            
                        if (menuEmpleadoStr == null || "4".equals(menuEmpleadoStr)) {
                            break; 
                        }

                        
                        switch (menuEmpleadoStr) {
                            case "1":
                                atracciones.menuAtracciones();
                                break;
                            case "2":
                                sistemaBoletos.mostrarReporte();
                                break;
                            case "3":
                                parqueo.menuParqueo();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                                break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Debe elegir '1' o '2'.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        }
    }
}