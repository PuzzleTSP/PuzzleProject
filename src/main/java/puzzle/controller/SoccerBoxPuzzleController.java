package puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import puzzle.PuzzleLauncher;
import puzzle.model.soccerbox.SoccerBoxGameboard;
import javafx.scene.layout.*;

public class SoccerBoxPuzzleController {

	//Instance variables, gameboard and reference to main application
	private SoccerBoxGameboard board = new SoccerBoxGameboard();	
	private PuzzleLauncher app;
	
	private Rectangle previousSelected;
	private Rectangle previousHovered;

	//FXML tags
	@FXML
	private Pane pane;
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
	private Sphere ball;
	
	
	/**
	 * Initialize function - required by MVC
	 * 
	 */
	@FXML
	private void initialize() {	
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
	 * initMoves()
	 * 
	 * A function which takes the scene (from the application object) and creates
	 * a new event handler for key-presses
	 * 
	 * INTEGRAL FOR MOVEMENT OF PIECES
	 * 
	 */
	public void initMoves( ) {
		pane.requestFocus();
		app.getScene().setOnKeyPressed( new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				move(event);
			}	
		});
		pane.requestFocus();
	}

	
	/**
	 * outlineSelected (MouseEvent event)
	 * 
	 * Handles the logic for clicking on and selecting an individual block
	 * 
	 * @param event
	 */
	@FXML
	public void outlineSelected(MouseEvent event) {
		initMoves();
		Rectangle pieceSelected = (Rectangle) event.getSource();
		if (isSelected(pieceSelected)) {
			pieceSelected.setStroke(Color.GOLD);
			previousHovered = pieceSelected;
			previousSelected = null;
		} else {
			pieceSelected.setStroke(Color.RED);
			deselect(previousSelected);
			previousSelected = pieceSelected;
			previousHovered = null;
		}
	}
	
	/**
	 * outlineHovered (MouseEvent event)
	 * 
	 * Handle the logic for hovering over a block, and indicating a hover with a yellow border
	 * 
	 * @param event
	 */
	@FXML
	private void outlineHovered(MouseEvent event) {
		initMoves();
		Rectangle pieceHovered = (Rectangle) event.getSource();
		if (isSelected(pieceHovered)) {
			deselect(previousHovered);
		} else {
			pieceHovered.setStroke(Color.GOLD);
			deselect(previousHovered);
			previousHovered = pieceHovered;
		}
	}
	
	/**
	 * deselect (Rectangle previous)
	 * 
	 * De-selects the currently chosen (red-bordered) piece
	 * 
	 * @param previous
	 */
	private void deselect(Rectangle previous) {
		if (previous == null) return;
		previous.setStroke(Color.BLACK);
	}
	
	/**
	 * move (KeyEvent event)
	 * 
	 * Receives a key input, and if is accepted (one of the four arrow keys), executes
	 * the move on the game board
	 * 
	 * @param event
	 */
	@FXML
	public void move( KeyEvent event ) {
		if( previousSelected != null ) {           //If there is a piece selected (red-border)
						
			//Retrieve block information
			Rectangle piece = previousSelected;
			String ID = piece.getId();
			boolean goalBlock = (ID.equals("goal"));
			
			System.out.println("Moving " + ID);
			//Handles moves based on the inputted key
			//Format is more or less the same for each case
			
			if( event.getCode() == KeyCode.UP ) {
				if( piece.getLayoutY() >= 125 ) {             //Check bounds of piece
					if( board.checkMove(ID, KeyCode.UP ) ) {           //Check move validity on game board
						piece.setLayoutY( piece.getLayoutY() - 100 );  
						if( goalBlock ) {								//Execute move (and move the ball if needed)
							ball.setLayoutY( ball.getLayoutY() - 100 );
						}
						board.logMove(ID, event.getCode() );       //Log move in to the gameboard object
					} else {
						initMoves();
					}
				}  else {
					initMoves();
				}
			} else if( event.getCode() == KeyCode.DOWN ) {
				if (piece.getLayoutY() + piece.getHeight() <= 425 ) {
					if( board.checkMove(ID, KeyCode.DOWN ) ) {
						piece.setLayoutY( piece.getLayoutY() + 100 );
						if( goalBlock ) {
							ball.setLayoutY( ball.getLayoutY() + 100 );
						}
						board.logMove(ID, event.getCode() );
					} else {
						initMoves();
					}
				} else {
					initMoves();
				}
			}else if( event.getCode() == KeyCode.LEFT ) {
				if (piece.getLayoutX() >= 125 ) {
					if( board.checkMove(ID, KeyCode.LEFT ) ) {
						piece.setLayoutX( piece.getLayoutX() - 100 );
						if( goalBlock ) {
							ball.setLayoutX( ball.getLayoutX() - 100 );
						}
						board.logMove(ID, event.getCode() );
					} else {
						initMoves();
					}
				} else {
					initMoves();
				}
			}else if( event.getCode() == KeyCode.RIGHT ) {
				if (piece.getLayoutX() + piece.getWidth() <= 325 ) {
					if( board.checkMove(ID, KeyCode.RIGHT ) ) {
						piece.setLayoutX( piece.getLayoutX() + 100 );
						if( goalBlock ) {
							ball.setLayoutX( ball.getLayoutX() + 100 );
						}
						board.logMove(ID, event.getCode() );
					} else {
						initMoves();
					}
				} else {
					initMoves();
				}
			}
			
		}
		
		initMoves();
		
		//After each move, check the position of the goal block for a win
		
		if( board.checkWin() ) {
			app.showMainMenu();
		}
	}
	
	/**
	 * isSelected()
	 * 
	 * return whether a rectangle (puzzle block) is selected
	 * 
	 * @param rectangle
	 * @return
	 */
	private Boolean isSelected(Rectangle rectangle) {
		if (rectangle.equals(previousSelected)) return true;
		return false;
	}
	
}
