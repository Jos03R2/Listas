package umg.edu.progra.listas;

public class Nodo {
    private int dato;
    private Nodo enlace;

    public Nodo(int x) {
        this.dato = x;
        this.enlace = null;
    }

    public Nodo(int x, Nodo n) {
        this.dato = x;
        this.enlace = n;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return dato + " -> " + (enlace != null ? enlace.getDato() : "null");
    }
}
