package BusinessLogic.WebAPI;

public class IncorrectTrayException extends RuntimeException {
    public IncorrectTrayException(int trayNumber) {
        super("Wrong tray chosen with number: " + trayNumber);
    }
}
