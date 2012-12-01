
/**
 *
 * @author guetar
 */
public class Track {
    
    //IV: gibt an, ob ein Auto die Maximalpunktezahl (10) erreicht hat, oder 
    //ein Auto eine Maximalzahl an Feldwechseln ausgefuehrt hat
    private boolean end=false;
    private CarQuick[][] track;
    
    public Track(int width, int height) {
        track = new CarQuick[width][height];
    }
    
    //NB: end wird auf true gesetzt und alle Threads sollen beendet werden
    public void gameOver(){
    end=true;
    }
    
    public void setCar(int x, int y, CarQuick c) {
        track[x][y] = c;
    }
    
    public CarQuick getCar(int x, int y) {
        return track[x][y];
    }
}