package christmas.util.exception;

public class EventException extends IllegalArgumentException {
    private static final String CONVENTION = "[ERROR] %s";

    private EventException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        System.out.println(String.format(CONVENTION, errorMessage.getMessage()));
    }

    public static EventException of(final ErrorMessage errorMessage) {
        return new EventException(errorMessage);
    }
}
