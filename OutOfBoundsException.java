/**
 * Wird ausgeloest, wenn ein Auto versucht auf ein Feld ausserhalb der Strecke 
 * zu fahren.
 * @author Matthias
 */
public class OutOfBoundsException extends Exception{
    
    @Override
    public String getMessage(){
    return "Out of Bounds.";
    }
}
