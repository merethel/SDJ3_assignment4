package BusinessLogic.WebAPI.Exceptions;

public class MaximumWeightException extends RuntimeException {
    public MaximumWeightException(int maximumWeight) {
        super("Maximum weight limit reached. Maximum limit is: " + maximumWeight);
    }
}
