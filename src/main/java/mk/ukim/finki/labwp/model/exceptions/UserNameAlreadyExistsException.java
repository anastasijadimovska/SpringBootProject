package mk.ukim.finki.labwp.model.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException(String username) {
        super(String.format("The username %s already exists",username));
    }
}
