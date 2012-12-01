
import java.awt.geom.Point2D;
import java.util.HashMap;


/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(10, 20);
        //flexible car
        CarFlexible carFlex = new CarFlexible(0, 0, 'n', track);
        track.getCars().put(carFlex.getPos(), carFlex);
        carFlex.move(1);
        
        //quick car
        CarQuick carQuick = new CarQuick(0, 1, 's', track);
        track.getCars().put(carQuick.getPos(), carQuick);
        carQuick.move(1);
    }
}