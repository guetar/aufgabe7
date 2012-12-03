
/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(String name, int x, int y, char o, Track track) {
        super(name, x, y, o, track);
    }
    
    @Override
    public void move(int dir)  throws OutOfBoundsException{
        
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
    
    private void left()  throws OutOfBoundsException{
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
        setPic(symbols.get(o));
        System.out.println(name + " moved left");
    }
    
    private void right() throws OutOfBoundsException{
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
        System.out.println(name + " moved right");
    }
}
