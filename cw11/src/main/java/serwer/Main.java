package serwer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server(6666);
        server.start();
        server.join();
    }

}
