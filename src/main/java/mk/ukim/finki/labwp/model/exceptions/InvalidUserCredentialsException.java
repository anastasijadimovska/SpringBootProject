package mk.ukim.finki.labwp.model.exceptions;


public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException(){
        super("You have provided invalid user credentials!");
    }
}
