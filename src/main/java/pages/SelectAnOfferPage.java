package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import common.utilities.WaitUtils;

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
		return ChooseAnOfferBtn.isDisplayed();
	}
	
	public void closebtnEnter4digitCode() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until( ExpectedConditions.elementToBeClickable(ClosebtnEnter4digitCode));
		if(ClosebtnEnter4digitCode.isDisplayed()) {
			ClosebtnEnter4digitCode.click();
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
