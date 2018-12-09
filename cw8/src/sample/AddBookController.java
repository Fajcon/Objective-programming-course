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

public class AddBookController implements Initializable {


    @FXML private TextField isbn;
    @FXML private TextField author;
    @FXML private TextField title;
    @FXML private TextField year;
    @FXML private Button addBookButton;
    DB dataBase = new DB();


    @FXML
    private void addBook(){
        dataBase.addBook(new Book(isbn.getText(), author.getText(), title.getText(), Integer.parseInt(year.getText())));
        System.out.println(new Book(isbn.getText(), author.getText(), title.getText(), Integer.parseInt(year.getText())).getAll());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
