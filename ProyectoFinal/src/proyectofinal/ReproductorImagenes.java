/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * Clase que implementa el paso 4 del encode.
 */
public class ReproductorImagenes implements Runnable{
    private ArrayList<BufferedImage> images = new ArrayList();
    
    JFrame frame = new JFrame(); // Ventana donde se mostrará la imagen.
    JLabel jlabel = new JLabel(); // Etiqueta donde metemos imagen y esta la metemos en la ventana.
    long time_before, time_after;
    
    private int fps;
    int ms_sleep;
    private String title;
    private int x, y;
        
    public ReproductorImagenes(ArrayList<BufferedImage> images, int fps, String title, int x, int y) {
        this.images = images;
        this.fps = fps;
        this.title = title;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void run() {
        //** REPRODUCIMOS VIDEO. **//
            // Visualizamos imagenes.
            frame.setLocation(x, y);
            frame.setTitle(this.title);
            frame.setVisible(true);
            for(int i = 0; i < images.size(); i++) {
                time_before = System.currentTimeMillis();
                
                // Metemos al frame la imagen a mostrar.
                jlabel.setIcon(new ImageIcon(images.get(i)));
                frame.add(jlabel);
                frame.pack();
                
                // Calculamos si hay que hacer un sleep o no.
                time_after = System.currentTimeMillis();
                ms_sleep = (1000/fps) - (int) (time_after - time_before);
                try {
                    if(ms_sleep > 0)
                        Thread.sleep(ms_sleep);
                } catch(InterruptedException e) {
                    
                }
                /*
                if(i+1 == images.size())
                    i = 0;
                */
            }
            
    }
    
}
