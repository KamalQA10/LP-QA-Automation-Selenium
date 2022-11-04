package com.crm.qa.testcases;

import org.testng.annotations.*;
import com.crm.qa.base.*;
import com.crm.qa.pages.ApplyPage;
import com.crm.qa.pages.SelectAnOfferPage;
import com.crm.qa.utilities.WaitUtils;

import CommonAssertions.Assertions;

@Test
public class LoanApplyTestCases extends TestBase {
//kkkkkkkk
		ApplyPage applypage;
		SelectAnOfferPage selectAnOfferPage;

		public LoanApplyTestCases() {
			super();
		}

		@BeforeSuite(alwaysRun = true)
		public void setUp() {
			initializaton();
			applypage = new ApplyPage();
			selectAnOfferPage = new SelectAnOfferPage();
		}

		public void TC001_ClickOnApplyBttn(){
			applypage.ClickApply();
			boolean flag = applypage.isLPLogoDisplayed();
			Assertions.verifyPageIsOpenedSucessfully("Start");
			Assertions.verifyButtonIsDisplayingOrNot(flag);
		}

		public void TC002_FillCustomerDetails() throws InterruptedException  {

			applypage.SelectLoanPurpose();
			applypage.EnterLoanAmount();
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
		
		public void TC003_ToValidateSelectOfferIsOpen(){
			boolean flag = selectAnOfferPage.isChooseAnOfferBtnDisplayed();
			Assertions.verifyButtonIsDisplayingOrNot(flag);
			selectAnOfferPage.ChooseAnOfferBttn();
			Assertions.verifyPageIsOpenedSucessfully("BankInformation");
		}

		@AfterSuite(alwaysRun = true)
		public void tearDown() {
			driver.close();
		}
}
