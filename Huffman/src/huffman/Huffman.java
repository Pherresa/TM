/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
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
        
        //Comprobar entrada datos es de tipo 2xN
        int esImpar = args.length%2;
        System.out.println(args.length);
        //Correcto
        if(esImpar == 0){
            System.out.println("Tabla entrada es correcta");
            List<String> simbols = new ArrayList<>();
            List<Integer> porcentajes = new ArrayList<>();
            for(int i = 0; i < args.length; i++){
                //porcentajes
                if(i%2 == 0){
                    System.out.println(args[i]);
                    simbols.add(args[i]);
                //Porcentajes    
                }else{
                    System.out.println(Integer.valueOf(args[i]));
                    porcentajes.add(Integer.valueOf(args[i]));
                }
            }
            huffman(simbols, porcentajes);
        }
        else
            System.out.println("Tabla entrada no es correcta");
        }

    private static void huffman(List<String> simbols, List<Integer> porcentajes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
