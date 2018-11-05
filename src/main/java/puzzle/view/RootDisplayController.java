package puzzle.view;

import javafx.fxml.FXML;
import puzzle.PuzzleLauncher;

public class RootDisplayController {
	
	private PuzzleLauncher app;
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void openMainMenu() {
		app.showMainMenu();
	}
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}

}
