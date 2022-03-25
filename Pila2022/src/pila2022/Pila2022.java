/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila2022;

import Utiles.TecladoIn;

/**
 *
 * @author Joaquin.coder
 */
public class Pila2022 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        int cant;
        String res;
        PilaEstatica arrPila=new PilaEstatica();
        PilaInt pila=new PilaInt();
        
        System.out.println("¿estatica(E) o dinamica(D)?");
        res=TecladoIn.readLine();
        if (res=="E") {
            System.out.println("¿cuantos valores desea ingresar a la pila?");
            cant=TecladoIn.readLineInt();
            cargarPila(arrPila,cant);
            tareaPilaEtatica(arrPila); 
        }else{
            cargarPila(pila);
            tareaPilaDinamica(pila);
        }          
    }
    public static void tareaPilaEtatica(PilaEstatica arrPila){
        //
        int seg;
        do{
            int s;
            switch(seg=menu()){ 
                case 1:
                    System.out.println("ingrese valor a apilar");
                    s=TecladoIn.readLineInt();
                    arrPila.apilar(s);
                    break;
                case 2:
                    arrPila.desapilar();
                    break;
                case 3:
                    arrPila.obtenerTope();
                    break;
                case 4:
                    System.out.println(arrPila.esVacia());
                    break;
                case 5:
                    arrPila.vaciar();
                    break;
                case 6:
                    arrPila.clonar();
                    break;
                case 7:
                    arrPila.cadena();
                    break;
                case 8:
                    System.out.println(arrPila.capicua());
                default:  
                    break;
            }
        }while(seg!=-1);
    }
    
    public static void tareaPilaDinamica(PilaInt pila){
        //
        int seg;
        do{
            int s;
            switch(seg=menu()){ 
                case 1:
                    System.out.println("ingrese valor a apilar");
                    s=TecladoIn.readLineInt();
                    pila.apilar(s);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    pila.obtenerTope();
                    break;
                case 4:
                    System.out.println(pila.esVacia());
                    break;
                case 5:
                    pila.vaciar();
                    break;
                case 6:
                    pila.clonarPila();
                    break;
                case 7:
                    pila.toString();
                    break;
                default:  
                    break;
            }
        }while(seg!=-1);
    }
    
    public static void cargarPila(PilaEstatica arrPila, int cant){
        //
        int i,v;
        System.out.println("ingrese las valores");
        for(i=0;i<=cant-1;i++){
            System.out.print("|");
            v=TecladoIn.readLineInt();
            arrPila.apilar(v);
        }
    }
    public static void cargarPila(PilaInt pila){
        //
        int valor;
        String res;
        boolean seguir;
        do {
            System.out.println("ingrese las valor");
            valor=TecladoIn.readLineInt();
            pila.apilar(valor);
            System.out.println("desea ingresar mas valores? S/N");
            res=TecladoIn.readLine();
            if (res=="S") {
               seguir=true; 
            }else{
                seguir=false;
            }
        } while (seguir==true);
        
    }
    public static int menu(){
        int v;
        System.out.println("1 para apilar / "
                + "2 para desapilar / "
                + "3 para obtener tope / "
                + "4 para ver si es vacia / "
                + "5 para vaciar la pila / "
                + "6 para clonar la pila / "
                + "7 para mostar  cadena / "
                + "8 para ver si es capicua / "
                + "-1 para salir ");
        v=TecladoIn.readLineInt();
        return v;
    }  
}