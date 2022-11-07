package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import common.utilities.*;

public class ApplyPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	Wait<WebDriver> wait_fluent = new FluentWait<WebDriver>(driver)
    		.withTimeout(Duration.ofSeconds(30L))
    		.pollingEvery(Duration.ofSeconds(5L))
    		.ignoring(NoSuchElementException.class);
	
	public ApplyPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='custom_html-2']/div/a") WebElement ApplyButton;
	@FindBy(xpath = "//a[@class='logo-ldp logo-app']")WebElement LPlogo;
	@FindBy(id = "loanAmount") WebElement LoanAmount;
	@FindBy(id = "loanPurpose") WebElement LoanPurpose;
	@FindBy(id = "firstName") WebElement FirstName;
	@FindBy(id = "lastName") WebElement LastName;
	@FindBy(id = "dob") WebElement DOB;
	@FindBy(id = "phone") WebElement PhoneNumber;
	@FindBy(xpath = "//*[@class='message-validation phoneVerification col-xs-12 hide-error ValidationFail']") WebElement InvalidPhoneError;
	@FindBy(id = "email") WebElement emailId;
	@FindBy(xpath = "//*[@id='check-email']") WebElement CheckEmail;
	@FindBy(xpath = "//img[@class='checking-email']") WebElement emailIdLoader;
	@FindBy(xpath = "//*[@id='check-email']") WebElement checkTickEmail;
	@FindBy(id = "check-email")WebElement EmailCheck;
	@FindBy(id = "google-addres") WebElement address;
	@FindBy(id = "unit") WebElement addressOptional;
	@FindBy(id = "postal_code") WebElement PinCode;
	@FindBy(xpath = "//img[@class='loading-inline requestzip']") WebElement ZipLoader;
	@FindBy(xpath = "//*[@class='input-group-addon icon']/img") WebElement Loader;
	@FindBy(id = "state") WebElement State;
	@FindBy(xpath = "//input[@id='locality']") WebElement City;
	@FindBy(xpath = "//div[text()=' City is required']") WebElement CityErrorMsg;
	@FindBy(id = "annualIncome") WebElement AnnualIncome;
	@FindBy(id = "income-source") WebElement IncomeSource;
	@FindBy(name = "ss3") WebElement ssnLast4digit;
	@FindBy(xpath = "//img[@class='loading-inline loading4ssn loader']") WebElement ssnLast4digitLoader;
	@FindBy(xpath = "//p[@class='ssn-full-helper']") WebElement FullssnEnerMessage;
	@FindBy(id = "ss1") WebElement ss1st3digit;
	@FindBy(name = "ss2") WebElement ssnMiddle2digit;
	@FindBy(id = "password") WebElement Password;
	@FindBy(xpath = "//button[@type='submit']") WebElement SubmitBttn;
	
	public boolean isLPLogoDisplayed() {
		return LPlogo.isDisplayed();
	} 
	
	public void ClickApply() {
		if (ApplyButton.isEnabled()) {
			wait.until(ExpectedConditions.elementToBeClickable(ApplyButton));
			ApplyButton.click();
		}
	}
	public void EnterLoanAmount() {
		if (LoanAmount.isEnabled()) {
			SeleniumActions.ClickAction(LoanAmount);
			LoanAmount.sendKeys(properties.getProperty("loanAmount"));
		}
	}
	public void SelectLoanPurpose() {
		if (LoanPurpose.isEnabled()) {
			SeleniumActions.ClickAction(LoanPurpose);
			SeleniumActions.selectbyText(LoanPurpose , properties.getProperty("loanPurpose"));
		}
	}
	
	public void EnterFirstName() {
		if (FirstName.isEnabled()) {
			SeleniumActions.ClickAction(FirstName);
			FirstName.sendKeys(properties.getProperty("firstName"));
		}
	}
	public void EnterLastName() {
		if (LastName.isEnabled()) {
			SeleniumActions.ClickAction(LastName);
			LastName.sendKeys(properties.getProperty("lastName"));
		}
	}
	public void EnterDateOfBirth() {
		if (DOB.isEnabled()) {
			SeleniumActions.ClickAction(DOB);
			DOB.sendKeys(properties.getProperty("dateOfBirth"));
		}
	}
	public void EnterPhoneNumber() {
		if (PhoneNumber.isEnabled()) {
			PhoneNumber.clear();
			SeleniumActions.ClickAction(PhoneNumber);
			PhoneNumber.sendKeys(properties.getProperty("phone"));
			
		}
	}
	public void EnterEmailId() {
		if (emailId.isEnabled()) {
			emailId.sendKeys(properties.getProperty("email"));
			SeleniumActions.ClickAction(emailId);
			SeleniumActions.ClickAction(CheckEmail);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
			wait.until( ExpectedConditions.visibilityOf(checkTickEmail));
		}
	}
	public void EnterAddress() {
		if (address.isEnabled()) {
			SeleniumActions.ClickAction(address);
			address.sendKeys(properties.getProperty("address"));
			if (addressOptional.isEnabled()) {
				SeleniumActions.ClickAction(addressOptional);
			}
		}
	}
	
	public void EnterPinCode() {
		if (PinCode.isEnabled()) {
			SeleniumActions.ClickAction(PinCode);
			PinCode.sendKeys(properties.getProperty("postal_code"));
			WaitUtils.loadingWait(driver, Loader);
		}
	}
	public void SelectState() {
		if (State.isEnabled()) {
			SeleniumActions.ClickAction(State);
			SeleniumActions.selectbyText(State , properties.getProperty("state"));
		}
	}
	public void EnterOptionalAddress() {
		if (addressOptional.isEnabled()) {
			SeleniumActions.ClickAction(addressOptional);
			addressOptional.sendKeys(properties.getProperty("address"));
		}
	}
	
	
	public void EnterCity() {
	/*public void enterCity(String cityName) {
			Actions actions = new Actions(driver);
			actions.moveToElement(City).click().perform();
			WaitUtils.waitVisibility(this.City, "City");
	        enterKeys(this.City, cityName, "City");
		}*/
		if (City.isEnabled()) {
			SeleniumActions.ClickAction(City);
			String City_Name = properties.getProperty("city");
			City.sendKeys(City_Name);
			if(CityErrorMsg.isDisplayed()) {
				SeleniumActions.ClickAction(CityErrorMsg);
				String City_Name2 = properties.getProperty("city");
				SeleniumActions.ClickAction(City);
				City.sendKeys(City_Name2);
			}
		}
	}
	
	public void EnterAnnualIncome() {
		if (AnnualIncome.isEnabled()) {
			SeleniumActions.ClickAction(AnnualIncome);
			AnnualIncome.sendKeys(properties.getProperty("annualIncome"));
		}
	}
	public void EnterIncomeSource() {
		if (IncomeSource.isEnabled()) {
			SeleniumActions.ClickAction(IncomeSource);
			IncomeSource.sendKeys(properties.getProperty("income-source"));
		}
	}
	public void EnterssnLast4digit() {
		if (ssnLast4digit.isEnabled()) {
			SeleniumActions.ClickAction(ssnLast4digit);
			ssnLast4digit.sendKeys(properties.getProperty("ssnLast4digit"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			wait.until( ExpectedConditions.visibilityOf(FullssnEnerMessage));
		}
	}
	public void Enterss1st3digit() {
		if (ss1st3digit.isEnabled()) {
			SeleniumActions.ClickAction(ss1st3digit);
			ss1st3digit.sendKeys(properties.getProperty("ss1st3digit"));
		}
	}
	
	public void EnterssnMiddle2digit() {
		if (ssnMiddle2digit.isEnabled()) {
			SeleniumActions.ClickAction(ssnMiddle2digit);
			ssnMiddle2digit.sendKeys(properties.getProperty("ssnMiddle2digit"));
		}
	}
	public void EnterPassword() {
		if (Password.isEnabled()) {
			SeleniumActions.ClickAction(Password);
			Password.sendKeys(properties.getProperty("password"));
		}
	}
	public void PressSubmitBttn() {
		if (SubmitBttn.isEnabled()) {
			SeleniumActions.ClickAction(SubmitBttn);
		}
	}

}
