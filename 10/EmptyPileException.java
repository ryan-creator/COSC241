package week10;

public class EmptyPileException extends Exception{

    private static final long serialVersionUID = 873498;

    public EmptyPileException(String message){
        super(message);
    }
}
