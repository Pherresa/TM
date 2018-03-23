/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explicacionespractica;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
/**
 *
 * @author pablo
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
public class ExplicacionesPractica {

    private static int[] bandList;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ArgParser parser = new ArgParser();
        JCommander jComm = null;
        try{
            jComm = new JCommander(parser, args);
        }
        BufferedImage imagen = null;
        //CLAS
            FileInputStream fis = new FileInputStream("ruta");
            try{
                imagen = ImageIO.read(fis);
                File f = new File("ruta");
                ZipFile zf = new ZipFile(f);
                zf.entries();
                //iterar con Enumeration extends zipentry> entries = zf.entries();
                    //ZipEntry entry = entries.nextElement();
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(ExplicacionesPractica.class.getName()).log(Level.SEVERE, null, ex);
            } 
            if(imagen != null){
                //get width and bla bla bla
                int pixelInt = imagen.getRGB(20, 10);
                Color pixelColor = new Color(pixelInt);
                System.out.println("R= "+ pixelColor.getRed());
                WritableRaster bitmap = (WritableRaster) imagen.getData();
                WritableRaster tesela = bitmap.createWritableChild(pixelInt, pixelInt, pixelInt, pixelInt, pixelInt, pixelInt, bandList);
                
                BufferedImage nuevaIMagen = new BufferedImage(imagen.getRGB(pixelInt, pixelInt), tesela, imagen.isAlphaPremultiplied());
                
            }
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ExplicacionesPractica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
