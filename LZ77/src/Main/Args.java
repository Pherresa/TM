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

    @Parameter(names = {"-comprueba", "-cp"}, description = "25 bits aleatorios, Mdes = 8 y Ment = 4", required = true )
    private String cp;
    
    @Parameter(names = { "-longitud", "-l" }, description = "Numero entero x para generar cadena de x bits aleatorio")
    private String longitud;

    @Parameter(names = {"-Ment", "-ve"}, description = "Ventana de entrada",
            validateWith = mentValidator.class)
    private String ment;

    @Parameter(names = {"-Mdes", "-vd"}, description = "Ventana deslizante",
            validateWith = mdesValidator.class)
    private String mdes;
    
    @Parameter(names = { "-input", "-i" }, description = "Entrada de datos binaria", 
            validateWith = inputValidator.class)
    private String input;
  
  
  
  
  
public boolean checkMdes(){
    boolean b;
    b = Integer.parseInt(this.mdes) <= Integer.parseInt(this.ment);
    if (Integer.parseInt(this.mdes) <= Integer.parseInt(this.ment)){
        System.out.println("ERROR: La ventana deslizante tiene que ser mayor o igual que la ventana de entrada");
    }
    return b;
}

public boolean sumVentanas(){
    boolean b;
    b = Integer.parseInt(this.mdes) + Integer.parseInt(this.ment) > input.length();
    return b;
}

    public String getCp(){
        return cp;
    }
    
    public void setCp(String cp){
        this.cp = cp;
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
    
    public String getLongitud() {
        return this.longitud;
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

