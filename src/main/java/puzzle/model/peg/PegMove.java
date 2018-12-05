package puzzle.model.peg;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PegMove {
	
	private Circle startCirc, middleCirc, endCirc;
	private ArrayList<Circle> pegList;
	
	private Circle[] jumpTriple = new Circle[3];
	
	private Color greenFill = Color.rgb(114,204,0);
	Color yellowFill = Color.web("#ffeb3b");
	
	//Array of Possible Moves
	int[][] moves = { {1,2,4}, {1,3,6}, 
					  {2,4,7}, {2,5,9},
					  {3,5,8}, {3,6,10},
					  {4,2,1}, {4,5,6}, {4,8,13}, {4,7,11},
					  {5,8,12}, {5,9,14},
					  {6,3,1}, {6,5,4}, {6,9,13}, {6,10,15},
					  {7,4,2}, {7,8,9},
					  {8,5,3}, {8,9,10},
					  {9,8,7}, {9,5,2},
					  {10,6,3}, {10,9,8},
					  {11,7,4}, {11,12,13},
					  {12,8,5}, {12,13,14},
					  {13,8,4}, {13,9,6}, {13,12,11}, {13,14,15}, 
					  {14,13,12}, {14,9,5},
					  {15,10,6}, {15,14,13}			
	};
	
	
	
	public PegMove(Circle s,Circle e, ArrayList<Circle> list) {
		this.startCirc = s;
		this.endCirc = e;
		this.pegList = list;
	}

	public boolean validMove() {
		//find move in array
		int first = getPosition(startCirc);
		int last = getPosition(endCirc);		
		
		for(int[] t: moves) {
			if(t[0] == first && t[2] == last) {
				for(Circle c: pegList) {
					if(Integer.parseInt(c.getId().substring(3)) == t[1]) {
						middleCirc = c;
					}
				}
				if(startCirc.getFill().toString().equals(yellowFill.toString()) && 
				   middleCirc.getFill().toString().equals(yellowFill.toString()) && 
				   endCirc.getFill().toString().equals(Color.WHITE.toString())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @return position of peg on the board
	 */
	public int getPosition(Circle c) {
		String circID = c.getId();
		
		return Integer.parseInt(circID.substring(3));
	}
	
	public Circle[] getJumpTriple() {
		jumpTriple[0] = startCirc;
		jumpTriple[1] = middleCirc;
		jumpTriple[2] = endCirc;
		
		return jumpTriple;
	}
	
}
