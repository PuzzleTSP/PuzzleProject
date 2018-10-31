package puzzle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainMenu {

	private Font titleFont = null;
	private Font buttonFont = null;

	private PuzzleLauncher launcher = null;

	public MainMenu(PuzzleLauncher launcher) {
		this.launcher = launcher;
		titleFont = new Font("MS Gothic", 50);
		buttonFont = new Font("MS UI Gothic", 30);
	}

	/**
	 * Initializes the layout for the Main Menu
	 * @return The border pane layout of the menu
	 */
    public BorderPane load() {

    	BorderPane layout = new BorderPane();

        Label title = new Label("Puzzle Launcher");
        title.setFont(titleFont);

        Button b1 = buildPuzzleButton(new PuzzleType1());
        Button b2 = buildPuzzleButton(new PuzzleType1());
        Button b3 = buildPuzzleButton(new PuzzleType1());

        VBox puzzles = new VBox();
        puzzles.setAlignment(Pos.TOP_CENTER);
        puzzles.getChildren().addAll(b1, b2, b3);
        BorderPane.setAlignment(puzzles, Pos.CENTER);

        Button exit = new Button("Exit");
        exit.setAlignment(Pos.CENTER);
        exit.setFont(buttonFont);
		exit.setOnMouseClicked(e -> launcher.getStage().close());

		exit.setBackground(new Background(new BackgroundFill(Color.web("#6d7a0e"), new CornerRadii(0.0), new Insets(0.0))));
		exit.setTextFill(Color.web("#fe964f"));

        layout.setCenter(puzzles);
        layout.setTop(title);
        layout.setBottom(exit);

        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(50,50,50,50));

        layout.setBackground(new Background(new BackgroundFill(Color.web("#c6fbff"), new CornerRadii(0.0), new Insets(0.0))));

        return layout;
    }

    /**
     * Factory for adding Puzzle options to menu
     * @param puzzle An instance of the puzzle being added
     * @return A new puzzle button
     */
    private Button buildPuzzleButton(Puzzle puzzle) {
		Button button = new Button(puzzle.getName());
		button.setAlignment(Pos.CENTER);
		VBox.setMargin(button, new Insets(30, 30, 30, 30));
		button.setOnMouseClicked(e -> launcher.display(puzzle));

		button.setFont(buttonFont);
		button.setBackground(new Background(new BackgroundFill(Color.web("#fe964f"), new CornerRadii(0.0), new Insets(0.0))));
		button.setBorder(new Border(new BorderStroke(Color.web("#6d7a0e"), BorderStrokeStyle.DOTTED, new CornerRadii(0.0), new BorderWidths(10.0))));

		return button;
	}
}
