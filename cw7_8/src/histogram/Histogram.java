package histogram;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Histogram extends Application {

    HistogramValues values = new HistogramValues();

    public Rectangle newRectangle(double sizeY){
        Rectangle rectangle = new Rectangle();
        if(values.rectangles.size() != 0){
            rectangle.setX(values.rectangles.get(values.rectangles.size()-1).getX()+36);
        }
        else rectangle.setX(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setY(500 - sizeY);
        rectangle.setWidth(20);
        rectangle.setHeight(sizeY);
        values.rectangles.add(rectangle);
        return rectangle;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button button = new Button("AddValue");
        NumberTextField values1TextField = new NumberTextField();
        values1TextField.setMaxSize(50, 20);
        values1TextField.setPrefColumnCount(3);
        values1TextField.setLayoutY(30);
        values1TextField.setLayoutX(80);
        Text values1Text = new Text("Value 1: ");
        values1Text.setLayoutY(50);
        values1Text.setLayoutX(1);
        Line osX = new Line(70, 500,   600,   500);
        Line osY = new Line(80, 510,   80,   190);
        Group root = new Group(button, values1TextField, values1Text,osX,osY);
        button.setOnAction(ev -> {
            if(!values1TextField.getText().isEmpty()) {
                root.getChildren().add(newRectangle(Double.parseDouble(values1TextField.getText())));
                root.getChildren().add(new Text(values.rectangles.get(values.rectangles.size()-1).getX(), 520, values1TextField.getText()));
            }
        });
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("My histogram");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String args[]){
        launch(args);
    }
}
