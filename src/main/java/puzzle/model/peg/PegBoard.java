package puzzle.model.peg;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PegBoard {
	
	private ArrayList<Circle> pegs;
	private ArrayList<int[]> currPosMove;
	private int possMove;
	
	private Color greenFill = Color.rgb(114,204,0);
	Color yellowFill = Color.web("#ffeb3b");
	
	Circle start, middle, end;
	
	private int[][] moves = { {1,2,4}, {1,3,6}, 
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
	
	public PegBoard(ArrayList<Circle> pegList) {
		this.pegs = pegList;
		this.possMove = 0;
		this.currPosMove = new ArrayList<int[]>();
	}
	
	public int possibleMove() {
		possMove = 0;
		//go through each peg
		for(Circle c: pegs) {
			int currPos = getPosition(c); //get current peg spot
			
			
			
			//find all moves that start with that peg
			for(int[] move: moves) {
				if(move[0] == currPos) {
					currPosMove.add(move);
				}
			}
		
			for(int[] move: currPosMove) {
				start = pegs.get(move[0] - 1);
				middle = pegs.get(move[1] - 1);
				end = pegs.get(move[2] - 1);
				
				
				if(start.getFill().toString().equals(yellowFill.toString()) && 
						   middle.getFill().toString().equals(yellowFill.toString()) && 
						   end.getFill().toString().equals(Color.WHITE.toString())) {
					possMove++;

				}
				
			}
			
			currPosMove =  new ArrayList<int[]>();
		}
		return possMove;
	}
	
	public int getPosition(Circle c) {
		String circID = c.getId();
		
		return Integer.parseInt(circID.substring(3));
	}
	
	public void updateBoard(ArrayList<Circle> currBoard) {
		this.pegs = currBoard;
	}
}
