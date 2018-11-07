package puzzle.view;

import java.awt.Stroke;
import java.io.IOException;

import javafx.event.ActionEvent;
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
	private Rectangle goal;
	
	@FXML
	private Rectangle wide;
	@FXML
	private Rectangle tallA;
	@FXML
	private Rectangle tallB;
	@FXML
	private Rectangle tallC;
	@FXML
	private Rectangle tallD;
	@FXML
	private Rectangle singleA;
	@FXML
	private Rectangle singleB;
	@FXML
	private Rectangle singleC;
	@FXML
	private Rectangle singleD;
	
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
	public void outlineSelected(ActionEvent event) {
		Rectangle pieceClicked = (Rectangle) event.getSource();
		pieceClicked.setStroke(Color.RED);
	}
	
}
