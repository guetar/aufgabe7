
/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
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
        
    }
    
    private void right() {
        
    }
}