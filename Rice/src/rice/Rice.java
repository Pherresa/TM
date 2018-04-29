/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rice;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Rice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int m = 32;
        //int n = 578;
        for(int n = -1023; n < 1024; n++){
            String q;
            String r;
            String s;
            System.out.println("Valor de M: " + m);
            System.out.println("Valor de N: " + n);
            s = signo(n);
            q = cociente(m, n).toString();
            r = residuo(m,n);
            String numero;
            numero = s + q + r;
            System.out.println("Signo: " + s);
            System.out.println("Cociente: " + q);
            System.out.println("Residuo: " + r);
            System.out.println("Número codificado: " + numero);
            System.out.println("Longitud codificado: " + numero.length());
            System.out.println("-------------------------------");
        }
        
        
        
    }

    private static StringBuilder cociente(int m, int n) {
        int bin;
        bin = abs(n)/m;
        StringBuilder unos = new StringBuilder();
        for(int i = 0; i < bin; i++){
            unos.append("1");
        }
        unos.append("0");
        return unos;
    }

    private static String residuo(int m, int n) {
        int bin;
        String r;
        bin = abs(n)%m;
        r = Integer.toBinaryString(bin);
        int l = (int) (Math.log(m)/Math.log(2));
        int length = r.length();
        while (length<l){
             r = '0' + r;
             length++;
        }
        
        return r;
        
    }

    private static String signo(int n) {
        if(n<0){
            return "0";
        }else{
            return "1";
        }
    }
    
}
