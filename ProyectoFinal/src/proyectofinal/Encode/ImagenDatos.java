/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author chyoonyo7.alumnes
 */
public class ImagenDatos implements Serializable{
    private BufferedImage img;
    private ArrayList<DatosCoincidencia>datos;

    
    public ImagenDatos(BufferedImage img, ArrayList<DatosCoincidencia> d) {
        this.img = img;
        this.datos = d;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public ArrayList<DatosCoincidencia> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<DatosCoincidencia> datos) {
        this.datos = datos;
    }   
    
    
}
