package foto;

public class NotFotoException extends Exception {
    private static String message = "Plik nie jest zdjeciem";

    @Override
    public String getMessage() {
        return message;
    }
}
