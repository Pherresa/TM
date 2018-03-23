/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explicacionespractica;

import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 *
 * @author pablo
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class ExplicacionesPractica {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        BufferedImage imagen = null;
        //CLAS
            FileInputStream fis = new FileInputStream("ruta");
            try{
                imagen = ImageIO.read(fis);
                
                
            } catch (IOException ex) {
                Logger.getLogger(ExplicacionesPractica.class.getName()).log(Level.SEVERE, null, ex);
            } 
            if(imagen != null){
                //get width and bla bla bla
                int pixelInt = imagen.getRGB(20, 10);
                Color pixelColor = new Color(pixelInt);
                System.out.println("R= "+ pixelColor.getRed());
                
            }
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ExplicacionesPractica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
