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
public class fpsValidator implements IParameterValidator {

    @Override
    public void validate(String string, String fps) throws ParameterException {
        int valor = Integer.parseInt(fps);
        
        if(valor < 1)
            throw new UnsupportedOperationException("ERROR: fps no puede ser mas pequeño de 1."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
