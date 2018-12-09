package foto;

public class DirectorCreationException extends Exception {
    private static String message = "Nie udalo sie uttworzyc folderu";

    @Override
    public String getMessage() {
        return message;
    }
}
