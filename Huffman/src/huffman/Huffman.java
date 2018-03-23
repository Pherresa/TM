/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Huffman {
    
    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Dato> simb_porcentaje = new ArrayList();
        simb_porcentaje.add(new Dato("D", 0.3));
        simb_porcentaje.add(new Dato("K", 0.2));
        simb_porcentaje.add(new Dato("Q", 0.2));
        simb_porcentaje.add(new Dato("J", 0.15));
        simb_porcentaje.add(new Dato("10", 0.1));
        simb_porcentaje.add(new Dato("9", 0.05));

        // Tabla resultado final.
        HashMap<String, String> tabla = new HashMap();
        tabla.put("D", "");
        tabla.put("K", "");
        tabla.put("Q", "");
        tabla.put("J", "");
        tabla.put("10", "");
        tabla.put("9", "");
        
        
        Nodo nodo_raiz;
        nodo_raiz = arbol(simb_porcentaje); // Creamos arbol.
        
        // Recorremos arbol y cogiendo la secuencia de bits.
        tabla = recorrer(nodo_raiz, tabla, "");
        
        // Mostramos resultados.
        System.out.println("D "+tabla.get("D"));
        System.out.println("K "+tabla.get("K"));
        System.out.println("Q "+tabla.get("Q"));
        System.out.println("J "+tabla.get("J"));
        System.out.println("10 "+tabla.get("10"));
        System.out.println("9 "+tabla.get("9"));
        

        /** Para pasar datos por argumento **/
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
    /*
    private static void huffman(HashMap<Double, String> simbolos, List<Double> porcentajes, List<Dato> lista) {
        int derecha, izquierda;
        double suma;
        String smb, smb2;

        // Vamos juntando hasta que queden 2 elementos.
        for(int i = porcentajes.size(); i > 2 ; i--) {
            // Ordenamos de mas grande a mas pequeño.
            Collections.sort(porcentajes, Collections.reverseOrder());
            
            // Obtenemos simbolos con porcentaje mas bajo.
            smb = simbolos.get(porcentajes.get(porcentajes.size()-1));
            smb2 = simbolos.get(porcentajes.get(porcentajes.size()-2));
                       
            //Sumamos sus porcentajes.
            suma = porcentajes.get(porcentajes.size()-1) + porcentajes.get(porcentajes.size()-2);
            suma = Math.round(suma *100d)/100d;
            
            //Añadimos el nuevo simbolo al diccionario y lista de datos.
            simbolos.put(suma, smb+smb2);
            lista.add(new Dato(smb+smb2, suma));
            
            //Quitamos los porcentajes y añadimos la suma
            // Como lista esta ordenada habra que borrar dos veces el ultimo elemento.
            porcentajes.remove(porcentajes.size()-1);
            porcentajes.remove(porcentajes.size()-1);
            porcentajes.add(suma);
            porcentajes.size();
        }
    }*/
    
    // Creamos el arbol empezando por las prob mas bajas, es decir dos hojas.
    // Cogemos dos dato, creamos al padre(la suma de estos dos).
    // Metemos padre en una lista.
    // Siguiente iteracion: cogemos dos nodos con prob mas baja de nuevo.
    // miramos que si alguno de estos dos era padre en la iteracion anterior.
    // Si era padre, pues cogemos el padre de antes si no añadimos normal.
    private static Nodo arbol(List<Dato> datos) throws CloneNotSupportedException {
        Dato dato1, dato2;
        Dato suma;
        Nodo nodo_padre = null, nodo1, nodo2;
        List<Nodo> padres = new ArrayList(); // Para comprobar si un nodo antes era padre.
        int i, trobat_nodo1, trobat_nodo2; // Para buscar si es padre.
        
        // Pasamos a crear el arbol directamente, empezamos con los que tienen porcentaje mas bajo.
        // Hijo izquierdo bit = 0. Hijo derecho bit = 1;
        // nodo1 siempre sera hijo izquierdo
        // nodo2 siempre sera hijo derecho.
        while(datos.size() > 1) {
            // Ordenamos de pequeño a grande.
            Collections.sort(datos);

            dato1 = datos.get(0); // Caracter con porcentaje mas pequeño
            dato2 = datos.get(1); // Caracter con segundo porcentaje mas pequeño.

            // Sumamos probabilidad y juntamos los caracteres.
            suma = dato1.suma(dato2);

            // Pasamos a crear los nodos.
            nodo1 = new Nodo(dato1, "0");
            nodo2 = new Nodo(dato2, "1");

            // Aqui buscamos si nodo1 o nodo2 es identico a un padre anterior.
            // Si es igual este padre anterior pasara a ser nodo1 o nodo2
            if(!padres.isEmpty()) {
              
                // Buscamos si nodo1, era padre anterior.
                trobat_nodo1 = 0;
                for(i = 0; i < padres.size(); i++) {
                    if(nodo1.equals(padres.get(i))) {
                        trobat_nodo1 = 1;
                        break;
                    }
                }
                if(trobat_nodo1 == 1) {
                    nodo1 = padres.get(i).clone();
                    nodo1.bit = "0";
                    padres.remove(i);
                }
                
                // Buscamos si nodo2, era padre anterior.
                trobat_nodo2 = 0;
                for(i = 0; i < padres.size(); i++) {
                    if(nodo2.equals(padres.get(i))){ 
                        trobat_nodo2 = 2;
                        break;
                    }
                }
                if(trobat_nodo2 == 2) {
                    nodo2 = padres.get(i).clone();
                    nodo2.bit = "1";
                    padres.remove(i);
                }

            }
            
            // La suma de dato1 y dato2 sera el padre de nodo1 y nodo2 actuales.
            nodo_padre = new Nodo(suma);
            
            // Asignamos hijos al padre actual.
            nodo_padre.izquierda = nodo1.clone();
            nodo1.padre = nodo_padre.clone();
            
            nodo_padre.derecha = nodo2.clone();
            nodo2.padre = nodo_padre.clone();

            // Añadimos padre actual, para luego saber si sera nodo1 o nodo2.
            padres.add(nodo_padre);
            
            //Quitamos los porcentajes y añadimos la suma
            // Como lista esta ordenada habra que borrar dos veces el primer elemento.
            datos.remove(0);
            datos.remove(0);
            datos.add(suma);
        }
        return nodo_padre;
    }
    
    private static HashMap<String,String> recorrer(Nodo nodo, HashMap<String, String> tabla, String bit) throws CloneNotSupportedException {
        
        if(nodo.izquierda != null) {
            recorrer(nodo.izquierda, tabla, bit+nodo.izquierda.bit);
        }
        if(nodo.derecha != null) {
            recorrer(nodo.derecha, tabla, bit+nodo.derecha.bit);
        }
        
        // Si no tiene hijos implica que este nodo es una hoja,
        // es decir, un caracter/simbolo suelto.
        if(nodo.izquierda == null && nodo.derecha == null) {
            tabla.put(nodo.dato.caracter, bit);
        }
        
        return tabla;
    }
    
}
