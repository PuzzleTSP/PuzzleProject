package puzzle.model.nonogram;

public class Square {
	
	private SquareState state;
	
	public Square() {
		state = SquareState.EMPTY;
	}
	
	public SquareState getState() {
		return state;
	}
	
	public void setState(SquareState newState) {
		state = newState;
	}
	
	public SquareState update() {
		if (state == SquareState.EMPTY) {
			state = SquareState.FULL;
		} else if (state == SquareState.FULL) {
			state = SquareState.XOUT;
		} else {
			state = SquareState.EMPTY;
		}
		return state;
	}
	
}
