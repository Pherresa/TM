/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import com.beust.jcommander.Parameter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pablo
 */
public class Args {
    
    @Parameter
  private List<String> parameters = new ArrayList<>();

  @Parameter(names = { "-input", "-i" }, description = "Entrada de datos binaria", required = true, 
          validateWith = inputValidator.class)
  private String input;

  @Parameter(names = {"-Ment", "-ve"}, description = "Ventana de entrada", required = true, 
          validateWith = mentValidator.class)
  private String ment;

  @Parameter(names = {"-Mdes", "-vd"}, description = "Ventana deslizante", required = true, 
          validateWith = mdesValidator.class)
  private String mdes;
  
  
public void checkMdes(){
    if (this.mdes.length()> this.ment.length()){
        System.out.println("ERROR: La ventana deslizante tiene que ser menor o igual que la ventana de entrada");
    }
}

public void sumVentanas(){
    if (this.mdes.length() + this.ment.length() > input.length()){
        System.out.println("ERROR: Las ventanas no pueden ser mayores que los datos de entrada");
    }
}
   /**
     * @return the parameters
     */
    public List<String> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * @return the ment
     */
    public String getMent() {
        return ment;
    }

    /**
     * @param ment the ment to set
     */
    public void setMent(String ment) {
        this.ment = ment;
    }

    /**
     * @return the mdes
     */
    public String getMdes() {
        return mdes;
    }

    /**
     * @param mdes the mdes to set
     */
    public void setMdes(String mdes) {
        this.mdes = mdes;
    }
}

