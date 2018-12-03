//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/26/18
//*** Description: The 2x2 block subclass of the PuzzleBlock superclass

package puzzle.model.soccerbox; 

public class PuzzleBlock2x2 extends PuzzleBlock {

	/* Define height/width of 2x2 puzzle block */
	int height = 2;
	int width = 2;
	
	protected PuzzleBlock2x2 ( int startingX, int startingY, String ID, int height, int width ) {
		super( startingX, startingY, ID, height, width );
	}
	
}
