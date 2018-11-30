//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/26/18
//*** Description: The 1x1 block subclass of the PuzzleBlock superclass


package puzzle.model.soccerbox;

public class PuzzleBlock1x1 extends PuzzleBlock {

	/* Define height/width for 1x1 block */ 
	int height = 1;
	int width = 1;
	
	
	protected PuzzleBlock1x1 ( int startingX, int startingY, String ID, int height, int width ) {
		super( startingX, startingY, ID, height, width );
	}
	
	
}
