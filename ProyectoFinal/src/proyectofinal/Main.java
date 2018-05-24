/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import proyectofinal.Parser.ArgumentParser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import proyectofinal.Encode.Encode;
import proyectofinal.Encode.ReproductorImagenes;

/**
 *
 * @author pablo
 */
public class Main {

    ArgumentParser args;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArgumentParser arguments = new ArgumentParser();
        try{
            
            JCommander jc = new JCommander(arguments, args);
            Main main2 = new Main(arguments);
            
        } catch(ParameterException e){
            System.out.println("Error : " + e.getMessage());
        }
    }

    private Main(ArgumentParser arguments) {
        this.args = arguments;
        
        boolean aver = false;
        boolean bina = false;
        if (arguments.getAveraging() != 0){
            aver = true;
        }
        if(arguments.getBinarizaton() != 0){
            bina = true;
        }

        BufferedImage image; // Imagen a mostrar.
        Filtres filtre = new Filtres(); // Clase donde tenemos implementado los filtros.
        ArrayList<BufferedImage> images = new ArrayList();
        ZipFile zf; // Para abrir archivos .zip
        ZipOutputStream zout;
                
        try{
            // Abrimos archivo zip de donde cogemos imagenes.
            zf = new ZipFile(this.args.getInput());
            // Zip donde guardaremos las imagenes.
            zout = new ZipOutputStream(new FileOutputStream("imagenesJPEG.zip"));
            
            // Convertimos en "lista" la entrada de imagenes.
            Enumeration<? extends ZipEntry> entries = zf.entries();
            
            //** CARGAMOS Y GUARDAMOS IMAGENES, CON FILTRO SI HACE FALTA **//
            int i = 0; // variable de prueba.
            while(entries.hasMoreElements()) {               
                // Obtenemos una imagen.
                image = ImageIO.read(zf.getInputStream(entries.nextElement()));
                
                //** APLICAMOS FILTROS **//
                if(bina){
                    image = filtre.binaritzacio(image, arguments.getBinarizaton());
                }
                if(aver){
                    image = filtre.averaging(image, arguments.getAveraging());
                }
                if(arguments.isNegative()){
                    image = filtre.negatiu(image);
                }
                
                images.add(image); // Añadimos a la lista para despues reproducir.
                
                //** GUARDAMOS IMAGEN EN .zip en formato .jpeg **//
                zout.putNextEntry(new ZipEntry("result"+String.format("%02d", i)+".jpeg"));
                ImageIO.write(image, "jpeg", zout);
                
                i++;
            }
            // Cerramos zips, tanto el de entrada como salida.
            zout.close();
            zf.close();
            
            //** REPRODUCIMOS VIDEO **//
            new Thread(new ReproductorImagenes(images, args.getFps())).start();
            
            /** Encode **/
            /*Encode encode = new Encode(this.args.getNtiles(), 
                    this.args.getSeekRange(), this.args.getGop(), this.args.getQuality());
            */
            // 31 para 10 teselas
            Encode encode = new Encode(31, 2, 10, 20);
            encode.codificar(images);
            
            
            /** Decode **/
            
        }catch(IOException e) {
            System.out.println("ERROR con el archivo zip.");
        }
    }
    
    
}
