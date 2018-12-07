import static org.junit.Assert.*;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import puzzle.controller.SoccerBoxPuzzleController;
import puzzle.model.soccerbox.SoccerBoxGameboard;

public class TestSoccerBox {

	SoccerBoxGameboard testBox = new SoccerBoxGameboard();
	SoccerBoxPuzzleController testController = new SoccerBoxPuzzleController();
	
	
	@Test
	public void testGameboardGeneration() {
		
		assertEquals(false, testBox.getGameBoard()[0][0].isOccupied());    //Should be true
		
		assertEquals(true, testBox.getGameBoard()[0][4].isOccupied());     //Should be false
		
		assertEquals(testBox.getBlocks().get(0), testBox.getGameBoard()[1][0].occupiedBy());   //Should be the goal block
	}
	
	
	@Test
	public void testSetUnoccupied() {
		testBox = new SoccerBoxGameboard();
		
		
		testBox.getGameBoard()[1][0].setUnoccupied();
		
		assertEquals(false, testBox.getGameBoard()[1][0].isOccupied());
	}
	
	@Test
	public void testGoodMoves() {
		
		testBox = new SoccerBoxGameboard();
		
		//Test moves up
		assertEquals( testBox.checkMove( "tallA", KeyCode.UP ), true );
		testBox.logMove( "tallA", KeyCode.UP );
		assertEquals( testBox.gameBoard[0][0].occupiedBy(), testBox.getBlock("tallA") );
		
		//Test moves down
		assertEquals( testBox.checkMove( "tallA" , KeyCode.DOWN ), true);
		testBox.logMove( "tallA", KeyCode.DOWN );
		assertEquals( testBox.gameBoard[0][2].occupiedBy(), testBox.getBlock("tallA") );
		
		//Test moves left
		testBox.logMove( "tallA", KeyCode.UP );
		assertEquals( testBox.checkMove( "wide", KeyCode.LEFT), true );
		testBox.logMove( "wide", KeyCode.LEFT );
		assertEquals( testBox.gameBoard[0][2].occupiedBy(), testBox.getBlock("wide") );
		
		//Test moves right
		assertEquals( testBox.checkMove( "wide", KeyCode.RIGHT ), true );
		testBox.logMove( "wide", KeyCode.RIGHT );
		assertEquals( testBox.gameBoard[1][2].occupiedBy(), testBox.getBlock("wide") );
		
	}
	
	
	
	
	@Test
	public void testMisc() {
		
		testBox = new SoccerBoxGameboard();
		
		//Test null result from getBlock
		assertEquals( testBox.getBlock( "doesntexist"), null );
		
		
		//Test win condition
		//testBox.gameBoard[1][2].setOccupied( testBox.getBlock("goal"));
		testBox.logMove("goal", KeyCode.DOWN);
		testBox.logMove("goal", KeyCode.DOWN);
		testBox.logMove("goal", KeyCode.DOWN);
		assertEquals( testBox.gameBoard[1][3].occupiedBy(), testBox.getBlock("goal"));
		assertEquals( testBox.checkWin(), true );
	}

}