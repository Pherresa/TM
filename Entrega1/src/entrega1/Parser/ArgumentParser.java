/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1.Parser;
import com.beust.jcommander.Parameter;
import java.util.ArrayList;
/**
 *
 * @author pablo
 */
public class ArgumentParser {
    @Parameter(names = {"--input", "-i"}, description = "Path to file.zip", required = true )
    private String input;
    
    @Parameter(names = {"--output", "-o"}, description = "Path to file output")
    private String output;
    
    @Parameter(names = {"--encode", "-e"}, description = "Encode the images")
    private boolean encode = false;
    
    @Parameter(names = {"--decode", "-d"}, description = "Decode the images")
    private boolean decode = false;
    
    @Parameter(names = {"--fps"}, description = "Frames per second to reproduce the video")
    private int fps = 24;
    
    @Parameter(names = {"--binarization"}, description = "Binarization filter threshold")
    private int binarizaton = 0;
    
    @Parameter(names = {"--negative"}, description = "Apply a negative filter")
    private boolean negative = false;
    
    @Parameter(names = {"--averaging"}, description = "Apply an average filter")
    private int averaging = 0;
    
    @Parameter(names = {"--ntiles"}, description = "Number of tiles X x Y")
    private ArrayList ntiles = new ArrayList(new ArrayList());
    
    @Parameter(names = {"--seekRange"}, description = "Maximum displacement while search adjacent tessels")
    private int seekRange = 1;
    
    @Parameter(names = {"--GOP",}, description = "GOP")
    private int gop = 5;
    
    @Parameter(names = {"--quality"}, description = "Quality factor to determine if two tessels are coincident")
    private int quality = 0;
    
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

    /**
     * @return the encode
     */
    public boolean isEncode() {
        return encode;
    }

    /**
     * @param encode the encode to set
     */
    public void setEncode(boolean encode) {
        this.encode = encode;
    }

    /**
     * @return the decode
     */
    public boolean isDecode() {
        return decode;
    }

    /**
     * @param decode the decode to set
     */
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

    /**
     * @return the ntiles
     */
    public ArrayList getNtiles() {
        return ntiles;
    }

    /**
     * @param ntiles the ntiles to set
     */
    public void setNtiles(ArrayList ntiles) {
        this.ntiles = ntiles;
    }

    /**
     * @return the seekRange
     */
    public int getSeekRange() {
        return seekRange;
    }

    /**
     * @param seekRange the seekRange to set
     */
    public void setSeekRange(int seekRange) {
        this.seekRange = seekRange;
    }

    /**
     * @return the gop
     */
    public int getGop() {
        return gop;
    }

    /**
     * @param gop the gop to set
     */
    public void setGop(int gop) {
        this.gop = gop;
    }

    /**
     * @return the quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * @return the batchMode
     */
    public boolean isBatchMode() {
        return batchMode;
    }

    /**
     * @param batchMode the batchMode to set
     */
    public void setBatchMode(boolean batchMode) {
        this.batchMode = batchMode;
    }
}
