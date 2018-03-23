/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.List;

/**
 *
 * @author chyoonyo7
 */
public class Nodo implements Cloneable{
    
    // Datos que contendra un nodo.
    public Dato dato;
    public String bit;
    
    // Parientes nodo.
    public Nodo padre;
    public Nodo izquierda;
    public Nodo derecha;
    
    public Nodo() {
        this.dato = null;
        this.izquierda = null;
        this.derecha = null;
    }
    // Para cuando creo un padre.
    public Nodo(Dato d) {
        this.dato = d;
        this.izquierda = null;
        this.derecha = null;
    }
    
    // Para las hojas SIN hijos, en caso de que solo sea 1 simbolo.
    public Nodo(Dato d, String bit) {
        this.dato = d;
        this.izquierda = null;
        this.derecha = null;
        this.bit = bit;
    }
    
    @Override
    public Nodo clone() throws CloneNotSupportedException {
        return (Nodo) super.clone();
    }

    public boolean equals(Nodo node) {
        return this.dato.equals(node.dato);
    }
    
    public boolean esPadre(List<Nodo> nodos) {
        boolean b = false;
        for(int i = 0; i < nodos.size(); i++) {
            if(this.dato.equals(nodos.get(i).dato))
                b = true;
        }
        return b;
    }
    // Atributos publicos asi no hay que matarse haciendo los getters y setters.
    
}
