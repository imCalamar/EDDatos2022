/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestConjuntista;

import Conjuntistas.ArbolAVL;

/**
 *
 * @author Joaquin.coder
 */
public class TestAVL {
    
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

        arbol.insertar(30);
        arbol.insertar(25);
        arbol.insertar(23);
        arbol.insertar(18);
        arbol.insertar(24);
        arbol.insertar(19);
        arbol.insertar(22);
        arbol.insertar(20);

        System.out.println(arbol.toString());

//        arbol.eliminar(23);
//        System.out.println(arbol.toString());
//        arbol.eliminarMenorElem();
//        System.out.println(arbol.toString());
    }

    
}
