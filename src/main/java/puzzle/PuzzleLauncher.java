package puzzle;

import javafx.application.Application;
import javafx.stage.Stage;

public class PuzzleLauncher extends Application {

	private Stage stage = null;

	public static void main(String[] args) {
	    launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setFullScreen(true);
        stage.setTitle("PPPP");

        MainMenu.initialize(stage);
		MainMenu.load();
	}
}
