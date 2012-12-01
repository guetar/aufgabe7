
/**
 * Wird ausgeloest, wenn ein Auto versucht auf ein bereits besetztes Feld zu 
 * fahren.
 * @author Matthias
 */
public class CollisionException extends Exception{
    
    @Override
    public String getMessage(){
    return "Car crashed.";
    }
}
