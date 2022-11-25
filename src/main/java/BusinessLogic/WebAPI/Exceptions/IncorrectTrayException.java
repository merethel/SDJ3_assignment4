package BusinessLogic.WebAPI.Exceptions;

public class IncorrectTrayException extends RuntimeException {
    public IncorrectTrayException(int trayNumber) {
        super("Wrong tray chosen with number: " + trayNumber);
    }
}
