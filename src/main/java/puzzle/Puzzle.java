package puzzle;

import javafx.scene.Scene;

/**
 * Outline for Puzzle functionality
 *
 * @author dhmckenz
 *
 */
public interface Puzzle {

	public String getName();

	public Scene run();

	public void exit();

	/**
	 * Puzzles must be able to run and exit. Additional suggested functionality:
	 * - Display rules
	 * - Undo move
	 * - Reset Puzzle
	 * - New puzzle
	 */

}
