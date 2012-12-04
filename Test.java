
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(20, 10, 10, 2);
        //flexible car1
        CarFlexible carFlex1 = new CarFlexible("Flexo1", 1, 1, 's', track);
        track.getCars().put(carFlex1.getPos(), carFlex1);
        
        //flexible car2
        CarFlexible carFlex2 = new CarFlexible("Flexo2", 18, 8, 'n', track);
        track.getCars().put(carFlex2.getPos(), carFlex2);
        
        //quick car1
        CarQuick carQuick1 = new CarQuick("Speedo1", 18, 1, 'w', track);
        track.getCars().put(carQuick1.getPos(), carQuick1);
        
        //quick car2
        CarQuick carQuick2 = new CarQuick("Speedo2", 1, 8, 'o', track);
        track.getCars().put(carQuick2.getPos(), carQuick2);
        
        System.out.println(track);
        
        carFlex1.start();
        carFlex2.start();
        carQuick1.start();
        carQuick2.start();
    }
}
