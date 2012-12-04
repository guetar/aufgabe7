/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steff
 */
public class DriveStyleEight extends DriveStyle {

    private int i;
    private boolean left;
    
    public DriveStyleEight() {
        i = 0;
        left = true;
    }
    
    @Override
    // NB: Nach jedem viertem Aufruf dieser Methode aendert sich die Richtung
    public int getDirection() {
        // Laesst das Auto in einer 8er Schleife fahren
        if (i >= 4) {
            left = !left;
            i = 0;
        }
        i++;
        
        if (left) {
            return 2;
        } else {
            return 4;
        }
    }
}
