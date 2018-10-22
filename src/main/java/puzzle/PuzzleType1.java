package puzzle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PuzzleType1 implements Puzzle {

	private final String name = "Puzzle Type 1";

	@Override
	public Pane run() {
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.TOP_CENTER);

		Button button1= new Button("Do Nothing");
		button1.setOnAction(e -> exit());

		Button button2 = new Button("move");
		button2.setOnAction(e -> layout1.setAlignment(Pos.BOTTOM_RIGHT));

        layout1.getChildren().addAll(button1, button2);

        return layout1;
	}

	@Override
	public void exit() {

	}

	@Override
	public String getName() {
		return name;
	}

}
