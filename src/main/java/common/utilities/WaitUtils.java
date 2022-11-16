package common.utilities;

import base.TestBase;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends TestBase {
	
	public static void JsExecutor(WebElement Element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Element);
    }
    
    public void loadingWait(WebDriver driver, WebElement loader) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loader));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }
    
    public static void loadingWaitElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitUntilURLexistText(WebDriver driver,String text) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.urlContains(text));
    }
    
}