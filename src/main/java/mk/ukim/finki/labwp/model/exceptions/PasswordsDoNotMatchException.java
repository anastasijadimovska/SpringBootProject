package mk.ukim.finki.labwp.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("The passwords you have provided does not match! Please try again!");
    }
}
