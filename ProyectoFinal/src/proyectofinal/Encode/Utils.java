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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        for(int row = 0; row+height <= imgHeight;  row += height){
            tesela_col = 0;
            for(int col = 0; col+width <= imgWidth; col += width){
                subImage = img.getSubimage(col, row, width, height);
                teselas.add(new Tesela(row, col, height, width, subImage, 
                        index,tesela_row, tesela_col));
                index++;
                tesela_col++;
            }
            tesela_row++;
        }
       return teselas;
    }
    
    // Calcula la media de una imagen.
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
    
    
    /** Funciones para pasar a Bytes y viceversa **/
    /**
    private final String BIG_ENDIAN = "be";
    private final String LITTLE_ENDIAN = "le";
    private final int INT_LENGTH = 4;
    private final int SHORT_LENGTH = 2;
    
    // De DatosCoincidencia a bytes.
    public InputStream vectorsToInputStream(ArrayList<DatosCoincidencia> datos) {
        ArrayList<Byte> buff = new ArrayList();
        
        for(DatosCoincidencia dato : datos)
            vectorToByte(buff, dato);
        
        // Pasamos lista a bytes.
        byte[] result = new byte[buff.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) buff.get(i);
        }
        return new ByteArrayInputStream(result);           
    }
    
    // De Bytes a DatosCoincidencia
    public ArrayList<DatosCoincidencia> inputStreamToVectors(InputStream stream) {
        byte[] bytes = inputStreamToByte(stream);
        
        ArrayList<DatosCoincidencia> datos = new ArrayList();
        short index_reference_img, index_tesela, x, y;
        for(int i = 0; i < bytes.length;){
            index_reference_img = bytesToShort16(new byte[] {bytes[i++],bytes[i++]}, BIG_ENDIAN);
            x = byteToShort16(bytes[i++]);
            y = byteToShort16(bytes[i++]);
            vectors.add(new DVector(reference,x, y));
        }
        return vectors;
    }
    
    private void vectorToByte(ArrayList<Byte> buff, DatosCoincidencia dato){
        write_short16(buff, (short)dato.getIndex_img_referencia());
        write_short16(buff, (short)dato.getIndex_tesela());
        write_shortAs8(buff, (short)dato.getX());
        write_shortAs8(buff, (short)dato.getY());
        
    }
    
    private void write_short16(ArrayList<Byte> buff,  short num)
    {
        byte bytes[] = new byte[SHORT_LENGTH];
        short16ToBytes(num,bytes, BIG_ENDIAN);
        // try with short
        for(int i = 0; i < SHORT_LENGTH; i++)
        {
            buff.add(bytes[i]);
        }
    }
    
    private byte[] inputStreamToByte(InputStream is){
        // Define a size if you have an idea of it.
        ByteArrayOutputStream r = new ByteArrayOutputStream();
        byte[] read = new byte[512]; // Your buffer size.
        try {
            for (int i; -1 != (i = is.read(read)); r.write(read, 0, i));
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r.toByteArray();
    }
    
    
    private short byteToShort16(byte number) {
        short result;
        result = (short) number;
        
        return result;
    }
     */
}
