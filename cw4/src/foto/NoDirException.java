package foto;

public class NoDirException extends Exception {
    private static String message = "Folder nie istnieje";

    @Override
    public String getMessage() {
        return message;
    }
}
