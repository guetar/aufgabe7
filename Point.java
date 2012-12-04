
/**
 *
 * @author guetar
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}