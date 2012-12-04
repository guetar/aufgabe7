
import java.awt.Dimension;
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
    
    //VB: width!=null, height!=null, limitMove!=null, limitColl!=null
    public Track(int width, int height, int limitMove, int limitColl) {
        cars = new HashMap<Point2D.Double, CarQuick>();
        this.width = width;
        this.height = height;
        this.limitMove = limitMove;
        this.limitColl = limitColl;
    }
    
    //NB: return HashMap=allCars
    public HashMap<Point2D.Double, CarQuick> getCars() {
        return this.cars;
    }
    
    //NB: limitReached = true if limitColl reached, false otherwise
    public void setLimitReached(boolean r) {
        this.limitReached = r;
    }
    
    //NB: return true if limitColl is reached, false otherwise
    public boolean getLimitReached() {
        return limitReached;
    }
    
    //NB: width=width of Track
    public int getWidth() {
        return width;
    }
    
    //NB: height=height of Track
    public int getHeight() {
        return height;
    }
    
    //NB: limitMove=max allowed movements
    public int getLimitMove() {
        return limitMove;
    }
    
    //NB: limitColl=max allowed collisions
    public int getLimitColl() {
        return limitColl;
    }
    
    //VB: width<30
    public synchronized String toString() {
        String res = "";
        String topEnd = "*";
        
        for (int i = 0; i < width+1; i++) {
            topEnd += "*";
        }
        topEnd += "\n";
        res += topEnd;
        
        for (int y = 0; y < height; y++) {
            res += "*";
            for (int x = 0; x < width; x++) {
                CarQuick tmp = cars.get(new Point2D.Double(x,y));
                if (tmp != null) {
                    res += tmp.toString();
                } else {
                    res += " ";
                }
            }
            res += "*" + y + "\n";
        }
        
        topEnd += " ";
        
        for (int i = 0; i < width; i++) {
            if (i < 10) {
                topEnd += i;
            } else if (i < 20) {
                topEnd += "1";
            } else {
                topEnd += "2";
            }
        } 
        topEnd += "\n ";
        
        for (int i = 0; i < width; i++) {
            if (i < 10) {
                topEnd += " ";
            } else if (i < 20) {
                topEnd += i - 10;
            } else {
                topEnd += i - 20;
            }
        }
        
        return res += topEnd + "\n\n\n";
    }
}
