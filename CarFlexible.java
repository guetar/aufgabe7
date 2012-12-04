
import java.util.Random;


/**
 *
 * @author guetar
 */
public class CarFlexible extends CarQuick {
    
    public CarFlexible(String name, int x, int y, char o, Track track) {
        super(name, x, y, o, track);
    }
    
    @Override
    public void sleepWhileDrive() throws InterruptedException {
        sleep(1500);
    }
    
    //kann geloescht werden
    public int getRandMove() {
        Random rg=new Random();
        return rg.nextInt(5)+1;
    }
    
    @Override
    public void move(int dir)  throws OutOfBoundsException{
        
        switch(dir) {
            case 1:
                if(verifyLimits())
                left();
                break;
            case 5:
                if(verifyLimits())
                right();
                break;
            default:
                super.move(dir);
                break;
        }
    }
    
    private int sqm = -1;
    //NB: return laesst auto auf quadratischer bahn mit halber seitenlaenge der
    //Strecke im Uhrzeigersinn fahren
    public int getMove() {
        sqm++;
        if (sqm == track.getHeight() / 2) {
            sqm=-1;
            return 5;
        } else {
            return 3;
        }
    }
    
    private void left()  throws OutOfBoundsException{
//        System.out.println(name + " is moving left from " + posToString());
        switch(o) {
            case 'n':
                setPos(x()-1, y(), 'w');
                break;
            case 's':
                setPos(x()+1, y(), 'o');
                break;
            case 'w':
                setPos(x(), y()+1, 's');
                break;
            case 'o':
                setPos(x(), y()-1, 'n');
                break;
            default:
                break;
        }
    }
    
    private void right() throws OutOfBoundsException{
//        System.out.println(name + " is moving right from " + posToString());
        switch(o) {
            case 'n':
                setPos(x()+1, y(), 'o');
                break;
            case 's':
                setPos(x()-1, y(), 'w');
                break;
            case 'w':
                setPos(x(), y()-1, 'n');
                break;
            case 'o':
                setPos(x(), y()+1, 's');
                break;
            default:
                break;
        }
        setPic(symbols.get(o));
    }
}
