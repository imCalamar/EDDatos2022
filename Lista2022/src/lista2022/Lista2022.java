/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista2022;

import lineales.dinamicas.Lista;

/**
 *
 * @author Joaquin.coder
 */
public class Lista2022 {
    static String sOk = "OK!", sErr = "ERROR";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("COMIENZO TEST PILA");
        Lista p1 = new Lista();
        System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());

        System.out.print("Apila 1 espera TRUE y [1]:\t\t\t\t" + ((p1.insertar(1, 1)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 2 espera TRUE y [1,2]:\t\t\t\t" + ((p1.insertar(2, 2)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 3 espera TRUE y [1,2,3]:\t\t\t\t" + ((p1.insertar(3, 3)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 4 espera TRUE y [1,2,3,4]:\t\t\t" + ((p1.insertar(4, 4)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 5 espera TRUE y [1,2,3,4,5]:\t\t\t" + ((p1.insertar(5, 5)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 6 espera TRUE y [1,2,3,4,5,6]:\t\t\t" + ((p1.insertar(6, 6)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 7 espera TRUE y [1,2,3,4,5,6,7]:\t\t\t" + ((p1.insertar(7, 7)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 8 espera TRUE y [1,2,3,4,5,6,7,8]:\t\t" + ((p1.insertar(8, 8)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 9 espera TRUE y [1,2,3,4,5,6,7,8,9]:\t\t" + ((p1.insertar(9, 9)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 10 espera TRUE y [1,2,3,4,5,6,7,8,9,10]:\t\t" + ((p1.insertar(10, 10)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.print("Apila 11 espera false en estatica true en dinamica:\t" + p1.insertar(11, 11));
        System.out.println("\t--> " + p1.toString());
        
        Lista p2 = p1.clone();
        System.out.println("Copia : \t\t\t\t--> " + p2.toString());
        
        Lista p3 = p1.obtenerMultiplos(2);
        System.out.println("multiplos : \t\t\t\t--> " + p3.toString());
        
        p1.eliminarApariciones(2);
        System.out.println("multiplos : \t\t\t\t--> " + p1.toString());
    }
    
}
