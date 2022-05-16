/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola2022;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

/**
 *
 * @author Joaquin.coder
 */
public class Cola2022 {
    
    static String sOk = "OK!", sErr = "ERROR";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("COMIENZO TEST PILA");
        Cola p1 = new Cola();
        System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());

//        System.out.print("Apila 1 espera TRUE y [1]:\t\t\t\t" + ((p1.poner(1)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 2 espera TRUE y [1,2]:\t\t\t\t" + ((p1.poner(2)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 3 espera TRUE y [1,2,3]:\t\t\t\t" + ((p1.poner(3)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 4 espera TRUE y [1,2,3,4]:\t\t\t" + ((p1.poner(4)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 5 espera TRUE y [1,2,3,4,5]:\t\t\t" + ((p1.poner(5)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 6 espera TRUE y [1,2,3,4,5,6]:\t\t\t" + ((p1.poner(6)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 7 espera TRUE y [1,2,3,4,5,6,7]:\t\t\t" + ((p1.poner(7)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 8 espera TRUE y [1,2,3,4,5,6,7,8]:\t\t" + ((p1.poner(8)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 9 espera TRUE y [1,2,3,4,5,6,7,8,9]:\t\t" + ((p1.poner(9)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 10 espera TRUE y [1,2,3,4,5,6,7,8,9,10]:\t\t" + ((p1.poner(10)) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 11 espera false en estatica true en dinamica:\t" + p1.poner(11));
//        System.out.println("\t--> " + p1.toString());
//    
//
//        System.out.print("Apila 2 espera TRUE y [1,2]:\t\t\t\t" + ((p1.poner("a")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 3 espera TRUE y [1,2,3]:\t\t\t\t" + ((p1.poner("b")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 4 espera TRUE y [1,2,3,4]:\t\t\t" + ((p1.poner("#")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 5 espera TRUE y [1,2,3,4,5]:\t\t\t" + ((p1.poner("c")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 6 espera TRUE y [1,2,3,4,5,6]:\t\t\t" + ((p1.poner("#")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 7 espera TRUE y [1,2,3,4,5,6,7]:\t\t\t" + ((p1.poner("e")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());
//        System.out.print("Apila 8 espera TRUE y [1,2,3,4,5,6,7,8]:\t\t" + ((p1.poner("d")) ? sOk : sErr));
//        System.out.println("\t--> " + p1.toString());


        System.out.print("Apila 2 espera TRUE y [1,2]:\t\t\t\t" + ((p1.poner("(")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 3 espera TRUE y [1,2,3]:\t\t\t\t" + ((p1.poner("8")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 4 espera TRUE y [1,2,3,4]:\t\t\t" + ((p1.poner("[")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 5 espera TRUE y [1,2,3,4,5]:\t\t\t" + ((p1.poner("c")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 6 espera TRUE y [1,2,3,4,5,6]:\t\t\t" + ((p1.poner("]")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 7 espera TRUE y [1,2,3,4,5,6,7]:\t\t\t" + ((p1.poner("e")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 8 espera TRUE y [1,2,3,4,5,6,7,8]:\t\t" + ((p1.poner(")")) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());

  
        Cola p2 = p1.clone();
        System.out.println("Copia espera 1,2,3,4,5,6,7,8,6: \t\t\t\t--> " + p2.toString());
        
        System.out.println("Obtener frente copia: \t\t\t\t--> " + p2.obtenerFrente());
        System.out.println("Obtener fin copia: \t\t\t\t--> " + p2.obtenerFin());
        
//        generar(p1);
        vb(p1);
    }
    public static void generar(Cola c1){
        Cola colaAux =new Cola();
        Cola colaFinal =new Cola();
        Pila pila =new Pila();
        
        if(!c1.esVacia()){
            while(!c1.esVacia()){
                while(c1.obtenerFrente()!="#" && !c1.esVacia()){

                    colaAux.poner(c1.obtenerFrente());
                    colaFinal.poner(c1.obtenerFrente());
                    pila.apilar(c1.obtenerFrente());
                    c1.sacar();
                }
                c1.sacar();
                while(!pila.esVacia()){
                    colaFinal.poner(pila.obtenerTope());
                    pila.desapilar();
                }
                while(!colaAux.esVacia()){
                    colaFinal.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                }
                if(!c1.esVacia()){
                    colaFinal.poner("#");
                }                   
            }
        }
        System.out.println(colaFinal.toString());
    }
    
    public static void vb(Cola c1){
        Pila pila = new Pila();
        boolean exito=true;
        while(!c1.esVacia() && exito){
            if (c1.obtenerFrente()=="("||c1.obtenerFrente()=="["||c1.obtenerFrente()=="{") {
                pila.apilar(c1.obtenerFrente());
            }else{
                if(c1.obtenerFrente()==")" && pila.obtenerTope()!="("){
                    exito=false;System.out.println("( "+exito);
                }else{
                    if(c1.obtenerFrente()=="]" && pila.obtenerTope()!="["){
                        System.out.println("[ "+exito);
                    exito=false;
                    }else{
                        if(c1.obtenerFrente()=="}" && pila.obtenerTope()!="{"){
                    exito=false;
                        }else{
                            if((c1.obtenerFrente()==")" && pila.obtenerTope()=="(") ||
                                    (c1.obtenerFrente()=="]" && pila.obtenerTope()=="[") ||
                                    (c1.obtenerFrente()=="}" && pila.obtenerTope()=="{")){
                                
                                pila.desapilar();
                                
                            }
                        }
                    }
                }
            }
            c1.sacar();
        }
        System.out.println(exito);
    }
    
    public static void vb2(Cola c1){
        Pila pila = new Pila();
        boolean exito=true;
        while(!c1.esVacia() && exito){
            if (c1.obtenerFrente()=="("||c1.obtenerFrente()=="["||c1.obtenerFrente()=="{") {
                pila.apilar(c1.obtenerFrente());
            }else{
                if((c1.obtenerFrente()==")" && pila.obtenerTope()!="(") ||
                        (c1.obtenerFrente()=="]" && pila.obtenerTope()!="[") ||
                        (c1.obtenerFrente()=="}" && pila.obtenerTope()!="{")){
                    exito=false;
                }else{
                    if((c1.obtenerFrente()==")" && pila.obtenerTope()=="(") ||
                            (c1.obtenerFrente()=="]" && pila.obtenerTope()=="[") ||
                            (c1.obtenerFrente()=="}" && pila.obtenerTope()=="{")){
                        pila.desapilar();
                    }
                }
            }
            c1.sacar();
        }
        
    }
}
