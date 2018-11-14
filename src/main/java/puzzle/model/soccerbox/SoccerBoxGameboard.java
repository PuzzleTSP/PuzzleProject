//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

package puzzle.model.soccerbox;

import java.util.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class SoccerBoxGameboard {

	// Instance variables, 2D-array of BoardTile's functions as gameBoard
	// "blocks" functions as the list of pieces on the board.

	public BoardTile[][] gameBoard = null;

	/*
	 * @return Returns the gameboard, an array of BoardTile elements
	 */
	public BoardTile[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(BoardTile[][] gameBoard) {
		 this.gameBoard = gameBoard;
	}

	public ArrayList<PuzzleBlock> getBlocks() {
		return blocks;
	}

	//public void setBlocks(ArrayList<PuzzleBlock> blocks) {
		// this.blocks = blocks;
	//}

	protected ArrayList<PuzzleBlock> blocks = new ArrayList<PuzzleBlock>(10);

	// Constructor, initializes the gameboard and pieces
	public SoccerBoxGameboard() {

		gameBoard = new BoardTile[4][5]; // Create Board
		initBlocks(); // Initialize puzzle blocks

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				gameBoard[i][j] = new BoardTile(i, j); // Initialize board tiles
			}
		}

		initOccupations(); // Assign puzzle blocks to their tiles

	}

	/*
	 * void initBlocks()
	 * 
	 * A method which creates the 10 puzzle piece objects and assigns them their
	 * starting x/y positions.
	 * 
	 */

	public void initBlocks() {

		PuzzleBlock goal = new PuzzleBlock2x2(1, 0, "goal");
		blocks.add(goal);
		PuzzleBlock singleA = new PuzzleBlock1x1(1, 3, "singleA");
		blocks.add(singleA);
		PuzzleBlock singleB = new PuzzleBlock1x1(1, 4, "singleC");
		blocks.add(singleB);
		PuzzleBlock singleC = new PuzzleBlock1x1(2, 3, "singleB");
		blocks.add(singleC);
		PuzzleBlock singleD = new PuzzleBlock1x1(2, 4, "singleD");
		blocks.add(singleD);
		PuzzleBlock wide = new PuzzleBlock2x1(1, 2, "wide");
		blocks.add(wide);
		PuzzleBlock tallA = new PuzzleBlock1x2(0, 1, "tallA");
		blocks.add(tallA);
		PuzzleBlock tallB = new PuzzleBlock1x2(0, 3, "tallC");
		blocks.add(tallB);
		PuzzleBlock tallC = new PuzzleBlock1x2(3, 1, "tallB");
		blocks.add(tallC);
		PuzzleBlock tallD = new PuzzleBlock1x2(3, 3, "tallD");
		blocks.add(tallD);

	}

	public void initOccupations() {

		for (PuzzleBlock p : blocks) {
			if (p instanceof PuzzleBlock2x2) {
				int x = p.getX();
				int y = p.getY();

				gameBoard[x][y].setOccupied(p);
				gameBoard[x + 1][y].setOccupied(p);
				gameBoard[x][y + 1].setOccupied(p);
				gameBoard[x + 1][y + 1].setOccupied(p);

			} else if (p instanceof PuzzleBlock1x2) {
				int x = p.getX();
				int y = p.getY();

				gameBoard[x][y].setOccupied(p);
				gameBoard[x][y + 1].setOccupied(p);
			} else if (p instanceof PuzzleBlock2x1) {
				int x = p.getX();
				int y = p.getY();

				gameBoard[x][y].setOccupied(p);
				gameBoard[x + 1][y].setOccupied(p);
			} else {
				int x = p.getX();
				int y = p.getY();

				gameBoard[x][y].setOccupied(p);
			}
		}
		
	}
	
	public boolean checkMove( String ID, KeyCode code ) {
		boolean result = true;
		PuzzleBlock piece = getBlock(ID);
		int xPos = piece.getX();
		int yPos = piece.getY();
				
		if( code == KeyCode.UP ) {
			int width = piece.width;
			for( int i = 0; i < width; i++ ) {
				System.out.println( gameBoard[0][0].isOccupied() );
				System.out.println( gameBoard[xPos + i][yPos - 1].isOccupied() );
				if( gameBoard[xPos + i][yPos - 1].isOccupied() ) {
					result = false;
				}
			}
		}else if( code == KeyCode.DOWN ) {
			int width = piece.width;
			for( int i = 0; i < width; i++ ) {
				if( gameBoard[xPos + i][yPos + 1].isOccupied() ) {
					result = false;
				}
			}
		}else if( code == KeyCode.LEFT ) {
			int height = piece.height;
			for( int i = 0; i < height; i++ ) {
				if( gameBoard[xPos - 1][yPos + i].isOccupied() ) {
					result = false;
				}
			}
		}else if( code == KeyCode.RIGHT ) {
			int height = piece.height;
			for( int i = 0; i < height; i++ ) {
				if( gameBoard[xPos + 1][yPos + i].isOccupied() ) {
					result = false;
				}
			}
		}
		
		return result;
	}
	
	
	public void logMove( String ID, KeyCode code ) {
		
	}

	
	public PuzzleBlock getBlock( String ID ) {
		PuzzleBlock result = null;
		for( PuzzleBlock block : blocks ) {
			if( block.getID().equals(ID) ) {
				return block;
			}
		}
		return result;
	}
	
	
	
	
}
