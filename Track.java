
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
        synchronized(cars) {
            this.limitReached = r;
            if (r) {
                Iterator it = cars.keySet().iterator();
                while(it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    CarQuick tmp = (CarQuick) pair.getValue();
                    tmp.interrupt();
                }
            }
        }
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
    
    //VB: width < 30
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
