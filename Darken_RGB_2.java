import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;
import static java.lang.Math.max;
import static java.lang.Math.min;
public class Darken_RGB_2 implements PlugInFilter {

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    static final int R = 0;
    static final int G = 1;
    static final int B = 2; 
    
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    static final int DECREMENTO = 100;
    
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    public int setup(String arg, ImagePlus imp) {
        return DOES_RGB;
    }

    public void run(ImageProcessor ip) {
        ColorProcessor cp      = (ColorProcessor) ip;
        int[] pixel            = new int[3];
        final int totalLinhas  = cp.getHeight();
        final int totalColunas = cp.getWidth();
        final int produtoEixos = totalLinhas * totalColunas;

        for (int i = 0; i < produtoEixos; ++i) {
            int u = i % totalColunas;
            int v = i / totalColunas;
        
            cp.getPixel(u, v, pixel);
            pixel[R] = min(max(f(pixel[R]), 0), 255);
            pixel[G] = min(max(f(pixel[G]), 0), 255);
            pixel[B] = min(max(f(pixel[B]), 0), 255);
            cp.putPixel(u, v, pixel);
        }
    }

    public int f(int x) {
        return x - DECREMENTO;
    }
}
