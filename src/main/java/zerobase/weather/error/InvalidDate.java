package zerobase.weather.error;

public class InvalidDate extends RuntimeException {
    private static final String MESSAGE = "Invalid date";

    public InvalidDate() {
        super(MESSAGE);
    }
}
