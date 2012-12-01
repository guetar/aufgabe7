
import java.awt.geom.Point2D;
import java.util.HashMap;


/**
 *
 * @author guetar
 */
public class Track {
    
    private HashMap<Point2D.Double, CarQuick> cars;
    private int width;
    private int height;
    private int limitMove;
    private int limitColl;
    private boolean limitReached;
    
    public Track(int width, int height, int limitMove, int limitColl) {
        cars = new HashMap<Point2D.Double, CarQuick>();
        this.width = width;
        this.height = height;
        this.limitMove = limitMove;
        this.limitColl = limitColl;
    }
    
    public HashMap<Point2D.Double, CarQuick> getCars() {
        return this.cars;
    }
    
    public void setLimitReached(boolean r) {
        this.limitReached = r;
    }
    
    public boolean getLimitReached() {
        return limitReached;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getLimitMove() {
        return limitMove;
    }
    
    public int getLimitColl() {
        return limitColl;
    }
}