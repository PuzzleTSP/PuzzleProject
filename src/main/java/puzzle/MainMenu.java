package puzzle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *	Creates the UI for the Main Menu.
 *
 *	@author dhmckenz
 */
public class MainMenu {

	private PuzzleLauncher launcher = null;	// References the PuzzleLauncher that it belongs to

	public MainMenu(PuzzleLauncher launcher) {
		this.launcher = launcher;
	}

	/**
	 * Initializes the layout for the Main Menu
	 * @return The border pane layout of the menu
	 */
  public BorderPane load() {
    	BorderPane layout = new BorderPane();

      Label title = new Label("Main Menu");
      title.setFont(new Font(40.0));

      Button b1 = buildPuzzleButton(new PuzzleType1());
      Button b2 = buildPuzzleButton(new PuzzleType1());
      Button b3 = buildPuzzleButton(new PuzzleType1());

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

    /**
     * Factory for adding Puzzle options to menu
     * @param puzzle An instance of the puzzle being added
     * @return A new puzzle button
     */
    private Button buildPuzzleButton(Puzzle puzzle) {
			Button button = new Button(puzzle.getName());
			button.setAlignment(Pos.CENTER);
			button.setFont(new Font(30.0));
			VBox.setMargin(button, new Insets(30, 30, 30, 30));
			button.setOnMouseClicked(e -> launcher.display(puzzle));

			return button;
		}
}
