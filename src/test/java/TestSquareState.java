import static org.junit.Assert.*;
import org.junit.Test;
import puzzle.model.nonogram.SquareState;
import java.awt.Color;

public class TestSquareState {
	
	@Test
	public void testXOUT() {
		assertEquals(-1, SquareState.XOUT.getValue());
		assertEquals(Color.WHITE, SquareState.XOUT.getColor());
		assertTrue(SquareState.XOUT.getxVisible());
	}
	
	@Test
	public void testEMPTY() {
		assertEquals(0, SquareState.EMPTY.getValue());
		assertEquals(Color.WHITE, SquareState.EMPTY.getColor());
		assertFalse(SquareState.EMPTY.getxVisible());
	}
	
	@Test
	public void testFULL() {
		assertEquals(1, SquareState.FULL.getValue());
		assertEquals(Color.BLACK, SquareState.FULL.getColor());
		assertFalse(SquareState.FULL.getxVisible());
	}
}
