/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Joaquin.coder
 */
public class Pila {
    
    private Object[] arreglo;
    private int tope;
    private static final int TAM=10;
    
    public Pila(){
        this.arreglo=new Object[TAM];
        this.tope=-1;
    }
    public boolean apilar(Object nuevoElemento){
        //
        boolean res;
        if(this.tope+1>=TAM){
            res=false;
        }else{
            tope++;
            arreglo[tope]=nuevoElemento;
            res=true;
        }
        return res;
    }
    public boolean desapilar(){
        //
        boolean res;
        if(this.tope==-1){
            res=false;
        }else{
            tope--;
            res=true;
        }
        return res;
    }
    public Object obtenerTope(){
        Object res;
        if(this.tope==-1){
            res=null;
        }else{
            res=this.arreglo[tope];
        }
        return res;
    }
    public boolean esVacia(){
        //
        boolean res=false;
        if(this.tope==-1){
            res=true;
        }
        return res;
    }
    public void vaciar(){
        this.tope=-1;
    }
    public Pila clone(){
        Pila nuevaPila = new Pila();
        int i;
        for(i=0;i<=tope;i++){
            nuevaPila.apilar(this.arreglo[i]);
        }
        return nuevaPila;
    }
        public String toString(){
        String cad="[";
        for(int i=0;i<=tope;i++){
            cad= cad+""+this.arreglo[i].toString()+",";
        }
        cad= cad+"]";
        return cad;
    }
    public boolean capicua(){
        //
        int i,j;
        boolean res=true;
        Object[] nuevoArr=this.arreglo.clone();
        i=0; j=this.tope;
        while(res==true && i<=this.tope/2 && j>=0){
            if(nuevoArr[j]==arreglo[i]){
                i++;
                j--;
            }else{
                res=false;
            }
        }
        return res;
    } 
}
