package gui.testServera;

import java.io.*;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(2000);
        Socket socket = null;
        String host = "127.0.0.1";

        socket = new Socket(host, 4444);

        File file = new File("test.bin");
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    }
}
