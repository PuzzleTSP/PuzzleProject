package puzzle.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import puzzle.PuzzleLauncher;

public class MainMenuController {
	
	private PuzzleLauncher app;

	@FXML
	private void initialize() {
		
	}
	
	@FXML
    private void openPuzzle1() {
		try {
			// Load Puzzle 1
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource("view/Puzzle1.fxml"));
            AnchorPane puzzle1 = (AnchorPane) loader.load();
            
            //Set main menu as center of root
            app.setCenterDisplay(puzzle1);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
}
