//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 11/17/18
//*** Description: The superclass of all puzzleblock objects

package puzzle.model.soccerbox;

public class PuzzleBlock {

	/* Instance variables */
	
	public int height;			//Height and width (in tiles) of the puzzle block
	public int width;
	protected int topLeftX;		//X and Y position on the board, stored as the top left portion of the block
	protected int topLeftY;
	protected String ID;		//An ID (name) for the puzzle block


	public PuzzleBlock () { }

	public PuzzleBlock ( int startingX, int startingY, String ID, int height, int width ) {
		this.topLeftX = startingX;
		this.topLeftY = startingY;
		this.ID = ID;
		this.height = height;
		this.width = width;
	}


	/* Basic getters and setters */
	
	
	public int getX() {
		return topLeftX;
	}
	public int getY() {
		return topLeftY;
	}
	public void setX( int x ) {
		topLeftX = x;
	}
	public void setY( int y ) {
		topLeftY = y;
	}
	public String getID() {
		return ID;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}
