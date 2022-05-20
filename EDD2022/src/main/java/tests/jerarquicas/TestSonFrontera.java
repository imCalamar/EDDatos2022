/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author señorJ
 */
public class TestSonFrontera {
    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        ArbolGen arbol=arbolPrueba();
        Lista l1,l2,l3,l4;
        l1 = listaPrueba();
        l2=new Lista();
        l3= listaPrueba2();
        l4= listaPrueba3();
        System.out.println("********************************");
        System.out.println("*      Test sonFrontera        *");
        System.out.println("********************************");
        System.out.println("\n");
        System.out.println("Resultado sonFrontera: " + (arbol.sonFrontera(l1)));
        System.out.println("lista l1: "+ l1.toString());
        System.out.println("\n");
        System.out.println("Resultado sonFrontera lista vacia: " + (arbol.sonFrontera(l2)));        
        System.out.println("lista l2: "+ l2.toString());
        System.out.println("\n");
        System.out.println("Resultado sonFrontera lista con elem repetidos: " + (arbol.sonFrontera(l3)));
        System.out.println("lista l3: "+ l3.toString());
        System.out.println("\n");
        System.out.println("Resultado sonFrontera lista con elem que no son hojas: " + (arbol.sonFrontera(l4)));        
        System.out.println("lista l4: "+ l4.toString());      
    }

    public static ArbolGen arbolPrueba(){   
        ArbolGen a = new ArbolGen();
        
        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");
        System.out.println("Inserto el 10 en raiz " + ((a.insertar(10, 1)) ? sOk : sErr));
        System.out.println("Inserto el 9 como hijo de 10 " + ((a.insertar(9, 10)) ? sOk : sErr));
        System.out.println("Inserto el 7 como hijo de 9 " + ((a.insertar(7, 9)) ? sOk : sErr));
        System.out.println("Inserto el 3 como hijo de 9 " + ((a.insertar(3, 9)) ? sOk : sErr));
        System.out.println("Inserto el 15 como hijo de 10 " + ((a.insertar(15, 10)) ? sOk : sErr));
        System.out.println("Inserto el 12 como hijo de 15 " + ((a.insertar(12, 15)) ? sOk : sErr));
        System.out.println("Inserto el 20 como hijo de 15 " + ((a.insertar(20, 15)) ? sOk : sErr));
        System.out.println("Inserto el 22 como hijo de 15 " + ((a.insertar(22, 15)) ? sOk : sErr));
        System.out.println("Inserto el 30 como hijo de 15 " + ((a.insertar(30, 15)) ? sOk : sErr));
        System.out.println("Inserto el 40 como hijo de 30 " + ((a.insertar(40, 30)) ? sOk : sErr));
        System.out.println("Inserto el 45 como hijo de 30 " + ((a.insertar(45, 30)) ? sOk : sErr));
        System.out.println("Inserto el 55 como hijo de 30 " + ((a.insertar(55, 30)) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n" + a.toString());
        System.out.println("\n");
        return a;
    }
    public static Lista listaPrueba(){
        Lista l=new Lista();
        System.out.println("Inserto el 7 a la lista l1" + ((l.insertar(7,1)) ? sOk : sErr));
        System.out.println("Inserto el 3 a la lista l1" + ((l.insertar(3,2)) ? sOk : sErr));
        System.out.println("Inserto el 12 a la lista l1" + ((l.insertar(12,3)) ? sOk : sErr));
        System.out.println("Inserto el 20 a la lista l1" + ((l.insertar(20,4)) ? sOk : sErr));
        System.out.println("Inserto el 22 a la lista l1" + ((l.insertar(22,5)) ? sOk : sErr));
        System.out.println("Inserto el 40 a la lista l1" + ((l.insertar(40,6)) ? sOk : sErr));
        System.out.println("Inserto el 45 a la lista l1" + ((l.insertar(45,7)) ? sOk : sErr));
        System.out.println("Inserto el 55 a la lista l1" + ((l.insertar(55,8)) ? sOk : sErr));
        System.out.println("\n");
        return l;
    }
    public static Lista listaPrueba2(){
        Lista l2=new Lista();
        System.out.println("Inserto el 7 a la lista l3" + ((l2.insertar(7,1)) ? sOk : sErr));
        System.out.println("Inserto el 3 a la lista l3" + ((l2.insertar(3,2)) ? sOk : sErr));
        System.out.println("Inserto el 12 a la lista l3" + ((l2.insertar(12,3)) ? sOk : sErr));
        System.out.println("Inserto el 20 a la lista l3" + ((l2.insertar(7,4)) ? sOk : sErr));
        System.out.println("Inserto el 22 a la lista l3" + ((l2.insertar(22,5)) ? sOk : sErr));
        System.out.println("Inserto el 40 a la lista l3" + ((l2.insertar(40,6)) ? sOk : sErr));
        System.out.println("Inserto el 45 a la lista l3" + ((l2.insertar(45,7)) ? sOk : sErr));
        System.out.println("Inserto el 55 a la lista l3" + ((l2.insertar(55,8)) ? sOk : sErr));
        System.out.println("\n");
        return l2;
    }
    public static Lista listaPrueba3(){
        Lista l2=new Lista();
        System.out.println("Inserto el 7 a la lista l4" + ((l2.insertar(7,1)) ? sOk : sErr));
        System.out.println("Inserto el 3 a la lista l4" + ((l2.insertar(3,2)) ? sOk : sErr));
        System.out.println("Inserto el 12 a la lista l4" + ((l2.insertar(12,3)) ? sOk : sErr));
        System.out.println("Inserto el 20 a la lista l4" + ((l2.insertar(7,4)) ? sOk : sErr));
        System.out.println("Inserto el 22 a la lista l4" + ((l2.insertar(30,5)) ? sOk : sErr));
        System.out.println("Inserto el 40 a la lista l4" + ((l2.insertar(40,6)) ? sOk : sErr));
        System.out.println("Inserto el 45 a la lista l4" + ((l2.insertar(45,7)) ? sOk : sErr));
        System.out.println("Inserto el 55 a la lista l4" + ((l2.insertar(55,8)) ? sOk : sErr));
        System.out.println("\n");
        return l2;
    }
}
