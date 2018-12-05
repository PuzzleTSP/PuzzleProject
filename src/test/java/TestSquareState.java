import static org.junit.Assert.*;
import org.junit.Test;
import puzzle.model.nonogram.SquareState;
import java.awt.Color;

public class TestSquareState {
	
	@Test
	public void testXOUT() {
		assertEquals(-1, SquareState.XOUT.getValue());
		assertTrue(SquareState.XOUT.getxVisible());
	}
	
	@Test
	public void testEMPTY() {
		assertEquals(0, SquareState.EMPTY.getValue());
		assertFalse(SquareState.EMPTY.getxVisible());
	}
	
	@Test
	public void testFULL() {
		assertEquals(1, SquareState.FULL.getValue());
		assertFalse(SquareState.FULL.getxVisible());
	}
}
