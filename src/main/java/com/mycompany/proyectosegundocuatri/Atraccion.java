/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosegundocuatri;

/**
 *
 * @author Yeremy
 */
public class Atraccion {
    private String nombre;
    private String descripcion;
    private int contadorSubidas;

    public Atraccion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contadorSubidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void incrementarSubida() {
        contadorSubidas++;
    }

    public int getContadorSubidas() {
        return contadorSubidas;
    }   
    
}
