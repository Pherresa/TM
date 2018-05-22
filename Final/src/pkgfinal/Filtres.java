/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 *
 * @author YOON
 */
public class Filtres {
    public Filtres(){
        
    }
    
    // Binarizar imagen.
    public BufferedImage binaritzacio(BufferedImage image, int threshold) {
        int ancho = image.getWidth();
        int alto = image.getHeight();
        BufferedImage result = new BufferedImage(ancho, alto, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage img_gray = this.B_N(image); // Convertimos en blanco y negro.
        
        for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                Color c = new Color(img_gray.getRGB(i, j));
                Color newColor;
                // Al haber pasado imagen a blanco y negro, sabemos que los
                // 3 canales RGB tienen el mismo valor.
                // Por eso nos basta con mirar solo 1.
                // Si color de pixel es mas pequeño que valor umbral, entonces
                // este pixel pasamos a 0, si no, a 255.
                if(c.getRed() < threshold) {
                    newColor = new Color(0, 0, 0);

                } else {
                    newColor = new Color(255, 255, 255);
                }
                
                // Metemos en la imagen resultado el filtro aplicado en (i,j) pixel.
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        return result;
    }
    
    // Filtro negativo.
    public BufferedImage negatiu(BufferedImage image) {
        int ancho = image.getWidth();
        int alto = image.getHeight();
        BufferedImage result = new BufferedImage(ancho, alto, BufferedImage.TYPE_3BYTE_BGR);
        int r, g, b;
        // Vamos pixel por pixel.
        for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                Color c = new Color(image.getRGB(i, j)); // Obtenemos colores rgb.
                // Aplicamos formula para filtro negativo.
                r = 255 - c.getRed();
                g = 255 - c.getGreen();
                b = 255 - c.getBlue();
                
                // Creamos color
                Color newColor = new Color(r, g, b);
                
                // Metemos en la imagen resultado el filtro aplicado en (i,j) pixel.
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        
        return result;
    }
    
    // Filtra de la mitjana
    public BufferedImage averaging(BufferedImage image, int valor) {
        
        float weight = 1.0f / (valor * valor);
        float[] data = new float[valor * valor];

        for (int i = 0; i < data.length; i++) {
            data[i] = weight;
        }

        Kernel kernel = new Kernel(valor,valor,data);
        BufferedImageOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage blurred = op.filter(image, null);
        
        return blurred;
    }
    
    // Convertir en blanco y negro.
    // mas info: https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm
    public BufferedImage B_N(BufferedImage image) {
        int ancho = image.getWidth();
        int alto = image.getHeight();
        BufferedImage result = new BufferedImage(ancho, alto, BufferedImage.TYPE_3BYTE_BGR);
        int r, g, b;
        for(int	i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++){
                Color c = new Color(image.getRGB(i, j));
                
                r = (int)(c.getRed() * 0.299);
                g = (int)(c.getGreen() * 0.587);
                b = (int)(c.getBlue() * 0.114);
                
                Color newColor = new Color(r+g+b, r+g+b, r+g+b);
                
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        
        return result;
    }
    
    // Convertir imagen con filtre sepia.
    public BufferedImage sepia(BufferedImage image) {
        int ancho = image.getWidth();
        int alto = image.getHeight();
        BufferedImage result = new BufferedImage(ancho,alto,BufferedImage.TYPE_3BYTE_BGR);
        int red, green, blue, r, g, b;
        
        for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                Color c	= new Color(image.getRGB(i, j));
                
                // Aplicamos filtro sepia.
                red = (int) (c.getRed());
                green = (int) (c.getGreen());
                blue = (int) (c.getBlue());
                r = (int) ((red * 0.393)+(green * 0.769)+(blue * 0.189));
                g = (int) ((red * 0.349)+(green * 0.686)+(blue * 0.168));
                b = (int) ((red * 0.272)+(green * 0.534)+(blue * 0.131));
                if (r>255)  r=255;
                if (g>255)  g=255;
                if (b>255)  b=255;
                
                // Añadimos resultado del pixel a result.
                Color newColor = new Color(r,g,b);
                result.setRGB(i, j,newColor.getRGB());
            }
        }
        return result;
    }
}
