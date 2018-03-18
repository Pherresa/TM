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
        String[][] simbolos = new String[][]{{"D","30"},
                                             {"K","20"},
                                             {"Q","2"},
                                             {"J","15"},
                                             {"10","10"},
                                             {"9","5"}
                                            };
        
        huffman(simbolos);

    private static void huffman(String[][] simbols) {
        
        Collections.sort(porcentajes);
        Collections.reverse(porcentajes);
        int derecha, izquierda;
        HashMap<Integer, String> resultado = new HashMap();
        izquierda = porcentajes.get(porcentajes.size()-1);
        derecha = porcentajes.get(porcentajes.size()-2);
        
        
        System.out.println(porcentajes.get(0));
    }

    
    
}
