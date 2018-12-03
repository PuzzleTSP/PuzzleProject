package puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.peg.PegMove;
import puzzle.model.towerH.TowerH;

public class TowerHController {
	
	private PuzzleLauncher app;
	private TowerH gameboard;
	
	@FXML Rectangle ring1; @FXML Rectangle ring2; @FXML Rectangle ring3; @FXML Rectangle ring4; @FXML Rectangle ring5;
	@FXML Rectangle tower1; @FXML Rectangle tower2; @FXML Rectangle tower3;
	
	Rectangle fromTower, toTower;
	private Rectangle previousSelected;
	private Rectangle previousHovered;
	
	@FXML
	private void initialize() {	
		gameboard = new TowerH();
	}
	
	/**
	 * closeApp function, required by MVC
	 * 
	 * Terminates the stage
	 */
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	/**
	 * setApp (PuzzleLauncher app) 
	 * 
	 * Stores the application object in use, to be used by the controller to reference the 
	 * scene and stage
	 * 
	 * @param app
	 */
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
	@FXML
	private void towerHover(MouseEvent event) {
		Rectangle pieceHovered = (Rectangle) event.getSource();
		
		if (isSelected(pieceHovered)) {
			deselect(previousHovered);
		} else {
			pieceHovered.setStroke(Color.BLUE);
			deselect(previousHovered);
			previousHovered = pieceHovered;
		}
	}
	
	@FXML 
	private void selectPeg(MouseEvent event) {
		Rectangle selectedTower = (Rectangle) event.getSource();
		
		//add first peg to the move
		if(fromTower == null) {
			fromTower = selectedTower;
			fromTower.setStroke(Color.RED);
			//get appropriate stack
		}
		else {
			toTower = selectedTower;
			
			//check if the move is valid
			if(true) {
				
			}
			else {
				//if not a valid move, reset the move
				
			}
		}
	}
	private void deselect(Rectangle previous) {
		if (previous == null || previous.getStroke().equals(Color.RED)) return;
		previous.setStroke(Color.BLACK);
	}
	
	private Boolean isSelected(Rectangle c) {
		if (c.equals(previousSelected) || c.getStroke().equals(Color.RED)) return true;
		return false;
	}
	
}
