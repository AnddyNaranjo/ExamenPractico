package buscaminas.controlador;

// Importaciones necesarias
import buscaminas.modelo.Tablero;
import buscaminas.modelo.Casilla;
import buscaminas.vista.VistaConsola;
import java.util.Scanner;

public class JuegoBuscaminas {
    private Tablero tablero;
    private VistaConsola vista;
    private boolean juegoTerminado;
    private int casillasSegurasRestantes;

    /**
     * Constructor: inicializa tablero, vista y contador de casillas seguras.
     */    
    
    public JuegoBuscaminas() {
        tablero = new Tablero();
        vista = new VistaConsola();
        juegoTerminado = false;
        casillasSegurasRestantes = (tablero.getTamaño() * tablero.getTamaño()) - 10; // total sin minas
    }

    /**
     * Inicia el ciclo principal del juego.
     */
    
    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        vista.mostrarMensaje("=== Bienvenido al Buscaminas ===");
        while (!juegoTerminado) {
            vista.mostrarTablero(tablero);
            vista.mostrarMensaje("Ingrese coordenada (ej: A5) para descubrir la casilla o (ej: M A5) para marcar la casilla como mina");

            String entrada = sc.nextLine().trim().toUpperCase();

            try {
                boolean esMarcar = false;
                String coordenada;

                if (entrada.startsWith("M ")) {
                    esMarcar = true;
                    coordenada = entrada.substring(2);
                } else {
                    coordenada = entrada;
                }

                int fila = coordenada.charAt(0) - 'A';
                int col = Integer.parseInt(coordenada.substring(1)) - 1;

                if (fila < 0 || fila >= tablero.getTamaño() || col < 0 || col >= tablero.getTamaño()) {
                    vista.mostrarMensaje("Coordenada fuera de rango");
                    continue;
                }

                if (esMarcar) {
                    tablero.getCasilla(fila, col).setMarcada(true);
                } else {
                    descubrirCasilla(fila, col);
                }

                if (casillasSegurasRestantes == 0) {
                    vista.mostrarMensaje("¡Felicidades! Has ganado.");
                    juegoTerminado = true;
                }

            } catch (Exception e) {
                vista.mostrarMensaje("Entrada inválida. Ejemplo válido: A5 o M A5");
            }
        }

        vista.mostrarTablero(tablero);
        vista.mostrarMensaje("Juego finalizado.");
    }
    
    /**
     * Descubre la casilla indicada
     */

    private void descubrirCasilla(int fila, int col) {
        Casilla c = tablero.getCasilla(fila, col);

        if (c.isDescubierta()) {
            vista.mostrarMensaje("Esa casilla ya está descubierta.");
            return;
        }

        c.setDescubierta(true);

        if (c.isTieneMina()) {
            vista.mostrarMensaje("¡Boom! Has perdido.");
            juegoTerminado = true;
            // Revelar todas las minas
            for (int i = 0; i < tablero.getTamaño(); i++) {
                for (int j = 0; j < tablero.getTamaño(); j++) {
                    if (tablero.getCasilla(i, j).isTieneMina()) {
                        tablero.getCasilla(i, j).setDescubierta(true);
                    }
                }
            }
            return;
        }

        casillasSegurasRestantes--;

        // Descubrir recursivamente si no hay minas cercanas
        if (c.getMinasCercanas() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nf = fila + i;
                    int nc = col + j;
                    if (nf >= 0 && nf < tablero.getTamaño() && nc >= 0 && nc < tablero.getTamaño()) {
                        if (!tablero.getCasilla(nf, nc).isDescubierta()) {
                            descubrirCasilla(nf, nc);
                        }
                    }
                }
            }
        }
    }
}