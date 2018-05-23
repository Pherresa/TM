/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Parser;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 *
 * @author YOON
 */
public class inputValidator implements IParameterValidator { 

    @Override
    public void validate(String string, String input) throws ParameterException {
        String s = input.substring(input.length()-4);
        if(!s.equals(".zip")) {
            throw new UnsupportedOperationException("ERROR: input ha de ser un archivo .zip");
        }
        
    }
    
}
