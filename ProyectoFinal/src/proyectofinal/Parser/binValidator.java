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
public class binValidator implements IParameterValidator {

    @Override
    public void validate(String string, String value) throws ParameterException {
        int valor = Integer.parseInt(value);
        if(valor < 0 || valor > 255) {
            throw new UnsupportedOperationException("ERROR: binarization <value>, value tiene que estar entre 0 y 255."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
