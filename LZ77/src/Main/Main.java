/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.beust.jcommander.JCommander;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(args);
        main.run();
    }

    public void run() {
        
    }   
    
    /**
     *
     * @param cadena, cadena a comprimir.
     * @param vDes, longitud ventana deslizante.
     * @param vEnt, longitud ventana entrada.
     * @return 
     */
    // Suponiendo que los datos de entrada estan todos correctos
    // Tenemos una cadena a comprimir y ventana deslizante y ventana entrada correctos.
    public String comprimir(String cadena, int long_vDes, int long_vEnt) {
        String result = "";
        int long_cadena = cadena.length();
        String mDes, mEnt;
        
        boolean igual = false;
        
        // Cogemos bits para ventana deslizante, que tiene de longitud
        // long_vDes.
        mDes = cadena.substring(0, long_vDes);
        
        // Cogemos bits para ventana entrada.
        // que empieza a partir de donde acada la deslizante + longitud ventana entrada.
        mEnt = cadena.substring(long_vDes, long_vDes + long_vEnt);
        
        // Mientras la longitud de la ventana entrada
        // sea igual que longitud inicial de la ventana entrada
        while(mEnt.length() == long_vEnt) {
            /**
             * Tengo vDes y vEnt, tengo q ir comparando hasta
             * encontrar los bits de mayor longitud identicos
             * Voy arrastrando de derecha a izquierda, si no encuentro
             * vEnt, mas pequeño y repito si encuentro perfecto y meto en result (L,D)
             * si no encuentro, a la q me quede 1 bit en vEnt lo meto en result
             * 
             * Despues, tengo que mover mDes y mEnt a otros bits, segun L de(L,D) 
             * y hacer lo mismo....
             *  esta noche sin falta
             * Necesito todo el rato inicio y final de mDes y mEnt, CREO
             * 
             */
            
            
            String vEnt_provisional;
            int count = 0;
            // Empezamos desde final de ventana deslizante
            // hasta llegar a la izquierda del todo.
            igual = false;
            vEnt_provisional = mEnt;
            
            while(vEnt_provisional.length() > 1) {
                
            }
        }
        
        return result;
    }
    
    public String descomprimir() {
        
        return "";
    }
    
    // Para convertir (L,D) en 01 001(por ejemplo),
    // la explicacion esta en apartado 4, punto 2.
    public String int_to_bit(int n) {
        
        return "";
    }
}
    

