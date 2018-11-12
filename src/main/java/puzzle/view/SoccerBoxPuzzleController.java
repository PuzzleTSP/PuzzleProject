package puzzle.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.soccerbox.SoccerBoxGameboard;

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
	
	private Rectangle previousSelected;
	private Rectangle previousHovered;
	
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
	
	public void initMoves( ) {
		app.getPrimaryStage().getScene().setOnKeyPressed( new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				move(event);
			}
			
		});
	}
	
	@FXML
	public void outlineSelected(MouseEvent event) {
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
	
	@FXML
	private void outlineHovered(MouseEvent event) {
		Rectangle pieceHovered = (Rectangle) event.getSource();
		if (isSelected(pieceHovered)) {
			deselect(previousHovered);
		} else {
			pieceHovered.setStroke(Color.GOLD);
			deselect(previousHovered);
			previousHovered = pieceHovered;
		}
	}
	
	private void deselect(Rectangle previous) {
		if (previous == null) return;
		previous.setStroke(Color.BLACK);
	}
	
	@FXML
	public void move( KeyEvent event ) {
		if( previousSelected != null ) {
			
			Rectangle piece = previousSelected;
			String ID = piece.getId();
			
			
			if( event.getCode() == KeyCode.UP ) {
				if( piece.getLayoutY() >= 125 ) {
					System.out.println( board.checkMove(ID, KeyCode.UP));
					if( board.checkMove(ID, KeyCode.UP ) ) piece.setLayoutY( piece.getLayoutY() - 100 );
				}
			} else if( event.getCode() == KeyCode.DOWN ) {
				if (piece.getLayoutY() + piece.getHeight() <= 425 ) {
					if( board.checkMove(ID, KeyCode.DOWN ) ) piece.setLayoutY( piece.getLayoutY() + 100 );
				}
			}else if( event.getCode() == KeyCode.LEFT ) {
				if (piece.getLayoutX() >= 125 ) {
					if( board.checkMove(ID, KeyCode.LEFT ) ) piece.setLayoutX( piece.getLayoutX() - 100 );
				}
			}else if( event.getCode() == KeyCode.RIGHT ) {
				if (piece.getLayoutX() + piece.getWidth() <= 325 ) {
					if( board.checkMove(ID, KeyCode.RIGHT ) ) piece.setLayoutX( piece.getLayoutX() + 100 );
				}
			}
			
		}
		
		//checkWin();
	}
	
	private Boolean isSelected(Rectangle rectangle) {
		if (rectangle.equals(previousSelected)) return true;
		return false;
	}
}
