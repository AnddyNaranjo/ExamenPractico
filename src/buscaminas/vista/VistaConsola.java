package buscaminas.vista;

import buscaminas.modelo.Tablero;
import buscaminas.modelo.Casilla;

public class VistaConsola {

    public void mostrarTablero(Tablero tablero) {
        int tamaño = tablero.getTamaño();

        // Encabezado columnas
        System.out.print("   ");
        for (int i = 1; i <= tamaño; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Filas con letras
        for (int i = 0; i < tamaño; i++) {
            char letraFila = (char) ('A' + i);
            System.out.print(letraFila + "  ");
            for (int j = 0; j < tamaño; j++) {
                Casilla c = tablero.getCasilla(i, j);
                if (c.isDescubierta()) {
                    if (c.isTieneMina()) {
                        System.out.print("X ");
                    } else if (c.getMinasCercanas() > 0) {
                        System.out.print(c.getMinasCercanas() + " ");
                    } else {
                        System.out.print("V ");
                    }
                } else if (c.isMarcada()) {
                    System.out.print("F "); // F = bandera
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
