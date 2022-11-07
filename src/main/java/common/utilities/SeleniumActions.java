package common.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import base.TestBase;

public class SeleniumActions extends TestBase {

	public static void selectbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void ClickAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	public static void MoveToIframe(int Indx) {
			driver.switchTo().frame(Indx);
	}
	
	public static void con(int Indx) {
		driver.switchTo().frame(Indx);
}

}
