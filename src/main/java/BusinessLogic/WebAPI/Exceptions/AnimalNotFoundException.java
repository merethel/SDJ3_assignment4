package BusinessLogic.WebAPI.Exceptions;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(int registrationNumber) {
        super("Could not find animal, with registration number: " + registrationNumber);
    }
}
