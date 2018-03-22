/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author chyoonyo7
 */
public class ArbolBinario {
    // Raiz de arbol estara iniciado.
    public Nodo raiz = new Nodo("Papa", 1.);
    
    
    // Intento...
    public void add2Nodos(Nodo nodo, Nodo nodo2, Nodo nodo_inicial) {
        
        // Si nodo_inicial NO tiene hijos, metemos los dos nodos.
        if(nodo_inicial.derecha == null && nodo_inicial.izquierda == null) {
            // Mirar que probabilidad es mas pequeña.
            // Si nodo es mas pequeño que nodo2, nodo lo metemos en hijo izquierdo.
            // El que pongamos en la iquierda le asignamos bit = 0,
            // al de la derecha le asignamos bit = 1;
            if(nodo.prob <= nodo2.prob) {
                // hijo izquierdo
                nodo_inicial.izquierda = nodo;
                nodo.bit = 0;
                
                // hijo derecho
                nodo_inicial.derecha = nodo2;
                nodo2.bit = 1;
                
            } else { //Si no, al reves.
                // hijo izquierdo
                nodo_inicial.izquierda = nodo2;
                nodo2.bit = 0;
                
                // hijo derecho
                nodo_inicial.derecha = nodo;
                nodo.bit = 1;
            }
        } else { // TEngo la idea a medias jajaja.
            
        }

    }
}
