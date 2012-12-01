
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
    
        Track track = new Track(10, 20);
        
        //flexible car
        track.setCar(0, 0, new CarFlexible());
        track.getCar(0, 0).move(1);
        
        //quick car
        track.setCar(0, 1, new CarQuick());
        track.getCar(0, 1).move(1);
    }
}