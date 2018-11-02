//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle;

public class PuzzleBlock {

	protected int height;
	protected int width;
	protected int topLeftX;
	protected int topLeftY;


	public PuzzleBlock () { }

	public PuzzleBlock ( int startingX, int startingY ) {
		this.topLeftX = startingX;
		this.topLeftY = startingY;
	}


	public int getX() {
		return topLeftX;
	}
	public int getY() {
		return topLeftY;
	}

}
