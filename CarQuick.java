
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    protected Track track;
    protected char o;
    protected Point2D.Double pos;
    protected int movements;
    protected int collisions;
    
    public CarQuick(int x, int y, char o, Track track) {
        this.pos = new Point2D.Double(x, y);
        this.o = o;
        this.movements = 0;
        this.collisions = 0;
        this.track = track;
    }
    
    @Override
    public void run(){
        Random rg=new Random();
        while(!track.getLimitReached()){
        int rand=rg.nextInt(3)+2;
            
            try {
                move(rand);
                sleep(20);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            catch(OutOfBoundsException e){
            
            }
        }
    
    }
    
    public void setPos(int x, int y, char orientation) throws OutOfBoundsException {
        if(x < 0 || x > track.getWidth() || y < 0 || y > track.getHeight()) {
            throw new OutOfBoundsException();
        }
        synchronized(this){
            Point2D.Double newPos = new Point2D.Double(x, y);
            try {
                if (track.getCars().containsKey(newPos)) {
                    throw new CollisionException();
                }
            } catch (CollisionException e) {
                CarQuick car = track.getCars().get(newPos);
                if ((o == 'n' && car.getOrient() == 's')
                        || (o == 's' && car.getOrient() == 'n')
                        || (o == 'w' && car.getOrient() == 'o')
                        || (o == 'o' && car.getOrient() == 'w')) {
                    driveInto();
                } else {
                    car.drivenInto();
                }
            }
        
        track.getCars().remove(pos);
        
        pos.setLocation(x, y);
        this.o = o;
        
        track.getCars().put(pos, this);
        }
    }
    
    public Point2D.Double getPos() {
        return pos;
    }
    
    public char getOrient() {
        return o;
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
    
    public void verifyLimits() {
//        System.out.println("x  = " + x() + " | " + "y = " + y() + " | " + "orientation = " + o);
        
        if(track.getLimitReached()) {
            return;
        }
        
        movements++;
        if(movements > track.getLimitMove()) {
            track.setLimitReached(true);
            System.out.println("Limit of Movements reached!");
            return;
        }
    }
    
    public void move(int dir) throws OutOfBoundsException{
        verifyLimits();
        
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
    
    private void diagLeft() throws OutOfBoundsException{
        System.out.println("moved diagLeft");
        switch(o) {
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
    
    private void forward() throws OutOfBoundsException{
        System.out.println("moved forward");
        switch(o) {
            case 'n':
                setPos(x(), y()-1, o);
                break;
            case 's':
                setPos(x(), y()+1, o);
                break;
            case 'w':
                setPos(x()-1, y(), o);
                break;
            case 'o':
                setPos(x()+1, y(), o);
                break;
            default:
                break;
        }
    }
    
    private void diagRight()throws OutOfBoundsException{
        System.out.println("moved diagRight");
        switch(o) {
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
                setPos(x()+1, y()+1, 's');
                break;
            default:
                break;
        }
    }
}
