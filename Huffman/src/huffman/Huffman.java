/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        /*
        String[][] simbolos = new String[][]{{"D","30"},
                                             {"K","20"},
                                             {"Q","2"},
                                             {"J","15"},
                                             {"10","10"},
                                             {"9","5"}
                                            };
        */
        //Comprobar entrada datos es de tipo 2xN
        int esImpar = args.length%2;
        //Correcto
        if(esImpar == 0){
            System.out.println("Tabla entrada es correcta");
            List<String> simbols = new ArrayList<>();
            List<Integer> porcentajes = new ArrayList<>();
            HashMap<Integer, String> tabla = new HashMap<>();
            int tmp;
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
                    tmp = Integer.valueOf(args[i]);
                    porcentajes.add(tmp/100);
                }
            }
            huffman(simbols, porcentajes, tabla);
        }
        else
            System.out.println("Tabla entrada no es correcta");
        }

    private static void huffman(List<String> simbolos, List<Integer> porcentajes, HashMap<Integer, String> tabla) {
        
        Collections.sort(porcentajes);
        Collections.reverse(porcentajes);
        int derecha, izquierda;
        HashMap<Integer, String> resultado = new HashMap();
        //ultima posición del dicionario izquierda, penultima derecha
        //derecha = diccionario(diccionario.lenght()-1);
        //izquierda = diccionario(diccionario.length()-2);
        // for key in izquierda[0]: resultado[key] = '0' + resultado[key]
        // for key in derecha[0]: resultado[key] = '1' + resultado[key]
        //diccionario = diccionario - 2 ultimas posiciones???
        
        System.out.println(porcentajes.get(0));
    }

    
    
}
