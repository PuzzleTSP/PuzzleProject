package puzzle.model.nonogram;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Square {
	
	public static int EMPTY = 0;
	public static int FULL = 1;
	private int state;
	
	public Square() {
		state = EMPTY;
	}
	
	public int getState() {
		return state;
	}
	
	public Paint update() {
		if (state == EMPTY) {
			state = FULL;
			return Color.BLACK;
		} else {
			state = EMPTY;
			return Color.WHITE;
		}
	}
}
