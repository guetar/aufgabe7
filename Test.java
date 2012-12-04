
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(20, 10, 100, 2);
        //flexible car1
        CarFlexible carFlex1 = new CarFlexible("Flexo1", 8, 3, 's', track, new DriveStyleRandomFlex());
        track.getCars().put(carFlex1.getPos(), carFlex1);
        
        //flexible car2
        CarFlexible carFlex2 = new CarFlexible("Flexo2", 11, 6, 'n', track, new DriveStyleRandomFlex());
        track.getCars().put(carFlex2.getPos(), carFlex2);
        
        //flexible car3
        CarFlexible carFlex3 = new CarFlexible("Flexo3", 6, 4, 'o', track, new DriveStyleSquare(track.getHeight()));
        track.getCars().put(carFlex3.getPos(), carFlex3);
        
        //flexible car4
        CarFlexible carFlex4 = new CarFlexible("Flexo4", 9, 5, 'w', track, new DriveStyleSquare(track.getHeight()));
        track.getCars().put(carFlex4.getPos(), carFlex4);
        
        
        
        //quick car1
        CarQuick carQuick1 = new CarQuick("Speedo1", 8, 6, 'n', track, new DriveStyleRandomQuick());
        track.getCars().put(carQuick1.getPos(), carQuick1);
        
        //quick car2
        CarQuick carQuick2 = new CarQuick("Speedo2", 11, 3, 'o', track, new DriveStyleRandomQuick());
        track.getCars().put(carQuick2.getPos(), carQuick2);
        
        //quick car3
        CarQuick carQuick3 = new CarQuick("Speedo3", 6, 5, 'o', track, new DriveStyleEight());
        track.getCars().put(carQuick3.getPos(), carQuick3);
        
        //quick car4
        CarQuick carQuick4 = new CarQuick("Speedo4", 9, 4, 'w', track, new DriveStyleEight());
        track.getCars().put(carQuick4.getPos(), carQuick4);
        
        
        
        System.out.println(track);
        
        carFlex1.start();
        carFlex2.start();
        carFlex3.start();
        carFlex4.start();
        carQuick1.start();
        carQuick2.start();
        carQuick3.start();
        carQuick4.start();
    }
}
