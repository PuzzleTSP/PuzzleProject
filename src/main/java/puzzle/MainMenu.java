package puzzle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenu {

	private PuzzleLauncher launcher = null;

	public MainMenu(PuzzleLauncher launcher) {
		this.launcher = launcher;
	}

    public BorderPane load() {
    	BorderPane layout = new BorderPane();

        Label title = new Label("Main Menu");
        title.setFont(new Font(40.0));

        Button b1 = buildButton("Puzzle 1");
        b1.setOnMouseClicked(e -> launcher.display(new PuzzleType1(launcher)));

        Button b2 = buildButton("Puzzle 1");
        b2.setOnMouseClicked(e -> launcher.display(new PuzzleType1(launcher)));

        Button b3 = buildButton("Puzzle 1");
        b3.setOnMouseClicked(e -> launcher.display(new PuzzleType1(launcher)));

        VBox puzzles = new VBox();
        puzzles.setAlignment(Pos.TOP_CENTER);
        puzzles.getChildren().addAll(b1, b2, b3);
        BorderPane.setAlignment(puzzles, Pos.CENTER);

        layout.setCenter(puzzles);
        layout.setTop(title);

        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(50,50,50,50));

        return layout;

    }

    private Button buildButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setAlignment(Pos.CENTER);
		button.setFont(new Font(30.0));
		VBox.setMargin(button, new Insets(30, 30, 30, 30));

		return button;
	}
}
