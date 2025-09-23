package Chaper8;

/**
 * @author Lindokuhle Makanda
 * Thrown when there is a high price increase on a {@code Product}
 */
public class HighPriceIncreaseException extends RuntimeException {
    /**
     * Constructs an {@code HighPriceIncreaseException} with the specified message
     * @param message The detail message
     */
    public HighPriceIncreaseException(String message) {
        super(message);
    }
}
