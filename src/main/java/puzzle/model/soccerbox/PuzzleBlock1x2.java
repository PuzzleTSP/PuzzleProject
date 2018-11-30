//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/26/18
//*** Description: The 1x2 block subclass of the PuzzleBlock superclass

package puzzle.model.soccerbox;

public class PuzzleBlock1x2 extends PuzzleBlock {

	/* Define height/width for 1x2 blocks */
	int width = 1;
	int height = 2;
	
	protected PuzzleBlock1x2 ( int startingX, int startingY, String ID, int height, int width ) {
		super( startingX, startingY, ID, height, width );
	}

}

