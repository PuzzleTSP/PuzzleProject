/**
 * @author Jacob Paivarinta
 * This puzzle is called a Nonograms, Hanjie, Picross, or Griddlers. For this case, we will refer to them as Nonograms.
 * 
 * This puzzle should create an array of m by n size and have toggle-able squares. Typically, there are numbers of squares 
 * 	given above and to the left of each row. The count of black squares is broken by white squares in the row. An example 
 * 	puzzle is located here: http://www.nonograms.org  
 * 
 * This class should be used to display the the Nonogram puzzle class
 */

package puzzle.view;

import javafx.scene.layout.Pane;
import puzzle.model.Puzzle;

public class NonogramViewer implements Puzzle {

	/**
	 * 
	 */
	public NonogramViewer() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzle.model.Puzzle#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzle.model.Puzzle#run()
	 */
	@Override
	public Pane run() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzle.model.Puzzle#exit()
	 */
	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
