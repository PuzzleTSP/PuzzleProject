//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle;

public class BoardTile {

	int boardXPos;
	int boardYPos;
	PuzzleBlock occupiedBy;

	protected BoardTile( int xPos, int yPos ) {
		this.boardXPos = xPos;
		this.boardYPos = yPos;
	}

	protected boolean isOccupied() {
		return (occupiedBy != null);
	}

	protected PuzzleBlock occupiedBy() {
		return occupiedBy;
	}

	protected void setOccupied( PuzzleBlock block ) {
	  occupiedBy = block;
	}

	protected void setUnoccupied() {
		occupiedBy = null;
	}


}
