package puzzle.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import puzzle.PuzzleLauncher;

public class MainMenuController {
	
	private PuzzleLauncher app;

	@FXML
	private void initialize() {
		
	}
	
	@FXML
    private void openPegPuzzle() {
		try {
			// Load Puzzle 1
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource("view/PegPuzzle.fxml"));
            BorderPane puzzle1 = (BorderPane) loader.load();
            
            //Set main menu as center of root
            app.setCenterDisplay(puzzle1);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	
	@FXML
    private void openSoccerBox() {
		try {
			// Load SoccerBox
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource("view/SoccerBoxPuzzle.fxml"));
            Pane soccerBox = (Pane) loader.load();
            
            //Set soccer box as center of root
            app.setCenterDisplay(soccerBox);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
}
