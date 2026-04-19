/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido activo en una mesa del restaurante.
 * Contiene la lista de productos solicitados con sus cantidades.
 * 
 * @author Katherin
 */
public class Pedido {

    private final List<ItemPedido> items = new ArrayList<>();
/**
     * Agrega un producto al pedido.
     * Si el producto ya existe en el pedido, incrementa su cantidad
     * en lugar de crear un nuevo ItemPedido.
     * 
     * @param producto Producto a agregar
     * @param cantidad Cantidad a agregar (debe ser positiva)
     */
    public void agregarItem(Producto producto, int cantidad) {
         // Buscar si el producto ya está en el pedido
        for (ItemPedido item : items) {
            if (item.getProducto().getNombre().equals(producto.getNombre())) {
                item.agregarCantidad(cantidad);
                return;
            }
        }
        items.add(new ItemPedido(producto, cantidad));
    }

     /**
     * Calcula el subtotal del pedido (suma de precio × cantidad de cada item).
     * 
     * @return Subtotal sin descuentos, IVA ni propina
     */
    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal = subtotal + item.calcularSubtotal();
        }
        return subtotal;
    }

    public int contarItemsDiferentes() {
        return items.size();
    }

      /**
     * Verifica si el pedido tiene al menos un producto.
     * 
     * @return true si hay productos, false si está vacío
     */
    public boolean tieneProductos() {
        return !items.isEmpty();
    }

    public List<ItemPedido> getItems() {
        return items;
    }

     /**
     * Elimina todos los items del pedido.
     * Se usa al generar una factura o al iniciar una nueva mesa.
     */
    public void limpiar() {
        items.clear();
    }
}

