package moviesub;

public class WrongFramesException extends Exception{
    public WrongFramesException(int nrLini, String linia) {
        super();
        message = "Line number("+ Integer.toString(nrLini)+")"+ " " + linia;
    }

    private static String message;

    @Override
    public String getMessage() {
        return message;
    }
}
