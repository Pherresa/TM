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
    * x,y, posicion inicio de la tesela.
    * height, widht lo que ocupara
    * content, contenido(subImagen) de la tesela.
    * index, posicion de la tesela en la lista de teselas
    * tesela_col, tesela_row, nos servira para poder buscar entre teselas.
    */
    private int x, y, height, width, index, tesela_row, tesela_col;
    private BufferedImage content;
    
    public Tesela(int x, int y, int h, int w, BufferedImage content, int index, int tesela_row, int tesela_col) {
        this.x = x;
        this.y = y;
        this.height = h;
        this.width = w;
        this.content = content;
        this.index = index;
        this.tesela_row = tesela_row;
        this.tesela_col = tesela_col;
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

    public int getTesela_row() {
        return tesela_row;
    }

    public void setTesela_row(int tesela_row) {
        this.tesela_row = tesela_row;
    }

    public int getTesela_col() {
        return tesela_col;
    }

    public void setTesela_col(int tesela_col) {
        this.tesela_col = tesela_col;
    }
    
    
}
