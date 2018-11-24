package photo;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView listOfFilesView;
    @FXML private Button viewFotoButton;
    @FXML private ImageView fotoView;
    private Stage stage;
    private File selectedDirectory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        selectedDirectory = directoryChooser.showDialog(stage);
        addPhotos();
    }

    @FXML public void viewFoto(){
        Image image = new Image(new File(listOfFilesView.getSelectionModel().getSelectedItem().toString()).toURI().toString());
        fotoView.setImage(image);

    }

    @FXML public void addPhotos() {

        ArrayList<File> listOfFiles = new ArrayList<>(Arrays.asList(selectedDirectory.listFiles()));
        for (final File f : listOfFiles) {
            listOfFilesView.getItems().add(f.getPath());
        }
    }

}
