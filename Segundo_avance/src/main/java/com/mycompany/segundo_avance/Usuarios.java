/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundo_avance;

/**
 *
 * @author willu
 */
public class Usuarios {
    
   private String nombre_rol;
   int rol;
   
   public Usuarios(String nombre_rol, int rol) {
       this.nombre_rol = nombre_rol;
       this.rol = rol;
   }
   public String getNombre_rol() {
       return nombre_rol;
   }
   public int getRol() {
       return rol;
 
   } 
}
