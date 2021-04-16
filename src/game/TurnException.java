package game;

public class TurnException extends Exception{

    @Override
    public void printStackTrace() {
        System.out.println(getMessage());
    }

    @Override
    public String getMessage() {
        return "Irrelevant turn";
    }

}
