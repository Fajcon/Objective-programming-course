package moviesub;

public class WrongFramesException extends Exception{
    private static String message = "Błąd sekwencji klatek";

    @Override
    public String getMessage() {
        return message;
    }
}
