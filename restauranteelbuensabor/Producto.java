/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Katherin
 */
public class Producto {

     /** Nombre descriptivo del producto */
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    
     /**
     * Retorna el nombre del producto.
     * 
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Retorna el precio del producto en pesos colombianos.
     * 
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }
}
