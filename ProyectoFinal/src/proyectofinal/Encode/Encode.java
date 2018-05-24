/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Encode;

import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import java.util.ArrayList;
import proyectofinal.ReproductorImagenes;

/**
 *
 * @author chyoonyo7
 */
public class Encode {
    
    private int nPixelsTile;
    private int seekRange;
    private int GOP;
    private float quality;
    //private BufferedImage img_reference;
    private ArrayList<BufferedImage> imgs_encodeds = new ArrayList();
    
    public Encode(int nPixelsTile, int seekRange, int GOP, float quality) {
        this.nPixelsTile = nPixelsTile;
        this.seekRange = seekRange;
        this.GOP = GOP;
        this.quality = quality;
        
    }
    /** Codificamos
     * @param images **/
    public void codificar(ArrayList<BufferedImage> images) {
        ArrayList<Tesela> teselas;
        int index_img_reference =0;
        BufferedImage img_reference = null, img_copy;
        
        ArrayList<DatosCoincidencia> datos = new ArrayList();
        DatosCoincidencia vector_datos;
        int count = 0;
        for(int index_img = 0; index_img < images.size(); index_img++) {
            // Si indice es multiplo del valor GOP, quiere decir que empezamos
            // subconjunto de imagenes. Ejemplo, si GOP = 5, para valores index
            // 0, 5, 10, 15, etc, empezaremos subconjunto.
            // Guardamos imagen tal cual.
            if(index_img % this.GOP == 0) {
                index_img_reference = index_img;
                img_reference = images.get(index_img);
                this.imgs_encodeds.add(Utils.copy_img(img_reference));
                
            } else { // Si no, buscamos coincidencia con la imagen de referencia.
                img_copy = Utils.copy_img(images.get(index_img));
                teselas = Utils.teselar_imagen(img_copy, 
                        this.nPixelsTile,this.nPixelsTile);
                
                // Pasamos a buscar teselas parecidas.
                for(Tesela t_destino : teselas) {
                    Tesela tesela_parecida = busqueda_tesela_parecida(t_destino, 
                            img_reference);
                    
                    if(tesela_parecida != null) {
                        count++;
                        //System.out.println("Entro if "+count);
                        // index creo que se puede borrar.
                        int index_tesela = tesela_parecida.getIndex();
                        int x = tesela_parecida.getX();
                        int y = tesela_parecida.getY();
                        
                        vector_datos = new DatosCoincidencia(index_img_reference,
                                index_tesela, x, y);
                        
                        datos.add(vector_datos);
                        
                        // Borrar tesela parecida de imagen destino.
                        //System.out.println(tesela_parecida.getX() +" | "+tesela_parecida.getY());
                        img_copy = Utils.tesela_to_black(img_copy, tesela_parecida);
                    }
                    
                }
                imgs_encodeds.add(img_copy);
            }
        }
        new Thread(new ReproductorImagenes(imgs_encodeds, 4)).start();
        //new Thread(new ReproductorImagenes(images, 10)).start();
    }
    //Búsqueda logarítmica en 2D (TDL), en cruz.
    private Tesela busqueda_tesela_parecida(Tesela tesela_destino, BufferedImage img_referencia) {
        float mejor_resta = this.getQuality();
        Tesela t_mejor_candidata = null, t_referencia;
        int teselaX, teselaY;
        BufferedImage subImage;
        
        // Comprobamos solamente en cruz, es decir,
        // arriba, abajo, izquierda o derecha.
        for(int x = -this.seekRange; x <= this.seekRange; x++) { 
            if(tesela_destino.getX() + x*this.nPixelsTile < 0 ||
                    tesela_destino.getX() + x*this.nPixelsTile + this.nPixelsTile >= img_referencia.getHeight())  {
                continue; // Ejemplo, Si estoy arriba del todo, no interesa coger tesela de arriba porque no hay.
            }
            for(int y = -this.seekRange; y <= this.seekRange; y++) {
                if(tesela_destino.getY() + y*this.nPixelsTile < 0 ||
                        tesela_destino.getY() + y*this.nPixelsTile + this.nPixelsTile >= img_referencia.getWidth()) {
                    continue;// Ejemplo, Si estoy izquierda del todo, no interesa coger tesela de izquierda.
                }
                
                // Creamos tesela_base para comparar con la de destino.
                teselaX = tesela_destino.getX() + x*this.nPixelsTile;
                teselaY = tesela_destino.getY() + y*this.nPixelsTile;
                
                subImage = img_referencia.getSubimage(teselaY, teselaX, this.nPixelsTile, this.nPixelsTile);
                
                // Guardar index, row y col creo que index lo podemos borrar.
                t_referencia = new Tesela(teselaX, teselaY, this.nPixelsTile, this.nPixelsTile, 
                        subImage, tesela_destino.getIndex(), tesela_destino.getTesela_row() + x,
                        tesela_destino.getTesela_col() + y);
                
                if(Float.compare(this.resta(tesela_destino, t_referencia), this.quality) < 0) {
                    if(Float.compare(this.resta(tesela_destino, t_referencia), mejor_resta) < 0) {
                        t_mejor_candidata = t_referencia;
                        mejor_resta = this.resta(tesela_destino, t_referencia);
                    }
                }
            }
            
        }     
        return t_mejor_candidata;
    }
    
    // Calculamos la resta de dos teselas con sus respectivas medias.
    // destino = imagen actual
    // base = imagen referencia
    private float resta(Tesela t_destino, Tesela t_base) {
        float resta;
        
        // Restamos las medias de cada tesela
        // destino - base
        // NO SE SI HACERLO EN VALOR ABSOLUTO O NO
        resta = abs(Utils.calcularMedia(t_destino.getContent()) - Utils.calcularMedia(t_base.getContent()));
        //resta = Utils.calcularMedia(destino.getContent()) - Utils.calcularMedia(base.getContent());
        return resta;
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
