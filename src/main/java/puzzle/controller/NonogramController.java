package puzzle.controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import puzzle.model.nonogram.Square;
import puzzle.model.nonogram.SquareState;

public class NonogramController {
	
	private Square[][] squares;
	private ObservableList<Node> gridChildren;
	private String[][] colLabels;
	private String[][] rowLabels;
	private int [][] solution;
	private int numberFull;
	private int correctNumberFull;
	
	@FXML
	GridPane grid;
	@FXML
	Label correctBox;
	@FXML
	Label titleBox;
	
	@FXML
	private void initialize() {
		numberFull = 0;
		correctNumberFull = 0;
		
		gridChildren = grid.getChildren();
		colLabels = new String[10][5];
		rowLabels = new String[10][5];
		squares = new Square[10][10];
		solution = new int[10][10];
		
		// Init Squares
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				squares[i][j] = new Square();
			}
		}

		loadNonogram("Cat.txt");
		
		assignLabels();
		
	}
	
	private void assignLabels() {
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
		int rowIndex = GridPane.getRowIndex(rec) - 1;
		int colIndex = GridPane.getColumnIndex(rec) - 1;
		Square square = squares[rowIndex][colIndex];
		
		SquareState state = square.update();
		numberFull += state.getValue();
		rec.setFill(state.getColor());
		
		Boolean xVisible = state.getxVisible();
		gridChildren.get(121 + 2*(10*rowIndex + colIndex)).setVisible(xVisible);
		gridChildren.get(122 + 2*(10*rowIndex + colIndex)).setVisible(xVisible);
		
		if (numberFull == correctNumberFull) {
			checkAnswer();
		}
	}

	@FXML
	private void selectNonogram(ActionEvent event) {
		Button selection = (Button) event.getSource();
		numberFull = 0;
		correctNumberFull = 0;
		loadNonogram(selection.getText() + ".txt");
		assignLabels();
		resetGrid();
		titleBox.setText(selection.getText());
	}
	
	private void resetGrid() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				squares[i][j].setState(SquareState.EMPTY);
				Rectangle rec = (Rectangle) gridChildren.get(12 + 11*i + j);
				rec.setFill(SquareState.EMPTY.getColor());
				gridChildren.get(121 + 2*(10*i + j)).setVisible(false);
				gridChildren.get(122 + 2*(10*i + j)).setVisible(false);
				
				grid.setDisable(false);
				correctBox.setVisible(false);
			}
		}
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
			
			// Load correct states
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					try {
						int correctState = in.nextInt();
						solution[i][j] = correctState;
						correctNumberFull += correctState;
					} 
					catch (Exception e) {
						System.err.println("The file named '" + fileName + "' caused an exception of the type:  " + e);
						System.err.println("This is an error of the method loadNonogram()  in the class NonogramController");
					}
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
	
	private void checkAnswer() {		
		Boolean correct = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (solution[i][j] == 1 && squares[i][j].getState().getValue() != 1) {
					correct = false;
				}
			}
		}
		
		if (correct) {
			grid.setDisable(true);
			correctBox.setVisible(true);
		}
	}
}
