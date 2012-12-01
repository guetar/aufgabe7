
/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    public synchronized void move(int dir) {
        
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
                break;
        }
    }
    
    private void diagLeft() {
        
    }
    
    private void forward() {
        
    }
    
    private void diagRight() {
        
    }
}