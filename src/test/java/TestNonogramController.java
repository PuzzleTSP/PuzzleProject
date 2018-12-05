import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import puzzle.controller.NonogramController;
import puzzle.model.nonogram.SquareState;

public class TestNonogramController {
	
	private NonogramController t;
	
	@Before
	public void setup() {
		t = new NonogramController();
		t.initialize();
	}
	
	@Test
	public void testInitialize() {
		assertEquals(0, t.getNumberFull());
		assertEquals(0, t.getCorrectNumberFull());
		assertEquals(10, t.getColLabels().length);
		assertEquals(5, t.getColLabels()[0].length);
		assertEquals(10, t.getRowLabels().length);
		assertEquals(5, t.getRowLabels()[0].length);
		assertEquals(10, t.getSquares().length);
		assertEquals(10, t.getSquares()[0].length);
		assertEquals(10, t.getSolution().length);
		assertEquals(10, t.getSolution()[0].length);
	}
	
	@Test
	public void testLoadNonogram() {
		t.loadNonogram("Moose.txt");
		assertEquals(66, t.getCorrectNumberFull());
		assertEquals(0, t.getSolution()[0][0]);
		assertEquals(1, t.getSolution()[5][6]);
		assertEquals(6, t.getColLabels()[5][4]);
		assertEquals(4, t.getRowLabels()[4][3]);		
	}
	
	@Test
	public void testResetGrid() {
		assertEquals(SquareState.EMPTY, t.getSquares()[4][4].getState());
	}
	
	@Test
	public void testSetLabelText() {
		assertEquals(" ", t.setLabelText(0));
		assertEquals("5", t.setLabelText(5));
	}

}
