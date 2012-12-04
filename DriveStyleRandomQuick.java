
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steff
 */
public class DriveStyleRandomQuick extends DriveStyle{
    
    protected Random rng;
    
    public DriveStyleRandomQuick() {
        rng = new Random();
    }

    @Override
    // Zufallszahl mit erweiterten Bereich fuer CarFlexibles zurueckgegeben
    public int getDirection() {
        return rng.nextInt(3) + 2; 
    }
}
