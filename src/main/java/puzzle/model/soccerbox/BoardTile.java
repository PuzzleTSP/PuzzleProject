//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 11/12/18
//*** Description: The base tile object, used in a 2D array to create the "gameboard"

package puzzle.model.soccerbox;

public class BoardTile {

	/*Instance variables*/
	int boardXPos;					//Tile X/Y position on the gameboard
	int boardYPos;
	PuzzleBlock occupiedBy;         //The puzzleblock occupying a tile
	boolean isOccupied = false;     //Boolean value, whether a tile is occupied or not

	public BoardTile( int xPos, int yPos ) {
		this.boardXPos = xPos;
		this.boardYPos = yPos;
		occupiedBy = null;
	}

	
	/* Basic getters and setters */
	
	
	public boolean isOccupied() {
		return isOccupied;
	}

	public PuzzleBlock occupiedBy() {
		return occupiedBy;
	}

	public void setOccupied( PuzzleBlock block ) {
	  occupiedBy = block;
	  isOccupied = true;
	}

	public void setUnoccupied() {
		occupiedBy = null;
		isOccupied = false;
	}


}
