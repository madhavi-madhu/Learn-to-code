package udemy.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import udemy.base.*;
import udemy.pages.FlightBook;
public class FlightBookTest extends Base {
	FlightBook fp;
  public FlightBookTest() throws IOException {
		super();
		}

@Test
  public void selectOrigin() {
	
	fp.selectFrom("Amritsar (ATQ)");
	
  }
}
