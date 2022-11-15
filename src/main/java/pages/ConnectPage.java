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
    @FindBy(xpath = "(//h2[text()='First Platypus Bank'])") private WebElement bankNameopt;
    @FindBy(xpath = "//span[contains(@class,'Pane-module__logo')]") public static WebElement plaidlogo ;
    @FindBy(xpath = "(//h2[text()='First Platypus Bank'])[2]") private WebElement bankNameopt1;
    @FindBy(xpath = "//h1[text()='Enter your credentials']") private WebElement EnterYourCredentialsPage;
    @FindBy(id = "aut-input-0") private WebElement BankUserNameTxtField;
    @FindBy(id = "aut-input-1") private WebElement BankPasswordTxtField;
    @FindBy(xpath = "//span[text()='Submit']") public static WebElement SubmitButton ;
    @FindBy(className = "Checkbox-module_checkbox__2-1xX") private WebElement SelectAcntCheckbox; 
    @FindBy(xpath = "//span[text()='Allow']") public static WebElement AllowButton ;
	
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
        } catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "Continue Button");}
		WaitUtils.loadingWaitElement(driver, continueButton);
		continueButton.click();
	}
	
	public void waitToplaidCancelbtn() {
		try {
        	wait.until(ExpectedConditions.visibilityOf(plaidCancelbtn));
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "plaidCancelbtn");}
	}
	
	public void EnterBankNameINSearchBankTxtBox() {
		try {
			wait.until(ExpectedConditions.visibilityOf(SearchBankTxtBox));
        			if (SearchBankTxtBox.isEnabled()) {
        				SeleniumActions.ClickAction(SearchBankTxtBox);
        				SearchBankTxtBox.sendKeys(properties.getProperty("banakName"));
        			} 
			} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "SearchBankTxtBox");}
	}
	
	public void ClickOnBankName() {
		try {
			wait.until(ExpectedConditions.visibilityOf(bankNameopt));
			SeleniumActions.ClickAction(bankNameopt);
		}	
		catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "bankNameopt");}
	}
	
	public void BankNameopt1() {
		try {
			wait.until(ExpectedConditions.visibilityOf(plaidlogo));
			SeleniumActions.ClickAction(bankNameopt1);
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "bankNameopt1");}
	} 
	
	public void BankUserNameTxtField() {
		try {
			wait.until(ExpectedConditions.visibilityOf(EnterYourCredentialsPage));
			SeleniumActions.ClickAction(BankUserNameTxtField);
			BankUserNameTxtField.sendKeys(properties.getProperty("Bankusername"));
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "EnterYourCredentialsPage");}
	}
	
	public void BankPasswordTxtField() {
		try {
			wait.until(ExpectedConditions.visibilityOf(EnterYourCredentialsPage));
			SeleniumActions.ClickAction(BankPasswordTxtField);
			BankPasswordTxtField.sendKeys(properties.getProperty("Banakpassword"));
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "EnterYourCredentialsPage");}
	}
	
	public void SubmitButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(SubmitButton));
			SeleniumActions.ClickAction(SubmitButton);
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "SubmitButton");}
	}
	
	public void SelectAcntCheckbox() {
		try {
			wait.until(ExpectedConditions.visibilityOf(SelectAcntCheckbox));
			SeleniumActions.ClickAction(SelectAcntCheckbox);
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "SelectAcntCheckbox");}
	}
	
	public void ClickOnAllowButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(AllowButton));
			SeleniumActions.ClickAction(AllowButton);
		} catch (Exception e) {Assert.assertTrue(false, "Unable to find : " + "AllowButton");}
	}
	
}

