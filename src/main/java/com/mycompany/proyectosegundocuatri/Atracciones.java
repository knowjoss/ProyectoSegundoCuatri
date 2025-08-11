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
public class Atracciones {
    

    private Atraccion[] lista;
    private int contador;
    

    public Atracciones() {
        lista = new Atraccion[20]; 
        contador = 0;
        cargarAtraccionesIniciales();
    }

    private void cargarAtraccionesIniciales() {
        agregarNuevaAtraccion("Montaña Rusa", "Una intensa aventura llena de velocidad y curvas.");
        agregarNuevaAtraccion("Noria", "Gran rueda panorámica con vista de todo el parque.");
        agregarNuevaAtraccion("Autos de Choque", "Diversión para todas las edades en autos eléctricos.");
        agregarNuevaAtraccion("Casa Embrujada", "Atracción espeluznante para los más valientes.");
        agregarNuevaAtraccion("Tiovivo", "Clásico carrusel con caballos y música.");
        agregarNuevaAtraccion("Splash", "Montaña acuática con un gran chapuzón final.");
        agregarNuevaAtraccion("Barco Pirata", "Gran barco que se balancea como una ola gigante.");
        agregarNuevaAtraccion("Kamikaze", "Adrenalina pura, giro completo en el aire.");
        agregarNuevaAtraccion("Sillas Voladoras", "Sillas giratorias que suben y vuelan.");
        agregarNuevaAtraccion("Tren Fantasma", "Paseo oscuro con sustos sorpresa.");
    }

    private void agregarNuevaAtraccion(String nombre, String descripcion) {
        if (contador < lista.length) {
            lista[contador] = new Atraccion(nombre, descripcion);
            contador++;
        }
    }

    public void agregarAtraccion() {
        if (contador >= lista.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más atracciones.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la atracción:");
        String descripcion = JOptionPane.showInputDialog("Ingrese una descripción:");

        lista[contador] = new Atraccion(nombre, descripcion);
        contador++;
        JOptionPane.showMessageDialog(null, "Atracción agregada correctamente.");
    }

    public void listarAtracciones() {
        String mensaje = "Lista de atracciones:\n";
       

        for (int i = 0; i < contador; i++) {
            mensaje += (i + 1) + ". " + lista[i].getNombre() + " - " + lista[i].getDescripcion() + "\n";
            
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void buscarAtraccion() {
        String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre a buscar:");
        boolean encontrada = false;

        for (int i = 0; i < contador; i++) {
            if (lista[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
                JOptionPane.showMessageDialog(null,
                        "Atracción encontrada:\nNombre: " + lista[i].getNombre() +
                        "\nDescripción: " + lista[i].getDescripcion());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Atracción no encontrada.");
        }
    }

    public void editarAtraccion() {
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la atracción a editar:");
        boolean encontrada = false;

        for (int i = 0; i < contador; i++) {
            if (lista[i].getNombre().equalsIgnoreCase(nombreEditar)) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", lista[i].getNombre());
                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción:", lista[i].getDescripcion());
                lista[i].setNombre(nuevoNombre);
                lista[i].setDescripcion(nuevaDescripcion);
                JOptionPane.showMessageDialog(null, "Atracción editada correctamente.");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Atracción no encontrada.");
        }
    }

    public void eliminarAtraccion() {
        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la atracción a eliminar:");
        boolean eliminada = false;

        for (int i = 0; i < contador; i++) {
            if (lista[i].getNombre().equalsIgnoreCase(nombreEliminar)) {
                for (int j = i; j < contador - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[contador - 1] = null;
                contador--;
                JOptionPane.showMessageDialog(null, "Atracción eliminada correctamente.");
                eliminada = true;
                break;
            }
        }

        if (!eliminada) {
            JOptionPane.showMessageDialog(null, "Atracción no encontrada.");
        }
    }
    public void menuAtracciones(){
        Atracciones atracciones=new Atracciones();
        while (true) {
            String menu2 = "MENÚ Atracciones:\n"
                        + "1. Agregar atraccion\n"
                        + "2. Listar atracciones\n"
                        + "3. Buscar atraccion\n"
                        + "4. Editar atraccion\n"
                        + "5. Eliminar atraccion\n"
                        + "6. Salir";
            
            String opcion = JOptionPane.showInputDialog(menu2);

            switch (opcion) {
                case "1":
                    atracciones.agregarAtraccion();
                    break;
                case "2":
                    atracciones.listarAtracciones();
                    break;
                case "3":
                    atracciones.buscarAtraccion();
                    break;
                case "4":
                    atracciones.editarAtraccion();
                    break;
                case "5":
                     atracciones.eliminarAtraccion();
                     break; 
                case "6":
                    JOptionPane.showMessageDialog(null,"Saliendo del sistema");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } 
    }
    
    public void menuVisitante() {
        while (true) {
            String menu = "MENÚ Visitas:\n"
                        + "1. Subirse a una atracción\n"
                        + "2. Salir";
            String opcion = JOptionPane.showInputDialog(menu);

            switch (opcion) {
                case "1":
                    subirseAtraccion();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Gracias por su visita!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
    public void subirseAtraccion() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay atracciones disponibles.");
            return;
        }

        String mensaje = "Seleccione una atracción para subirse:\n";
        for (int i = 0; i < contador; i++) {
            mensaje += (i + 1) + ". " + lista[i].getNombre() + "\n";
        }

        String entrada = JOptionPane.showInputDialog(mensaje);

        if (entrada == null || entrada.equals("")) {
            JOptionPane.showMessageDialog(null, "Opción inválida.");
            return;
        }

        int opcion = 0;

        for (int i = 1; i <= contador; i++) {
            String numeroOpcion = "" + i;
            if (entrada.equals(numeroOpcion)) {
                opcion = i;
                break;
            }
        }

        if (opcion > 0) {
            lista[opcion - 1].incrementarSubida();
            JOptionPane.showMessageDialog(null, "Te subiste a: " + lista[opcion - 1].getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "Número inválido.");
        }

    }
    
}