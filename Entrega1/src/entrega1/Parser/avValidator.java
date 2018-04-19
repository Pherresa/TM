/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1.Parser;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 *
 * @author YOON
 */
public class avValidator implements IParameterValidator {

    @Override
    public void validate(String string, String value) throws ParameterException {
        int valor = Integer.parseInt(value);
        if(valor < 3) {
            throw new UnsupportedOperationException("ERROR: averaging <value>, value ha de ser mayor de 2.");
        }
        
    }
    
}
