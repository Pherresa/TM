/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Utils {
    
    /**
     * 
     * @param img, imagen a teselar
     * @param height, altura de la tesela
     * @param width, anchura de la tesela
     * @return, lista de teselas.
     */
    public static ArrayList<Tesela> teselar_imagen(BufferedImage img, int height, int width){
        int imgHeight = img.getHeight();
        int imgWidth = img.getWidth();
        ArrayList<Tesela> teselas = new ArrayList();
        int index = 0;
        BufferedImage subImage;
        int tesela_row = 0, tesela_col = 0;
        System.out.println(imgHeight+" "+imgWidth);
        for(int row = 0; row+height <= imgHeight;  row += height){
            tesela_col = 0;
            for(int col = 0; col+width <= imgWidth; col += width){
                subImage = img.getSubimage(row, col, width, height);
                teselas.add(new Tesela(row, col, height, width, subImage, 
                        index,tesela_row, tesela_col));
                index++;
                tesela_col++;
                
                System.out.println(row+" "+col);
            }
            tesela_row++;
        }
       return teselas;
    }
    
    public static float calcularMedia(BufferedImage img) {
        float mean = 0;
        Color RGB;
        
        for(int i = 0; i < img.getHeight(); i++) {
            for(int j = 0; j < img.getWidth(); j++) {
                RGB = new Color(img.getRGB(i, j));
                mean += (RGB.getRed()+ RGB.getGreen() + RGB.getBlue()) / 3;
            }
            
        }
        int size = img.getHeight() * img.getWidth();
        mean /= size;
        
        return mean;
    }
    
    // Pintar una tesela en negro.
    public static void tesela_to_black(BufferedImage img, Tesela tesela) {
        for(int row = tesela.getX(); row < tesela.getHeight(); row ++) {
            for(int col = tesela.getY(); col < tesela.getWidth(); col++) {
                img.setRGB(row, col, new Color(0,0,0).getRGB());
            }
        }
    }
    
    
}