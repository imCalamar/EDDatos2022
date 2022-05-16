package jerarquicas.dinamicas;

public class NodoGen {
    //Clase que se usa en ArbolGen
    //Object es la super clase o la clase de donde derivan todas
    //las clases creadas por los programadores

    private Object elem;
    private NodoGen hijoExtremoIzq;
    private NodoGen hermanoDer;

    public NodoGen(Object e) {
        elem = e;
    }

    public NodoGen(Object e, NodoGen hei, NodoGen hd) {
        elem = e;
        hijoExtremoIzq = hei;
        hermanoDer = hd;
    }

    public NodoGen getHijoIzquierdo() {
        return hijoExtremoIzq;
    }

    public NodoGen getHermanoDerecho() {
        return hermanoDer;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object e) {
        elem = e;
    }

    public void setHermanoDerecho(NodoGen hd) {
        hermanoDer = hd;
    }

    public void setHijoIzquierdo(NodoGen hei) {
        hijoExtremoIzq = hei;
    }
}
