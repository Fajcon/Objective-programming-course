package moviesub;

public class NoMatchException extends Exception{
    private static String message = "Błąd formatu napisów";

    @Override
    public String getMessage() {
        return message;
    }
}
