/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Parser;
import com.beust.jcommander.Parameter;
/**
 *
 * @author pablo
 */
public class ArgumentParser {
    @Parameter(names = {"--input", "-i"}, description = "Path to file.zip",
            required = true, validateWith = inputValidator.class )
    private String input;
    
    @Parameter(names = {"--output", "-o"}, description = "Path to file.zip output",
            required = true, validateWith = outputValidator.class)
    private String output;
    
    @Parameter(names = {"--encode", "-e"}, description = "Encode the images")
    private boolean encode = false;
    
    @Parameter(names = {"--decode", "-d"}, description = "Decode the images")
    private boolean decode = false;
    
    @Parameter(names = {"--fps"}, description = "Frames per second to reproduce the video", 
            required = true, validateWith = fpsValidator.class)
    private int fps;
    
    @Parameter(names = {"--binarization"}, description = "Binarization filter threshold",
            validateWith = binValidator.class)
    private int binarizaton = 0;
    
    @Parameter(names = {"--negative"}, description = "Apply a negative filter")
    private boolean negative = false;
    
    @Parameter(names = {"--averaging"}, description = "Apply an average filter",
            validateWith = avValidator.class)
    private int averaging = 0;
    
    @Parameter(names = {"--ntiles"}, description = "Number of tiles X x Y",
            validateWith = integerValidator.class)
    private int ntiles = 0;
    
    @Parameter(names = {"--seekRange"}, description = "Maximum displacement while search adjacent tessels",
            validateWith = integerValidator.class)
    private int seekRange = 1;
    
    @Parameter(names = {"--GOP",}, description = "GOP", 
            validateWith = integerValidator.class)
    private int gop = 5;
    
    @Parameter(names = {"--quality"}, description = "Quality factor to determine if two tessels are coincident",
            validateWith = floatValidator.class)
    private float quality = 0;
    
    @Parameter(names = {"-b", "--batch"}, description = "Batch mode")
    private boolean batchMode = false;

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }

    public boolean isEncode() {
        return encode;
    }

    public void setEncode(boolean encode) {
        this.encode = encode;
    }

    public boolean isDecode() {
        return decode;
    }

    public void setDecode(boolean decode) {
        this.decode = decode;
    }

    /**
     * @return the fps
     */
    public int getFps() {
        return fps;
    }

    /**
     * @param fps the fps to set
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /**
     * @return the binarizaton
     */
    public int getBinarizaton() {
        return binarizaton;
    }

    /**
     * @param binarizaton the binarizaton to set
     */
    public void setBinarizaton(int binarizaton) {
        this.binarizaton = binarizaton;
    }

    /**
     * @return the negative
     */
    public boolean isNegative() {
        return negative;
    }

    /**
     * @param negative the negative to set
     */
    public void setNegative(boolean negative) {
        this.negative = negative;
    }

    /**
     * @return the averaging
     */
    public int getAveraging() {
        return averaging;
    }

    /**
     * @param averaging the averaging to set
     */
    public void setAveraging(int averaging) {
        this.averaging = averaging;
    }

    public int getNtiles() {
        return ntiles;
    }

    public void setNtiles(int ntiles) {
        this.ntiles = ntiles;
    }

    public int getSeekRange() {
        return seekRange;
    }

    public void setSeekRange(int seekRange) {
        this.seekRange = seekRange;
    }

    public int getGop() {
        return gop;
    }

    public void setGop(int gop) {
        this.gop = gop;
    }


    public float getQuality() {
        return quality;
    }


    public void setQuality(float quality) {
        this.quality = quality;
    }


    public boolean isBatchMode() {
        return batchMode;
    }


    public void setBatchMode(boolean batchMode) {
        this.batchMode = batchMode;
    }

}
