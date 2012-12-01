
/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(int x, int y) {
        super(x, y);
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
    }
    
    private void right() {
        System.out.println("moved right");
    }
}