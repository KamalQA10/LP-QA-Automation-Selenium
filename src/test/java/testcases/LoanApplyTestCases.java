package testcases;

import org.testng.annotations.*;
import CommonAssertions.Assertions;
import base.*;
import common.utilities.SeleniumActions;
import common.utilities.WaitUtils;
import pages.*;

@Test
public class LoanApplyTestCases extends TestBase {

		ApplyPage applypage;
		SelectAnOfferPage selectAnOfferPage;
		BankInformationPage bankInformationPage;
		ConnectPage connectPage;

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
		}

		@AfterSuite(alwaysRun = true)
		public void tearDown() {
			//driver.close();
		}
}
