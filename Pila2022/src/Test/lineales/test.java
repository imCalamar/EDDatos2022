/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Utiles.TecladoIn;
import dinamica.Pila;
//import estatica.Pila;

/**
 *
 * @author Joaquin.coder
 */
public class test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 

        Pila pila=new Pila();
        cargarPila(pila);
        tarea(pila);        
    }
    public static void tarea(Pila pila){
        //
        int seg;
        Object s;
        do{
            
            switch(seg=menu()){ 
                case 1:
                    System.out.println("ingrese valor a apilar");
                    s=TecladoIn.readLine();
                    pila.apilar(s);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    System.out.println("tope de la pila: "+ pila.obtenerTope());
                    break;
                case 4:
                    System.out.println(pila.esVacia());
                    break;
                case 5:
                    pila.vaciar();
                    break;
                case 6:
                    System.out.println("clon: "+pila.clonarPila());
                    break;
                case 7:
                    System.out.println("cadena de la pila: "+pila.toString());
                    break;
                default:  
                    break;
            }
        }while(seg!=-1);
    }
    
    public static void cargarPila(Pila pila){
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
            
            seguir = "S".equals(res);
            
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