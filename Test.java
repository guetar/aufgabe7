
import java.awt.geom.Point2D;
import java.util.HashMap;


/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
    
        HashMap<Point2D, CarQuick> cars = new HashMap<Point2D, CarQuick>();
        
        //flexible car
        CarFlexible carFlex = new CarFlexible(0, 0);
        cars.put(carFlex.getPos(), carFlex);
        carFlex.move(1);
        
        //quick car
        CarQuick carQuick = new CarQuick(0, 1);
        cars.put(carQuick.getPos(), carQuick);
        carQuick.move(1);
    }
}