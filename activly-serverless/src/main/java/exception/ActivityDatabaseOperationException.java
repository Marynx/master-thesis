package exception;

public class ActivityDatabaseOperationException extends RuntimeException {
    
    public ActivityDatabaseOperationException(String message) {
        super(message);
    }
    
    public ActivityDatabaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
