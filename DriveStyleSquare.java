/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steff
 */
public class DriveStyleSquare extends DriveStyle {
    
    private int sqm = -1;
    private int length;
    
    public DriveStyleSquare(int length) {
        this.length = length;
    }
    
    @Override
    //NB: return laesst auto auf quadratischer bahn mit halber seitenlaenge der
    //Strecke im Uhrzeigersinn fahren
    public int getDirection() {
        sqm++;
        if (sqm == length / 2) {
            sqm=-1;
            return 5;
        } else {
            return 3;
        }
    }
}
