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
    private ArrayList<BufferedImage> imgs;
    private ArrayList<DatosCoincidencia> datos;
    
    public Decode(ArrayList<BufferedImage> imgs, ArrayList<DatosCoincidencia> d) {
        this.imgs = imgs;
        this.datos = d;
    }
}
