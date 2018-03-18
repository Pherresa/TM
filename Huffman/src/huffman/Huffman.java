/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

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
        //Correcto
        if(esImpar == 0){
            System.out.println("Tabla entrada es correcta");
        //Incorrecto
        }else
            System.out.println("Tabla entrada no es correcta");
        }
    
}
