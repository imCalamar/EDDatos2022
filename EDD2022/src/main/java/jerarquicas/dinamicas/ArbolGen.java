package jerarquicas.dinamicas;
import lineales.dinamicas.*;
public class ArbolGen {

    //gen porque es generico de N nodos hijos
    private NodoGen raiz;
    
    public ArbolGen() {
        raiz = null;
    }    
    public void vaciar() {
        this.raiz = null;
    }   
    public int altura() {
        int altura = -1;
        if (!this.esVacio()) {
            altura = alturaAux(this.raiz, 0);
        }
        return altura;
    }    
    private int alturaAux(NodoGen n, int alturaPadre) {
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                alturaPadre = alturaAux(n.getHijoIzquierdo(), ++alturaPadre);
            }
            else{
                //llegamos a una hoja, hay que comparar con los hermanos derechos
                int alturaParaHermanos = alturaPadre;
                int alturaNivelActual = alturaPadre;
                NodoGen hermano = n.getHermanoDerecho();
                while (hermano != null) {
                    alturaParaHermanos = alturaAux(hermano, alturaNivelActual);
                    if (alturaParaHermanos > alturaPadre) {
                        alturaPadre = alturaParaHermanos;
                    }
                    hermano = hermano.getHermanoDerecho();
                }                
            }           
        }
        return alturaPadre;
    }   
    public boolean esVacio() {
        return (this.raiz == null);
    }   
    public boolean insertar(Object nuevoElem,Object elementoPadre){
        //
        boolean exito=true;
        NodoGen padre;
        if(this.raiz==null){
            this.raiz=new NodoGen(nuevoElem);
        }else{  
            padre=obtenerNodo(this.raiz,elementoPadre);
            if(padre!=null){
                if(padre.getHijoIzquierdo()==null){
                    padre.setHijoIzquierdo(new NodoGen(nuevoElem));
                }else{
                    NodoGen aux=padre.getHijoIzquierdo();
                    while(aux!=null){
                        if(aux.getHermanoDerecho()==null){
                            aux.setHermanoDerecho(new NodoGen(nuevoElem));
                            aux=aux.getHermanoDerecho().getHermanoDerecho();
                        }else{
                            aux=aux.getHermanoDerecho();
                        }
                    }
                }
            }else{
                exito=false;
            }
        }
        return exito;
    }
    public boolean pertenece(Object elem) {
        NodoGen aux = obtenerNodo(this.raiz, elem);
        //si el elemento encontro encontes aux es 
        //distinto de nulo por lo tanto retorna verdadero
        return (aux != null);
    }       
    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo */
        NodoGen resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el hijo izquierdo
                resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    public Lista ancestros(Object elem) {
        Lista l1 = new Lista();
        listarAncestrosAux(this.raiz, l1, elem);
        l1.eliminar(1);
        return l1;
    }
    private void listarAncestrosAux(NodoGen n, Lista l1, Object elem) {
        if (n != null) {
            if (n.getElem().equals(elem)) {
                l1.insertar(n.getElem(), l1.getLongitud() + 1);
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && l1.esVacia()) {
                    listarAncestrosAux(hijo, l1, elem);
                    hijo = hijo.getHermanoDerecho();
                }
                if (!l1.esVacia()) {
                    l1.insertar(n.getElem(), l1.getLongitud() + 1);
                }
            }
        }
    }
    public Lista listarPosorden() {
        Lista salida = new Lista();
        listarPosOrdenAux(this.raiz, salida);
        return salida;
    }  
    private void listarPosOrdenAux(NodoGen n, Lista l) {
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPosOrdenAux(hijo, l);
                hijo = hijo.getHermanoDerecho();
            }
            l.insertar(n.getElem(), l.getLongitud() + 1);
        }
    }       
    public Object padre(Object e) {
        Object x = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(e)) {
                x = pAux(e, this.raiz);
            }
        }
        return x;
    }
    private Object pAux(Object e, NodoGen n) {
        Object res = null;
        if (n != null) {
            NodoGen h = n.getHijoIzquierdo();
            while (h != null && res == null) {
                if (h.getElem().equals(e)) {
                    res = n.getElem();
                } else {
                    h = h.getHermanoDerecho();
                }
            }
            if (res == null) {
                h = n.getHijoIzquierdo();
                while (h != null && res == null) {
                    res = pAux(e, h);
                    h = h.getHermanoDerecho();
                }
            }
        }
        return res;
    }
    public Lista listarPreorden() {
        Lista salida = new Lista();
        listarPreOrdenAux(this.raiz,salida);
        return salida;
    } 
    private void listarPreOrdenAux(NodoGen n, Lista l) {
        if (n!=null){
            
            l.insertar(n.getElem(), l.getLongitud() + 1);
            
            if(n.getHijoIzquierdo() != null) {
                NodoGen aux = n.getHijoIzquierdo();
                while (aux != null) {
                    listarPreOrdenAux(aux, l);
                    aux = aux.getHermanoDerecho();
                }
            }
        }
    }
    
    public Lista listarHastaNivel(int niv){
        return listarHastaNivelRec(this.raiz, niv, 0,new Lista());
    }
    private Lista listarHastaNivelRec(NodoGen nodo,int niv, int i,Lista l){
        //
        if(nodo!=null && niv>=i){
            l.insertar(nodo.getElem(),l.getLongitud()+1);
            
            if(nodo.getHijoIzquierdo()!=null && (niv>= i+1)){
                NodoGen aux = nodo.getHijoIzquierdo();
                while(aux!=null){
                    l=listarHastaNivelRec(aux,niv,i+1,l);
                    aux=aux.getHermanoDerecho();
                }
            }
        }
        return l;
    }
           
    public boolean sonFrontera(Lista unaLista) {
        int i=1;
        boolean exito;
        
        if(!unaLista.esVacia()){
            exito=verificarRepetidos(unaLista);    
            
            while(exito==true && i<=unaLista.getLongitud()){
                exito=sonFronteraAux(this.raiz,unaLista.recuperar(i),false);
                i++;
            }  
        }else{
            exito=false;
        }
        return exito;
    }
    private boolean verificarRepetidos(Lista unaLista){
        boolean seguir=true;
        int i=1;
        while(seguir==true && i<=unaLista.getLongitud()){
            Object elem=unaLista.recuperar(i);
            int j=i+1;
            while(seguir==true && j<=unaLista.getLongitud()){
                if(unaLista.recuperar(j).equals(elem)){
                    seguir=false;
                }
                j++;
            }
            i++;
        }
        return seguir;
    }
    private boolean sonFronteraAux(NodoGen n, Object elem,boolean seguir) {
        if (n!=null && seguir!=true){
            if(elem.equals(n.getElem()) && n.getHijoIzquierdo()==null){
                seguir=true;
            }
            if(n.getHijoIzquierdo() != null) {
                NodoGen aux = n.getHijoIzquierdo();
                while (aux != null) {
                    seguir=sonFronteraAux(aux,elem,seguir);
                    aux = aux.getHermanoDerecho();
                }
            }
        }
        return seguir;
    }
    public Lista listarInorden(){
        //
        Lista salida=new Lista();
        listarInordenAux(this.raiz,salida);
        return salida;
    }
    private void listarInordenAux(NodoGen n, Lista ls){
        //
        if(n!=null){
            //lamado recursivo con primer hijo de n
            if(n.getHijoIzquierdo()!=null){
                listarInordenAux(n.getHijoIzquierdo(),ls);
            }
            //visita nodo n
            ls.insertar(n.getElem(),ls.getLongitud()+1);
             //llamamos a los otros hijos de n
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarInordenAux(hijo,ls);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
    }  
public Lista listarEntreNiveles(int n1,int n2){
        System.out.println(this.raiz.getElem());
        Lista ls = new Lista(); 
       
        ls= listarEntreNivelesAux(this.raiz,0,n1,n2,ls);
        return ls;
    }
    private Lista listarEntreNivelesAux(NodoGen n, int nivel, int n1, int n2, Lista ls){
        if(n!=null){   
            if(n.getHijoIzquierdo()!=null){
                ls=listarEntreNivelesAux(n.getHijoIzquierdo(),nivel+1,n1,n2,ls);
            }
            if(nivel>=n1 && nivel<=n2){
                ls.insertar(n.getElem(),ls.getLongitud()+1);
            }
            
            if(n.getHijoIzquierdo()!=null && (nivel<=n2+1)){
                NodoGen aux = n.getHijoIzquierdo().getHermanoDerecho();
                while(aux!=null){
                    ls=listarEntreNivelesAux(aux,nivel+1,n1,n2,ls);
                    aux=aux.getHermanoDerecho();
                }
            }
        }
        return ls;
    }
    public ArbolGen clone() {
        ArbolGen ar = new ArbolGen();
        if (this.raiz != null) {
            ar.raiz = cloneAux(this.raiz);
        }
        return ar;
    }

    private NodoGen cloneAux(NodoGen n) {
        NodoGen aux = null;
        if (n != null) {
            //de esta manera con un nuevo nodo al asignarle HI e HED recorro siempre primero por izq 
            //cuando encuentra tope en iz va por derecha y trata de seguir bajando en caso de que no pueda sigue por derecha 
            //al nodo hijo se le asigna aux como hi e hed
            aux = new NodoGen(n.getElem(), cloneAux(n.getHijoIzquierdo()), cloneAux(n.getHermanoDerecho()));
        }
        return aux;
    }
    public Lista listarPorNiveles() {
        Lista l = new Lista();
        Cola c = new Cola();
        NodoGen aux = this.raiz;
        c.poner(aux);
        while (!c.esVacia()) {
            NodoGen nuevo = (NodoGen) c.obtenerFrente();
            l.insertar(nuevo.getElem(), l.getLongitud() + 1);
            aux = (NodoGen) c.obtenerFrente();
            c.sacar();
            aux = aux.getHijoIzquierdo();
            while (aux != null) {
                c.poner(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return l;
    }
    public int nivel(Object e) {
        return nAux(this.raiz, e);
    }
    private int nAux(NodoGen n, Object elemento) {
        int niv1 = -1;
        if (n.getElem().equals(elemento)) {
            niv1 = 0;
        } else {
            if (n.getHijoIzquierdo()!= null) {
                niv1 = nAux(n.getHijoIzquierdo(), elemento);
                if (niv1 == -1) {
                    NodoGen aux = n.getHijoIzquierdo().getHermanoDerecho();
                    while (aux != null) {
                        niv1 = nAux(aux, elemento);
                        if (niv1 > -1) {
                            niv1++;
                            aux = null;
                        } else {
                            aux = aux.getHermanoDerecho();
                        }
                    }
                } else {
                    niv1++;
                }
            }
        }
        return niv1;
    }
    
    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }   
    private String toStringAux(NodoGen nodo) {
        String cad = "\n";
        if (nodo != null) {
            cad += "[Nodo: " + nodo.getElem() + ", Hijos: ";
            
            NodoGen hijo = nodo.getHijoIzquierdo();
            if (hijo == null) {
                cad += "-";
            }
            while (hijo != null) {
                cad += hijo.getElem();
                hijo = hijo.getHermanoDerecho();
                if (hijo != null) {
                    cad += ", ";
                }
            }
            cad += "]";
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                cad += toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return cad;
    }//fin auxToString
//    public int grado(){
//        int g;
//        if(this.raiz==null){
//            g=-1;
//        }else{
//            g=gradoRec(this.raiz,0);
//        }
//        return g;
//    }
//      
//    public int gradoSubarbol(Object n){
//        int g;
//        if(this.raiz==null){
//            g=-1;
//        }else{
//            NodoGen aux = obtenerNodo(this.raiz, n);
//            if(aux!=null){
//                System.out.println("etro metodo con: "+aux.getElem());
//                g=gradoRec(aux,0);
//            }else{
//                g=-1;
//            }
//            
//        }
//        return g;
//    }
//    private int gradoRec(NodoGen n,int g){
//        int aux=0;
//        if(n!=null){
//            System.out.println("nodo actual: "+ n.getElem());
//
//            
//            NodoGen nodoAux=n.getHijoIzquierdo();
//            while(nodoAux!=null){                  
//                aux++;System.out.println("grado: "+ aux);
//                nodoAux=nodoAux.getHermanoDerecho();
//            }
//            if(aux>g){
//                g=aux;
//                System.out.println("grado Final: "+ g);
//                
//            } 
//            g=gradoRec(n.getHermanoDerecho(),g); 
//        }
//        return g;
//    }
//    
// Grado no funciona correctamente
}
