package com.crm.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.WaitUtils;

public class SelectAnOfferPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	public SelectAnOfferPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "(//span[@class='choose'])[1]") public static WebElement ChooseAnOfferBtn;
	@FindBy(xpath = "//*[@class='ld ld-ring ld-spin lp-spinner']") WebElement ChooseBtnLoader;
	@FindBy(xpath = "(//span[@class='ico-selected'])[1]") WebElement OfferSelectedTickBttn;
	@FindBy(xpath = "//div[@class='modal-header']/button") WebElement ClosebtnEnter4digitCode;
	
	public boolean isChooseAnOfferBtnDisplayed() {
		/*if(ClosebtnEnter4digitCode.isEnabled()){
			ClosebtnEnter4digitCode.click();
			//WaitUtils.loadingWaitElement(driver, ChooseBtnLoader);
		}*/
		return ChooseAnOfferBtn.isDisplayed();
	}
	
	public void closebtnEnter4digitCode() throws InterruptedException {
		Thread.sleep(9000);
		if(ClosebtnEnter4digitCode.isDisplayed()) {
			System.out.println("Kamalllllllllllll");
			ClosebtnEnter4digitCode.click();
			System.out.println("Akshatttttttttttttttttttt");
		}
	}
	
	public void ChooseAnOfferBttn() {
		if (ChooseAnOfferBtn.isEnabled()) {
			ChooseAnOfferBtn.click();
			WaitUtils.loadingWait(driver, ChooseBtnLoader);
		}
	}

	public void offerSelectedTickBttn() {
		//wait.until( ExpectedConditions.visibilityOf(OfferSelectedTickBttn));
		if(ClosebtnEnter4digitCode.isDisplayed()){
			ClosebtnEnter4digitCode.click();
		}
	}
}
