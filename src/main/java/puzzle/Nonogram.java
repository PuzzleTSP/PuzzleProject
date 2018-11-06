/**
 * @author Jacob Paivarinta
 * This puzzle is called a Nonograms, Hanjie, Picross, or Griddlers. For this case, we will refer to them as Nonograms.
 * 
 * This puzzle should create an array of m by n size and have toggle-able squares. Typically, there are numbers of squares 
 * 	given above and to the left of each row. The count of black squares is broken by white squares in the row. An example 
 * 	puzzle is located here: http://www.nonograms.org  
 */
package puzzle;

import java.util.Scanner;

public class Nonogram {

	private int width, height;
	private int[][] boardMaster; // the master gameboard
	private int[][] boardLiving; // the gameboard that the player will interact with

	/**
	 * initializes the height and width of the nanogram based on the input file
	 */
	public Nonogram(String filePath) {
		Scanner scan = null;
		try {
			scan = new Scanner(filePath);
			width = scan.nextInt();
			height = scan.nextInt();

			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					boardMaster[i][j] = scan.nextInt();
				}
			}

			boardMaster = new int[width][height];
		} catch (Exception e) {
			System.err.println();
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}

	/**
	 * Gets the tile value at the given x and y position, true if filled, false if
	 * empty
	 */
	protected boolean isFilled(int x, int y) {
		return boardMaster[x][y] == boardLiving[x][y];
	}

	public int getValue(int masterOrLiving, int x, int y) {
		if (masterOrLiving == 1) {
			return boardMaster[x][y];
		} else {
			return boardLiving[x][y];
		}
	}

	// *
	public static void main(String[] args) {
		String path = "nonogram_test_3x3.txt";
		Nonogram ng = new Nonogram(path);

		
	}
	/**/
}
