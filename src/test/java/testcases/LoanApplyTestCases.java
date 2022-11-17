package testcases;

import org.testng.annotations.*;
import CommonAssertions.Assertions;
import base.*;
import common.utilities.SeleniumActions;
import common.utilities.WaitUtils;
import pages.*;

@Test
public class LoanApplyTestCases extends TestBase {

	WaitUtils waitUtils;
	ApplyPage applypage;
	SelectAnOfferPage selectAnOfferPage;
	BankInformationPage bankInformationPage;
	ConnectPage connectPage;
	EmploymentInformationPage employmentInformationPage;
	PaymentSetupPage paymentSetupPage;
	ACHPage ACHpage;
	
		public LoanApplyTestCases() {
		super();
	}

	@BeforeSuite(alwaysRun = true)
		public void setUp() {
		initializaton();
		applypage = new ApplyPage();
		selectAnOfferPage = new SelectAnOfferPage();
		bankInformationPage = new BankInformationPage();
		connectPage = new ConnectPage();
		employmentInformationPage = new EmploymentInformationPage();
		paymentSetupPage = new PaymentSetupPage();
		ACHpage = new ACHPage();
	}

		public void TC001_ClickOnApplyBttn(){
			applypage.ClickApply();
			boolean flag = applypage.isLPLogoDisplayed();
			Assertions.verifyPageIsOpenedSucessfully("Start");
			Assertions.verifyButtonIsDisplayingOrNot(flag);
		}

		public void TC002_FillCustomerDetails() throws InterruptedException  {
			applypage.EnterLoanAmount();
			applypage.SelectLoanPurpose();
			applypage.EnterFirstName();
			applypage.EnterLastName();
			applypage.EnterDateOfBirth();
			applypage.EnterPhoneNumber();
			applypage.EnterEmailId();
			applypage.EnterAddress();
			applypage.EnterPinCode();
			applypage.SelectState();
			applypage.EnterOptionalAddress();
			applypage.EnterCity();
			applypage.EnterAnnualIncome();
			applypage.EnterIncomeSource();
			applypage.EnterssnLast4digit();
			applypage.Enterss1st3digit();
			applypage.EnterssnMiddle2digit();
			applypage.EnterPassword();
			applypage.PressSubmitBttn();
			WaitUtils.loadingWaitElement(driver, SelectAnOfferPage.ChooseAnOfferBtn);
			Assertions.verifyPageIsOpenedSucessfully("SelectAnOffer");
		}
		
		public void TC003_ToValidateSelectOfferIsOpen() throws InterruptedException{
			boolean flag = selectAnOfferPage.isChooseAnOfferBtnDisplayed();
			Assertions.verifyButtonIsDisplayingOrNot(flag);
			selectAnOfferPage.closebtnEnter4digitCode();
			selectAnOfferPage.ChooseAnOfferBttn();
			Assertions.verifyPageIsOpenedSucessfully("BankInformation");
		}
		
		public void TC004_ToValidateBankInformationPage() throws InterruptedException{
			boolean flag = bankInformationPage.isCONNECTYOURBANKACCOUNTNOWDisplayed();
			Assertions.verifyButtonIsDisplayingOrNot(flag);
			bankInformationPage.cONNECTYOURBANKACCOUNTNOW();
		}
		
		public void TC005_ToValidateConnectPage() throws Exception{
			Assertions.verifyPageIsOpenedSucessfully("Connect");
			connectPage.WaitToLoadIframe();
			connectPage.SwitchToIframe();
			connectPage.waitToplaidCancelbtn();	
			SeleniumActions.ScrollDown();
			connectPage.clickOnContinuebtn();
			connectPage.EnterBankNameINSearchBankTxtBox();
			connectPage.ClickOnBankName();
			connectPage.BankNameopt1();
			connectPage.BankUserNameTxtField();
			connectPage.BankPasswordTxtField();		
			connectPage.SubmitButton();
			connectPage.SelectAcntCheckbox();
			connectPage.clickOnContinuebtn();
			connectPage.ClickOnAllowButton();
		}
		
		public void TC006_ToValidateEmploymentInformationPage() throws Exception{
			WaitUtils.waitUntilURLexistText(driver, "EmploymentInformation");
			Assertions.verifyPageIsOpenedSucessfully("EmploymentInformation");
			employmentInformationPage.EnterBankNameINSearchBankTxtBox();
			employmentInformationPage.EnteremployerPhoneTxtBox();
			employmentInformationPage.EnterworkEmailAddressTxtBox();
			employmentInformationPage.EnterjobTitleTxtBox();
			employmentInformationPage.EnterstartDateTxtBox();
			employmentInformationPage.ClickONnextBttn();
		}
		
		public void TC007_ToValidatePaymentSetupPage() throws Exception{
			WaitUtils.waitUntilURLexistText(driver, "PaymentSetup");
			Assertions.verifyPageIsOpenedSucessfully("PaymentSetup");
			paymentSetupPage.ClickOnPaymentSetupNextBtn();
		}
		
		public void TC008_ToValidateACHPage() throws Exception{
			WaitUtils.waitUntilURLexistText(driver, "Consent/HardPull/ACH");
			Assertions.verifyPageIsOpenedSucessfully("Consent/HardPull/ACH");
			ACHpage.ClickONACHcheckboxes();
			ACHpage.ClickONACHsubmitBtn();
		}
		
		@AfterSuite(alwaysRun = true)
		public void tearDown() {
			//driver.close();
		}
}
