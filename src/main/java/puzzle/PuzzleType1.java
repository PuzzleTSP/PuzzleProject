import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PuzzleType1 implements Puzzle {

	private Stage stage = null;
	private Scene scene = null;

	public PuzzleType1(Stage stage) {
		this.stage = stage;
		initialize();
	}


	@Override
	public void run() {

	}

	@Override
	public void exit() {

	}

	private void initialize() {
		stage.setFullScreen(true);
        stage.setTitle("PPPP - type 1 puzzle");

		Label label1= new Label("Puzzle type 1");
		Button button1= new Button("Return to Menu");
		button1.setOnAction(e -> exit());
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene = new Scene(layout1, 300, 250);

        stage.setScene(scene);
        stage.show();
	}

}
