/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Utils {
    
    
    public List<Tesela> teselar(BufferedImage imagen, int height, int width){
        int iHeight = imagen.getHeight();
        int iWidth = imagen.getWidth();
        List<Tesela> teselas = new ArrayList<Tesela>();
        int index = 0;
        BufferedImage data;
        for(int j = 0; j  <= iHeight;  j += height){
            for(int i = 0; i <= iWidth; i += width){
                data = imagen.getSubimage(i, j, width, height);
                Tesela tesela = new Tesela(i,j, height, width, data, index);
                teselas.add(tesela);
                index++;
            }
        }
       return teselas;
    }
}
