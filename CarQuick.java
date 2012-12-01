
import java.awt.geom.Point2D;


/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    protected Track track;
    protected char orientation;
    protected Point2D.Double pos;
    
    public CarQuick(int x, int y) {
        pos = new Point2D.Double(x, y);
    }
    
    public void setPos(int x, int y) {
        pos.setLocation(x, y);
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
                System.out.println("Cannot move in spezified direction!");
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
                setPos(x(), y()-1);
                break;
            case 's':
                setPos(x(), y()+1);
                break;
            case 'w':
                setPos(x()-1, y());
                break;
            case 'o':
                setPos(x()+1, y());
                break;
            default:
                break;
        }
        
    }
    
    private void diagRight() {
        System.out.println("moved diagRight");
    }
}
