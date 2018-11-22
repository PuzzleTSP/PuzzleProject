package puzzle.view;

import java.util.ArrayList;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import puzzle.PuzzleLauncher;
import puzzle.model.peg.PegBoard;
import puzzle.model.peg.PegMove;

//TODO win condition 


public class PegPuzzleController {
	private PuzzleLauncher app;
	
	
	@FXML Circle peg1; @FXML Circle peg2;@FXML Circle peg3;	@FXML Circle peg4; @FXML Circle peg5;
	@FXML Circle peg6; @FXML Circle peg7; @FXML Circle peg8; @FXML Circle peg9; @FXML Circle peg10;
	@FXML Circle peg11; @FXML Circle peg12; @FXML Circle peg13; @FXML Circle peg14; @FXML Circle peg15;
	
	@FXML
	Button refreshButton;
	
	@FXML
	Button undo;
	
	@FXML
	VBox winBox;
	
	@FXML
	Text gameOver;
	
	@FXML
	Button winRestart;
	
	@FXML Text numPegs; @FXML Text winMessage; @FXML Text otherText1; @FXML Text otherText2;
	
	private Circle previousSelected;
	private Circle previousHovered;
	private Circle startCirc, jumpCirc;
	
	ArrayList<Circle> pegList = new ArrayList<Circle>();
	
	PegMove currMove;
	PegBoard gameBoard;
	Circle[] moveTriple;
	Stack<PegMove> moveStack;
	
	
	Color greenFill = Color.rgb(114,204,0);
	
	int numFill;
	
	boolean boardFlip = false ;
	
	@FXML
	private void initialize() {	
		if(pegList.isEmpty()) {
			pegList.add(peg1);
			pegList.add(peg2);
			pegList.add(peg3);
			pegList.add(peg4);
			pegList.add(peg5);
			pegList.add(peg6);
			pegList.add(peg7);
			pegList.add(peg8);
			pegList.add(peg9);
			pegList.add(peg10);
			pegList.add(peg11);
			pegList.add(peg12);
			pegList.add(peg13);
			pegList.add(peg14);
			pegList.add(peg15);
		}
		
		int randPeg = (int)(Math.random() * 15);
		
		pegList.get(randPeg).setFill(Color.WHITE);
		
		startCirc = null;
		jumpCirc = null;
		currMove = null;
		moveStack = new Stack<PegMove>();
		
		gameBoard = new PegBoard(pegList);
		System.out.println(gameBoard.possibleMove());
		numFill = 14;
		
		winBox.setVisible(boardFlip);
		gameOver.setVisible(boardFlip);
		winRestart.setVisible(boardFlip);
		numPegs.setVisible(boardFlip);
		winMessage.setVisible(boardFlip);
		otherText1.setVisible(boardFlip);
		otherText2.setVisible(boardFlip);
		
		
		boardFlip = !boardFlip;
	}
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
	@FXML
	private void refresh() {
		for(Circle c: pegList) {
			c.setFill(greenFill);
		}
		
		int randPeg = (int)(Math.random() * 15);
		
		pegList.get(randPeg).setFill(Color.WHITE);
		
		gameBoard = new PegBoard(pegList);
		
		numFill = 14;
		
		moveStack.removeAllElements();
	}
	
	@FXML
	private void restart() {
		for(Circle c: pegList) {
			c.setFill(greenFill);
		}
		
		int randPeg = (int)(Math.random() * 15);
		
		pegList.get(randPeg).setFill(Color.WHITE);
		
		gameBoard = new PegBoard(pegList);
		moveStack.removeAllElements();

		numFill = 14;
		
		flipVisible();
	}
	
	@FXML
	private void circleHover(MouseEvent event) {
		Circle pieceHovered = (Circle) event.getSource();
		
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
		Circle selectedPeg = (Circle) event.getSource();
		
		//add first peg to the move
		if(startCirc == null) {
			startCirc = selectedPeg;
			startCirc.setStroke(Color.RED);
		}
		else {
			//add second peg to the move
			jumpCirc = selectedPeg;
			jumpCirc.setStroke(Color.RED);
			currMove = new PegMove(startCirc,jumpCirc,pegList);
			
			//check if the move is valid
			if(currMove.validMove()) {
				//get valid move triple
				moveTriple = currMove.getJumpTriple();
				
				//change colors of pegs to make the jump 
				moveTriple[0].setFill(Color.WHITE);
				moveTriple[1].setFill(Color.WHITE);
				moveTriple[2].setFill(greenFill);
				
				startCirc.setStroke(Color.BLACK);
				jumpCirc.setStroke(Color.BLACK);

				startCirc = null;
				jumpCirc = null;
				//add move to the stack of moves
				moveStack.push(currMove);
				
				numFill--;
				
				gameBoard.updateBoard(pegList);
				if(gameBoard.possibleMove() == 0) {
					flipVisible();
				}
			}
			else {
				//if not a valid move, reset the move
				startCirc.setStroke(Color.BLACK);
				jumpCirc.setStroke(Color.BLACK);
				
				startCirc = null;
				jumpCirc = null;
			}
		}
	}
	private void deselect(Circle previous) {
		if (previous == null || previous.getStroke().equals(Color.RED)) return;
		previous.setStroke(Color.BLACK);
	}
	
	private Boolean isSelected(Circle c) {
		if (c.equals(previousSelected) || c.getStroke().equals(Color.RED)) return true;
		return false;
	}
	
	
	@FXML
	private void undo() {
		if(moveStack.isEmpty() == false) {
			PegMove lastMove = moveStack.pop();
		
			Circle[] lastTriple = lastMove.getJumpTriple();
			
			lastTriple[0].setFill(greenFill);
			lastTriple[1].setFill(greenFill);
			lastTriple[2].setFill(Color.WHITE);
		}
	}
	
	public void flipVisible() {
		winBox.setVisible(boardFlip);
		gameOver.setVisible(boardFlip);
		winRestart.setVisible(boardFlip);
		
		numPegs.setText(Integer.toString(numFill));
		numPegs.setVisible(boardFlip);
		
		switch(numFill) {
			case 1:
				winMessage.setText("a genius!");
				break;
			case 2:
				winMessage.setText("pretty smart.");
				break;
			case 3:
				winMessage.setText("just average.");
				break;
			default:
				winMessage.setText("just plain dumb :(");
				break;
		}
		winMessage.setVisible(boardFlip);
		
		undo.setDisable(boardFlip);
		refreshButton.setDisable(boardFlip);
		
		otherText1.setVisible(boardFlip);
		otherText2.setVisible(boardFlip);
		
		for(Circle c: pegList) {
			c.setDisable(boardFlip);
		}
		
		boardFlip = !boardFlip;
	}
	
	
}
