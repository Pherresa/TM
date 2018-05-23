/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.image.BufferedImage;

/**
 *
 * @author chyoonyo7.alumnes
 */
public class Tesela {
    /*
    * x,y posicion inicio de la tesela.
    * height, widht lo que ocupara
    * index, posicion de la tesela en la lista de teselas
    * content, contenido(subImagen) de la tesela.
    */
    private int x, y, height, width, index;
    private BufferedImage content;
    
    public Tesela(int x, int y, int h, int w, BufferedImage content, int index) {
        this.x = x;
        this.y = y;
        this.height = h;
        this.width = w;
        this.content = content;
        this.index = index;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public BufferedImage getContent() {
        return content;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setContent(BufferedImage content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
}
