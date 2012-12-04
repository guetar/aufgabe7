/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steff
 */
public class DriveStyleRandomFlex extends DriveStyleRandomQuick {
    
    public int getMove() {
        return rng.nextInt(5) + 1;
    }
}
