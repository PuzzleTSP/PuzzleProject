package puzzle.view;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.nonogram.Square;

public class NonogramController {
	
	private PuzzleLauncher app;
	private Square[][] squares;
	
	@FXML private Rectangle p1A; @FXML private Rectangle p1B; @FXML private Rectangle p1C; @FXML private Rectangle p1D; @FXML private Rectangle p1E;
	@FXML private Rectangle p2A; @FXML private Rectangle p2B; @FXML private Rectangle p2C; @FXML private Rectangle p2D; @FXML private Rectangle p2E;
	@FXML private Rectangle p3A; @FXML private Rectangle p3B; @FXML private Rectangle p3C; @FXML private Rectangle p3D; @FXML private Rectangle p3E;
	@FXML private Rectangle p4A; @FXML private Rectangle p4B; @FXML private Rectangle p4C; @FXML private Rectangle p4D; @FXML private Rectangle p4E;
	@FXML private Rectangle p5A; @FXML private Rectangle p5B; @FXML private Rectangle p5C; @FXML private Rectangle p5D; @FXML private Rectangle p5E;
	
	@FXML
	private void initialize() {
		Rectangle[][] pieces = {{p1A, p1B, p1C, p1D, p1E},
							    {p2A, p2B, p2C, p2D, p2E},
							    {p3A, p3B, p3C, p3D, p3E},
							    {p4A, p4B, p4C, p4D, p4E},
							    {p5A, p5B, p5C, p5D, p5E}};
		
		squares = new Square[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				squares[i][j] = new Square(pieces[i][j]);
			}
		}
	}
	
	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}

}
