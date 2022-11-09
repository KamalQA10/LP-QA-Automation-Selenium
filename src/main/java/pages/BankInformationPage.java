package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import base.TestBase;
import common.utilities.SeleniumActions;
import common.utilities.WaitUtils;

public class BankInformationPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public BankInformationPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css = ".bank-info-card") public static WebElement CONNECTYOURBANKACCOUNTNOW ;
	
	public boolean isCONNECTYOURBANKACCOUNTNOWDisplayed() {
		wait.until( ExpectedConditions.elementToBeClickable(CONNECTYOURBANKACCOUNTNOW));
		return CONNECTYOURBANKACCOUNTNOW.isDisplayed();
	}
	
	public void cONNECTYOURBANKACCOUNTNOW() throws InterruptedException {
		//WaitUtils.loadingWait(driver, CONNECTYOURBANKACCOUNTNOW);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", CONNECTYOURBANKACCOUNTNOW);
		SeleniumActions.ClickAction(CONNECTYOURBANKACCOUNTNOW);
	}
}



