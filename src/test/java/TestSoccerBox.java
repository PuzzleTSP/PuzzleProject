import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSoccerBox {

	SoccerBoxGameboard testBox = new SoccerBoxGameboard();
	
	
	@Test
	public void testGameboardGeneration() {
		
		assertEquals(false, testBox.gameBoard[0][0].isOccupied());    //Should be true
		
		assertEquals(true, testBox.gameBoard[0][4].isOccupied());     //Should be false
		
		assertEquals(testBox.blocks.get(0), testBox.gameBoard[1][0].occupiedBy());   //Should be the goal block
	}
	
	
	@Test
	public void testSetUnoccupied() {
		testBox = new SoccerBoxGameboard();
		
		
		testBox.gameBoard[1][0].setUnoccupied();
		
		assertEquals(false, testBox.gameBoard[1][0].isOccupied());
	}

}