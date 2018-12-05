import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import puzzle.controller.NonogramController;
import puzzle.model.nonogram.SquareState;

public class TestNonogramController {
	
	private NonogramController t;
	
	@Before
	public void start() {
		t = new NonogramController();
		
	}
	
	@Test
	public void testSetLabelText() {
		assertEquals(" ", t.setLabelText(0));
		assertEquals("5", t.setLabelText(5));
	}

}
