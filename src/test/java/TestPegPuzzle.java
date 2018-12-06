import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import puzzle.controller.PegPuzzleController;
import puzzle.model.peg.PegBoard;
import puzzle.model.peg.PegMove;
public class TestPegPuzzle {
	
	
	//Tests for PegMove.java
	@Test
	public void testValidPegMove() {
		Circle peg1, peg2,peg3,peg4,peg5,peg6,peg7,peg8,peg9,peg10,peg11,peg12,peg13,peg14,peg15;
		int i = 1;
		peg1 = new Circle();
		peg2 = new Circle();
		peg3 = new Circle();
		peg4 = new Circle();
		peg5 = new Circle();
		peg6 = new Circle();
		peg7 = new Circle();
		peg8 = new Circle();
		peg9 = new Circle();
		peg10 = new Circle();
		peg11 = new Circle();
		peg12 = new Circle();
		peg13 = new Circle();
		peg14 = new Circle();
		peg15 = new Circle();

		
		PegMove testMove,testSecondMove, testBadMove;
		ArrayList<Circle> pegList = new ArrayList<Circle>();
		
		pegList.add(peg1);
		pegList.add(peg2);
		pegList.add(peg3);
		pegList.add(peg4);
		pegList.add(peg5);
		pegList.add(peg6);
		pegList.add(peg7);
		pegList.add(peg8);
		pegList.add(peg9);
		pegList.add(peg10);
		pegList.add(peg11);
		pegList.add(peg12);
		pegList.add(peg13);
		pegList.add(peg14);
		pegList.add(peg15);
		
		for(Circle c: pegList) {
			c.setFill(Color.web("#ffeb3b"));
			c.setId("peg" + Integer.toString(i));
			i++;
		}
		
				
		pegList.get(7).setFill(Color.WHITE);
		
		testMove = new PegMove(peg10,peg8, pegList);
		testSecondMove = new PegMove(peg3,peg8,pegList);
		testBadMove = new PegMove(peg9,peg8,pegList);
		
		assertEquals(true, testMove.validMove());
		assertEquals(true, testSecondMove.validMove());
		assertEquals(false, testBadMove.validMove());
	}
	
	@Test
	public void testGetJumpTriple() {
		
	}
	
	@Test
	public void testPegMovePos() {
		
	}
	
	//Tests for PegBoard.java
	
	@Test
	public void testPossibleMove() {
		Circle peg1, peg2,peg3,peg4,peg5,peg6,peg7,peg8,peg9,peg10,peg11,peg12,peg13,peg14,peg15;
		int i = 1;
		peg1 = new Circle();
		peg2 = new Circle();
		peg3 = new Circle();
		peg4 = new Circle();
		peg5 = new Circle();
		peg6 = new Circle();
		peg7 = new Circle();
		peg8 = new Circle();
		peg9 = new Circle();
		peg10 = new Circle();
		peg11 = new Circle();
		peg12 = new Circle();
		peg13 = new Circle();
		peg14 = new Circle();
		peg15 = new Circle();

		ArrayList<Circle> pegList = new ArrayList<Circle>();
		
		pegList.add(peg1);
		pegList.add(peg2);
		pegList.add(peg3);
		pegList.add(peg4);
		pegList.add(peg5);
		pegList.add(peg6);
		pegList.add(peg7);
		pegList.add(peg8);
		pegList.add(peg9);
		pegList.add(peg10);
		pegList.add(peg11);
		pegList.add(peg12);
		pegList.add(peg13);
		pegList.add(peg14);
		pegList.add(peg15);
		
		for(Circle c: pegList) {
			c.setFill(Color.web("#ffeb3b"));
			c.setId("peg" + Integer.toString(i));
			i++;
		}
		
		
		pegList.get(7).setFill(Color.WHITE);
		
		PegBoard testBoard = new PegBoard(pegList);
		
		assertEquals(2, testBoard.possibleMove());
		
		pegList.get(7).setFill(Color.web("#ffeb3b"));
		
		testBoard.updateBoard(pegList);
		
		assertEquals(0, testBoard.possibleMove());
	}
	
	@Test
	public void testGetPos() {
		
	}
	
	@Test
	public void updateBoard() {
		
	}
}
