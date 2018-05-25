/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
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
        BufferedImage subImage;
        int row =0, col=0;
        for(row = 0; row+height <= imgHeight;  row += height){
            for(col = 0; col+width <= imgWidth; col += width){
                subImage = img.getSubimage(col, row, width, height);
                teselas.add(new Tesela(row, col, height, width, subImage));
            }
        }

        return teselas;
    }
    
    // Calcula la media de una imagen.
    public static float calcularMedia(BufferedImage img) {
        float mean = 0;
        Color RGB;
        
        for(int i = 0; i < img.getHeight(); i++) {
            for(int j = 0; j < img.getWidth(); j++) {
                RGB = new Color(img.getRGB(j, i));
                mean += (RGB.getRed()+ RGB.getGreen() + RGB.getBlue()) / 3;
            }
            
        }
        int size = img.getHeight() * img.getWidth();
        mean /= size;
        
        return mean;
    }
    
    // Pintar una tesela en negro.
    public static BufferedImage tesela_to_black(BufferedImage img, Tesela tesela) {
        for(int row = tesela.getX(); row < tesela.getX()+tesela.getHeight(); row ++) {
            for(int col = tesela.getY(); col < tesela.getY()+tesela.getWidth(); col++) {
                img.setRGB(col, row, new Color(0,0,0).getRGB());
            }
        }
        return img;
    }
    
    // Meter en una tesela la media de la tesela.
    public static BufferedImage tesela_to_mean(BufferedImage img, Tesela tesela) {
        Color pixel;
        int sumR = 0, sumG = 0, sumB = 0;
        for(int row = tesela.getX(); row < tesela.getX()+tesela.getHeight(); row ++) {
            for(int col = tesela.getY(); col < tesela.getY()+tesela.getWidth(); col++) {
                pixel = new Color(img.getRGB(col,row));
                sumR += pixel.getRed();
                sumG += pixel.getGreen();
                sumB += pixel.getBlue();

            }
        }
        int size = tesela.getHeight() * tesela.getWidth();
        sumR /= size;
        sumG /= size;
        sumB /= size;

        for(int row = tesela.getX(); row < tesela.getX()+tesela.getHeight(); row ++) {
            for(int col = tesela.getY(); col < tesela.getY()+tesela.getWidth(); col++) {
                img.setRGB(col, row, new Color(sumR,sumG,sumB).getRGB());
                
            }
        }
        return img;
    }
    
    // Meter en una tesela la media de la tesela.
    public static BufferedImage tesela_to_mean_allImg(BufferedImage img, Tesela tesela) {
        Color pixel;
        int sumR = 0, sumG = 0, sumB = 0;
        for(int row = 0; row < img.getHeight(); row ++) {
            for(int col = 0; col < img.getWidth(); col++) {
                pixel = new Color(img.getRGB(col,row));
                sumR += pixel.getRed();
                sumG += pixel.getGreen();
                sumB += pixel.getBlue();

            }
        }
        int size = img.getHeight() * img.getWidth();
        sumR /= size;
        sumG /= size;
        sumB /= size;

        for(int row = tesela.getX(); row < tesela.getX()+tesela.getHeight(); row ++) {
            for(int col = tesela.getY(); col < tesela.getY()+tesela.getWidth(); col++) {
                img.setRGB(col, row, new Color(sumR,sumG,sumB).getRGB());
                
            }
        }
        return img;
    }
    
    public static BufferedImage copy_img(BufferedImage img) {
        ColorModel cm = img.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = img.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    
    // Meter una tesela de base a destino.
    public static BufferedImage intercambio_tesela(BufferedImage img_base, BufferedImage img_destino, int tposX, int tposY,int size_tesela) {

        // Cogemos el color de un pixel de la tesela de la imagen base
        // y la metemos en el mismo pixel per en imagen destino.
        for(int x = tposX; x < tposX+size_tesela; x++) {
            for(int y = tposY; y < tposY+size_tesela; y++) {
                img_destino.setRGB(y, x, img_base.getRGB(y, x));
            }
        }
        
        return img_destino;
    }
    
}
