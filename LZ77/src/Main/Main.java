/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;


/**
 *
 * @author pablo
 */
public class Main {

    Args args;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Args arguments = new Args();
        
        try{
            JCommander jc = new JCommander(arguments, args);
            if(args.length > 2) {
                if(!arguments.checkMdes()) {
                    Main main2 = new Main(arguments);
                }
            }
        }catch(ParameterException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public Main(Args arguments) {
        this.args = arguments;
        String s = "";
        // Si escribimos cp si o no.
        if(arguments.getCp().equals("si") || arguments.getCp().equals("no")) {
            
            if(arguments.getCp().equals("si")){// Si es -cp si. // APARTADO 1
                for(int i = 0; i<25; i++){
                    s += Math.round(Math.random());
                }
                
                System.out.println("Cadena a comprimir: "+s);
                System.out.println("Ventana entrada: 4");
                System.out.println("Ventana deslizante: 8");
                s = comprimir(s, 8, 4);
                System.out.println("Resultado de la compresion: "+s);
                s = descomprimir(s, 8, 4);
                System.out.println("Resultado de la descompresion: "+s);
            
            } else { // si es -cp no.
                if(arguments.getInput().length() == 1) { // Si -i es 0 o 1
                    // Cogemos valor de -l.
                    int n = Integer.parseInt(arguments.getLongitud());
                    for(int i = 0; i < n; i++){
                        s += Math.round(Math.random());
                    }
                    System.out.println("Cadena a comprimir: "+s);
                    System.out.println("Cadena con longitud: "+arguments.getLongitud());
                    System.out.println("Ventana entrada: "+args.getMent());
                    System.out.println("Ventana deslizante: "+args.getMdes());
                    s = comprimir(s, Integer.parseInt(args.getMdes()), Integer.parseInt(args.getMent()));
                    System.out.println("Resultado de la compresion: "+s);
                    s = descomprimir(s, Integer.parseInt(args.getMdes()), Integer.parseInt(args.getMent()));
                    System.out.println("Resultado de la descompresion: "+s);
                    
                } else { // si -i es cadena larga.
                    if(arguments.sumVentanas()) { // Si suma ventanas superior a cadena i, error.
                        System.out.println("ERROR: Las ventanas no pueden ser mayores que los datos de entrada");
                    } else {
                        s = args.getInput();
                        System.out.println("Cadena a comprimir: "+s);
                        System.out.println("Ventana entrada: "+args.getMent());
                        System.out.println("Ventana deslizante: "+args.getMdes());
                        s = comprimir(s, Integer.parseInt(args.getMdes()), Integer.parseInt(args.getMent()));
                        System.out.println("Resultado de la compresion: "+s);
                        s = descomprimir(s, Integer.parseInt(args.getMdes()), Integer.parseInt(args.getMent()));
                        System.out.println("Resultado de la descompresion: "+s);
                    }
                } 
            }
        } else {
            System.out.println("Falta argumento -cp si o -cp no");
        }

    }
    /**
     *
     * @param cadena, cadena a comprimir.
     * @param long_vDes, longitud ventana deslizante
     * @param long_vEnt, longitud ventana entrada.
     * @return 
     */
    // Suponiendo que los datos de entrada estan todos correctos
    // Tenemos una cadena a comprimir y ventana deslizante y ventana entrada correctos.
    public String comprimir(String cadena, int long_vDes, int long_vEnt) {
        String result; // Resultado comprimido final.
        boolean igual, acabar;
        String mEnt, bits;
        // Para saber las posiciones finales y iniciales
        // de las ventanas en la cadena para utilizar despues.
        int init_mDes, final_mDes, init_mEnt, final_mEnt;
        int l = 0; // Longitud que guardaremos
        int index_inici_comparar;
        int index_final_comparar;
        
        // Indices iniciales de las ventanas en la cadena.
        init_mDes = 0;
        final_mDes = long_vDes - 1;
        init_mEnt = long_vDes;
        final_mEnt = long_vDes + long_vEnt - 1;
              
        // Primera parte de result es la primera ventana deslizante.
        result = cadena.substring(init_mDes, final_mDes+1);
        
        // Cogemos bits para ventana entrada.
        // Que sera los bits que iremos comparando en la ventana deslizante.
        mEnt = cadena.substring(init_mEnt, final_mEnt + 1);
        
        // Mientras la longitud de la ventana entrada que queda
        // sea igual a la longitud ventana entrada inicial no pararemos.
        acabar = false;
        while(!acabar) {         
            // vEnt_long_for es la cantidad de bits de Vent a comparar.
            // Mientras no encontremos coincidencia iremos
            // decrementando la cantidad de bits.
            // Si llegamos a quedarnos solo con un bit, este bit
            // lo guardamos en result y pasamos a mover ventanas.
            igual = false;
            for(int vEnt_long_for = long_vEnt; vEnt_long_for >= 1; vEnt_long_for--) {
                mEnt = cadena.substring(init_mEnt, init_mEnt + vEnt_long_for);
                // Aquest for per poder arrastrar 
                // la ventana entrada cap a l'esquerra.
                // long_vEnt+1+i, +1 porque sumo indices no longitud.
                // si longitud es x, indices va desde 0 a x-1.
                // +i para arrastrar a la izquierda una unidad cada iteracion.
                for(int i = 0; (final_mDes - vEnt_long_for+1 - i) >= init_mDes; i++) {
                    // Agafem inici i final de ventana deslizante
                    // per despres comparar amb ventana entrada.
                    index_inici_comparar = final_mDes - vEnt_long_for+1 - i;
                    index_final_comparar = index_inici_comparar + vEnt_long_for;

                    // Comparem.
                    igual = mEnt.equals(cadena.substring(index_inici_comparar, index_final_comparar));
                    
                    if(igual) { // Si hem trobat coincidencia
                        // Hem de guardar (L, D)
                        l = vEnt_long_for; // para usarlo despues para desplazar ventanas.
                        bits = int_to_bit(l, long_vEnt);
                        result += bits; // Guardamos L.
 
                        // Restando desde el inicio de la parte de ventana deslizante
                        // que comparamos menos el init de ventana entrada obtenemos D
                        bits = int_to_bit(init_mEnt - index_inici_comparar, long_vDes);
                        result += bits;
                        break; // Terminamos for de i.
                    }
                }
                // Si hemos llegado aqui por coincidencia no hace falta acortar ventana entrada.
                if(igual) {
                    break;
                }
            } // end for vent_long_prov.
            
            // Si igual es false, quiere decir que ventana entrada se ha quedado en 1 bit
            // sin encontrar ninguna coincidencia anterior,
            // entonces guardamos el primer bit de ventana entrada directamente.
            // Guardaremos (1,1) tal como pide enunciado
            if(!igual) {
                bits = int_to_bit(1, long_vEnt);
                result += bits;
                bits = int_to_bit(1, long_vDes);
                result += bits;
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
            // Si lo que queda por buscar(vEnt) es menor a la
            // longitud ventana entrada inicial, terminamos.
            if(final_mEnt >= cadena.length()) {
                acabar = true;
                result += cadena.substring(final_mDes+1, cadena.length());
            }
        }// Fi while.
        
        return result;
    }
    
    // Nos dan cadena a comprimir y pasamos a descomprimirla.
    public String descomprimir(String cadena, int long_vDes, int long_vEnt) {
        String result = "";
        int num_bits_L, num_bits_D, i;
        int valorL = 0, valorD = 0;
        int potencia2;
        // Calculamos los bits que ocupan (L,D).
        // Miramos si es potencia de 2.
        potencia2 = long_vDes & (long_vDes-1);
        if(potencia2 == 0)
            num_bits_D = (int) (Math.log(long_vDes) / Math.log(2));
        else
            num_bits_D = Integer.toBinaryString(long_vDes).length();
        
        potencia2 = long_vEnt & (long_vEnt-1);
        if(potencia2 == 0)
            num_bits_L = (int) (Math.log(long_vEnt) / Math.log(2));
        else
            num_bits_L = Integer.toBinaryString(long_vEnt).length();
        
        // Sabemos que el principio de la cadena comprimida, con longitud vDes, 
        // era el principio de la cadena normal.
        result += cadena.substring(0, long_vDes);
        // Ejemplo: Si vEnt 4 i mDes 8, avanzaremos de 5 en 5.
        //for(i = long_vDes; i+num_bits_L+num_bits_D < cadena.length(); i += num_bits_L+num_bits_D) {
        for(i = long_vDes; i+num_bits_L+num_bits_D < cadena.length(); i += num_bits_L+num_bits_D) {
            // Pasamos los bits de L y D a decimal.
            valorL = bit_to_int(cadena.substring(i, i+num_bits_L));
            valorD = bit_to_int(cadena.substring(i+num_bits_L, i+num_bits_L+num_bits_D));

            // Empezando en la posicion result.length(), es decir,
            // en la siguiente posicion despues del ultimo elemento,
            // retrocedemos D posiciones y cogemos L bits y añadimos a resultado.

            result += result.substring(result.length()-valorD, result.length()-valorD+valorL);
        }
        
        // Lo que nos quede suelto al final lo añadimos a saco.
        result += cadena.substring(i);        
        return result;
    }
    
    // Para convertir (L,D) en 01 001(por ejemplo),
    // la explicacion esta en apartado 4, punto 2.
    /** Ejemplo 2 bits:
     * 1 = 01, 2 = 10, 3 = 11
     * 4 deberia ser 100, pero se representara como 00
     * @param n, int a transformar en bits.
     * @param passar_a_bits, valor que lo pasaremos a bits.
     * @return cadena de bits.
     */
    public String int_to_bit(int n, int passar_a_bits) {
        int longitud_bits;
        // Ejemplo, si es 8, i paso directo a bits me sale 1000
        // pero yo kiero saber la cantidad de bits para representar 8 numeros
        // es decir, 3.
        // Comprobamos si es potencia de 2.
        int potencia2 = passar_a_bits & (passar_a_bits-1);
        if(potencia2 == 0) {
            longitud_bits = (int) (Math.log(passar_a_bits) / Math.log(2));
        } else {
            longitud_bits = Integer.toBinaryString(passar_a_bits).length();
        }
        
        String bits = Integer.toBinaryString(n);
        // En el caso de 2 bits, si encontramos 100,
        // tenemos que convertilo en 00.
        for(int i = 0; i < bits.length(); i++) {
            // Si en alguna posicion, diferente de 0,
            // de la cadena encuentro un bit 1
            // o si longitud de bits es menor a la 
            // longitud bits de ventana entrada
            // devolver todos los bits tal cual.
            if(i > 0 && bits.charAt(i) == '1' || bits.length() < longitud_bits){
                // Para añadir 0 al pricinpio de la cadena
                // Si faltasen bits.
                for(int j = 0; bits.length() < longitud_bits; j++)
                    bits = "0"+bits;
                return bits;
            }
        }
        // Si numero de bits es 3 y nos sale un 8 se representa como 1000
        // para nosotros el 8 seria 000, en este ejemplo.
        if(bits.length() > longitud_bits)
            return bits.substring(1, bits.length());
        
        // Ejemplo, num bits = 3  y nos sale 100(4 en decimal),
        // lo retornamos tal cual.
        return bits;
        
    }        
    
    // Per passar de bit a decimal.
    public int bit_to_int(String bits) {
        int n;
        boolean trobat = false;
                
        for(int i = 0; i < bits.length(); i++) {
            if(bits.charAt(i) == '1') {
                trobat = true;
            }            
        }
        // Si no hem trobat cap 1
        // vol dir que tindrem algo rollo 000
        // 000 per nosaltre es 8 no 0!
        // 0000 es 16 no 0
        if(!trobat)
            // Retornem 2 elevat el numero de bits.
            return (int) Math.pow(2, bits.length());
        
        // Convertim binary a decimal i retornem.
        return Integer.parseInt(bits, 2);
    }
    
}
    

