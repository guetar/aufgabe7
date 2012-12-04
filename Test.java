
/**
 *
 * @author guetar
 */
public class Test {
    
    public static void main(String[] args) {
        
        Track track = new Track(20, 10, 100, 3);
        
        //flexible car1
        CarFlexible carFlex1 = new CarFlexible("Flexo1", 8, 3, 's', track);
        track.getCars().put(carFlex1.getPos(), carFlex1);
        
        //flexible car2
        CarFlexible carFlex2 = new CarFlexible("Flexo2", 11, 6, 'n', track);
        track.getCars().put(carFlex2.getPos(), carFlex2);
        
        //flexible car3
        CarFlexible carFlex3 = new CarFlexible("Flexo3", 6, 4, 'o', track);
        track.getCars().put(carFlex3.getPos(), carFlex3);
        
        //flexible car4
        CarFlexible carFlex4 = new CarFlexible("Flexo4", 9, 5, 'w', track);
        track.getCars().put(carFlex4.getPos(), carFlex4);
        
        //flexible car5
        CarFlexible carFlex5 = new CarFlexible("Flexo5", 6, 1, 's', track);
        track.getCars().put(carFlex5.getPos(), carFlex5);
        
        //flexible car6
        CarFlexible carFlex6 = new CarFlexible("Flexo6", 7, 5, 'n', track);
        track.getCars().put(carFlex6.getPos(), carFlex6);
        
        //flexible car7
        CarFlexible carFlex7 = new CarFlexible("Flexo7", 2, 4, 'o', track);
        track.getCars().put(carFlex7.getPos(), carFlex7);
        
        //flexible car8
        CarFlexible carFlex8 = new CarFlexible("Flexo8", 13, 5, 'w', track);
        track.getCars().put(carFlex8.getPos(), carFlex8);
        
        //flexible car9
        CarFlexible carFlex9 = new CarFlexible("Flexo9", 12, 2, 'o', track);
        track.getCars().put(carFlex9.getPos(), carFlex9);
        
        //flexible car10
        CarFlexible carFlex10 = new CarFlexible("Flexo10", 10, 9, 'w', track);
        track.getCars().put(carFlex10.getPos(), carFlex10);
        
        
        
        //quick car1
        CarQuick carQuick1 = new CarQuick("Speedo1", 8, 6, 'n', track);
        track.getCars().put(carQuick1.getPos(), carQuick1);
        
        //quick car2
        CarQuick carQuick2 = new CarQuick("Speedo2", 11, 3, 'o', track);
        track.getCars().put(carQuick2.getPos(), carQuick2);
        
        //quick car3
        CarQuick carQuick3 = new CarQuick("Speedo3", 6, 5, 'o', track);
        track.getCars().put(carQuick3.getPos(), carQuick3);
        
        //quick car4
        CarQuick carQuick4 = new CarQuick("Speedo4", 9, 4, 'w', track);
        track.getCars().put(carQuick4.getPos(), carQuick4);
        
        //quick car1
        CarQuick carQuick5 = new CarQuick("Speedo5", 3, 9, 'n', track);
        track.getCars().put(carQuick5.getPos(), carQuick5);
        
        //quick car2
        CarQuick carQuick6 = new CarQuick("Speedo6", 18, 3, 'o', track);
        track.getCars().put(carQuick6.getPos(), carQuick6);
        
        //quick car3
        CarQuick carQuick7 = new CarQuick("Speedo7", 14, 5, 'o', track);
        track.getCars().put(carQuick7.getPos(), carQuick7);
        
        //quick car4
        CarQuick carQuick8 = new CarQuick("Speedo8", 5, 4, 'w', track);
        track.getCars().put(carQuick8.getPos(), carQuick8);
        
        //quick car3
        CarQuick carQuick9 = new CarQuick("Speedo9", 17, 5, 'o', track);
        track.getCars().put(carQuick9.getPos(), carQuick9);
        
        //quick car4
        CarQuick carQuick10 = new CarQuick("Speedo10", 13, 4, 'w', track);
        track.getCars().put(carQuick10.getPos(), carQuick10);
        
        
        //start race
        System.out.println("Start race with a limit of ");
        System.out.println(track.getLimitMove() + " movements and " + track.getLimitColl() + " collisions ...");
        System.out.println("");
        
        System.out.println(track);
        
        carFlex1.start();
        carFlex2.start();
        carFlex3.start();
        carFlex4.start();
        carFlex5.start();
        carFlex6.start();
        carFlex7.start();
        carFlex8.start();
        carFlex9.start();
        carFlex10.start();
        
        carQuick1.start();
        carQuick2.start();
        carQuick3.start();
        carQuick4.start();
        carQuick5.start();
        carQuick6.start();
        carQuick7.start();
        carQuick8.start();
        carQuick9.start();
        carQuick10.start();
    }
}
