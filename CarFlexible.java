
/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(int x, int y, char o, Track track) {
        super(x, y, o, track);
    }
    
    @Override
    public synchronized void move(int dir) {
        
        switch(dir) {
            case 1:
                verifyLimits();
                left();
                break;
            case 5:
                verifyLimits();
                right();
                break;
            default:
                super.move(dir);
                break;
        }
    }
    
    private void left() {
        System.out.println("moved left");
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
    
    private void right() {
        System.out.println("moved right");
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
    }
}