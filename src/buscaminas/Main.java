package buscaminas;

import buscaminas.controlador.JuegoBuscaminas;

/**
Inicializa el controlador y arranca el juego.
*/

public class Main {
	/**
     * Método principal que ejecuta el juego.
     */
    public static void main(String[] args) {
        JuegoBuscaminas juego = new JuegoBuscaminas();
        juego.iniciar();
    }
}
