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
        //OBJETOS PRINCIPALES
        Atracciones atracciones = new Atracciones(); 
        Boletos sistemaBoletos = new Boletos(atracciones);
        Parqueo parqueo = new Parqueo(); 

        //MENU PRINCIPAL
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
            
             //SELECCION DE TIPO DE USUARIO
            if ("1".equals(opcion)) {
                String seleccion = JOptionPane.showInputDialog("Por favor digite: \n" +
                                                              "'1' Si eres visitante.\n" +
                                                              "'2' Si eres empleado.");

                if (seleccion == null) {
                    continue; 
                }

                if ("1".equals(seleccion)) {
                    
                    while (true) {
                        String menuVisitante = JOptionPane.showInputDialog("--- Menú de Visitante ---\n" +
                                                                             "1. Comprar boletos.\n" +
                                                                             "2. Ir a las Atracciones.\n" + 
                                                                             "3. Parqueo.\n" +
                                                                             "4.Salir");
                        
                        if (menuVisitante == null || "4".equals(menuVisitante)) {
                            break; 
                        }

                        
                        switch (menuVisitante) {
                            case "1":
                                sistemaBoletos.comprarEntradas();
                                break;
                            case "2":
                                sistemaBoletos.irAtracciones();
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
                        String menuEmpleado = JOptionPane.showInputDialog("""
                            --- Menú de Empleado --- 
                            1. Gestionar atracciones
                            2. Ver reportes
                            3. Gestionar parqueo 
                            4. Mostrar Reporte de Usuarios
                            5.Salir
                            """);
                       
                            
                        if (menuEmpleado == null || "5".equals(menuEmpleado)) {
                            break; 
                        }

                        
                        switch (menuEmpleado) {
                            case "1":
                                atracciones.menuAtracciones();
                                break;
                            case "2":
                                sistemaBoletos.mostrarReporte();
                                break;
                            case "3":
                                parqueo.menuParqueo();
                                break;
                            case "4":
                                sistemaBoletos.mostrarReporteUsuarios();
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