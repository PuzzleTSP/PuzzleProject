//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle.model.soccerbox;

public class PuzzleBlock {

	protected int height;
	protected int width;
	protected int topLeftX;
	protected int topLeftY;
	protected String ID;


	public PuzzleBlock () { }

	public PuzzleBlock ( int startingX, int startingY, String ID ) {
		this.topLeftX = startingX;
		this.topLeftY = startingY;
		this.ID = ID;
	}


	public int getX() {
		return topLeftX;
	}
	public int getY() {
		return topLeftY;
	}
	public String getID() {
		return ID;
	}

}
