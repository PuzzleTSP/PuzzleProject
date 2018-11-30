//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/26/18
//*** Description: The 2x1 block subclass of the PuzzleBlock superclass

package puzzle.model.soccerbox;

public class PuzzleBlock2x1 extends PuzzleBlock {

	/* Define height/width for 2x1 puzzle block */
	int width = 2;
	int height = 1;

	public PuzzleBlock2x1 ( int startingX, int startingY, String ID, int height, int width ) {
		super( startingX, startingY, ID, height, width );
	}
}
