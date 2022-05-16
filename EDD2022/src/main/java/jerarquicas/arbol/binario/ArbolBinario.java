package jerarquicas.arbol.binario;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

//import lineales.dinámicas.ColaInt;
public class ArbolBinario {

    //Atributo
    private NodoArbol raiz;

    //Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    //Propios de la Clase
    public boolean insertar(Object nuevoElem, Object padre, char pos) {
        /* metodo que inserta elemNuevo como hijo izquierdo o derecho
         de la primer aparición de elemPadre, según lo indique el parámetro
         posicion. */
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevoElem,null,null);
        } else {
            //si no esta vacio se busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, padre);
            
            if (nodoPadre != null) {
                if (pos == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(nuevoElem));
                } else {
                    if (pos == 'D' && nodoPadre.getDerecho() == null) {
                        //si el padre existe y no tiene Hijo derecho se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(nuevoElem));
                    } else {
                        //si el padre no existe o ya tiene ese hijo, da error
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }//fin insertar

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo */
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElemento() == buscado) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el hijo izquierdo
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }//fin obtenerNodo

    public int altura() {
        /* Devuelve la altura del árbol, es decir la longitud del camino
         más largo desde la raíz hasta una hoja (Nota: un árbol vacío tiene
         altura -1 y una hoja tiene altura 0). */
        return alturaAux(this.raiz, -1);
    }//fin altura

    private int alturaAux(NodoArbol nodo, int cont) {
        /*  */
        int alt = 0, aux;
        if (nodo != null) {
            cont++;
            alt = alturaAux(nodo.getIzquierdo(), cont);
            //el contador es la altura si es mayor
            if (cont > alt) {
                alt = cont;
            }
            aux = alturaAux(nodo.getDerecho(), cont);
            //el auxiliar es la altura si es mayor
            if (aux > alt) {
                alt = aux;
            }
        }
        return alt;
    }//fin alturaAux

    public int nivel(int elem) {
        /* Devuelve el nivel de un elemento en el árbol.
         Si el elemento no existe en el árbol devuelve -1 */
        return nivelAux(this.raiz, elem, -1);
    }//fin nivel
    private int nivelAux(NodoArbol nodo, Object elem, int cont) {
        /*  */
        int nivel = -1;
        if (nodo != null) {
            //como el nodo existe, incrementamos el contador de nivel
            cont++;
            if (nodo.getElemento() != elem) {
                //recorremos el lado izquierdo del arbol
                nivel = nivelAux(nodo.getIzquierdo(), elem, cont);
                if (nivel == -1) {
                    //si el nivel es -1, el elemento no se encontro
                    //procede a buscarlo por el lado derecho
                    nivel = nivelAux(nodo.getDerecho(), elem, cont);
                }
            } else {
                /* cuando el elemento buscado coincide con el elemento del nodo
                 asigna el valor del contador en el momento */
                nivel = cont;
            }
        }
        return nivel;
    }//fin nivelAux

    public Object padre(Object elem) {
        /* Dado un elemento devuelve el valor almacenado en su nodo padre
         (busca la primera aparición del elemento). */
        return padreAux(this.raiz, elem);
    }//fin padre
    private Object padreAux(NodoArbol nodo, Object busc) {
        /* metodo privado que devuelve el valor del nodo padre del elemento buscado */
        Object res = null;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                if (nodo.getIzquierdo().getElemento() == busc) {
                    res = nodo.getElemento();
                } else {
                    res = padreAux(nodo.getIzquierdo(), busc);
                }
            }
            if (res == null) { ////  revisar *****************************************************************************
                if (nodo.getDerecho() != null) {
                    if (nodo.getDerecho().getElemento() == busc) {
                        res = nodo.getElemento();
                    } else {
                        res = padreAux(nodo.getDerecho(), busc);
                    }
                }
            }
        }
        return res;
    }//fin padreAux
    public boolean esVacio() {
        /* metodo que permite saber si el arbol es vacio */
        return (this.raiz == null);
    }//fin esVacio

    public void vaciar() {
        /* metodo que permite vaciar un arbol. Como la estructura se recorre
         desde la raiz, si la raiz es nula, el arbol está vacio */
        //al menos en Java ;P
        this.raiz = null;
    }//fin vaciar

    public Lista listarPreOrder() {
        /* Devuelve una lista con los elementos del árbol 
         binario en el recorrido en preorden */
        Lista preOrder = new Lista();
        preOrder = preOrderAux(this.raiz, preOrder);
        return preOrder;
    }//fin listarPreOrder

    private Lista preOrderAux(NodoArbol nodo, Lista lista) {
        /* recorre el arbol en preorden */
        if (nodo != null) {
            //como el nodo existe, lo agrega a la lista
            lista.insertar(nodo.getElemento(), lista.getLongitud() + 1);
            //visita el nodo izquierdo
            preOrderAux(nodo.getIzquierdo(), lista);
            //visita el nodo derecho
            preOrderAux(nodo.getDerecho(), lista);
        }
        return lista;
    }//Fin preOrderAux

    public Lista listarInOrder() {
        /* Devuelve una lista con los elementos del árbol 
         binario en el recorrido en inorden */
        Lista inOrder = new Lista();
        inOrder = inOrderAux(this.raiz, inOrder);
        return inOrder;
    }//fin listarInOrder

    private Lista inOrderAux(NodoArbol nodo, Lista lista) {
        /* metodo que recorre e inserta los elementos del arbol en
         la lista con recorrido inOrder */
        if (nodo != null) {
            //como el nodo existe, visita al nodo izquierdo
            inOrderAux(nodo.getIzquierdo(), lista);
            //cuando no hay mas nodos del lado izquierdo, agrega 
            //el elemento a la lista
            lista.insertar(nodo.getElemento(), lista.getLongitud() + 1);
            //visita el nodo derecho
            inOrderAux(nodo.getDerecho(), lista);
        }
        return lista;
    }//Fin inOrderAux

    public Lista listarPosOrder() {
        /* Devuelve una lista con los elementos del árbol 
         binario en el recorrido en posorden */
        Lista posOrder = new Lista();
        posOrder = posOrderAux(this.raiz, posOrder);
        return posOrder;
    }//fin listarPosOrder

    private Lista posOrderAux(NodoArbol nodo, Lista lista) {
        /* recorre el arbol en posOrder */
        if (nodo != null) {
            //como el nodo existe, visita el siguiente nodo izquierdo
            posOrderAux(nodo.getIzquierdo(), lista);
            //cuando finaliza el recorrido de nodos del lado izquierdo, visita
            //los nodos del lado derecho
            posOrderAux(nodo.getDerecho(), lista);
            //agrega los elementos a la lista
            lista.insertar(nodo.getElemento(), lista.getLongitud() + 1);
        }
        return lista;
    }//fin posOrderAux

    public Lista listarNiveles() {
        /* Devuelve una lista con los elementos del árbol 
         binario en el recorrido por niveles */
        Lista niveles = new Lista();
        if (this.raiz != null) {
            niveles = listNivAux(this.raiz, niveles);
        }
        return niveles;
    }//fin listarNiveles

    private Lista listNivAux(NodoArbol nodo, Lista lista) {
        /* */
        Cola cola = new Cola();
        int cont = 1;
        Object valor;
        cola.poner(nodo.getElemento());
        while (!(cola.esVacia())) {
            valor = cola.obtenerFrente();
            lista.insertar(valor, cont);
            nodo = obtenerNodo(this.raiz, valor);
            cola.sacar();
            cont++;
            if (nodo != null) {
                if (nodo.getIzquierdo() != null) {
                    cola.poner(nodo.getIzquierdo().getElemento());
                }
                if (nodo.getDerecho() != null) {
                    cola.poner(nodo.getDerecho().getElemento());
                }
            }
        }
        return lista;
    }//fin listNivlAux

    public ArbolBinario clonar() {
        /* */
        ArbolBinario newArbol = new ArbolBinario();
        if (this.raiz != null) {
            newArbol.raiz = clonarAux(this.raiz, null);
        }
        return newArbol;
    }//fin clonar

    private NodoArbol clonarAux(NodoArbol nodo, NodoArbol nodoClon) {
        /* */
        if (nodo != null) {
            if (nodoClon == null) {
                nodoClon = new NodoArbol(nodo.getElemento());
            }
            if (nodo.getIzquierdo() != null) {
                nodoClon.setIzquierdo(new NodoArbol(nodo.getIzquierdo().getElemento()));
                clonarAux(nodo.getIzquierdo(), nodoClon.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                nodoClon.setDerecho(new NodoArbol(nodo.getDerecho().getElemento()));
                clonarAux(nodo.getDerecho(), nodoClon.getDerecho());
            }
        }
        return nodoClon;
    }//fin clonarAux

    
    @Override
    public String toString() {
        /* */
        return toStringAux(this.raiz);
    }//fin toString

    private String toStringAux(NodoArbol nodo) {
        /* */
        String cadena = "";
        if (nodo != null) {
            //como el nodo existe, lo agrega a la lista
            cadena += "\n[Padre: '" + nodo.getElemento() + "', Hijo Izquierdo: '";
            //verifica que el nodo izquierdo exista y lo agrega a la cadena:
            if (nodo.getIzquierdo() != null) {
                cadena += nodo.getIzquierdo().getElemento() + "'";
            } else {
                cadena += " '";
            }
            cadena += ", Hijo Derecho: '";
            //verifica que el nodo derecho exista y lo agrega a la cadena:
            if (nodo.getDerecho() != null) {
                cadena += nodo.getDerecho().getElemento() + "']";
            } else {
                cadena += " ']";
            }
            //visita el nodo izquierdo
            cadena += toStringAux(nodo.getIzquierdo());
            //visita el nodo derecho
            cadena += toStringAux(nodo.getDerecho());
        }
        return cadena;
    }//fin toStringAux

    
    public boolean verificarPatron(Lista patron){
        boolean exito = false;
        
        return verificarPatronAux(patron,exito, this.raiz,0); 
    }

    private boolean verificarPatronAux(Lista listaP, boolean exito, NodoArbol nodoAB,int pos) {
        pos++;

        if(nodoAB!=null ){

            if(nodoAB.getElemento()==listaP.recuperar(pos)){
                if(nodoAB.getIzquierdo()==null && nodoAB.getDerecho()==null && listaP.recuperar(pos+1)==null){
                    exito=true;
                }
                if (exito!=true) {
                    exito=verificarPatronAux(listaP,exito,nodoAB.getIzquierdo(),pos);
                    exito=verificarPatronAux(listaP,exito,nodoAB.getDerecho(),pos);
                }
            }  
        }
    return exito;
    }
    
    public Lista frontera(){
        return fronteraAux(new Lista(), this.raiz); 
    }
    private Lista fronteraAux(Lista lista, NodoArbol nodoAB) {

        if(nodoAB!=null){
            if(nodoAB.getIzquierdo()==null && nodoAB.getDerecho()==null){
                lista.insertar(nodoAB.getElemento(),lista.getLongitud()+1);
            }
            lista=fronteraAux(lista,nodoAB.getIzquierdo());
            lista=fronteraAux(lista,nodoAB.getDerecho());
        }
        return lista;
    }
    
    public ArbolBinario clonarInvertido(){
        ArbolBinario clon = new ArbolBinario();
        clon.insertar(this.raiz.getElemento(), 0,'I');
        return clonarInvertidoAux(clon,clon.raiz, this.raiz); 
    }
    private ArbolBinario clonarInvertidoAux(ArbolBinario clon, NodoArbol nodoClon, NodoArbol nodoAB) {

        if(nodoAB!=null){
            if(nodoAB.getIzquierdo()!=null){
                clon.insertar(nodoAB.getIzquierdo().getElemento(), nodoClon.getElemento(), 'D'); 
            }
            if(nodoAB.getDerecho()!=null) {
                clon.insertar(nodoAB.getDerecho().getElemento(), nodoClon.getElemento(), 'I');
            }     
            clon=clonarInvertidoAux(clon,nodoClon.getDerecho(),nodoAB.getIzquierdo());
            clon=clonarInvertidoAux(clon,nodoClon.getIzquierdo(),nodoAB.getDerecho());
        }
        return clon;
    }
}