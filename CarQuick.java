
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    protected String name;
    protected Track track;
    protected char o;
    protected char pic;
    protected Point2D.Double pos;
    protected int movements;
    protected int collisions;
    protected HashMap<Character, Character> symbols;
    
    public CarQuick(String name, int x, int y, char o, Track track) {
        this.name = name;
        this.pos = new Point2D.Double(x, y);
        this.o = o;
        this.movements = 0;
        this.collisions = 0;
        this.track = track;
        
        symbols = new HashMap<Character, Character>();
        symbols.put('n','^');
        symbols.put('s','v');
        symbols.put('o','>');
        symbols.put('w','<');
        this.pic = symbols.get(o);
    }
    
    @Override
    public void run(){
        while(!track.getLimitReached()){
            try {
                sleepWhileDrive();
                move(getRandMove());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            catch(OutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
    
    }
    
    public void sleepWhileDrive() throws InterruptedException {
        sleep(1000);
    }
    
    public int getRandMove() {
        Random rg=new Random();
        return rg.nextInt(3)+2;
    }
    
    public void setPos(int x, int y, char orientation) throws OutOfBoundsException {
        if(x < 0 || x > track.getWidth() || y < 0 || y > track.getHeight()) {
            throw new OutOfBoundsException();
        } else {
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
            this.o = orientation;

            track.getCars().put(pos, this);
            
            System.out.println(name + " moved to " + posToString());
            System.out.println(track);
            }
        }
        
    }
    
    public void setPic(char pic) {
        this.pic = pic;
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
            System.out.println(name + " reached Limit of Movements!");
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
                System.out.println(name + " cannot move in specified direction!");
                break;
        }
    }
    
    private void diagLeft() throws OutOfBoundsException{
        System.out.println(name + " is moving diagLeft from " + posToString());
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
        setPic(symbols.get(o));
    }
    
    private void forward() throws OutOfBoundsException{
        System.out.println(name + " is moving forward from " + posToString());
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
        setPic(symbols.get(o));
    }
    
    private void diagRight()throws OutOfBoundsException{
        System.out.println(name + " is moving diagRight from " + posToString());
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
        setPic(symbols.get(o));
    }
    
    public String toString() {
        String s = ""+pic;
        return s;
    }
    
    public String posToString() {
        DecimalFormat d = new DecimalFormat("#");
        return "("+d.format(pos.x)+","+d.format(pos.y)+")";
    }
}
