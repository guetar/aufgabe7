
import java.awt.geom.Point2D;
import java.util.HashMap;


/**
 *
 * @author guetar
 */
public class Track {
    
    private HashMap<Point2D, CarQuick> cars;
    private int width;
    private int height;
    
    public Track(int width, int height) {
        cars = new HashMap<Point2D, CarQuick>();
        this.width = width;
        this.height = height;
    }
    
    public HashMap<Point2D, CarQuick> getCars() {
        return this.cars;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
