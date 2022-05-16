package jerarquicas.arbol.binario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Utiles.TecladoIn;
import lineales.dinamicas.Lista;

/**
 *
 * @author alumno
 */
public class EstructurasArboles {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        tarea(arbolPrueba());
    }
    public static void tarea(ArbolBinario arbol){
        //
        int seg,padre,elem;
        char lado;
        do{
            switch(seg=menu()){ 
                case 1:
                    System.out.println("ingrese valor a apilar");
                    elem=TecladoIn.readLineInt();
                    System.out.println("ingrese a que nodo enlasar el elemto");
                    padre=TecladoIn.readLineInt();
                    System.out.println("ingrese el lado an cual pociosionar I/D");
                    lado=TecladoIn.readLineNonwhiteChar();
                    System.out.println(arbol.insertar(padre, elem, lado));
                    break;
                case 2:
                    System.out.println("ingrese el elemento para hallar su padre");
                    elem=TecladoIn.readLineInt();
                    System.out.println(arbol.padre(elem));
                    break;
                case 3:
                    System.out.println("ingrese el elemento para saber su nivel");
                    elem=TecladoIn.readLineInt();
                    System.out.println(arbol.nivel(elem));
                    break;
                case 4:
                    System.out.println(arbol.altura());
                    break;
                case 5:
                    System.out.println(arbol.listarPreOrder());
                    break;
                case 6:
                    System.out.println(arbol.listarInOrder());
                    break;
                case 7:
                    System.out.println(arbol.listarPosOrder());
                    break;
                case 8:
                    System.out.println(arbol.toString());
                    break;
                case 9:
                    System.out.println(listaPatron().toString());
                    System.out.println(arbol.verificarPatron(listaPatron()));
                    break;
                case 10:
                    System.out.println(arbol.frontera().toString());
                    break;
                case 11:
                    System.out.println(arbol.clonarInvertido().toString());
                    break;
                default:  
                    break;
            }
        }while(seg!=-1);
    }
    public static int menu(){
        int v;
        System.out.println("1 para insertar un elemto / "
                + "2 para eliminar un elemento en una posicion / "
                + "3 para localizar la posicion de un elemento / "
                + "4 para recuperar un elemento con una posicion / "
                + "5 para listar preorden / "
                + "6 para listar inorden / "
                + "7 para listar posorden / "
                + "8 para clonar la lista / "
                + "9 para patron / "
                + "-1 para salir ");
        v=TecladoIn.readLineInt();
        return v;
    }  
    public static ArbolBinario arbolPrueba(){
        //
        ArbolBinario nuevoArbol=new ArbolBinario();
        nuevoArbol.insertar(0, 0, 'I');
        nuevoArbol.insertar(1, 0, 'I');
        nuevoArbol.insertar(2, 0, 'D');
        nuevoArbol.insertar(3, 1, 'I');
        nuevoArbol.insertar(4, 1, 'D');
        nuevoArbol.insertar(5, 2, 'I');
        nuevoArbol.insertar(6, 2, 'D');   
        return nuevoArbol;
    }
        public static Lista listaPatron(){
        //
        Lista listaaux=new Lista();
        listaaux.insertar(0, 1);
        listaaux.insertar(2, 2);
        listaaux.insertar(6, 3);
        return listaaux;
    }
}
