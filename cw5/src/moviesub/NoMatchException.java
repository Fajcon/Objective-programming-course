package moviesub;

public class NoMatchException extends Exception{
    public NoMatchException(int nrLini, String linia) {
        super();
        message = "Line number("+ Integer.toString(nrLini)+")"+ " " + linia;
    }

    private static String message;

    @Override
    public String getMessage() {
        return message;
    }
}
