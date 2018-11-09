package puzzle.view;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;

public class PegPuzzleController {
	private PuzzleLauncher app;
	
	@FXML
	private Circle peg1;
	@FXML
	private Circle peg2;
	@FXML
	private Circle peg3;
	@FXML
	private Circle peg4;
	@FXML
	private Circle peg5;
	@FXML
	private Circle peg6;
	@FXML
	private Circle peg7;
	@FXML
	private Circle peg8;
	@FXML
	private Circle peg9;
	@FXML
	private Circle peg10;
	@FXML
	private Circle peg11;
	@FXML
	private Circle peg12;
	@FXML
	private Circle peg13;
	@FXML
	private Circle peg14;
	@FXML
	private Circle peg15;
	
	private Circle previousSelected;
	private Circle previousHovered;
	
	private ArrayList<Circle> pegs = new ArrayList<Circle>();
	
	@FXML
	private void initialize() {	
		if(pegs.isEmpty()) {
			pegs.add(peg1);
			pegs.add(peg2);
			pegs.add(peg3);
			pegs.add(peg4);
			pegs.add(peg5);
			pegs.add(peg6);
			pegs.add(peg7);
			pegs.add(peg8);
			pegs.add(peg9);
			pegs.add(peg10);
			pegs.add(peg11);
			pegs.add(peg12);
			pegs.add(peg13);
			pegs.add(peg14);
			pegs.add(peg15);
		}
		
		int startPeg = (int) (Math.random() * 14);
		
		pegs.get(startPeg).setFill(Color.WHITE);
	}
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
	
}
