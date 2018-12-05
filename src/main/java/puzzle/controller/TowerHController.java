package puzzle.controller;

import java.util.Stack;

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
	private Rectangle fromTow, toTow;
	private Stack<Rectangle> tower1Stack, tower2Stack,tower3Stack;
	
	private int[] yLoc = {438,400,362,324,286};
	private int[] xLoc = {32, 48, 58, 71, 92};
	private int[] xTow1 = {0,21,34,46,60};
	private int[] xTow2 = {245,266,279,291,305};
	private int[] xTow3 = {496,517,530,542,556};
	
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
		}
		else {
			toTow = selectedTower;
			if(fromTow.equals(toTow)) {
				deselect(fromTow);
				fromTow = null;
				toTow = null;
			}else {
				moveRing(fromTow,toTow);
				System.out.println("finishedMove");
				updateGraphics();
				deselect(fromTow);
				deselect(toTow);
				fromTow = null;
				toTow = null;
			}
		}
	}
	
	private void deselect(Rectangle rect) {
		rect.setStroke(Color.BLACK);
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
			if(tower1Stack.get(i).getLayoutX() != xTow1[i] && tower1Stack.get(i).getLayoutX() != yLoc[i]) {
				tower1Stack.get(i).setLayoutX(tower1.getLayoutX() - xLoc[ringSize(tower1Stack.get(i)) - 1]);
				tower1Stack.get(i).setLayoutY(yLoc[i]);
			}
		}
		
		for(int i = 0; i< tower2Stack.size(); i++) {
			if(tower2Stack.get(i).getLayoutX() != xTow2[i] && tower2Stack.get(i).getLayoutX() != yLoc[i]) {
				tower2Stack.get(i).setLayoutX(tower2.getLayoutX() - xLoc[ringSize(tower2Stack.get(i)) - 1]);
				tower2Stack.get(i).setLayoutY(yLoc[i]);
			}
		}
		
		for(int i = 0; i< tower3Stack.size(); i++) {
			if(tower3Stack.get(i).getLayoutX() != xTow3[i] && tower3Stack.get(i).getLayoutX() != yLoc[i]) {
				tower3Stack.get(i).setLayoutX(tower3.getLayoutX() - xLoc[ringSize(tower3Stack.get(i)) - 1]);
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
	
}
