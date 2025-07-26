/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

import javax.swing.JOptionPane;

/**
 *
 * @author Yeremy
 */
public class Parqueo {
    private Vehiculo[] espacios;

    
    public Parqueo() {
        espacios = new Vehiculo[30]; 
        
        /* Reduge la cantidad de parqueos a 30, 
        ya que en 100 no se ve los espacios disponibles completos
        */
        
    }

    
    public void registrarVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        Vehiculo nuevo = new Vehiculo(placa, modelo);

        boolean registrado = false;
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i] == null) {
                espacios[i] = nuevo;
                JOptionPane.showMessageDialog(null,
                    "Vehículo registrado en el espacio #" + (i + 1) +
                    "\nPlaca: " + nuevo.getPlaca() +
                    "\nModelo: " + nuevo.getModelo());
                registrado = true;
                break;
            }
        }

        if (!registrado) {
            JOptionPane.showMessageDialog(null, "No hay espacios disponibles.");
        }
    }

    
    public void verEspaciosDisponibles() {
        String mensaje = "Espacios disponibles:\n";
        boolean hayEspacios = false;

        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i] == null) {
                mensaje += "Espacio #" + (i + 1) + " está libre\n";
                hayEspacios = true;
            }
        }

        if (!hayEspacios) {
            mensaje += "No hay espacios disponibles.";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
     
    public void menuParqueo(){
        Parqueo parqueo=new Parqueo();
        while (true) {
            
            String menu = "Menú de Parqueo:\n"
                        + "1. Registrar vehículo\n"
                        + "2. Ver espacios disponibles\n"
                        + "3. Salir";
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    parqueo.registrarVehiculo();
                    break;
                case 2:
                    parqueo.verEspaciosDisponibles();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;  
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
    
}
