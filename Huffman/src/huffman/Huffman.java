/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap<Double, String> simbolos = new HashMap<>();
        simbolos.put(0.3, "D");
        simbolos.put(0.2, "K");
        simbolos.put(0.2, "Q");
        simbolos.put(0.15, "J");
        simbolos.put(0.1, "10");
        simbolos.put(0.05, "9");
        List<String> simbols = new ArrayList<>();
        List<Double> porcentajes = new ArrayList<>();
        porcentajes.add(0.3);
        porcentajes.add(0.2);
        porcentajes.add(0.2);
        porcentajes.add(0.15);
        porcentajes.add(0.1);
        porcentajes.add(0.05);

        huffman(simbolos, porcentajes);
        
        //Para pasar datos por argumento
        /*
        //Comprobar entrada datos es de tipo 2xN
        int esImpar = args.length%2;
        //Correcto
        if(esImpar == 0){
            System.out.println("Tabla entrada es correcta");
            double tmp;
            for(int i = 0; i < args.length; i+=2){
                tabla.put(Integer.valueOf(args[i]), args[i+1]);
            }
            for(int i = 0; i< args.length; i++){
                //Simbolos
                if(i%2 == 0){
                    //System.out.println(args[i]);
                    simbols.add(args[i]);
                //Porcentajes    
                }else{
                    //System.out.println(Integer.valueOf(args[i]));
                    tmp = Double.valueOf(args[i]);
                    porcentajes.add(tmp/100);
                }
            }
            huffman(simbolos, porcentajes);
        }
        else
            System.out.println("Tabla entrada no es correcta");
        }
        */
    }
        
    private static void huffman(HashMap<Double, String> simbolos, List<Double> porcentajes) {
        System.out.println(porcentajes.size());
        //Collections.sort(porcentajes);
        //Collections.reverse(porcentajes);
        int derecha, izquierda;
        double suma;
        String smb, smb2;
        
        /**
        //obtenemos los 2 ultimos simbolos con menos peso
        smb = simbolos.get(porcentajes.get(porcentajes.size()-1));
        smb2 = simbolos.get(porcentajes.get(porcentajes.size()-2));
        //Los eliminamos
        simbolos.remove(porcentajes.get(porcentajes.size()-1));
        simbolos.remove(porcentajes.get(porcentajes.size()-2));
        //sumamos sus porcentajes
        suma = porcentajes.get(porcentajes.size()-1) + porcentajes.get(porcentajes.size()-2);
        //Añadimos el nuevo simbolo al diccionario
        simbolos.put(suma, smb+smb2);
        //Quitamos los porcentajes y añadimos la suma
        porcentajes.remove(porcentajes.size()-1);
        porcentajes.remove(porcentajes.size()-2);
        porcentajes.add(suma);
        porcentajes.size();
        */

        // Vamos juntando hasta que queden 2 elementos.
        while(porcentajes.size() > 2) {
            // Ordenamos de mas grande a mas pequeño.
            Collections.sort(porcentajes, Collections.reverseOrder());

            smb = simbolos.get(porcentajes.get(porcentajes.size()-1));
            smb2 = simbolos.get(porcentajes.get(porcentajes.size()-2));
            //Los eliminamos
            simbolos.remove(porcentajes.get(porcentajes.size()-1));
            simbolos.remove(porcentajes.get(porcentajes.size()-2));
            //sumamos sus porcentajes

            suma = porcentajes.get(porcentajes.size()-1) + porcentajes.get(porcentajes.size()-2);
            //Añadimos el nuevo simbolo al diccionario
            simbolos.put(suma, smb+smb2);
            //Quitamos los porcentajes y añadimos la suma
            porcentajes.remove(porcentajes.size()-1);
            porcentajes.remove(porcentajes.size()-2);
            porcentajes.add(suma);
            porcentajes.size();
            
            System.out.println("Iter");
            for(int i = 0; i < porcentajes.size(); i++) {
                System.out.println(porcentajes.get(i));
            }
        }
        
        System.out.println("Final");
        for(int i = 0; i < porcentajes.size(); i++) {
            System.out.println(porcentajes.get(i));
        }
        //repetir hasta que solo haya 2 entradas en el diccionario y/o porcentajes
        
        
        //ultima posición del dicionario izquierda, penultima derecha
        //derecha = diccionario(diccionario.lenght()-1);
        //izquierda = diccionario(diccionario.length()-2);
        // for key in izquierda[0]: resultado[key] = '0' + resultado[key]
        // for key in derecha[0]: resultado[key] = '1' + resultado[key]
        //diccionario = diccionario - 2 ultimas posiciones???
        
    }
    /** ME HECHO LA PICHA UN LIO... BORRARLO TODO SI QUIERES JAJAJA  **/
    private ArbolBinario arbol(HashMap<Double, String> simbolos, List<Double> porcentajes) {
        ArbolBinario arbol = new ArbolBinario();
        
        /* 
         * Tenemos una lista con 2 porcentajes y un dicccionario que si le damos
         * porcentaje nos devuelve un simbolo.
         */
        
        // Los primeros hijos serian
        Nodo nodo = new Nodo(simbolos.get(porcentajes.get(0)), porcentajes.get(0));
        Nodo nodo2 = new Nodo(simbolos.get(porcentajes.get(1)), porcentajes.get(1));
        arbol.add2Nodos(nodo, nodo2, arbol.raiz);
        
        // Ahora seria hacer lo mismo con los hijos... tengo una idea pero no
        // me acabo de aclarar :S
        
        // La condicion para iterar creo que no esta bien
        // Me baso un poco en el ejercicio solucionado que hay en el campus de lo que hicimos en clase.
        Nodo prueba = arbol.raiz; // Ya tiene hijos derecha e izquierda.
        for(int i = 0; i < simbolos.size()-2; i++) {
            String simb;
            Double prob;
            // Cogemos hijo izquierda.
            simb = prueba.izquierda.simbolo; // Simbolo del hijo izquierdo
            prob = prueba.izquierda.prob; // prob del hijo izquierdo
            // Si el simbolo del hijo izquierdo es mayor de 1 caracter
            // implica que tendra nodos hijos.
            //Si justamente son 2, pasamos a meterlos.
            if(prueba.izquierda.simbolo.length() == 2){
                // Necesitaria a partir del simbolo sacar su probabilidad tmb.
                nodo.simbolo = Character.toString(simb.charAt(0));
                //nodo.prob =;
                nodo2.simbolo =Character.toString(simb.charAt(1));
                //nodo2.prob = ;
                
                //arbol.add2Nodos(nodo, nodo2, prueba);
            } else {
                
            }
            if(prueba.izquierda.simbolo.length() > 1) {
                
            }
                
            
        }
        return arbol;
    }
            

    
    
}
