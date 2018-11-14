package puzzle.model.peg;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class PegMove {
	
	private Circle startCirc, endCirc;
	private ArrayList<Circle> pegList;
	private Button button;
	
	//Array of Possible Moves
	int[][] moves = { {1,2,3}, {1,3,6}, 
					  {2}, {}, {}, {}, {}, {},
					  {3}, {}, {}, {}, {}, {},
					  {4}, {}, {}, {}, {}, {},
					  {5}, {}, {}, {}, {}, {},
					  {6}, {}, {}, {}, {}, {},
					  {7}, {}, {}, {}, {}, {},
					  {8}, {}, {}, {}, {}, {},
					  {9}, {}, {}, {}, {}, {},
					  {10}, {}, {}, {}, {}, {},
					  {11}, {}, {}, {}, {}, {},
					  {12}, {}, {}, {}, {}, {},
					  {13}, {}, {}, {}, {}, {},
					  {14}, {}, {}, {}, {}, {},
					  {15}, {}, {}, {}, {}, {}
					
	};
	
	
	
	public PegMove(Circle s,Circle e, ArrayList<Circle> list) {
		this.startCirc = s;
		this.endCirc = e;
		this.pegList = list;
	}

	public boolean moveExist() {
		//find move in array
		//if move is in the array, move on    else return false
		//check if the color are valid for a move, if they are move on    else false
		return false;
	}
	
	/**
	 * @return position of peg on the board
	 */
	public int getPosition(Circle c) {
		String circID = c.getId();
		
		return Integer.getInteger(circID.substring(3));
	}
	
}
