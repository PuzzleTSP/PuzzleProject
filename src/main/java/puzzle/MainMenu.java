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

        Button button1= new Button("Type 1 Puzzle");
        button1.setOnAction(e -> new PuzzleType1(stage));

        Button button2 = new Button("p2");
        button2.setOnAction(e -> stage.setScene(new P2().run()));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2);
        Scene menu= new Scene(layout1, 300, 250);

        stage.setScene(menu);
        stage.show();
    }
}
