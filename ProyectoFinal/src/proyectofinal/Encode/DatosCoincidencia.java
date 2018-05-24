/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.io.Serializable;

/**
 *
 * @author chyoonyo7
 */
public class DatosCoincidencia implements Serializable {
    private int index_img_referencia;
    private int index_img_destino;
    private int x;
    private int y;
    
    public DatosCoincidencia(int index_img_referencia, int index_tesela, int x, int y) {
        this.index_img_referencia = index_img_referencia;
        this.index_img_destino = index_tesela;
        this.x = x;
        this.y = y;
    }

    public int getIndex_img_referencia() {
        return index_img_referencia;
    }

    public void setIndex_img_referencia(int index_img_referencia) {
        this.index_img_referencia = index_img_referencia;
    }

    public int getIndex_destino() {
        return index_img_destino;
    }

    public void setIndex_destino(int index_destino) {
        this.index_img_destino = index_destino;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
