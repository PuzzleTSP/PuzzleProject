package puzzle.model.nonogram;

import javafx.scene.shape.Rectangle;

public class Square {
	
	private Rectangle piece;
	public static int EMPTY = 0;
	public static int FULL = 1;
	private int state;
	
	public Square(Rectangle piece) {
		this.piece = piece;
		state = 0;
	}
	
	public Rectangle getPiece() {
		return piece;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}

}
