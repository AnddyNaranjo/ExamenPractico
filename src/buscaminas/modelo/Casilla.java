package buscaminas.modelo;

public class Casilla {
    private boolean tieneMina;
    private int minasCercanas;
    private boolean descubierta;
    private boolean marcada;

    public Casilla() {
        this.tieneMina = false;
        this.minasCercanas = 0;
        this.descubierta = false;
        this.marcada = false;
    }

    public boolean isTieneMina() { return tieneMina; }
    public void setTieneMina(boolean tieneMina) { this.tieneMina = tieneMina; }

    public int getMinasCercanas() { return minasCercanas; }
    public void setMinasCercanas(int minasCercanas) { this.minasCercanas = minasCercanas; }

    public boolean isDescubierta() { return descubierta; }
    public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }

    public boolean isMarcada() { return marcada; }
    public void setMarcada(boolean marcada) { this.marcada = marcada; }
}
