import javafx.scene.control.Button;

public class Peg {
	
	private int position;
	private Button button;
	
	public Peg(int p, Button b) {
		this.position = p;
		this.button = b;
	}
	
	/**
	 * Figures out possible spots for the peg to jump to
	 * @return array of possible positions peg can jump to
	 */
	public int[] canJumpTo() {
		return null;
	}
	
	/**
	 * @return position of peg on the board
	 */
	public int getPosition() {
		return this.position;
	}
	
}
