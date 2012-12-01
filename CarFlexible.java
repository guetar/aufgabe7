
/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(int x, int y, char orientation, Track track) {
        super(x, y, orientation, track);
    }
    
    @Override
    public synchronized void move(int dir) {
        
        switch(dir) {
            case 1:
                left();
                break;
            case 5:
                right();
                break;
            default:
                super.move(dir);
                break;
        }
    }
    
    private void left() {
        System.out.println("moved left");
        switch(orientation) {
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
        switch(orientation) {
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