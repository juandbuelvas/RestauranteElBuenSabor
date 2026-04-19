/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Katherin
 */

public class Factura {

    // : constantes con nombre para todos los magic numbers
    private static final double TASA_IVA = 0.19;
    private static final double TASA_PROPINA = 0.10;
    private static final double TASA_DESCUENTO = 0.05;
    private static final double UMBRAL_PROPINA = 50000;
    private static final int MIN_ITEMS_DESCUENTO = 3;

    private final Pedido pedido;
    private final int numero;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento(double subtotal) {
        if (pedido.contarItemsDiferentes() > MIN_ITEMS_DESCUENTO) {
            return subtotal * TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        double subtotal = calcularSubtotal();
        return subtotal - calcularDescuento(subtotal);
    }

    // El IVA se calcula sobre el subtotal ya descontado, según DIAN
    public double calcularIVA() {
        return calcularSubtotalConDescuento() * TASA_IVA;
    }

    // La propina aplica sobre el subtotal con descuento, antes del IVA
    public double calcularPropina() {
    double base = calcularSubtotalConDescuento() + calcularIVA();
    if (calcularSubtotalConDescuento() > UMBRAL_PROPINA) {
        return base * TASA_PROPINA;
    }
    return 0;
}

    public double calcularTotal() {
    double subtotalConDescuento = calcularSubtotalConDescuento();
    double iva = calcularIVA();
    double propina = calcularPropina();
    return subtotalConDescuento + iva + propina;
}
}
