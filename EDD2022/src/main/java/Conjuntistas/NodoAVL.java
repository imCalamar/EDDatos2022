/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjuntistas;

/**
 *
 * @author Joaquin.coder
 */
public class NodoAVL {
    private Comparable elem;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;
    
    public NodoAVL(Comparable elem1, NodoAVL izq1 ,NodoAVL der1){
        this.elem = elem1;
        this.izquierdo = izq1;
        this.derecho = der1;
        this.altura = 0;
    }
    public NodoAVL(Comparable elem1){
        this.elem = elem1;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 0;
    }
    public Comparable getElem(){
        return this.elem;
    }
    public int getAltura(){
        return this.altura;
    }
    public NodoAVL getIzq(){
        return this.izquierdo;
    }
    public NodoAVL getDer(){
        return this.derecho;
    }
    public void setAltura(int alt1){
        this.altura = alt1;
    }
    public void setElem(Comparable elem1 ){
        this.elem = elem1;
    }
    public void setIzq(NodoAVL izq1){
        this.izquierdo = izq1;
    }
    public void setDer(NodoAVL der1){
        this.derecho = der1;
    }
    public void actualizarAltura(){
        this.altura++;
    }
    public void recalcularAltura(){
       this.setAltura(Math.max(alturaAux(this.izquierdo), alturaAux(this.derecho))+1);
    }
     private int alturaAux(NodoAVL n){
        int res = -1;
        if( n != null){
            res = n.getAltura();
        }
        return res;
    }
}
