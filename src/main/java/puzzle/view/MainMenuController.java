package puzzle.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
            loader.setLocation(PuzzleLauncher.class.getResource("view/PegPuzzle.fxml"));
            Pane pegPuzzle = (Pane) loader.load();
            try {
				app.init();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //Set main menu as center of root
            app.setCenterDisplay(pegPuzzle);
            
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
