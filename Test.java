
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(10, 20, 10, 2);
        //flexible car
        CarFlexible carFlex = new CarFlexible(0, 0, 'n', track);
        track.getCars().put(carFlex.getPos(), carFlex);
        carFlex.move(5);
        carFlex.move(3);
        carFlex.move(4);
        carFlex.move(1);
        carFlex.move(1);
        carFlex.move(3);
        carFlex.move(3);
        carFlex.move(3);
        
        //quick car
        CarQuick carQuick = new CarQuick(0, 1, 's', track);
        track.getCars().put(carQuick.getPos(), carQuick);
        carQuick.move(3);
        carQuick.move(2);
    }
}