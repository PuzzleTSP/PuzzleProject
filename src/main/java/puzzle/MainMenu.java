package puzzle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {

	private static Stage stage;

	protected static void initialize(Stage primaryStage) {
		stage = primaryStage;
	}

    protected static void load() {

        //Menu scene
        Label label1= new Label("Main Menu");

        PuzzleType1 p1 = new PuzzleType1();
        Button button1= new Button(p1.getName());
        button1.setOnAction(e -> stage.setScene(p1.run()));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        Scene menu= new Scene(layout1, 300, 250);

        stage.setScene(menu);
        stage.show();
    }
}
