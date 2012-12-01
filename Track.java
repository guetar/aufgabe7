
/**
 *
 * @author guetar
 */
public class Track {
    
    private CarQuick[][] track;
    
    public Track(int width, int height) {
        track = new CarQuick[width][height];
    }
    
    public void setCar(int x, int y, CarQuick c) {
        track[x][y] = c;
    }
    
    public CarQuick getCar(int x, int y) {
        return track[x][y];
    }
}