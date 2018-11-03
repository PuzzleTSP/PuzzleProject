import static org.junit.Assert.*;
import org.junit.Test;
import puzzle.model.soccerbox.SoccerBoxGameboard;

public class TestSoccerBox {

	SoccerBoxGameboard testBox = new SoccerBoxGameboard();
	
	
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

}