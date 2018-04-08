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
class mentValidator implements IParameterValidator {

   @Override
    public void validate(String string, String ment) throws ParameterException {
        int mentrada = Integer.parseInt(ment);
        boolean isValid;
        isValid = (mentrada & -mentrada) == mentrada;
        if (!isValid){
            throw new ParameterException("La ventana de entrada debe ser potencia de 2");
        
        }
    }
}
