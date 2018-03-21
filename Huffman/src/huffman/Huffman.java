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
        
        //repetir hasta que solo haya 2 entradas en el diccionario y/o porcentajes
        
        
        //ultima posición del dicionario izquierda, penultima derecha
        //derecha = diccionario(diccionario.lenght()-1);
        //izquierda = diccionario(diccionario.length()-2);
        // for key in izquierda[0]: resultado[key] = '0' + resultado[key]
        // for key in derecha[0]: resultado[key] = '1' + resultado[key]
        //diccionario = diccionario - 2 ultimas posiciones???
        
    }

    

    
    
}
