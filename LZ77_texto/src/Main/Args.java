/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import com.beust.jcommander.Parameter;
/**
 *
 * @author pablo
 */
public class Args {
    @Parameter(names = { "-input", "-i" }, description = "Nombre archivo txt", 
        validateWith = inputValidator.class, required = true)
    private String input;
        
    @Parameter(names = {"-Ment", "-ve"}, description = "Ventana de entrada",
            validateWith = mentValidator.class, required = true)
    private String ment;

    @Parameter(names = {"-Mdes", "-vd"}, description = "Ventana deslizante",
            validateWith = mdesValidator.class, required = true)
    private String mdes;

  
public boolean checkMdes(){
    boolean b;
   
    b = Integer.parseInt(this.mdes) < Integer.parseInt(this.ment);
    if (Integer.parseInt(this.mdes) < Integer.parseInt(this.ment)){
        System.out.println("ERROR: La ventana deslizante tiene que ser mayor o igual que la ventana de entrada");
    }
    return b;
}

    public boolean sumVentanas(){
        boolean b;
        b = Integer.parseInt(this.mdes) + Integer.parseInt(this.ment) > input.length();
        return b;
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

