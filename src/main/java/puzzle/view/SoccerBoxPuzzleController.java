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

	private boolean movesInit = false;
	
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

	public void initMoves() {
		app.getPrimaryStage().getScene().setOnKeyPressed( new EventHandler<KeyEvent>() {
			@Override
			public void handle( KeyEvent event ) {
				move(event);
			}
		});
	}
	
	
	@FXML
	private void closeApp() {
		app.getPrimaryStage().close();
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
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
	public void outlineHovered(MouseEvent event) {
		Rectangle pieceHovered = (Rectangle) event.getSource();
		if (isSelected(pieceHovered)) {
			deselect(previousHovered);
		} else {
			pieceHovered.setStroke(Color.GOLD);
			deselect(previousHovered);
			previousHovered = pieceHovered;
		}
	}
	
	
	@FXML
	public void move(KeyEvent event) {
		System.out.print( "key event ");
		
		if( previousSelected != null ) {
			
			if( event.getCode() == KeyCode.UP ) {
				if( previousSelected.getY() >= 125 ) {
					previousSelected.setY( previousSelected.getY() - 100 );
				}
			}
			else if( event.getCode() == KeyCode.DOWN ) {
				if( previousSelected.getY() <= 425 ) {
					previousSelected.setY( previousSelected.getY() + 100 );
				}
			}else if( event.getCode() == KeyCode.LEFT ) {
				if( previousSelected.getX() >= 125  ) {
					previousSelected.setX( previousSelected.getX() - 100 );
				}
			}else if( event.getCode() == KeyCode.RIGHT ) {
				if( previousSelected.getX() <= 325 ) {
					previousSelected.setX( previousSelected.getX() + 100 );
				}
			}
			
		}
	}
	
	
	private void deselect(Rectangle previous) {
		if (previous == null) return;
		previous.setStroke(Color.BLACK);
	}
	
	private Boolean isSelected(Rectangle rectangle) {
		if (rectangle.equals(previousSelected)) return true;
		return false;
	}
}
