package gui;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Base64;

public class Mem implements Serializable{
    public String base64Image;
    public String up;
    public String down;

    public Mem(File imageFile, String up, String down) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.base64Image = Base64.getEncoder().encodeToString(fileContent);
        this.up = up;
        this.down = down;
    }
//    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//        stream.defaultReadObject();
//        image = SwingFXUtils.toFXImage(ImageIO.read(stream), null);
//        up = (String) stream.readObject();
//        down = (String) stream.readObject();
//    }
//
//    private void writeObject(ObjectOutputStream stream) throws IOException {
//        stream.defaultWriteObject();
//        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", stream);
//        stream.writeObject(up);
//        stream.writeObject(down);
//
//    }
}
