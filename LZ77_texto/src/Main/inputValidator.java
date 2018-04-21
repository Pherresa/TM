/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 *
 * @author pablo
 */
public class inputValidator implements IParameterValidator {

    @Override
    public void validate(String name, String entrada) throws ParameterException {
        String s = entrada.substring(entrada.length()-4);
        if(!s.equals(".txt")){
            throw new ParameterException("No es un archivo txt.");
        }
    }
    
}
