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
        boolean isValid;
        isValid = entrada.matches("[01]+");
        if(!isValid){
            throw new ParameterException("La entrada de datos debe ser binaria");
        }
    }
    
}
