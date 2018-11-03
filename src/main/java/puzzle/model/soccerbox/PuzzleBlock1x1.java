package puzzle.model.soccerbox;

public class PuzzleBlock1x1 extends PuzzleBlock {

	int height = 1;
	int width = 1;
	
	
	protected PuzzleBlock1x1 ( int startingX, int startingY ) {                  //All starting positions based on top left corner of piece 
		super( startingX, startingY );
	}
	
	
}
