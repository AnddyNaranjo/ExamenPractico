package buscaminas.modelo;

import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private final int tamaño = 10;
    private final int minas = 10;

    public Tablero() {
        casillas = new Casilla[tamaño][tamaño];
        inicializarCasillas();
        colocarMinas();
        calcularNumeros();
    }

    private void inicializarCasillas() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random r = new Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int x = r.nextInt(tamaño);
            int y = r.nextInt(tamaño);
            if (!casillas[x][y].isTieneMina()) {
                casillas[x][y].setTieneMina(true);
                colocadas++;
            }
        }
    }

    private void calcularNumeros() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (!casillas[i][j].isTieneMina()) {
                    int contador = contarMinasCercanas(i, j);
                    casillas[i][j].setMinasCercanas(contador);
                }
            }
        }
    }

    private int contarMinasCercanas(int fila, int col) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nf = fila + i;
                int nc = col + j;
                if (nf >= 0 && nf < tamaño && nc >= 0 && nc < tamaño) {
                    if (casillas[nf][nc].isTieneMina()) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public Casilla getCasilla(int fila, int col) {
        return casillas[fila][col];
    }

    public int getTamaño() {
        return tamaño;
    }
}
