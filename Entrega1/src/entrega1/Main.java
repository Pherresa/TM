/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import entrega1.Parser.ArgumentParser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
public class Main {

    ArgumentParser args;
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
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
        //TODO ABRIR ZIP, LEER IMAGENES Y APLICAR FILTROS.
        
        // Para poder mostrar a los fps que pida user.
        long time_before, time_after;
        int fps = 10; // AHora mismo imprimo cada 1 segundo.
        int ms_sleep;
       
        BufferedImage image; // Imagen a mostrar.
        Filtres filtre = new Filtres(); // Clase donde tenemos implementado los filtros.
        ArrayList<BufferedImage> images = new ArrayList();
        JFrame frame = new JFrame(); // Ventana donde se mostrará la imagen.
        JLabel jlabel = new JLabel(); // Etiqueta donde metemos imagen y este metemos en la ventana.
        ZipFile zf; // Para abrir archivos .zip
        ZipEntry entry;
        ZipOutputStream zous;
                
        try{
            // Abrimos archivo zip de donde cogemos imagenes.
            zf = new ZipFile(this.args.getInput());
            // Zip donde guardaremos las imagenes.
            zous = new ZipOutputStream(new FileOutputStream(this.args.getOutput()));
            
            // Convertimos en "lista" la entrada de imagenes.
            Enumeration<? extends ZipEntry> entries = zf.entries();
            
            //** CARGAMOS Y GUARDAMOS IMAGENES, CON FILTRO SI HACE FALTA **//
            int i = 0; // variable de prueba.
            while(entries.hasMoreElements()) {               
                // Obtenemos una imagen.
                entry = entries.nextElement();
                image = ImageIO.read(zf.getInputStream(entry));
                
                //** APLICAMOS FILTROS **//
                
                //image = filtre.binaritzacio(image, 70);
                //image = filtre.negatiu(image);
                //image = filtre.averaging(image, 3);
                
                // Estos dos son opcionales, solo quiero probar.
                //image = filtre.B_N(image);
                //image = filtre.sepia(image);
                
                //** HASTA AQUI FILTROS **//
                
                images.add(image); // Añadimos a la lista para despues reproducir.
                
                //** GUARDAMOS IMAGEN EN .zip **//
                // TODO
                // zous.putNextEntry(new ZipEntry("result"+i+".jpeg"));
                // ImageIO.write(image, "jpeg", zous);
                
                i++;
            }
            // Cerramos zips, tanto el de entrada como salida.
            //zou.close();
            zf.close();
            
            //** REPRODUCIMOS VIDEO. **//
            // Visualizamos imagenes.
            frame.setVisible(true);
            for (BufferedImage img : images) {
                
                time_before = System.currentTimeMillis();
                
                jlabel.setIcon(new ImageIcon(img)); // Añadimos la imagen al label.
                frame.getContentPane().add(jlabel);
                frame.pack();
                
                // Calculamos si hay que hacer un sleep o no.
                time_after = System.currentTimeMillis();
                ms_sleep = (1000/fps) - (int) (time_after - time_before);
                try {
                    if(ms_sleep > 0)
                        Thread.sleep(ms_sleep);
                } catch(InterruptedException e) {
                    
                }
            }

        }catch(IOException e) {
            
        }
    }
    
    
}
