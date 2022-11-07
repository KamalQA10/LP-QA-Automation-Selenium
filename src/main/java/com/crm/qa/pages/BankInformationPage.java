package com.crm.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.WaitUtils;

public class BankInformationPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public BankInformationPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "(//div[@class='bank-info-card']/img)") public static WebElement CONNECTYOURBANKACCOUNTNOW ;
	
	public boolean isCONNECTYOURBANKACCOUNTNOWDisplayed() {
		wait.until( ExpectedConditions.visibilityOf(CONNECTYOURBANKACCOUNTNOW));
		return CONNECTYOURBANKACCOUNTNOW.isDisplayed();
	}
	
	public void cONNECTYOURBANKACCOUNTNOW() {
		if(CONNECTYOURBANKACCOUNTNOW.isDisplayed()) {
			CONNECTYOURBANKACCOUNTNOW.click();
		}
	}
}
