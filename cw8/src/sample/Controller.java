package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private ListView dataView;
    @FXML private Button connectButton;
    @FXML private Button viewButton;
    @FXML private Button searchByAuthorButton;
    @FXML private TextField authorText;
    @FXML private TextField isbnText;
    @FXML private Button searchByIsbnButton;
    DB dataBase = new DB();

    @FXML
    private void connectWithDataBase(){
        dataBase.connect();
    }

    @FXML
    private void viewData(){
        dataView.getItems().clear();
        ArrayList<Book> books = dataBase.getData();
        for (Book b: books) {
            dataView.getItems().add(b.getAll());
        }

    }

    @FXML
    private void searchByAuthor(){
        dataView.getItems().clear();
        ArrayList<Book> books = new ArrayList<>();
        if (authorText.getText().contains(" ")) {
            books = dataBase.getDataByAuthor(authorText.getText());
        }
        else books = dataBase.getDataBylastName(authorText.getText());
        for (Book b: books) {
            dataView.getItems().add(b.getAll());
        }

    }
    @FXML
    private void searchByIsbn(){
        dataView.getItems().clear();
        ArrayList<Book> books = dataBase.getDataByIsbn(isbnText.getText());
        for (Book b: books) {
            dataView.getItems().add(b.getAll());
        }

    }

    @FXML
    private void addBook() throws IOException {
        Parent root=  FXMLLoader.load(Main.class.getResource("AddBook.fxml"));
        Scene newScene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(newScene);
        newStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
