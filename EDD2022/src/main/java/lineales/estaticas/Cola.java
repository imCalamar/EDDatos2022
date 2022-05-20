/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;
/**
 *
 *
 */
public class Cola {
    private Object [] cola;
    private int frente ;
    private int fin;
    private static  final int tam = 20 ;
    
    public Cola(){
    this.cola = new Object [tam];   
    this.fin = 0;
    this.frente = 0;
}
    public boolean esVacia(){
        return this.frente == this.fin;
    }
    public void vaciar(){
        this.frente = this.fin;
    }
    public Object obtenerFrente(){
        Object res;
        if(this.esVacia()){
            res = -1;
        }else{
            res = cola[this.frente];
        }
        return res;
    }
    public boolean sacar(){
        boolean res = true;
        if(this.esVacia()){
            // la cola esta vacia 
            res = false;
        }else{
            // al menos hay un elemento : avanza el frente (de manera circular)
            this.frente = (this.frente + 1) % this.tam;
        }
        return  res ;
    }
    public boolean poner(Object nElem){
        boolean res;
        if(this.frente == (this.fin + 1)%tam){
        // la cola esta llena
            res = false;
        }else{
            this.cola[fin] = nElem;
            this.fin= (this.fin + 1)% this.tam;
            res = true;
                    
        }
         return res;        
    }
     public String toString() {
        String res;
        int aux;

        res = "[";
        aux = frente;
        while (aux != fin) {
            res += cola[aux];
            aux = (aux + 1) % tam;
            if (aux != fin) {
                res += ", ";
            }
        }
        res += "]";

        return res;
    }
    public Cola clonar(){
        Cola clon = new Cola();
        clon.frente = this.frente;
        clon.fin = this.fin;
        clon.cola = this.cola.clone();
        return clon;
    }
    
}