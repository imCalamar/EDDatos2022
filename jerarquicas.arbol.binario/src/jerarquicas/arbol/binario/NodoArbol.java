package jerarquicas.arbol.binario;

public class NodoArbol {

    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    
    
     public NodoArbol(Object elem) {
        this.elemento = elem;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoArbol(Object nuevoElem, NodoArbol i, NodoArbol d) {
        this.elemento = nuevoElem;
        this.izquierdo = i;
        this.derecho = d;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    public void setElem(int n) {
        this.elemento = n;
    }

    public void setIzquierdo(NodoArbol j) {
        this.izquierdo = j;
    }

    public void setDerecho(NodoArbol m) {
        this.derecho = m;
    }
}
