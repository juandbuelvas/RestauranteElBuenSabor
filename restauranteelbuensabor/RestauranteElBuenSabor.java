/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Mesa mesa = new Mesa();
    private static final Pedido pedido = new Pedido();
    private static final Proceso servicioFacturacion = new Proceso();

   public static void main(String[] args) {
      ImpresionFactura.imprimirEncabezado(); 
    ejecutarMenuPrincipal();
    scanner.close();
}

    private static void ejecutarMenuPrincipal() {
        boolean continuar = true;
        while (continuar) {
            mostrarOpcionesMenu();
            int opcionMenu = scanner.nextInt();
            continuar = procesarOpcion(opcionMenu);
        }
    }
  /**
     * Muestra las opciones disponibles en el menú principal.
     */
    private static void mostrarOpcionesMenu() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static boolean procesarOpcion(int opcionMenu) {
        if (opcionMenu == 1) {
            ImpresionFactura.mostrarCarta();
        } else if (opcionMenu == 2) {
            procesarAgregarProducto();
        } else if (opcionMenu == 3) {
            procesarVerPedido();
        } else if (opcionMenu == 4) {
            procesarGenerarFactura();
        } else if (opcionMenu == 5) {
            procesarNuevaMesa();
        } else if (opcionMenu == 0) {
            System.out.println("Hasta luego!");
            return false;
        } else {
            System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
        }
        System.out.println();
        return true;
    }
/**
     * Procesa la opción 2: Agregar un producto al pedido.
     * Solicita número de producto y cantidad, valida la entrada,
     * asigna una mesa si es necesario, y agrega el item al pedido.
     */
    private static void procesarAgregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Carta.cantidadProductos() + "): ");
        int numeroProducto = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        
        
    // Validar que el producto exista
        Producto producto = Carta.buscarPorNumero(numeroProducto);
        if (producto == null) {
            System.out.println("Producto no existe. La carta tiene " + Carta.cantidadProductos() + " productos.");
            return;
        }
        // Validar que la cantidad sea positiva
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser un valor positivo.");
            return;
        }

        if (!mesa.estaOcupada()) {
            asignarMesa();
        }

        pedido.agregarItem(producto, cantidad);
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
    }
    /**
     * Asigna un número de mesa al cliente actual.
     * Si el número ingresado es inválido (<= 0), se asigna la mesa 1 por defecto.
     */
    private static void asignarMesa() {
        System.out.print("Ingrese numero de mesa: ");
        int numeroMesa = scanner.nextInt();
        if (numeroMesa <= 0) {
            numeroMesa = 1;
        }
        mesa.asignarNumero(numeroMesa);
    }

    private static void procesarVerPedido() {
        if (pedido.tieneProductos()) {
            ImpresionFactura.mostrarPedido(pedido);
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
    }

    private static void procesarGenerarFactura() {
        if (!pedido.tieneProductos()) {
            System.out.println("No se puede generar factura.");
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
            return;
        }
        Factura factura = servicioFacturacion.generarFactura(pedido);
        ImpresionFactura.imprimirFacturaCompleta(factura);
        pedido.limpiar();
        mesa.liberar();
    }

    private static void procesarNuevaMesa() {
        pedido.limpiar();
        mesa.liberar();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
    }
}

