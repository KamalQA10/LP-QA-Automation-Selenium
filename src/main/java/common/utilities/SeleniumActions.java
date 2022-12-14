package common.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class SeleniumActions extends TestBase {
	private static JavascriptExecutor js = (JavascriptExecutor) driver;

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
	
    public static void switchToFrameUsingID(String id) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id)));
        } catch (Exception e) {
            Assert.assertTrue(false, "Unable to switch to the frame. " + e);
        }
        return;
    }
    
	public static void WebPageZoomOut()
    {
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("document.body.style.zoom = '0.1'");
    }
	
	public static void ScrollDown()
    {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll down perfomed");
    }
	
	public static void JsExecutorTillElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void JsExecutorTillElements(String string) {	
        js.executeScript("arguments[0].scrollIntoView();", string);
	}
	
}
