/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila2022;

/**
 *
 * @author Joaquin.coder
 */
public class PilaEstatica {
    
    private Object[] arreglo;
    private int tope;
    private static final int TAM=20;
    
    public PilaEstatica(){
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
    public int obtenerTope(){
        //
        if(this.tope==-1){
            return -1;
        }else{
            return tope;
        }
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
    public PilaEstatica clonar(){
        PilaEstatica nuevaPila = new PilaEstatica();
        nuevaPila.arreglo=this.arreglo;
        return nuevaPila;
    }
    public String cadena(){
        String cad="";
        int i;
        for(i=0;i<=tope;i++){
            cad= Integer.toString((int) this.arreglo[i]);
            System.out.print(cad);
        }
        System.out.println("");
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
