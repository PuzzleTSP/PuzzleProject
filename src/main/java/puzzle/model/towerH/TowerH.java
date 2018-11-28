package puzzle.model.towerH;

import java.util.Stack;

public class TowerH {
	private Stack<Integer> Tower1 = new Stack<Integer>();
	private Stack<Integer> Tower2 = new Stack<Integer>();
	private Stack<Integer> Tower3 = new Stack<Integer>();
	
	
	/**
	 * Boolean to tell whether a move is acceptable.
	 */
	protected boolean acceptableMove(Stack<Integer> from, Stack<Integer> to) {
		if (from.peek() < to.peek() ) return false;
		else return true;
	}
	
	
}
