import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Zad4 extends Application {
    private TextArea resultTextArea;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Задание №4");
        Button generateButton = new Button("Рандом");
        generateButton.setOnAction((e) -> {
            this.generateNumbers();
        });
        this.resultTextArea = new TextArea();
        this.resultTextArea.setEditable(false);
        VBox mainPane = new VBox(12.0);
        mainPane.setPadding(new Insets(10.0));
        mainPane.getChildren().addAll(new Node[]{generateButton, this.resultTextArea});
        Scene scene = new Scene(mainPane, 300.0, 200.0);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateNumbers() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 7; ++i) {
            int randomNumber = random.nextInt();
            sb.append(randomNumber).append("\n");
        }

        this.resultTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
