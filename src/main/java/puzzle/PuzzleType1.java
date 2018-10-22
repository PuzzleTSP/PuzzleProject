package puzzle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PuzzleType1 implements Puzzle {

private Scene scene = null;

	@Override
	public Scene run() {
		Label label1= new Label("PuzzleType1");
		VBox layout1 = new VBox(20);

		Button button1= new Button("Return to Menu");
		button1.setOnAction(e -> exit());

		Button button2 = new Button("move");
		button2.setOnAction(e -> layout1.setAlignment(Pos.BOTTOM_RIGHT));



        layout1.getChildren().addAll(label1, button1, button2);
        scene = new Scene(layout1, 300, 250);

        return scene;
	}

	@Override
	public void exit() {
		MainMenu.load();
	}

}
