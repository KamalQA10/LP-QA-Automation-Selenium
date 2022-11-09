package pages;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TestBase;
import common.utilities.SeleniumActions;

public class BankInformationPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public BankInformationPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css = ".bank-info-card") public static WebElement CONNECTYOURBANKACCOUNTNOW ;
	
	public boolean isCONNECTYOURBANKACCOUNTNOWDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try{
		      wait
		      .ignoring(ElementNotInteractableException.class, NoSuchElementException.class)
		      .until(ExpectedConditions.visibilityOf(CONNECTYOURBANKACCOUNTNOW));
		} catch (Exception ignored){ }
		return CONNECTYOURBANKACCOUNTNOW.isDisplayed();
	}
	
	public void cONNECTYOURBANKACCOUNTNOW() throws InterruptedException {
		SeleniumActions.ClickAction(CONNECTYOURBANKACCOUNTNOW);
	}
}



