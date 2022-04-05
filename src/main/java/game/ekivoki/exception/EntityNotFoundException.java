package game.ekivoki.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {
        this("Entity not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
