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
 * @author pablo
 */
public class integerValidator implements IParameterValidator { 

    @Override
    public void validate(String string, String value) throws ParameterException {
        int valor = Integer.parseInt(value);
        if(valor < 0 ){
            throw new UnsupportedOperationException("ERROR: El valor tiene que ser mayor que 0"); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
