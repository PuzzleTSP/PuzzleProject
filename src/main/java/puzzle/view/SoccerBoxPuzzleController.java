package puzzle.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.soccerbox.SoccerBoxGameboard;
import puzzle.model.soccerbox.*;
import javafx.scene.layout.Pane;

public class SoccerBoxPuzzleController {

	
	private SoccerBoxGameboard board = new SoccerBoxGameboard();
	
	
	private PuzzleLauncher app;

	
	
	@FXML
	private void initialize() {	
		
	}
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
	@FXML
	public void outlineSelected( Rectangle piece ) {
		piece.setStroke( Color.RED );
	}
	
}
