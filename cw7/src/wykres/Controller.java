package wykres;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private CategoryAxis xAxis;
    @FXML private NumberAxis yAxis;
    @FXML private LineChart<?,?> LineChart;
    XYChart.Series series= new XYChart.Series();
    @FXML private TextField rangeStartTextField;
    @FXML private TextField rangeEndTextField;
    private int rangeStart ;
    private int rangeEnd;
    @FXML private TextField wzor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            LineChart.getData().removeAll(series);
            LineChart.getData().addAll(series);
    }

    @FXML public void draw(){
        Wielomian wielomian = new Wielomian(wzor.getText());
        rangeStart = Integer.parseInt(rangeStartTextField.getText());
        rangeEnd = Integer.parseInt(rangeEndTextField.getText());
        for (int i = rangeStart; i <= rangeEnd; i++) {
            series.getData().add(new XYChart.Data(Integer.toString(i), wielomian.getResult(i)));
        }
    }
    int funkcjaKwadratowa(int x){
        return x*x;
    }


}
//(\+|\-)(\d*)(\w)(\^)(\-?\d*)