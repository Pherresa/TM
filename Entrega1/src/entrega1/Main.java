/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import entrega1.Parser.ArgumentParser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 *
 * @author pablo
 */
public class Main {

    ArgumentParser args;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArgumentParser arguments = new ArgumentParser();
        try{
            JCommander jc = new JCommander(arguments, args);
            Main main2 = new Main(arguments);
            
        }catch(ParameterException e){
            System.out.println("Error : " + e.getMessage());
        }
    }

    private Main(ArgumentParser arguments) {
        this.args = arguments;
        //TODO ABRIR ZIP, LEER IMAGENES Y APLICAR FILTROS.
    }
    
}
