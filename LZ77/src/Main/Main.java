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
        /*Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(args);
        main.run();
    */
        String cadena = "11011100101001111010100010001";
        String res;
        res = comprimir(cadena, 8, 5);
        System.out.println(res);
    }
/*
    public void run() {
        
    }   */
    
    /**
     *
     * @param cadena, cadena a comprimir.
     * @param long_vDes, longitud ventana deslizante
     * @param long_vEnt, longitud ventana entrada.
     * @return 
     */
    // Suponiendo que los datos de entrada estan todos correctos
    // Tenemos una cadena a comprimir y ventana deslizante y ventana entrada correctos.
    public static String comprimir(String cadena, int long_vDes, int long_vEnt) {
        String result = ""; // Resultado comprimido final.
        int long_cadena = cadena.length();
        int guardar; // provisional, tenemos q pasar a bits.
        String mDes, mEnt;
        boolean igual;
        // Para saber las posiciones finales y iniciales
        // de las ventanas en la cadena.
        int init_mDes, final_mDes, init_mEnt, final_mEnt;
        int l = 0; // Longitud que guardaremos
        
        // Indices de cada ventana en la cadena.
        init_mDes = 0;
        final_mDes = long_vDes - 1;
        init_mEnt = long_vDes;
        final_mEnt = long_vDes + long_vEnt - 1;
        
        // Cogemos bits para ventana deslizante.
        mDes = cadena.substring(init_mDes, final_mDes+1);
        
        // Primera parte de result es la primera ventana deslizante.
        result += mDes;
        
        // Cogemos bits para ventana entrada.
        mEnt = cadena.substring(init_mEnt, final_mEnt + 1);
        
        // Mientras la longitud de la ventana entrada
        // sea igual que longitud inicial de la ventana entrada
        while(true) {
            //System.out.println(mDes);
            int index_inici_comparar;
            int index_final_comparar;
            
            String mEnt_prov = mEnt;
            
            // vEnt_long_for es la cantidad de bits que tiene ventana entrada.
            // cuando quede solo 1 directamente guardamos en result
            igual = false;
            for(int vEnt_long_for = mEnt_prov.length(); vEnt_long_for > 1; vEnt_long_for--) {
                mEnt_prov = cadena.substring(init_mEnt, init_mEnt + vEnt_long_for);
                // Per poder arrastrar la ventana entrada cap a l'esquerra.
                //long_vEnt+1, +1 porque sumo indices no longitud.
                // si longitud es x, indices va desde 0 a x-1.
                for(int i = 0; (final_mDes - vEnt_long_for+1 - i) > init_mDes; i++) {
                    // Agafem inici i final de ventana deslizante
                    // per a despres comparar amb ventana entrada.
                    index_inici_comparar = final_mDes - vEnt_long_for+1 - i;
                    index_final_comparar = index_inici_comparar + vEnt_long_for;

                    // Comparem.
                    igual = mEnt_prov.equals(cadena.substring(index_inici_comparar, index_final_comparar));
                    if(igual) { // Si hem trobat coincidencia
                        // tengo que guardar (L, D)
                        l = vEnt_long_for;
                        result += l; // Guardamos L.
                        // Restando desde el inicio de la parte de ventana deslizante
                        // que comparamos menos el init de ventana entrada obtenemos D
                        guardar = index_inici_comparar - init_mEnt;
                        result += guardar;
                        //result += index_inici_comparar - init_mEnt; // Guardamos D.
                        break; // Terminamos for de i.
                    }
                }
                // Si hemos llegado aqui por coincidencia no hace falta acortar ventana entrada.
                if(igual) {
                    break;
                }
            } // end for vent_long_prov.
            
            // Si igual es false, quiere decir que ventana entrada se ha quedado en 1
            // entonces guardamos el primer bit de ventana entrada directamente.
            if(!igual) {
                result += mEnt.substring(0, 1);
            }
            
            // Aqui arrastramos ventana deslizante y entrada.
            // Segun si hemos encontrado coincidiencia o no.
            if(igual) { // Si hemos encontrado coincidencia arrastraremos L posiciones.
                init_mDes +=  l;
                final_mDes += l;
                init_mEnt += l;
                final_mEnt += l;
            } else { // Si no solo 1 posicion.
                init_mDes +=  1;
                final_mDes += 1;
                init_mEnt += 1;
                final_mEnt += 1;
            }
            
            // Cogemos bits para nueva ventana deslizante.
            mDes = cadena.substring(init_mDes, final_mDes + 1);
            
            // Cogemos bits para nueva ventana entrada.
            // Si ventana entrada es mas pequeña lo que queda de bits a buscar.
            if(final_mEnt + 1 >= cadena.length()) {
                result += cadena.substring(final_mDes+1, cadena.length());
                break;
            }
            mEnt = cadena.substring(init_mEnt, final_mEnt + 1);
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
    

