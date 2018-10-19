import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class testHello {

	helloworld test = new helloworld();
	
	@Test
	public void testHello () {
		assertEquals("Hello", test.getHello(), "Hello");
	}

}