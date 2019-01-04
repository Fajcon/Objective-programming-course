package serwer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server extends Thread{

    private IDManager idManager = new IDManager();
    String username = "username";
    String password = "password";
    int port = 6666;

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Now listening on port: " + port);
            boolean end = false;
            while (!end) {
                try (Socket clientSocket = serverSocket.accept()) {
                    try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        String input = in.readLine();
                        out.println(commends(input));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("Accept failed: " + port);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port);
        }
    }

    private String commends(String request){
        String[] args = request.split(" ");
        if (args.length<2) return "false";
        String command = args[0];
        System.out.println(command);
        if (command.equals("LOGIN")){
            String[] s2 = args[1].split(";");
            if (s2.length < 2) return "false";
            String login = s2[0];
            System.out.println(s2[0]);
            System.out.println(s2[1]);
            if(s2[0].equals(username) && s2[1].equals(password)){
                return idManager.getId();
            }
        } else if (command.equals("LOGOUT")){
            return Boolean.toString(idManager.removeID(args[1]));
        } else if (command.equals("LS")&&idManager.checkID(args[1])){
            return "String postaci: plik1;plik2;plik3";
        } else if (command.equals("GET")&&idManager.checkID(args[1])){
            return "String z zawartością pliku, gdzie zawartość pliku jest jedną linią";
        }
        return "false";
    }

}