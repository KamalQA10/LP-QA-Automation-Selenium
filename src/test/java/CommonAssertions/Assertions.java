package CommonAssertions;

import base.TestBase;
import static org.testng.AssertJUnit.assertTrue;

public class Assertions extends TestBase {
	
	public static void verifyPageIsOpenedSucessfully(String Text) {
		assertTrue(driver.getCurrentUrl().contains(Text));
	}
	
	public static void verifyButtonIsDisplayingOrNot(boolean flag) {	
		assertTrue(flag);
	}
	
}