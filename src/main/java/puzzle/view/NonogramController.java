package puzzle.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import puzzle.PuzzleLauncher;
import puzzle.model.nonogram.Square;

public class NonogramController {
	
	private PuzzleLauncher app;
	private Square[][] squares;
	private ObservableList<Node> gridChildren;
	private String[][] colLabels;
	private String[][] rowLabels;
	
	@FXML
	GridPane grid;
	
	@FXML
	private void initialize() {
		gridChildren = grid.getChildren();
		colLabels = new String[10][5];
		rowLabels = new String[10][5];
		squares = new Square[10][10];
		
		// Init Squares
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				squares[i][j] = new Square();
			}
		}

		loadNonogram("cat.txt");
		
		// check that children are correct
//		for (int i = 0; i <= 10; i++) {
//			for (int j = 0; j <= 10; j++) {
//				Node child = gridChildren.get(11*i+j);
//				System.out.println(GridPane.getRowIndex(child) + " " + GridPane.getColumnIndex(child));
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < 10; i++) {
			VBox vBox = (VBox) gridChildren.get(i+1);
			ObservableList<Node> vBoxChildren = vBox.getChildren();
			
			HBox hBox = (HBox) gridChildren.get(11*(i+1));
			ObservableList<Node> hBoxChildren = hBox.getChildren();
			
			for (int j = 0; j < 5; j++) {
				Label colLabel = (Label) vBoxChildren.get(j);
				colLabel.setText(colLabels[i][j]);
				
				Label rowLabel = (Label) hBoxChildren.get(j);
				rowLabel.setText(rowLabels[i][j]);
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

	private void loadNonogram(String fileName) {
		File modelNonogramDir = new File("./src/main/java/puzzle/model/nonogram");
		try (Scanner in = new Scanner(new File(modelNonogramDir, fileName))) {
			// Load column labels
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					colLabels[i][4-j] = setLabelText(in.nextInt());
				}
			}
			// Load row labels
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					rowLabels[i][4-j] = setLabelText(in.nextInt());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String setLabelText(int num) {
		String labelText = " ";
		if (num > 0) {
			labelText = String.valueOf(num);
		}
		return labelText;
	}
}
