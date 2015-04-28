package li.allan.exception;

public class UAParserException extends RuntimeException {

    public UAParserException(String message) {
        super(message);
    }

    public UAParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UAParserException(Throwable cause) {
        super(cause);
    }
}
