package puzzle.model.nonogram;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SquareState {
	
	private int value;
	private Paint color;
	private Boolean xVisible;
	
	public static final SquareState XOUT = new SquareState(-1, Color.WHITE, true);
	public static final SquareState EMPTY = new SquareState(0, Color.WHITE, false);
	public static final SquareState FULL = new SquareState(1, Color.BLACK, false);

	public SquareState(int value, Paint color, Boolean xVisible) {
		this.value = value;
		this.color = color;
		this.xVisible = xVisible;
	}
	
	public int getValue() {
		return value;
	}
	
	public Paint getColor() {
		return color;
	}
	
	public Boolean getxVisible() {
		return xVisible;
	}
}
