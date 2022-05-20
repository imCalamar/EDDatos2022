package  lineales.dinamicas;

import Utiles.*;

/**
 *
 * @author Joaquin Arias FAI-1629
 */

public class Lista {

    private int longitud;
    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public int getLongitud() {
        return this.longitud;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        boolean respuesta = false;
        if (this.cabecera == null) {
            respuesta = true;
        }

        return respuesta;
    }

    public Object obtenerCabecera() {
        return this.cabecera.getElemento();
    }

    public boolean insertar(Object elem, int pos) {
        //modulo que permite insertar un elemento nuevo en la lista, en la pos recibida
        boolean exito = true;
        if (pos < 1 || pos > (this.longitud + 1)) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elem, this.cabecera);
            } else {
                int cont = 1;
                Nodo aux = this.cabecera;
                while (cont < pos - 1) {
                    aux = aux.getEnlace();
                    cont++;
                }
                Nodo newElem = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(newElem);
            }
            this.longitud++;
        }
        return exito;
    }//fin insertar

    public boolean eliminar(int pos) {
        //modulo que permite eliminar el elemento de la posicion recibida
        boolean exito = true;
        if (pos < 1 || pos > this.longitud || this.cabecera == null) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = cabecera.getEnlace();
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
        }
        return exito;
    }//fin eliminar
   
    
    public Lista clone() {
        Lista clon = new Lista();
        Nodo aux = this.cabecera;
        Nodo aux2, N;
        if (aux != null) {
            clon.cabecera = new Nodo(aux.getElemento(), null);
            aux2 = clon.cabecera;
            //recorro la lista original con aux
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                N = new Nodo(aux.getElemento(), null);
                aux2.setEnlace(N);
                aux2 = N;
            }
        }
        clon.longitud = this.longitud;
        return clon;
    }
    public Lista obtenerMultiplos(int num) {
        Lista clon = new Lista();
        Nodo aux = this.cabecera;
        Nodo aux2 = null, N;
        int pos =1;
        if (aux != null) {
            while (aux2 == null && aux!=null) { //insertar el primer nodo 

                if ((pos%num)==0){
                    clon.cabecera = new Nodo(aux.getElemento(), null);
                    aux2 = clon.cabecera;
                }else{
                    aux = aux.getEnlace();
                    pos++;
                }
            }
            //recorro la lista original con aux
            if (aux != null) {
                while (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                    pos++;
                    if ((pos%num)==0){
                        N = new Nodo(aux.getElemento(), null);
                        aux2.setEnlace(N);
                        aux2 = N;
                    }
                }
            }
        }
        clon.longitud = this.longitud;
        return clon;
    }   
    public void eliminarApariciones(Object x){
        //
        boolean seguir=true;
        if(this.cabecera!=null){
            
            while(seguir && this.cabecera!=null){
                if(this.cabecera.getElemento()==x) {
                    this.cabecera = cabecera.getEnlace();
                }else{
                    seguir=false;
                }
            }  
            Nodo aux=this.cabecera;
            if (aux != null) {
                while(aux.getEnlace()!=null){
                    if (aux.getEnlace().getElemento()==x) {
                        if (aux.getEnlace().getEnlace()==null) {
                            aux.setEnlace(null);
                        }else{
                            aux.setEnlace(aux.getEnlace().getEnlace());
                        }  
                    }else{
                       aux=aux.getEnlace(); 
                    }
                }
            }
        }
    }

    public void copiar(Lista lista) {
        //se usa en grafo
        //metodo que permite "copiar" los elementos 
        //de la lista que ingresa por parámentro
        //a la lista que recibe el método
        if (lista.cabecera != null) {
            this.cabecera = new Nodo(lista.cabecera.getElemento());
            Nodo aux = cabecera;
            Nodo auxCopia = lista.cabecera.getEnlace();
            while (auxCopia != null) {
                aux.setEnlace(new Nodo(auxCopia.getElemento()));
                aux = aux.getEnlace();
                auxCopia = auxCopia.getEnlace();
            }
        }
    }

    public Object recuperar(int pos) {
        int auxPos = 1;
        Object salida = null;
        Nodo aux = null;
        if (pos >= 1 && pos <= this.longitud) {
            aux = this.cabecera;
            while (auxPos < pos) {
                aux = aux.getEnlace();
                auxPos++;
            }
            salida = aux.getElemento();
        }
        return salida;
    }

    public int localizar(Object elem) {
        int salida = -1, recorrido = 1;
        boolean exito = false;
        Nodo aux = this.cabecera;
        while (aux != null && !exito) {
            if (aux.getElemento().equals(elem)) {
                salida = recorrido;
                exito = true;
            } else {
                recorrido++;
                aux = aux.getEnlace();
            }
        }
        return salida;
    }

    public boolean equals(Lista l) {
        boolean salida = false;
        if (this.getLongitud() == l.getLongitud()) {
            salida = equalsAux(this.cabecera, l.cabecera);
        }
        return salida;
    }

    private boolean equalsAux(Nodo nodoLista1, Nodo nodoLista2) {
        boolean rta = true;
        if (nodoLista1 != null) {
            if (nodoLista2 != null) {
                if (nodoLista1.equals(nodoLista2)) {
                    rta = equalsAux(nodoLista1.getEnlace(),nodoLista2.getEnlace());
                }
            } else {
                rta = false;
            }
        } else {
            if (nodoLista2 != null) {
                rta = false;
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        String mensaje="";
        if (this.cabecera == null) {
            mensaje = "Ø";
        } else {
            mensaje = "{";
            Nodo aux = this.cabecera;
            while (aux != null) {
                mensaje += aux.getElemento().toString();
                if (aux.getEnlace() != null) {
                    mensaje += ", ";
                }
                aux = aux.getEnlace();
            }
            mensaje += "}";
        }
        return mensaje;
    }
}