
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(10, 20, 10, 2);
        //flexible car
        CarFlexible carFlex = new CarFlexible(0, 0, 's', track);
        track.getCars().put(carFlex.getPos(), carFlex);
        carFlex.start();
        
        //quick car
        CarQuick carQuick = new CarQuick(0, 1, 's', track);
        track.getCars().put(carQuick.getPos(), carQuick);
        carQuick.start();
      
    }
}