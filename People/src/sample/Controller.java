package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller{
    @FXML private TextField fullName;
    @FXML private TextField phone;
    @FXML private TextField pesel;
    @FXML private ListView<String> listViewFullName;
    @FXML private ListView<String> listViewPhone;
    @FXML private ListView<String> listViewPesel;
    @FXML private ListView<Integer> listViewId;

    People people = new People();

    int id = 1;

    public void test(){
        people.peopleList.add(new Person(fullName.getText(), phone.getText(), pesel.getText()));
        listViewFullName.getItems().add(fullName.getText());
        listViewPhone.getItems().add(phone.getText());
        listViewPesel.getItems().add(pesel.getText());
        listViewId.getItems().add(id);
        id++;

    }


}
