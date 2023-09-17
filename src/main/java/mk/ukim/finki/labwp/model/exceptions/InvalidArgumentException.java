package mk.ukim.finki.labwp.model.exceptions;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException(){
        super("You have provided invalid arguments");
    }
}
