
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

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
    protected DriveStyle style;

    //VB: name!=null, x!=null, y!=null, o!=null, track!=null
    //NB: pic=orientation
    public CarQuick(String name, int x, int y, char o, Track track, DriveStyle style) {
        this.name = name;
        this.pos = new Point2D.Double(x, y);
        this.o = o;
        this.movements = 0;
        this.collisions = 0;
        this.track = track;
        this.style = style;

        symbols = new HashMap<Character, Character>();
        symbols.put('n', '^');
        symbols.put('s', 'v');
        symbols.put('o', '>');
        symbols.put('w', '<');
        this.pic = symbols.get(o);
    }

    @Override
    // VB: Alle Variablen != null
    // NB: run muss durch while-Schleifen-Termination beendet werden
    public void run() {
        while (!track.getLimitReached()) {
            try {
                sleepWhileDrive();
                move(style.getDirection());
            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
            } catch (OutOfBoundsException e) {
//                System.out.println(e.getMessage());
            }
        }
    }

    // NB: Das Auto ist fuer 1 Sekunde "gefahren"
    public void sleepWhileDrive() throws InterruptedException {
        sleep(1000);
    }

    //VB: x!=null, y!=null, orientation!=null
    //NB: newPos=x,y, track.getCars()=updated
    public void setPos(int x, int y, char orientation) throws OutOfBoundsException {
        this.o = orientation;         
        if (x < 0 || x >= track.getWidth() || y < 0 || y >= track.getHeight()) {
            throw new OutOfBoundsException(name);
        } else {
            // Alle anderen Thread-Objekte in cars von track > STOP
            synchronized (track.getCars()) {
                Point2D.Double newPos = new Point2D.Double(x, y);
              
                try {                   
                    if (track.getCars().containsKey(newPos)) {
                        throw new CollisionException();
                    }
                    track.getCars().remove(pos);
                    pos.setLocation(x, y);
                    track.getCars().put(pos, this);
                    setPic(symbols.get(o));

                    //System.out.println(name + " moved to " + posToString());
                    System.out.println(track);
                } catch (CollisionException e) {
                    CarQuick car = track.getCars().get(newPos);
                    if ((o == 'n' && car.getOrient() == 's')
                            || (o == 's' && car.getOrient() == 'n')
                            || (o == 'w' && car.getOrient() == 'o')
                            || (o == 'o' && car.getOrient() == 'w')) {
                        
                        System.out.println("FRONT COLLISION!");
                        System.out.println(name + ": " + (collisions + 2));
                        System.out.println("");
                        
                        driveInto(2);
                    } else {
                        System.out.println("SIDE COLLISION!!");
                        System.out.println(name + ": " + (collisions + 1));
                        System.out.println("");
                        
                        driveInto(1);
                        car.drivenInto();
                    }
                }

            }
        }

    }

    // VB: Korrektes Character uebergeben (1 von 4 gueltige)
    // NB: Character korrekt gesetzt
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

    public void driveInto(int col) {
        collisions += col;
        if (collisions >= track.getLimitColl()) {
            System.out.println("Limit of collisions reached!");
            System.out.println("Winner is: " + name);
            track.setLimitReached(true);
        }
    }

    public void drivenInto() {
        collisions--;
    }

    //NB: returns true wenn noch kein Limit erreicht wurde
    public boolean verifyLimits() {
//        System.out.println("x  = " + x() + " | " + "y = " + y() + " | " + "orientation = " + o);

        if (track.getLimitReached()) {
            return false;
        }

        movements++;
        if (movements == track.getLimitMove()) {
            track.setLimitReached(true);
            System.out.println(name + " reached Limit of Movements!");
        }
        
        return true;
    }

    public void move(int dir) throws OutOfBoundsException {
        if(verifyLimits()) {
            switch (dir) {
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
    }

    //NB: pos=newPos, o=newOrientation
    private void diagLeft() throws OutOfBoundsException {
//        System.out.println(name + " is moving diagLeft from " + posToString());
        switch (o) {
            case 'n':
                setPos(x() - 1, y() - 1, 'w');
                break;
            case 's':
                setPos(x() + 1, y() + 1, 'o');
                break;
            case 'w':
                setPos(x() - 1, y() + 1, 's');
                break;
            case 'o':
                setPos(x() + 1, y() - 1, 'n');
                break;
            default:
                break;
        }
    }

    //NB: pos=newPos, o=newOrientation
    private void forward() throws OutOfBoundsException {
//        System.out.println(name + " is moving forward from " + posToString());
        switch (o) {
            case 'n':
                setPos(x(), y() - 1, o);
                break;
            case 's':
                setPos(x(), y() + 1, o);
                break;
            case 'w':
                setPos(x() - 1, y(), o);
                break;
            case 'o':
                setPos(x() + 1, y(), o);
                break;
            default:
                break;
        }
    }

    //NB: pos=newPos, o=newOrientation
    private void diagRight() throws OutOfBoundsException {
//        System.out.println(name + " is moving diagRight from " + posToString());
        switch (o) {
            case 'n':
                setPos(x() + 1, y() - 1, 'o');
                break;
            case 's':
                setPos(x() - 1, y() + 1, 'w');
                break;
            case 'w':
                setPos(x() - 1, y() - 1, 'n');
                break;
            case 'o':
                setPos(x() + 1, y() + 1, 's');
                break;
            default:
                break;
        }
    }

    @Override
    // return ein Symbol von <,>,^,v
    public String toString() {
        String s = "" + pic;
        return s;
    }

    // return Koordinaten in Form (x,y)
    public String posToString() {
        DecimalFormat d = new DecimalFormat("#");
        return "(" + d.format(pos.x) + "," + d.format(pos.y) + ")";
    }
}
