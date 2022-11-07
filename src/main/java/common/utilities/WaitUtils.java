package common.utilities;

import base.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtils extends TestBase {
	protected static WebDriver driver;

    public static void JsExecutor(WebElement Element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Element);
    }
    
    public static void loadingWait(WebDriver driver, WebElement loader) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
        wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
    }
    
    public static void loadingWaitElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to appear
    }
    
    public static void loadingWaitElementby(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    @SuppressWarnings("deprecation")
	public static void pageLoadWait() {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
}