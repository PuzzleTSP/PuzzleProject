package puzzle.controller;

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
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}

}
