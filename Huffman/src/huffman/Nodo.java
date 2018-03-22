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
public class Nodo {
    
    // Datos que contendra un nodo.
    public String simbolo; 
    public Double prob;
    public int bit;
    
    // Parientes nodo.
    public Nodo padre = null;
    public Nodo izquierda = null;
    public Nodo derecha = null;
    
    public Nodo(String simbolo, Double prob) {
        this.simbolo = simbolo;
        this.prob = prob;
    }
    
    // Atributos publicos asi no hay que matarse haciendo los getters y setters.
    
}
