import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.shape.Circle;
import puzzle.controller.PegPuzzleController;
import puzzle.model.peg.PegBoard;
import puzzle.model.peg.PegMove;
public class TestPegPuzzle {
	
	PegPuzzleController testPuzzle;
	
	@Before
	public void start() {
		testPuzzle = new PegPuzzleController();
	}
	
	//Tests for PegPuzzleController.java
	@Test
	public void testInit() {
		testPuzzle.initialize();
		assertEquals(false, testPuzzle.pegList.isEmpty());
	}
	
	@Test
	public void testRefresh() {
		
	}
	
	@Test
	public void testJump() {
		
	}
	
	@Test
	public void testUndo() {
		
	}
	
	//Tests for PegMove.java
	@Test
	public void testValidPegMove() {
		Circle peg1, peg2,peg3,peg4;
		PegMove testMove;
	}
	
	@Test
	public void testGetJumpTriple() {
		
	}
	
	@Test
	public void testPegMovePos() {
		
	}
	
	
}
