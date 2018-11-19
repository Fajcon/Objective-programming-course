package histogram;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Histogram extends Application {

    HistogramValues values = new HistogramValues();

    public Rectangle newRectangle(double sizeY){
        Rectangle rectangle = new Rectangle();
        if(values.rectangles.size() != 0){
            rectangle.setX(values.rectangles.get(values.rectangles.size()-1).getX()+21);
        }
        else rectangle.setX(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setY(500 - sizeY);
        rectangle.setWidth(20);
        rectangle.setHeight(sizeY);
        values.rectangles.add(rectangle);
        values.values.add(sizeY);
        return rectangle;
    }

    @Override
    public void start(Stage stage) throws Exception {


        Button button = new Button("AddValue");
        TextArea values1TextArea = new TextArea();
        values1TextArea.setMaxSize(200, 20);
        values1TextArea.setLayoutY(30);
        values1TextArea.setLayoutX(80);
        Text values1Text = new Text("Value 1: ");
        values1Text.setLayoutY(50);
        values1Text.setLayoutX(1);

        newRectangle(100);
        newRectangle(80);
        Group root = new Group(button, values1TextArea, values1Text);
        for (Rectangle r:values.rectangles) {
            root.getChildren().add(r);
        }
        button.setOnAction(ev -> {
            if(!values1TextArea.getText().isEmpty())
                root.getChildren().add(newRectangle(Double.parseDouble(values1TextArea.getText())));
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
