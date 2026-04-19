/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class ImpresionFactura {

    
    private static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    private static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    private static final String NIT = "900.123.456-7";
    private static final String SEPARADOR_LARGO = "========================================";
    private static final String SEPARADOR_CORTO = "----------------------------------------";
    private static final String FORMATO_ITEM = "%-20s x%-6d $%,.0f%n";
    private static final String FORMATO_LINEA = "%-27s $%,.0f%n";

      /**
     * Muestra la carta completa del restaurante con todos los productos.
     * Los productos se numeran automáticamente del 1 al N.
     */
    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_LARGO);
        int indice = 0;
        while (indice < Carta.cantidadProductos()) {
            Producto producto = Carta.buscarPorNumero(indice + 1);
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), producto.getNombre(), producto.getPrecio());
            indice++;
        }
        System.out.println(SEPARADOR_LARGO);
    }

      /**
     * Muestra el contenido actual del pedido (productos y cantidades).
     * 
     * @param pedido Pedido activo a mostrar
     */
    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--- PEDIDO ACTUAL ---");
        for (ItemPedido item : pedido.getItems()) {
            System.out.printf(FORMATO_ITEM,
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal());
        }
        System.out.println(SEPARADOR_CORTO);
        System.out.printf(FORMATO_LINEA, "Subtotal:", pedido.calcularSubtotal());
    }

     /**
     * Imprime el encabezado del restaurante (nombre, dirección, NIT).
     * Se reutiliza en facturas completas, resúmenes y carta.
     */
    public static void imprimirEncabezado() {
        System.out.println(SEPARADOR_LARGO);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    " + DIRECCION);
        System.out.println("    NIT: " + NIT);
        System.out.println(SEPARADOR_LARGO);
    }

    //  método único para imprimir totales — elimina duplicación entre completa y resumen
    private static void imprimirTotales(Factura factura) {
        double subtotalConDescuento = factura.calcularSubtotalConDescuento();
        double iva = factura.calcularIVA();
        double propina = factura.calcularPropina();
        double total = factura.calcularTotal();

        System.out.println(SEPARADOR_CORTO);
        System.out.printf(FORMATO_LINEA, "Subtotal:", subtotalConDescuento);
        System.out.printf(FORMATO_LINEA, "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", propina);
        }
        System.out.println(SEPARADOR_CORTO);
        System.out.printf(FORMATO_LINEA, "TOTAL:", total);
        System.out.println(SEPARADOR_LARGO);
    }
/**
     * Imprime una factura completa con detalle de todos los items.
     * Incluye: encabezado, número de factura, cada producto con su subtotal,
     * totales desglosados y mensaje de agradecimiento.
     * 
     */
    public static void imprimirFacturaCompleta(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println(SEPARADOR_CORTO);

        for (ItemPedido item : factura.getPedido().getItems()) {
            System.out.printf(FORMATO_ITEM,
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal());
        }

        imprimirTotales(factura);
        System.out.println("Gracias por su visita!");
        System.out.println(NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println(SEPARADOR_LARGO);
    }

    public static void imprimirFacturaResumen(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        imprimirTotales(factura);
    }
}
