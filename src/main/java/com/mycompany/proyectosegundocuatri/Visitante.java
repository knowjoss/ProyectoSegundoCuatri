/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

/**
 *
 * @author Josuni
 */
public class Visitante {
    
    private String nombre;
    private String cedula;
    private int totalPagado;
    

    public Visitante(String nombre, String cedula, int totalPagado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.totalPagado = totalPagado;
    }

    public String getNombre() {
        return nombre;
    }

   public String getCedula() {
        return cedula;
    }

    public int getTotalPagado() {
        return totalPagado;
    } 

    public String mostrarInfo() {
        return "Nombre: " + nombre + ", Cédula: " + cedula + ", Total pagado: ₡" + totalPagado;
    }

}       
