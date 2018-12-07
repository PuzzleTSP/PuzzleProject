import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.*;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import puzzle.controller.TowerHController;


public class TestTowers {
	private Stack<Rectangle> tower1Stack, tower2Stack, tower3Stack;
	Rectangle tower1 = new Rectangle();;  Rectangle tower2 = new Rectangle();  Rectangle tower3 = new Rectangle();
	Rectangle ring1 = new Rectangle();  Rectangle ring2 = new Rectangle(); 
	Rectangle ring3 = new Rectangle();  Rectangle ring4 = new Rectangle();
	Rectangle ring5 = new Rectangle();
	TowerHController testTowers;
	
	@Before
	public void start() {
		testTowers = new TowerHController();
		tower1Stack = new Stack<Rectangle>();
		tower2Stack = new Stack<Rectangle>();
		tower3Stack = new Stack<Rectangle>();
		
		
		tower1Stack.push(ring5);
		tower1Stack.push(ring4);
		tower1Stack.push(ring3);
		tower1Stack.push(ring2);
		tower1Stack.push(ring1);
		ring1.setId("ring" + Integer.toString(1));
		ring2.setId("ring" + Integer.toString(2));
		ring3.setId("ring" + Integer.toString(3));
		ring4.setId("ring" + Integer.toString(4));
		ring5.setId("ring" + Integer.toString(5));
		tower1.setId("tower" + Integer.toString(1));
		tower2.setId("tower" + Integer.toString(2));
		
		
	}
	
	@Test
	public void testRingSize() {
		assertEquals(true, testTowers.ringSize(ring1) == 1);
		assertEquals(true, testTowers.ringSize(ring2) == 2);
		assertEquals(true, testTowers.ringSize(ring3) == 3);
		assertEquals(true, testTowers.ringSize(ring4) == 4);
		assertEquals(false, testTowers.ringSize(ring5) == 1);
	}
	
}
