//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle.model.soccerbox;

public class BoardTile {

	int boardXPos;
	int boardYPos;
	PuzzleBlock occupiedBy;
	boolean isOccupied = false;

	public BoardTile( int xPos, int yPos ) {
		this.boardXPos = xPos;
		this.boardYPos = yPos;
		occupiedBy = null;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public PuzzleBlock occupiedBy() {
		return occupiedBy;
	}

	protected void setOccupied( PuzzleBlock block ) {
	  occupiedBy = block;
	  isOccupied = true;
	}

	public void setUnoccupied() {
		occupiedBy = null;
		isOccupied = false;
	}


}
