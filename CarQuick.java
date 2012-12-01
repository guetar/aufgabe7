
import java.awt.geom.Point2D;
import java.util.HashMap;


/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    protected Track track;
    protected char orientation;
    protected Point2D.Double pos;
    
    public CarQuick(int x, int y, char orientation, Track track) {
        this.pos = new Point2D.Double(x, y);
        this.orientation = orientation;
        this.track = track;
    }
    
    public void setPos(int x, int y, char orientation) {
        if(x < 0 || x > track.getWidth() || y < 0 || y > track.getHeight()) {
            System.out.println("Out of Bounds!");
        }
        if(track.getCars().containsKey(getPos())) {
            System.out.println("Collision!");
        }
        
        track.getCars().remove(getPos());
        
        pos.setLocation(x, y);
        this.orientation = orientation;
        
        track.getCars().put(getPos(), this);
    }
    
    public Point2D.Double getPos() {
        return pos;
    }
    
    public int x() {
        return (int) pos.getX();
    }
    
    public int y() {
        return (int) pos.getY();
    }
    
    public synchronized void move(int dir) {
        
        switch(dir) {
            case 2:
                diagLeft();
                break;
            case 3:
                forward();
                break;
            case 4:
                diagRight();
                break;
            default:
                System.out.println("Cannot move in specified direction!");
                break;
        }
    }
    
    private void diagLeft() {
        System.out.println("moved diagLeft");
    }
    
    private void forward() {
        System.out.println("moved forward");
        switch(orientation) {
            case 'n':
                setPos(x(), y()-1, orientation);
                break;
            case 's':
                setPos(x(), y()+1, orientation);
                break;
            case 'w':
                setPos(x()-1, y(), orientation);
                break;
            case 'o':
                setPos(x()+1, y(), orientation);
                break;
            default:
                break;
        }
        
    }
    
    private void diagRight() {
        System.out.println("moved diagRight");
    }
}