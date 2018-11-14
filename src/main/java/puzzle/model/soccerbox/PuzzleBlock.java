//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle.model.soccerbox;

public class PuzzleBlock {

	public int height;
	public int width;
	protected int topLeftX;
	protected int topLeftY;
	protected String ID;


	public PuzzleBlock () { }

	public PuzzleBlock ( int startingX, int startingY, String ID, int height, int width ) {
		this.topLeftX = startingX;
		this.topLeftY = startingY;
		this.ID = ID;
		this.height = height;
		this.width = width;
	}


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
