package puzzle.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.nonogram.Square;

public class NonogramController {
	
	private PuzzleLauncher app;
	private Square[][] squares;
	
	@FXML private Label row1; @FXML private Label row2; @FXML private Label row3; @FXML private Label row4; @FXML private Label row5;
	@FXML private Label row6; @FXML private Label row7; @FXML private Label row8; @FXML private Label row9; @FXML private Label row10;
	@FXML private Label col1; @FXML private Label col2; @FXML private Label col3; @FXML private Label col4; @FXML private Label col5;
	@FXML private Label col6; @FXML private Label col7; @FXML private Label col8; @FXML private Label col9; @FXML private Label col10;
	
	@FXML
	private void initialize() {
		squares = new Square[10][10];
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				squares[i][j] = new Square();
			}
		}
	}
	
	@FXML
	private void Select(MouseEvent event) {
		Rectangle rec = (Rectangle) event.getSource();
		Square square = squares[GridPane.getRowIndex(rec)-1][GridPane.getColumnIndex(rec)-1];
		rec.setFill(square.update());
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}

}
