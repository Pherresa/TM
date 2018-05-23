/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

/**
 *
 * @author chyoonyo7
 */
public class Encode {
    
    private int nPixelsTile;
    private int seekRange;
    private int GOP;
    private float quality;
    
    public Encode(int nPixelsTile, int seekRange, int GOP, float quality) {
        this.nPixelsTile = nPixelsTile;
        this.seekRange = seekRange;
        this.GOP = GOP;
        this.quality = quality;
    }
    

    public int getnTilesX() {
        return nPixelsTile;
    }

    public void setnTilesX(int nPixelsTile) {
        this.nPixelsTile = nPixelsTile;
    }

    public int getSeekRange() {
        return seekRange;
    }

    public void setSeekRange(int seekRange) {
        this.seekRange = seekRange;
    }

    public int getGOP() {
        return GOP;
    }

    public void setGOP(int GOP) {
        this.GOP = GOP;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    
}
