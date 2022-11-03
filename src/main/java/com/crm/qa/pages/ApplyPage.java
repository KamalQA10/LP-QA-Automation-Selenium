package com.crm.qa.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.qa.utilities.*;
import com.google.common.base.Function;

import com.crm.qa.base.TestBase;

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
	@FindBy(id = "email") WebElement emailId;
	@FindBy(xpath = "//*[@id='check-email']") WebElement CheckEmail;
	@FindBy(xpath = "//img[@class='checking-email']") WebElement emailIdLoader;
	@FindBy(xpath = "//*[@id='check-email']/span") WebElement checkTickEmail;
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
			LoanAmount.click();
			LoanAmount.sendKeys(properties.getProperty("loanAmount"));
		}
	}
	public void SelectLoanPurpose() {
		if (LoanPurpose.isEnabled()) {
			LoanPurpose.click();
			//WaitUtils.JsExecutor(LoanPurpose);
			SeleniumActions.selectbyText(LoanPurpose , properties.getProperty("loanPurpose"));
		}
	}
	
	public void EnterFirstName() {
		if (FirstName.isEnabled()) {
			FirstName.clear();
			FirstName.click();
			FirstName.sendKeys(properties.getProperty("firstName"));
		}
	}
	public void EnterLastName() {
		if (LastName.isEnabled()) {
			LastName.clear();
			LastName.click();
			LastName.sendKeys(properties.getProperty("lastName"));
		}
	}
	public void EnterDateOfBirth() {
		if (DOB.isEnabled()) {
			DOB.clear();
			DOB.click();
			DOB.sendKeys(properties.getProperty("dateOfBirth"));
		}
	}
	public void EnterPhoneNumber() {
		if (PhoneNumber.isEnabled()) {
			PhoneNumber.clear();
			PhoneNumber.click();
			PhoneNumber.sendKeys(properties.getProperty("phone"));
		}
	}
	public void EnterEmailId() {
		if (emailId.isEnabled()) {
			emailId.clear();
			emailId.sendKeys(properties.getProperty("email"));
			emailId.click();
			CheckEmail.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
			wait.until( ExpectedConditions.visibilityOf(checkTickEmail));
		}
	}
	public void EnterAddress() {
		if (address.isEnabled()) {
			address.click();
			address.sendKeys(properties.getProperty("address"));
			if (addressOptional.isEnabled()) {
				addressOptional.click();
			}
		}
	}
	
	public void EnterPinCode() {
		if (PinCode.isEnabled()) {
			PinCode.clear();
			PinCode.click();
			PinCode.sendKeys(properties.getProperty("postal_code"));
			WaitUtils.loadingWait(driver, Loader);
		}
	}
	public void SelectState() {
		if (State.isEnabled()) {
			State.click();
			SeleniumActions.selectbyText(State , properties.getProperty("state"));
		}
	}
	public void EnterOptionalAddress() {
		if (addressOptional.isEnabled()) {
			addressOptional.click();
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
			City.click();
			String City_Name = properties.getProperty("city");
			City.sendKeys(City_Name);
			if(CityErrorMsg.isDisplayed()) {
				CityErrorMsg.click();
				String City_Name2 = properties.getProperty("city");
				City.click();
				City.sendKeys(City_Name2);
			}
		}
	}
	
	public void EnterAnnualIncome() {
		if (AnnualIncome.isEnabled()) {
			AnnualIncome.clear();
			AnnualIncome.click();
			AnnualIncome.sendKeys(properties.getProperty("annualIncome"));
		}
	}
	public void EnterIncomeSource() {
		if (IncomeSource.isEnabled()) {
			IncomeSource.click();
			IncomeSource.sendKeys(properties.getProperty("income-source"));
		}
	}
	public void EnterssnLast4digit() {
		if (ssnLast4digit.isEnabled()) {
			ssnLast4digit.clear();
			ssnLast4digit.click();
			ssnLast4digit.sendKeys(properties.getProperty("ssnLast4digit"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			wait.until( ExpectedConditions.visibilityOf(FullssnEnerMessage));
		}
	}
	public void Enterss1st3digit() {
		if (ss1st3digit.isEnabled()) {
			ss1st3digit.clear();
			ss1st3digit.click();
			ss1st3digit.sendKeys(properties.getProperty("ss1st3digit"));
		}
	}
	
	public void EnterssnMiddle2digit() {
		if (ssnMiddle2digit.isEnabled()) {
			ssnMiddle2digit.clear();
			ssnMiddle2digit.click();
			ssnMiddle2digit.sendKeys(properties.getProperty("ssnMiddle2digit"));
		}
	}
	public void EnterPassword() {
		if (Password.isEnabled()) {
			Password.clear();
			Password.click();
			Password.sendKeys(properties.getProperty("password"));
		}
	}
	public void PressSubmitBttn() {
		if (SubmitBttn.isEnabled()) {
			SubmitBttn.click();
		}
	}

}
