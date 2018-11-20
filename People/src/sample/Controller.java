package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    @FXML private TextField fullName;
    @FXML private TextField phone;
    @FXML private TextField pesel;
    People people = new People();

    public void test(){
        people.peopleList.add(new Person(fullName.getText(),phone.getText(), pesel.getText()));
    }

    public void writePeople(){
        for (Person p: people.peopleList) {
            System.out.println(p.getPesel() + " " + p.getFullName() + " " + p.getPhone());
        }
    }

}
