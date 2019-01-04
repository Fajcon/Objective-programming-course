package gui;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.misc.BASE64Decoder;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;

public class Controller implements Initializable {

    @FXML
    private ListView listOfFilesView;
    @FXML private Button viewFotoButton;
    @FXML private ImageView fotoView;
    private Stage stage;
    private File selectedImg;
    private Image image = null;
    private Mem mem;
    @FXML private TextField up;
    @FXML private TextField down;
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML public void viewFoto(){
        FileChooser fileChooser = new FileChooser();
        selectedImg = fileChooser.showOpenDialog(stage);
        image = new Image(new File(selectedImg.getPath().toString()).toURI().toString());
        fotoView.setImage(image);
    }

    @FXML public void createMem(){
        mem = new Mem(selectedImg, up.getText(), down.getText());
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializedMem"))) {
            outputStream.writeObject(mem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sendToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendToServer() throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
//        BufferedReader in = null;
        File file = null;
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            file = new File("serializedMem");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            in.nextLine();
            System.out.println(in);
        }

        out.close();
        echoSocket.close();
    }

    @FXML public void loadMem(){
        BufferedImage bufferedImage = null;
        byte[] imageByte;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serializedMem"))) {
            Mem loadedMem = (Mem) inputStream.readObject();
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(loadedMem.base64Image);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            bufferedImage = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            fotoView.setImage(image);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
