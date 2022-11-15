package common.utilities;

import base.TestBase;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Function;

public class WaitUtils extends TestBase {
	protected static WebDriver driver;
	//static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	public static WebElement fluentWait(final WebElement element){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(60))
	            .pollingEvery(Duration.ofSeconds(60))
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return element;
	        }
	    });
	    return foo;
	};
	
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
    
    public static void loadingWaitElementby(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static WebElement waitVisibility(WebElement element, String elementName) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Assert.assertTrue(false, "Unable to find : " + elementName);
        }
        return element;
    }
    
    @SuppressWarnings("deprecation")
	public static void pageLoadWait() {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
     
}