import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import puzzle.model.nonogram.Square;
import puzzle.model.nonogram.SquareState;

public class TestNonogramSquare {
	
	private Square testSquare;
	
	@Before
	public void setup() {
		testSquare = new Square();
	}
	
	@Test
	public void testGetState() {
		assertEquals(SquareState.EMPTY, testSquare.getState());
	}
	
	@Test
	public void testSetState() {
		testSquare.setState(SquareState.XOUT);
		assertEquals(SquareState.XOUT, testSquare.getState());
	}
	
	@Test
	public void testUpdate() {
		testSquare.update();
		assertEquals(SquareState.FULL, testSquare.getState());
		testSquare.update();
		assertEquals(SquareState.XOUT, testSquare.getState());
		testSquare.update();
		assertEquals(SquareState.EMPTY, testSquare.getState());
	}

}
