package Conjuntistas;

import lineales.dinamicas.Lista;

public class ArbolBB {

    private NodoArbol raiz;
    
    public boolean eliminarMinimo(){
        boolean exito=true;
        if(!esVacio()){
            if(this.raiz.getIzquierdo()==null){
                this.raiz=this.raiz.getDerecho();
            }else{
            elMinAux(this.raiz, this.raiz.getIzquierdo());
        }
        }
        return exito;
    }
    private void elMinAux(NodoArbol n, NodoArbol r){
        while(r.getIzquierdo()!=null){
            n=r;
            r=r.getIzquierdo();
        }
        if(r.getDerecho()!=null){
            n.setIzquierdo(r.getDerecho());
        }else{
            n.setIzquierdo(null);
        }
    }
    public boolean esVacio(){
        return this.raiz==null;
    }
    public boolean eliminarMaximo(){
         boolean exito=true;
        if(!esVacio()){
            if(this.raiz.getIzquierdo()==null){
                this.raiz=this.raiz.getDerecho();
            }else{
            elMaxAux(this.raiz, this.raiz.getDerecho());
        }
        }
        return exito;
    }
    private void elMaxAux(NodoArbol n, NodoArbol r){
        while(r.getDerecho()!=null){
            n=r;
            r=r.getDerecho();
        }
        if(r.getIzquierdo()!=null){
            n.setDerecho(r.getIzquierdo());
        }else{
            n.setDerecho(null);
        }
    }
    public boolean insertar(Comparable e) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(e);
        } else {
            exito = insertarAux(this.raiz, e);
        }
        return exito;
    }
    
    private boolean insertarAux(NodoArbol n, Comparable e) {
        boolean exito = true;
        if ((n.getElem().compareTo(e)) == 0) {
            exito = false;
        } else {
            if ((n.getElem().compareTo(e)) > 0) {//si donde estoy parado es mayor que el elemento e voy a la izquierda
                if (n.getIzquierdo() != null) {
                    exito = insertarAux(n.getIzquierdo(), e);
                } else {
                    n.setIzquierdo(new NodoArbol(e));
                }
            } else {//si donde estoy es menor que el que busco voy a la derecha
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), e);
                } else {
                    n.setDerecho((new NodoArbol(e)));
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Comparable e) {
        boolean exito = true;
        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, e);
        } else {
            exito = false;
        }
        return exito;
    }

    private boolean perteneceAux(NodoArbol n, Comparable e) {
        boolean res = false;
        if (n != null) {
            if (n.getElem().compareTo(e) == 0) {
                res = true;
            } else {
                if (n.getElem().compareTo(e) > 0) {
                    res = perteneceAux(n.getIzquierdo(), e);
                }
                if (n.getElem().compareTo(e) < 0) {
                    res = perteneceAux(n.getDerecho(), e);
                }
            }
        }
        return res;
    }

    public boolean eliminar(Comparable e) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = eliminarAux(this.raiz, null, e);
        }
        return exito;
    }

    private boolean eliminarAux(NodoArbol n, NodoArbol r, Comparable e) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().compareTo(e) == 0) {
                int x = cantHijos(n);
                if (x == 2) {
                    casoTres(n);//dos hijos
                } else {
                    if (x == 1) {
                        casoDos(n, r);//un hijo
                    } else {
                        //casoUno  sin hijos
                        if(this.raiz.getElem().compareTo(n.getElem())==0){
                            this.raiz=null;
                        }else{
                            casoUno(n,r);
                        }
                    }
                }
                exito=true;
            } else {
                if (n.getElem().compareTo(e) > 0) {//si n es mayor a e me voy a la izquierda de n
                    eliminarAux(n.getIzquierdo(), n, e);
                } else {
                    eliminarAux(n.getDerecho(), n, e);// si n es menor a e me voy a la derecha de n
                }
            }
        }
        return exito;
    }
    
    private void casoUno(NodoArbol n, NodoArbol r){
        if(r.getDerecho().getElem().compareTo(n.getElem())==0){
            r.setDerecho(null);
        }else{
            r.setIzquierdo(null);
        }
    }

    private void casoDos(NodoArbol n, NodoArbol r) {
        if(this.raiz.getElem().compareTo(n.getElem())==0){
            if(n.getDerecho()!=null){
                this.raiz=n.getDerecho();
            }else{
                this.raiz=n.getIzquierdo();
            }
        }else{
            if(r.getDerecho().getElem().compareTo(n.getElem())==0){
                if(n.getDerecho()!=null){
                    r.setDerecho(n.getDerecho());
                }else{
                    r.setDerecho(n.getIzquierdo());
                }
            }else{
                if(n.getDerecho()!=null){
                    r.setIzquierdo(n.getDerecho());
                }else{
                    r.setIzquierdo(n.getIzquierdo());
                }
            }
        }
    }

    private void casoTres(NodoArbol n) {
        NodoArbol aux = n.getIzquierdo(), auxP = null;
        while (aux.getDerecho() != null) {
            auxP = aux;
            aux = aux.getDerecho();
        }
        n.setElem(aux.getElem());
        if (aux.getIzquierdo() != null) {
            auxP.setDerecho(aux.getIzquierdo());
        }else{
           auxP.setDerecho(null);
        }
    }

    private int cantHijos(NodoArbol n) {
        int x;
        if (n.getDerecho() != null && n.getIzquierdo() != null) {
            x = 2;
        } else {
            if ((n.getDerecho() != null) || (n.getIzquierdo() != null)) {
                x = 1;
            } else {
                x = 0;
            }
        }
        return x;
    }
    public boolean vaciar(){
        this.raiz=null;
        return true;
    }
    
    public Lista listar() {
        Lista l = new Lista();
        if (this.raiz != null) {
            listarAux(this.raiz, l);
        }
        return l;
    }

    private void listarAux(NodoArbol n, Lista l) {
        if (n != null) {
            listarAux(n.getIzquierdo(), l);
            l.insertar(n.getElem(), l.getLongitud() + 1);
            listarAux(n.getDerecho(), l);
        }
    }
    
    public Lista listarPorRango(Comparable min, Comparable max) {
        Lista l = new Lista();
        if (raiz != null) {
          listarRangoAux(min,max,this.raiz,  l);
        }
        return l;
    }

    private void listarRangoAux(Comparable min, Comparable max, NodoArbol n, Lista l) {
        if (n != null) {
            if (n.getElem().compareTo(min) >= 0) {
                listarRangoAux(min, max, n.getIzquierdo(), l);
            }
            if (n.getElem().compareTo(min) >= 0 && n.getElem().compareTo(max) <= 0) {
                l.insertar(n.getElem(), l.getLongitud() + 1);
            }
            if (n.getElem().compareTo(max) <= 0) {
                listarRangoAux(min, max, n.getDerecho(), l);
            }
        }
    }
    public Comparable minimoElem(){
        Comparable e=null;
        if(!esVacio()){
            if(this.raiz.getIzquierdo()!=null){
                e=minE(this.raiz);
            }else{
                e=this.raiz.getElem();
            }
        }
        return e;
    }
    
    private Comparable minE(NodoArbol n){
        while(n.getIzquierdo()!=null){
            n=n.getIzquierdo();
        }
        return n.getElem();
    }

    public Comparable maximoElem(){
        Comparable e=null;
        if(!esVacio()){
            if(this.raiz.getDerecho()!=null){
                e=maxE(this.raiz);
            }else{
                e=this.raiz.getElem();
            }
        }
        return e;
    }
    
    private Comparable maxE(NodoArbol n){
        while(n.getDerecho()!=null){
            n=n.getDerecho();
        }
        return n.getElem();
    }
    
    public String toString() {
        String s = "";
        if (this.raiz != null) {
            s = toStringAux(this.raiz);
        }
        return s;
    }

    private String toStringAux(NodoArbol n) {
        String s = "";
        if (n != null) {
            s = "" + n.getElem();
            if (n.getIzquierdo() != null) {
                s = s + "    HI:" + n.getIzquierdo().getElem();
            } else {
                s = s + "    HI --";
            }
            if (n.getDerecho() != null) {
                s = s + "    HD:" + n.getDerecho().getElem() + "\n";
            } else {
                s = s + "    HD --\n";
            }
            s = s + "" + toStringAux(n.getIzquierdo());
            s = s + "" + toStringAux(n.getDerecho());
        }
        return s;
    }
}