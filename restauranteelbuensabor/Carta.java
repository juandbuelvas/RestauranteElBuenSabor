/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Katherin
 */
public class Carta {

    private static final List<Producto> productos = new ArrayList<>();

    static {
        productos.add(new Producto("Bandeja Paisa", 32000));
        productos.add(new Producto("Sancocho de Gallina", 28000));
        productos.add(new Producto("Arepa con Huevo", 8000));
        productos.add(new Producto("Jugo Natural", 7000));
        productos.add(new Producto("Gaseosa", 4500));
        productos.add(new Producto("Cerveza Poker", 6000));
        productos.add(new Producto("Agua Panela", 3500));
        productos.add(new Producto("Arroz con Pollo", 25000));
    }
  /**
     * Retorna una copia de la lista de productos.
     * Modificaciones externas no afectan la carta original.
     * 
     * @return Nueva lista con todos los productos
     */
    public static List<Producto> getProductos() {
        return productos;
    }

    public static int cantidadProductos() {
        return productos.size();
    }
/**
     * Busca un producto por su número de orden en la carta (1-indexado).
     * 
     * @param numero Número del producto (1 = primer producto)
     * @return Producto encontrado, o null si el número es inválido
     */
    public static Producto buscarPorNumero(int numero) {
        int indice = numero - 1;
        if (indice >= 0 && indice < productos.size()) {
            return productos.get(indice);
        }
        return null;
    }
}