/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Objects;

/**
 *
 * @author chyoonyo7
 */
public class Dato implements Comparable<Dato> {
    public Double porcentaje;
    public String caracter;
    
    public Dato(String c, Double d) {
        this.caracter = c;
        this.porcentaje = d;
    }
    public Dato() {
        this.caracter = null;
        this.porcentaje = null;
    }


    @Override
    public int compareTo(Dato dato) {
        if(this.porcentaje < dato.porcentaje)
            return -1;
        
        if(this.porcentaje > dato.porcentaje)
            return 1;
        
        return 0;
    }
    
    public Dato suma(Dato d) {
        Dato result = new Dato();
        result.caracter = this.caracter +d.caracter;
        result.porcentaje = this.porcentaje +d.porcentaje;
        result.porcentaje = Math.round(result.porcentaje *100d)/100d;
        
        return result;
    }
    
    public boolean equals(Dato d) {
        return this.caracter.equals(d.caracter) && Objects.equals(this.porcentaje, d.porcentaje);
    }
}
