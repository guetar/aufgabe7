/**
 * Wird ausgeloest, wenn ein Auto versucht auf ein Feld ausserhalb der Strecke 
 * zu fahren.
 * @author Matthias
 */
public class OutOfBoundsException extends Exception{
    
    private String name;
    
    public OutOfBoundsException(String name) {
        this.name = name;
    }
    
    @Override
    public String getMessage(){
    return name + ": Out of Bounds.";
    }
}
