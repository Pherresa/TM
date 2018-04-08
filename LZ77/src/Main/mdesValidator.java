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
class mdesValidator implements IParameterValidator {

    @Override
    public void validate(String string, String mdes) throws ParameterException {
        int mdeslizante = Integer.parseInt(mdes);
        boolean isValid;
        isValid = (mdeslizante & -mdeslizante) == mdeslizante;
        if (!isValid){
            throw new ParameterException("La ventana deslizante debe ser potencia de 2");
        
        }
    }
    
}
