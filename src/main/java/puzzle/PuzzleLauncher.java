package puzzle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PuzzleLauncher extends Application {

	private MainMenu menu = null;
	private Scene scene = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage stage = primaryStage;
		stage.setFullScreen(true);
		stage.setTitle("PPPP");

		menu = new MainMenu(this);
		scene = new Scene(menu.load());

		stage.setScene(scene);
		stage.show();

	}

	public MainMenu getMenu() {
		return menu;
	}

	public void display(Puzzle puzzle) {

		Pane puzzlePane = puzzle.run();

		BorderPane layout = new BorderPane();

		Label title = new Label(puzzle.getName());
		BorderPane.setAlignment(title, Pos.CENTER);
		BorderPane.setMargin(title, new Insets(50, 50, 50, 50));
		layout.setTop(title);

		BorderPane.setAlignment(puzzlePane, Pos.CENTER_LEFT);
		BorderPane.setMargin(title, new Insets(50, 50, 50, 50));
		layout.setCenter(puzzlePane);

		Button menuButton = new Button("Main Menu");
		menuButton.setOnAction(e -> displayMenu());
		layout.setBottom(menuButton);

		BorderPane.setAlignment(menuButton, Pos.CENTER);
		BorderPane.setMargin(menuButton, new Insets(50, 50, 50, 50));

		scene.setRoot(layout);
	}

	public void displayMenu() {
		scene.setRoot(menu.load());
	}

}
