package Conjuntistas;

public class NodoArbol {

    private NodoArbol izquierdo;
    private NodoArbol derecho;
    private Comparable elemento;

    public NodoArbol(Comparable elem1, NodoArbol izq1, NodoArbol der1) {
        this.elemento = elem1;
        this.izquierdo = izq1;
        this.derecho = der1;
    }

    public NodoArbol(Comparable elemento) {
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoArbol() {
        this.elemento = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public void setDerecho(NodoArbol nodo) {
        this.derecho = nodo;
    }

    public void setIzquierdo(NodoArbol nodo) {
        this.izquierdo = nodo;
    }

    public void setElem(Comparable elemento) {
        this.elemento = elemento;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    public Comparable getElem() {
        return this.elemento;
    }
}
