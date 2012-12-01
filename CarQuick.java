
/**
 *
 * @author guetar
 */
public class CarQuick extends Thread {
    
    protected Track track;
    
    public CarQuick(Track track) {
        this.track = track;
    }
    
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
                System.out.println("Cannot move in spezified direction!");
                break;
        }
    }
    
    private void diagLeft() {
        System.out.println("moved diagLeft");
    }
    
    private void forward() {
        System.out.println("moved forward");
    }
    
    private void diagRight() {
        System.out.println("moved diagRight");
    }
}
