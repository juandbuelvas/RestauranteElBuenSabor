/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Katherin
 */
public class Mesa {

    private int numero;
    private boolean ocupada;

    public Mesa() {
        this.numero = 0;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }
  /**
     * Asigna un número a la mesa y la marca como ocupada.
     * 
     * @param numero Número de mesa a asignar (debe ser > 0)
     */
    public void asignarNumero(int numero) {
        this.numero = numero;
        this.ocupada = true;
    }

    public boolean estaOcupada() {
        return ocupada;
    }
  /**
     * Libera la mesa para el siguiente cliente.
     */
    public void liberar() {
        this.numero = 0;
        this.ocupada = false;
    }
}