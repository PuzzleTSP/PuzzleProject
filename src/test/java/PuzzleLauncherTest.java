import puzzle.*;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PuzzleLauncherTest {

  private PuzzleLauncher p = null;

  @Before
  public void setup() {
    p = new PuzzleLauncher();
  }

  @Test
  public void sampleTest() {
    //assertEquals(true, p.launch());         launch has no return type
  }
}
