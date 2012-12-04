/**
 * Wird ausgeloest, wenn ein Auto versucht auf ein Feld ausserhalb der Strecke 
 * zu fahren.
 * @author Matthias
 */
public class OutOfBoundsException extends Exception{
    
    private String name;
    
    // VB: name != null
    public OutOfBoundsException(String name) {
        this.name = name;
    }
    
    @Override
    // NB: return Name des Cars mit Fehlermeldung 
    public String getMessage(){
        return name + ": Out of Bounds.";
    }
}
