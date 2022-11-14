package pages;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;
import common.utilities.SeleniumActions;
import common.utilities.WaitUtils;

public class ConnectPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public ConnectPage() {
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(css = "h1[id='a11y-title']") private WebElement checkPlaidTextPresence;
	@FindBy(xpath = "//iframe[@id='plaid-link-iframe-7']") public WebElement Iframe;
	@FindBy(xpath = "//span[text()='Continue']") public static WebElement continueButton ;
    @FindBy(css = "#plaid-link-iframe-1") private WebElement frame;
    @FindBy(xpath = "//*[@class='Icons-module_icon__3ePq6']") private WebElement plaidCancelbtn;
    @FindBy(id = "search-input") private WebElement SearchBankTxtBox;
    @FindBy(xpath = "//h2[text()='First Platypus Bank']") private WebElement bankNameopt;
	
	public void WaitToLoadIframe() { 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		try{
		      wait
		      .ignoring(StaleElementReferenceException.class)
		      .ignoring(WebDriverException.class)
		      .until(ExpectedConditions.visibilityOf(frame));
		} catch (Exception ignored){ }
	}
	
	public void webPageZoomOut() {
		SeleniumActions.WebPageZoomOut();
	}
	
	public void SwitchToIframe() {
		SeleniumActions.switchToFrameUsingID("plaid-link-iframe-1");
	}
	
	public void clickOnContinuebtn() {
		try {
            	wait.until(ExpectedConditions.visibilityOf(continueButton));
        } catch (Exception e) {
            Assert.assertTrue(false, "Unable to find : " + "Continue Button");
        }
		WaitUtils.loadingWaitElement(driver, continueButton);
		continueButton.click();
	}
	
	public void waitToplaidCancelbtn() {
		try {
        	wait.until(ExpectedConditions.visibilityOf(plaidCancelbtn));
		} catch (Exception e) {
        	Assert.assertTrue(false, "Unable to find : " + "plaidCancelbtn");
    	}
	}
	
	public void EnterBankNameINSearchBankTxtBox() {
		try {
        			wait.until(ExpectedConditions.visibilityOf(SearchBankTxtBox));
        			if (SearchBankTxtBox.isEnabled()) {
        				SeleniumActions.ClickAction(SearchBankTxtBox);
        				SearchBankTxtBox.sendKeys(properties.getProperty("banakName"));
        			} 
			}	
        	catch (Exception e) {
        		Assert.assertTrue(false, "Unable to find : " + "SearchBankTxtBox");
        	}
		}
	
	public void ClickOnBankName() {
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(bankNameopt));
			SeleniumActions.ClickAction(bankNameopt);
		}	
		catch (Exception e) {
			Assert.assertTrue(false, "Unable to find : " + "bankNameopt");
		}
	}

}

