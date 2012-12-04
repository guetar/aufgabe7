
import java.util.Random;


/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(String name, int x, int y, char o, Track track, DriveStyle style) {
        super(name, x, y, o, track, style);
    }
    
    @Override
    public void sleepWhileDrive() throws InterruptedException {
        sleep(1500);
    }
    
    @Override
    public void move(int dir)  throws OutOfBoundsException{
        // steff: Matthias seine Änderungen auskommentiert damits funzt bei mir.
        
        switch(dir) {
            case 1:
                if(verifyLimits())
                left();
                break;
            case 5:
                if(verifyLimits())
                right();
                break;
            default:
                super.move(dir);
                break;
        }
    }
    
    private void left()  throws OutOfBoundsException{
//        System.out.println(name + " is moving left from " + posToString());
        switch(o) {
            case 'n':
                setPos(x()-1, y(), 'w');
                break;
            case 's':
                setPos(x()+1, y(), 'o');
                break;
            case 'w':
                setPos(x(), y()+1, 's');
                break;
            case 'o':
                setPos(x(), y()-1, 'n');
                break;
            default:
                break;
        }
    }
    
    private void right() throws OutOfBoundsException{
//        System.out.println(name + " is moving right from " + posToString());
        switch(o) {
            case 'n':
                setPos(x()+1, y(), 'o');
                break;
            case 's':
                setPos(x()-1, y(), 'w');
                break;
            case 'w':
                setPos(x(), y()-1, 'n');
                break;
            case 'o':
                setPos(x(), y()+1, 's');
                break;
            default:
                break;
        }
        setPic(symbols.get(o));
    }
}
