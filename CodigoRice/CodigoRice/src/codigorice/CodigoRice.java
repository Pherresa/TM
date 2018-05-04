/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigorice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author YOON
 */
public class CodigoRice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        int M = 32;
        // Rango de N
        int N_minimo = -1023;
        int N_maximo = 1023;
        
        String codificacion;
        int cociente, residuo;
        int longitud_N_original;
        FileWriter fichero = new FileWriter("datos.txt");
        PrintWriter pw = new PrintWriter(fichero);
        int ahorro_bits = 0;
        
        for(int N = N_minimo; N <= N_maximo; N++) {
            // Si es negativo o positivo variamos el bit de signo.
            if(N < 0) {
                codificacion = "0"; // primer bit marcamos como negativo
            } else {
                codificacion = "1"; // primer bit marcamos como positivo.
            }
            
            cociente = Math.abs(N) / M;
            residuo = Math.abs(N) % M;
            
            // Metemos en codificacion tantos 1's como indique el valor cociente.
            for(int i = 0; i < cociente; i++) {
                codificacion += "1";
                
                if(i == cociente-1)
                    codificacion += "0";
            }
            
            // Despues añadimos el valor de residuo en binario.
            codificacion += Integer.toBinaryString(residuo);
            
            System.out.println("N="+N+" | M= "+M);
            System.out.println("Cociente= "+cociente+" | Residuo= "+residuo);
            System.out.println("Codigo Rice= "+codificacion);
            longitud_N_original =Integer.toBinaryString(Math.abs(N)).length()+1;
            System.out.println("Numero de bits= "+codificacion.length()+" Bits original: "+longitud_N_original+"\n");
            
            // Calculamos el maximo ahorro de bits.
            if(longitud_N_original - codificacion.length() > ahorro_bits) {
                ahorro_bits = longitud_N_original - codificacion.length();
            }
            
            //Lo use para exportar los datos a un txt y hacer las graficas.
            //pw.println(codificacion.length()+ " "+ longitud_N_original+ " "+N);
            //pw.println(codificacion.length());
            //pw.println(longitud_N_original);
            //pw.println(N);
            
            
        }
        pw.close();
        fichero.close();
        
        System.out.println("Maximo ahorro de bits: "+ahorro_bits);
    }
    
}
