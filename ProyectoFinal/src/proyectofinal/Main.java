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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import proyectofinal.Encode.DatosCoincidencia;
import proyectofinal.Encode.Encode;
import proyectofinal.Encode.ImagenDatos;

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
        ArrayList<BufferedImage> images_codificadas = new ArrayList();
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
            //new Thread(new ReproductorImagenes(images, args.getFps())).start();
            
            /** Encode **/
            /*Encode encode = new Encode(this.args.getNtiles(), 
                    this.args.getSeekRange(), this.args.getGop(), this.args.getQuality());
            */
            // 31 para 10 teselas
            long time_before, time_after;
            time_before = System.currentTimeMillis();
            
            Encode encode = new Encode(20, 2, 10, 0.5f);
            ArrayList<ImagenDatos> img_codificadas;
            img_codificadas = encode.codificar(images);
            
            time_after = System.currentTimeMillis();
            System.out.print("Tiempo Codificacion: ");
            System.out.println(time_after-time_before);
            
            /** Guardamos en disco la codificacion **/
            // Zip donde guardaremos las imagenes comprimidas.
            zout = new ZipOutputStream(new FileOutputStream(this.args.getOutput()));
            //GUARDAMOS IMAGEN EN .zip en formato .jpeg
            for(int index = 0; index < img_codificadas.size(); index++) {
                zout.putNextEntry(new ZipEntry("result"+String.format("%02d", index)+".jpeg"));
                ImageIO.write(img_codificadas.get(index).getImg(), "jpeg", zout);
                
            }
            // Creamos archivo para los vectores.
            zout.putNextEntry(new ZipEntry("vectores.vec"));
            ObjectOutputStream ous = new ObjectOutputStream(zout);
            
            for(int index = 0; index < img_codificadas.size(); index++) {
                ous.writeObject(img_codificadas.get(index).getDatos());
            }

            System.out.println("Fin guardar disco");
            
            // Cerramos archivos.
            ous.close();
            zout.close();

            /** Decode **/
            // Abrimos archivo zip de donde cogemos imagenes comprimidas.
            zf = new ZipFile(this.args.getOutput());
            FileOutputStream fos;
            ObjectInputStream ois;
            InputStream is;
            // Convertimos en "lista" la entrada de imagenes.
            entries = zf.entries();
            
            
            //** CARGAMOS Y GUARDAMOS IMAGENES CODIFICADAS**//
            ArrayList<DatosCoincidencia> datos;
            ArrayList<ImagenDatos>img_datos = new ArrayList();
            ImagenDatos img_data = new ImagenDatos(null, null);
            while(entries.hasMoreElements()) {
                ZipEntry entry =  entries.nextElement();
                if(entry.getName().endsWith(".vec")) {
                    ois = new ObjectInputStream(zf.getInputStream(entry));
                    for(int j = 0; j < images_codificadas.size(); j++) {
                        img_datos.get(j).setDatos((ArrayList<DatosCoincidencia>) ois.readObject());
                    }

                } else {
                    // Obtenemos una imagen.
                    image = ImageIO.read(zf.getInputStream(entry));
                    images_codificadas.add(image);
                    img_data.setImg(image);
                    img_datos.add(new ImagenDatos(image, null));
                }
            }
            
            new Thread(new ReproductorImagenes(images_codificadas, 8)).start();
            System.out.println(img_datos.get(0).getDatos());
        }catch(IOException e) {
            System.out.println("ERROR con el archivo zip.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
