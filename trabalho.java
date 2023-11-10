import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Brighten_RGB_2 implements PlugInFilter {

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    static final int R = 0;
    static final int G = 1;
    static final int B = 2; 
    
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    static final int DECREMENTO = 10;
    
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    public int setup(String arg, ImagePlus imp) {
        return DOES_RGB; // this plugin works on RGB images
    }

    public void run(ImageProcessor ip) {
        ColorProcessor cp      = (ColorProcessor) ip;
        int[] pixel            = new int[3];
        final int totalLinhas  = cp.getHeight();
        final int totalColunas = cp.getWidth();

        for (int v = 0; v < totalLinhas; ++v) {
            for (int u = 0; u < totalColunas; ++u) {
                cp.getPixel(u, v, pixel);
                pixel[R] = Math.max(pixel[R] - DECREMENTO, 0); 
                pixel[G] = Math.max(pixel[G] - DECREMENTO, 0);
                pixel[B] = Math.max(pixel[B] - DECREMENTO, 0);
                cp.putPixel(u, v, pixel);
            }
        }
    }
}