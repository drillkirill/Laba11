
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Zad3 extends Application {
    private TextField from;
    private TextField to;
    private Button button;
    private LineChart<Number, Number> lineChart;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Задание №3");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        this.lineChart = new LineChart(xAxis, yAxis);
        Label fromLabel = new Label("От:");
        Label toLabel = new Label("До:");
        this.from = new TextField();
        this.to = new TextField();
        this.button = new Button("Построить");
        this.button.setOnAction((e) -> {
            this.plotGraph();
        });
        HBox inputPane = new HBox(10.0);
        inputPane.setAlignment(Pos.CENTER);
        inputPane.getChildren().addAll(new Node[]{fromLabel, this.from, toLabel, this.to, this.button});
        VBox mainPane = new VBox(10.0);
        mainPane.setPadding(new Insets(10.0));
        mainPane.getChildren().addAll(new Node[]{inputPane, this.lineChart});
        Scene scene = new Scene(mainPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void plotGraph() {
        double from = Double.parseDouble(this.from.getText());
        double to = Double.parseDouble(this.to.getText());
        XYChart.Series<Number, Number> series = new XYChart.Series();
        series.setName("График функции");

        for(double x = from; x <= to; x += 0.1) {
            double y = Math.log(Math.abs(Math.pow(x, 2)-5*x)+5*Math.sin(x));
            series.getData().add(new XYChart.Data(x, y));
        }

        this.lineChart.getData().clear();
        this.lineChart.setCreateSymbols(false);
        this.lineChart.getData().add(series);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
