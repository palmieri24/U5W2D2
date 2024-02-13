package alessiapalmieri.U5W2D2.Exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(long id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
