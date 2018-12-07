package puzzle.controller;

import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import puzzle.PuzzleLauncher;


public class TowerHController {
	
	private PuzzleLauncher app;

	@FXML Rectangle ring1; @FXML Rectangle ring2; @FXML Rectangle ring3; @FXML Rectangle ring4; @FXML Rectangle ring5;
	@FXML Rectangle tower1; @FXML Rectangle tower2; @FXML Rectangle tower3;
	@FXML VBox endScreenRect;
	
	@FXML Text winText1,numMovesText;
	
	@FXML Button restart;
	
	Rectangle fromTower, toTower;

	private Rectangle fromTow, toTow;
	private Stack<Rectangle> tower1Stack, tower2Stack,tower3Stack;
	
	private int[] yLoc = {438,400,362,324,286};
	private int[] xLoc = {32, 48, 58, 71, 92};

	private Color towerColor = Color.rgb(67, 46, 36);
	
	int moveCounter;
	
	@FXML
	private void initialize() {	

		tower1Stack = new Stack<Rectangle>();
		tower2Stack = new Stack<Rectangle>();
		tower3Stack = new Stack<Rectangle>();
		
		
		tower1Stack.push(ring5);
		tower1Stack.push(ring4);
		tower1Stack.push(ring3);
		tower1Stack.push(ring2);
		tower1Stack.push(ring1);


		fromTow = null;
		toTow = null;
		
		moveCounter = 0;
		
		endScreenRect.setVisible(false);
		restart.setVisible(false);
		numMovesText.setVisible(false);
		winText1.setVisible(false);
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
	
	/**
	 * outlineHovered (MouseEvent event)
	 * 
	 * Handle the logic for hovering over a block, and indicating a hover with a yellow border
	 * 
	 * @param event
	 */
	@FXML
	private void towerHover(MouseEvent event) {
		Rectangle pieceHovered = (Rectangle) event.getSource();
		if(isSelected(pieceHovered) != true)
			pieceHovered.setStroke(Color.GOLD);

	}
	
	@FXML 
	private void towerHoverExit(MouseEvent event) {
		Rectangle pieceHovered = (Rectangle) event.getSource();
		if(isSelected(pieceHovered) != true)
			pieceHovered.setStroke(Color.BLACK);
	}
	

	@FXML
	private void towerSelect(MouseEvent event) {
		Rectangle selectedTower = (Rectangle) event.getSource();
		
		if(fromTow == (null)) {
			fromTow = selectedTower;
			fromTow.setStroke(Color.RED);
			fromTow.setFill(Color.RED);
		}
		else {
			toTow = selectedTower;
			toTow.setStroke(Color.RED);
			toTow.setFill(Color.RED);
			if(fromTow.equals(toTow)) {
				deselect(fromTow);
				deselect(toTow);
				fromTow = null;
				toTow = null;
			}else {
				moveRing(fromTow,toTow);
				moveCounter++;
				updateGraphics();
				deselect(fromTow);
				deselect(toTow);
				fromTow = null;
				toTow = null;
				
				checkWin();
			}
		}
	}
	
	@FXML
	private void restart() {
		tower1Stack = new Stack<Rectangle>();
		tower2Stack = new Stack<Rectangle>();
		tower3Stack = new Stack<Rectangle>();
		
		
		tower1Stack.push(ring5);
		tower1Stack.push(ring4);
		tower1Stack.push(ring3);
		tower1Stack.push(ring2);
		tower1Stack.push(ring1);

		updateGraphics();
		
		fromTow = null;
		toTow = null;
		
		moveCounter = 0;
		
		tower1.setDisable(false);
		tower2.setDisable(false);
		tower3.setDisable(false);
		
		endScreenRect.setVisible(false);
		restart.setVisible(false);
		numMovesText.setVisible(false);
		winText1.setVisible(false);
	}
	
	
	private void deselect(Rectangle rect) {
		rect.setStroke(Color.BLACK);
		rect.setFill(towerColor);
	}
	
	private void moveRing(Rectangle from, Rectangle to) {
		int towerFromNum = Integer.parseInt(from.getId().substring(5));
		int towerToNum = Integer.parseInt(to.getId().substring(5));
		
		Stack<Rectangle> fromStack, toStack;
		fromStack = new Stack<Rectangle>();
		toStack = new Stack<Rectangle>();
		
		switch(towerFromNum) {
		case 1:
			fromStack = tower1Stack;
			break;
		case 2: 
			fromStack = tower2Stack;
			break;
		case 3:
			fromStack = tower3Stack;
			break;
		}
		
		switch(towerToNum) {
		case 1:
			toStack = tower1Stack;
			break;
		case 2: 
			toStack = tower2Stack;
			break;
		case 3:
			toStack = tower3Stack;
			break;
		}
		

		if(fromStack.isEmpty() == false) {
			Rectangle movingRect = fromStack.peek();
			
			Rectangle stackingRect;
			
			//tower you are moving to has no rings 
			if(toStack.isEmpty()) {
				fromStack.pop();
				toStack.push(movingRect);
				
			}
			else {
				stackingRect = toStack.peek();
				
				if(ringSize(movingRect) < ringSize(stackingRect)) {
					fromStack.pop();
					toStack.push(movingRect);
				}
			}
			
			
		}

	}
	
	public int ringSize(Rectangle rect) {
		return Integer.parseInt(rect.getId().substring(4));
	}
	
	private void updateGraphics() {
		for(int i = 0; i< tower1Stack.size(); i++) {
			double correctX = tower1.getLayoutX() - xLoc[ringSize(tower1Stack.get(i)) - 1];
			if(tower1Stack.get(i).getLayoutX() != correctX && tower1Stack.get(i).getLayoutX() != yLoc[i]) {
				tower1Stack.get(i).setLayoutX(correctX);
				tower1Stack.get(i).setLayoutY(yLoc[i]);
			}
		}
		
		for(int i = 0; i< tower2Stack.size(); i++) {
			double correctX = tower2.getLayoutX() - xLoc[ringSize(tower2Stack.get(i)) - 1];

			if(tower2Stack.get(i).getLayoutX() != correctX && tower2Stack.get(i).getLayoutX() != yLoc[i]) {
				tower2Stack.get(i).setLayoutX(correctX);
				tower2Stack.get(i).setLayoutY(yLoc[i]);
			}
		}
		
		for(int i = 0; i< tower3Stack.size(); i++) {
			double correctX = tower3.getLayoutX() - xLoc[ringSize(tower3Stack.get(i)) - 1];

			if(tower3Stack.get(i).getLayoutX() != correctX && tower3Stack.get(i).getLayoutX() != yLoc[i]) {
				tower3Stack.get(i).setLayoutX(correctX);
				tower3Stack.get(i).setLayoutY(yLoc[i]);
			}
		}
	}
	
	private boolean isSelected(Rectangle rect) {
		if(rect.getStroke().equals(Color.RED)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void checkWin() {
		if(tower3Stack.size() == 5) {
			
			numMovesText.setText("You completed the towers in " + moveCounter + " moves");
			
			tower1.setDisable(true);
			tower2.setDisable(true);
			tower3.setDisable(true);
			
			endScreenRect.setVisible(true);
			restart.setVisible(true);
			numMovesText.setVisible(true);
			winText1.setVisible(true);
		}
		
	}
}
