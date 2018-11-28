package puzzle.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import puzzle.PuzzleLauncher;
import puzzle.controller.SoccerBoxPuzzleController;

public class MainMenuController {
	
	private PuzzleLauncher app;
	private Button previousHovered;
	
	@FXML
	private Button SoccerBoxButton;
	@FXML
	private Button PegButton;
	@FXML
	private Button HanoiButton;
	@FXML
	private Button NonogramButton;

	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void outlineHovered(MouseEvent event) {
		Button pieceHovered = (Button) event.getSource();
		if (previousHovered != null) {
			previousHovered.setBorder(Border.EMPTY);
		}
		pieceHovered.setBorder(new Border(new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, new CornerRadii(3.0), BorderStroke.THIN)));
		previousHovered = pieceHovered;
	}
	
	@FXML
	private void openPuzzle(ActionEvent event) {
		
		// Find view location
		Button selected = (Button) event.getSource();
		String location = null;
		if (selected.equals(SoccerBoxButton)) location = "view/SoccerBoxPuzzle.fxml";
		else if (selected.equals(PegButton)) location = "view/PegPuzzle.fxml";
//		else if (selected.equals(HanoiButton)) resource = "view/TowersOfHanoi.fxml";
		else if (selected.equals(NonogramButton)) location = "view/Nonogram.fxml";
		else location = "view/EmptyPuzzle.fxml";
		
		try {
			// Load Puzzle
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource(location));
            Pane puzzle = (Pane) loader.load();
            
            //Set puzzle as center of root
            app.setCenterDisplay(puzzle);
   
            if (selected.equals(SoccerBoxButton)) {
	            SoccerBoxPuzzleController controller = (SoccerBoxPuzzleController)loader.getController();
	            controller.setApp( app );
	            controller.initMoves();
            }
    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void setApp(PuzzleLauncher app) {
		this.app = app;
	}
	
}
