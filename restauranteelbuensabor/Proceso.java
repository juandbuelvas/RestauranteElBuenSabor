/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Katherin
 */
public class Proceso {

    private int proximoNumeroFactura = 1;
    /**
     * Genera una nueva factura para el pedido especificado.
     * El número de factura se incrementa automáticamente con cada generación.
     * 
     * @param pedido Pedido con los items consumidos por el cliente
     * @return Factura generada con su número único
     */
    public Factura generarFactura(Pedido pedido) {
        Factura factura = new Factura(pedido, proximoNumeroFactura);
        proximoNumeroFactura = proximoNumeroFactura + 1;
        return factura;
    }
}
