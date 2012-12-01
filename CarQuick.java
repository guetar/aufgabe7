
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
    protected int movements;
    protected int collisions;
    
    public CarQuick(int x, int y, char orientation, Track track) {
        this.pos = new Point2D.Double(x, y);
        this.orientation = orientation;
        this.track = track;
    }
    
    public void setPos(int x, int y, char orientation) {
        if(x < 0 || x > track.getWidth() || y < 0 || y > track.getHeight()) {
            System.out.println("Out of Bounds!");
            return;
        }
        
        Point2D.Double newPos = new Point2D.Double(x, y);
        
        if(track.getCars().containsKey(newPos)) {
            System.out.println("Collision!");
            
            CarQuick car = track.getCars().get(newPos);
            if((orientation == 'n' && car.getOrient() == 's')
            || (orientation == 's' && car.getOrient() == 'n')
            || (orientation == 'w' && car.getOrient() == 'o')
            || (orientation == 'o' && car.getOrient() == 'w'))
            {
                car.drivenInto();
            }
            driveInto();
            return;
        }
        
        track.getCars().remove(pos);
        
        pos.setLocation(x, y);
        this.orientation = orientation;
        
        track.getCars().put(pos, this);
    }
    
    public Point2D.Double getPos() {
        return pos;
    }
    
    public char getOrient() {
        return orientation;
    }
    
    public int x() {
        return (int) pos.getX();
    }
    
    public int y() {
        return (int) pos.getY();
    }
    
    public void driveInto() {
        collisions++;
        if(collisions >= track.getLimitColl()) {
            System.out.println("Limit of collisions reached!");
            track.setLimitReached(true);
        }
    }
    
    public void drivenInto() {
        collisions--;
    }
    
    public void move(int dir) {
        if(track.getLimitReached()) {
            return;
        }
        
        movements++;
        if(movements > track.getLimitMove()) {
            System.out.println("Limit of Movements reached!");
            return;
        }
        
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
        switch(orientation) {
            case 'n':
                setPos(x()-1, y()-1, 'w');
                break;
            case 's':
                setPos(x()+1, y()+1, 'o');
                break;
            case 'w':
                setPos(x()-1, y()+1, 's');
                break;
            case 'o':
                setPos(x()+1, y()-1, 'n');
                break;
            default:
                break;
        }
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
        switch(orientation) {
            case 'n':
                setPos(x()+1, y()-1, 'o');
                break;
            case 's':
                setPos(x()-1, y()+1, 'w');
                break;
            case 'w':
                setPos(x()-1, y()-1, 'n');
                break;
            case 'o':
                setPos(x()+1, y()-1, 's');
                break;
            default:
                break;
        }
    }
}
