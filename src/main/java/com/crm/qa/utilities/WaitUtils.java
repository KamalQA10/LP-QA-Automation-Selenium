package com.crm.qa.utilities;

import com.crm.qa.base.TestBase;
import com.google.common.base.Function;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


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
    
}