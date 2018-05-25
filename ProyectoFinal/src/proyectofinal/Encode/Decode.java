/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 *
 * @author chyoonyo7.alumnes
 */
public class Decode {
    // Lista de imagen con su respectivo vector de datos.
    // Dentro de su vector de datos, tiene varios DatosCoincidencia
    // uno por cada tesela cambiada, en DatosCoincidencia tenemos
    // la informacion de donde recuperar esa tesela.
    private ArrayList<ImagenDatos> imgs_datos;
    
    public Decode(ArrayList<ImagenDatos> imgs_datos) {
        this.imgs_datos = imgs_datos;

    }
    
    public ArrayList<BufferedImage> decodificar(int size_tile) {
        ArrayList<BufferedImage> imgs_decoded = new ArrayList();
        ArrayList<DatosCoincidencia> datos = new ArrayList();
        BufferedImage copy_img;
        BufferedImage img_base = null;

        for(int index = 0; index < this.imgs_datos.size(); index++) {
            
            // Si es null, implica que esta imagen es una de referencia
            // la guardamos tal cual y pasamos a la siguiente.
            if(this.imgs_datos.get(index).getDatos() == null) {
                img_base = Utils.copy_img(this.imgs_datos.get(index).getImg());
                imgs_decoded.add(img_base);
                
            } else {
                // Obtenemos la lista de DatosCoincidencia,
                // cada DatoCoincidencia contiene que tesela esta modificada.
                // y pasaremos a recuperar la tesela.
                datos = this.imgs_datos.get(index).getDatos();
                
                // Obtenemos la imagen que toca recuperar.
                copy_img = Utils.copy_img(this.imgs_datos.get(index).getImg());
                
                // Recorreremos todo datos, sabemos que cada elemmento de datos
                // nos sirve para recuperar una tesela.
                for(int i = 0; i < datos.size(); i++) {
                    int tposX = datos.get(i).getX();
                    int tposY = datos.get(i).getY();
                    
                    copy_img = Utils.intercambio_tesela(img_base, copy_img, tposX, tposY, size_tile);
                }
                // Una vez decodificada añadimos imagen a la lista de imagenes decodificadas.
                imgs_decoded.add(copy_img);
            }
        }
        
        return imgs_decoded;
    }
    
    
}
