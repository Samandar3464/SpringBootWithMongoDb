package uz.pdp.javawithmongodb;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String massage) {
        super(massage);
    }
}
