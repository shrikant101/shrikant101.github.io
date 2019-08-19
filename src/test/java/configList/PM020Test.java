package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM020Test extends BaseTest {
private static final Logger LOGGER = Logger.getLogger(PM020Test.class);
	
	// *************WEB ELEMENTS********************** }
	//
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
			String fdrowGroup = "//div[.='__LABEL__']/../../.././/a[@title='Manage']";
			String fdProductLink = "//a/span[.='__LABEL__']";
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			basepage.click(false, "//a[@aria-label='Offers']");
			basepage.click(true, fdrowGroup,"WPC0001");
			basepage.click(true, fdProductLink,"Define CASA Offer");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM020 screen")
	public void PM020(Method method, String OfferCode, String OfferName, String OfferDescription, String OfferType, String StartDate, String ExpiryDate, String ProductCode, String AllowedCurrencies, String Currency, String ReconciliationRequired, 
			String ReconciliationParameters, String AccountType, String ReconciliationType, String MultiRecordOffsetAllowed, String StandardFeatures, String Overdraft, String AdvanceAgainstUnclearFunds, String ConvenienceOfferingAllowed, 
			String ConvenienceOfferingAppropriationSequence, String Overline, String TOD, String DebitBalanceAllowed, String FundUtilizationSequence, String EnableFCFParameters, String AllowedRateType, String AllowedRateType2, 
			String RestrictedOperations, String RestrictedOperations2, String DefaultAccountPreferences, String AllowedFacilities, String SweepIn, String MinimumSweepInAmount, String SweepInAmountBasisInMultiplesof, String ReverseSweepIn, 
			String PrincipalOffset, String SweepOut, String PassBook, String ChequeBook, String InwardDirectDebit, String PeriodicCredit, String PeriodicDebit, String BusinessPayments, String BusinessCollections, String Maximumnoofaccountspercustomer, 
			String AllowUDM, String MaximumNumberofCASAAccountsAllowedForPrincipalOffset, String InterestPayableonExcessAmountofOffset, String CaptureAccountLevelPurposeCode, String DebitCardFeatureBasedOn, String DebitCardFeature, 
			String AlternateAccountsAllowed, String RateLockRequired, String RateLockValidityPeriod, String LockedRatetobeApplied, String ODSustenanceFee, String TaxFileNumberApplicable, String RegDCounter, String CourtesyPay, 
			String CourtesyPayRepaymentDays, String CourtesyPay2, String QuoteParameters, String PayoutQuoteforClosureApplicable, String Quotesgenerationpermissionupto, String ToleranceLimitbasedOn, String NoticeForWithdrawalParameters, 
			String NoticeForWithdrawalRequired, String MinimumNoticePeriod, String GracePeriodApplicable, String ChequeBookParameters, String ChequeBookType, String AutoReorderLevel, String AutoReorderLevel2, String ChequeBackground, 
			String Personalized, String NumberofLeavesperChequeBook, String Description, String ADDButtonIcon, String DeleteButtonIcon, String FlexiCreditParameters, String InterestRepaymentType, String DebitAllowedDaysinFixedPeriod, 
			String OffsetBenefitApplicable, String OffsetBenefitAllowed, String InterestPayableonExcessAmountofOffset2, String AllowFundTransferOptions, String OwnAccounts, String ThirdPartyAccounts, String ExternalAccounts, String ControlParameters, 
			String MinimumBalanceType, String MinimumBalanceBreachChargeBasis, String CurrencyControlParameters, String CurrencyCode, String MinimumBalanceAmount, String ATMWithdrawalLimit, String MinimumInitialDepositAmount, String CourtesyPayAmount, 
			String CourtesyPayAmountRuleID, String CourtesyPayThreshold, String CourtesyPayApplicabilityDays, String CourtesyPayThresholdRuleID, String CourtesyPayApplicabilityRuleID, String LinkageParameters, String StatementPolicyCode, 
			String StatementPolicyDescription, String OfferEligibilityRuleID, String OfferEligibilityRuleName, String QuestionSetID, String Description2, String MultiFundDeposit, String ChargeSingleFeeforaMultiFundTransaction, 
			String DisplaySingleTransactioninBankStatement, String MultimodeWithdrawal, String ChargeSingleFeeforMultimodewithdrawalTransaction, String DisplaySingleTransactionforMultimodewithdrawalTransactioninBankStatement, 
			String BackdatedAccountOpening, String BackdatedAccountopeningallowedperiod, String AlternateAccount, String PseudoEntry, String PseudoEntryInterest, String MandatoryRedirectionOfCreditInterest, 
			String MandatoryRedirectionOfDebitInterestunchecked, String MandatoryRedirectionOfFees, String DisallowCreditInterestRedirectionIfAccountisDebitBlockedduetoKYCstatus, String CreditInterestToBeRedirectedTo, 
			String AlertOutboundDocumentationParameters, String EventName, String LeadDays, String LagDays, String AllowedAccessChannelsforServicing, String InternetBanking, String PhoneBanking, String Branch, String MobileBanking, String ATMPOS, 
			String Documentation, String TermNCondition, String IconId, String AdditionalProductInformation, String FMDAParameters, String MaximumDepositAmount, String MinimumDepositAmount, String MinimumWithdrawalAmount, String OfferRemarks, 
			String Text1, String Text2, String ExternalReferenceID, String EntityName, String ReferenceID, String AdditionInformation, String OwnerName, String BrowseImage, String AdditionalInformation, String BillingParameters, String BillingMethod, 
			String PercentageofPrincipal, String GracePeriod, String BillingFrequency) throws InterruptedException {
		
		    // ExtentReports Description
		    ExtentTestManager.startTest(OfferCode, "Start verification of PM020 screen");
			
			// *************PAGE INSTANTIATIONS*************
			BasePage basepage = new BasePage(driver, wait);
		
			// *************PAGE ELEMENTS********************	
			String fdChoiceDebitCard = "//label[.='__LABEL__']/../../td//input[@type='checkbox']/../../label[.='__DATA__']";
			String fdTable1 = "(//span[.='__LABEL__'])[3]//following::td[1]//span[.='__LABEL__']//following::td[1]//span/span/span[.='__LABEL__']//following::td[1]//span/span/span[.='__LABEL__']";
			// *************PAGE METHODS********************		
			basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));

			basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Offer Code",OfferCode);
			basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Offer Code",OfferCode);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Offer Name",OfferName);
			basepage.verifyElementPresent(true,locatorProp.getProperty("textAreaLevel2"),"Offer Description",OfferDescription);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Offer Code",OfferCode);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Start Date",StartDate);
			
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Expiry Date",ExpiryDate);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Product Code",ProductCode);
			
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"), "Currency", Currency);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Advance Against Unclear Funds", AdvanceAgainstUnclearFunds);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Convenience Offering Allowed", ConvenienceOfferingAllowed);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Convenience Offering Appropriation Sequence", ConvenienceOfferingAppropriationSequence);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Overline", Overline);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "TOD", TOD);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Debit Balance Allowed", DebitBalanceAllowed);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Funds Utilization Sequence", FundUtilizationSequence);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Enable FCF Parameters", EnableFCFParameters);
			basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"), "Allowed Rate Type", AllowedRateType2);
			////label[.='Allowed Rate Type']/../following-sibling::td/span/select[@title='Variable Rate Period'];
			
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Sweep In", SweepIn);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Principal Offset", PrincipalOffset);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Sweep Out", SweepOut);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Pass Book", PassBook);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Cheque Book", ChequeBook);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Inward Direct Debit", InwardDirectDebit);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Periodic Credit", PeriodicCredit);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Periodic Debit", PeriodicDebit);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Business Payments", BusinessPayments);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Business Collections", BusinessCollections);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Maximum Number of Accounts for Customer", Maximumnoofaccountspercustomer);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow UDM", AllowUDM);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Maximum Number of CASA Accounts Allowed for Principal  Offset", MaximumNumberofCASAAccountsAllowedForPrincipalOffset);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Interest Payable on Excess Amount of Offset", InterestPayableonExcessAmountofOffset);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Debit Card Feature Based On",DebitCardFeatureBasedOn);
			
			basepage.verifyElementPresent(true,fdChoiceDebitCard,"Debit Card Feature",DebitCardFeature);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Alternate Accounts Allowed", AlternateAccountsAllowed);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Rate Lock Required", RateLockRequired);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Tax File Number Applicable", TaxFileNumberApplicable);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Locked Rate to be Applied ", LockedRatetobeApplied);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Courtesy Pay", CourtesyPay);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Capture Account Level Purpose Code", CaptureAccountLevelPurposeCode);
			
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Rate Lock Validity Period",RateLockValidityPeriod);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Courtesy Pay Repayment Days",CourtesyPayRepaymentDays);
			
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Own Accounts", OwnAccounts);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Third-Party Accounts", ThirdPartyAccounts);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"External Accounts", ExternalAccounts);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Minimum Balance Type", MinimumBalanceType);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Minimum Balance Breach Charge Basis", MinimumBalanceBreachChargeBasis);
			
			
			basepage.verifyTableRow(true,fdTable1,CurrencyControlParameters);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Statement Policy Code", StatementPolicyCode);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Statement Policy Description", StatementPolicyDescription);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Offer Eligibility Rule ID", OfferEligibilityRuleID);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Offer Eligibility Rule Name", OfferEligibilityRuleName);
			//basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Question Set ID", QuestionSetID);
			
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Charge Single Fee for a Multi Fund Transaction", ChargeSingleFeeforaMultiFundTransaction);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Display Single Transaction in Bank Statement", DisplaySingleTransactioninBankStatement);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Charge Single Fee for Multi Mode Withdrawal Transaction", ChargeSingleFeeforMultimodewithdrawalTransaction);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Display Single Transaction for Multi Mode withdrawal Transaction in Bank Statement", DisplaySingleTransactionforMultimodewithdrawalTransactioninBankStatement);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Backdated Account Opening Allowed Period(In Days)", BackdatedAccountopeningallowedperiod);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Maximum Deposit Amount", MaximumDepositAmount);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Minimum Deposit Amount", MinimumDepositAmount);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Minimum Withdrawal Amount", MinimumWithdrawalAmount);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Maximum Deposit Amount", MaximumDepositAmount);
			basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Maximum Deposit Amount", MaximumDepositAmount);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Internet Banking", InternetBanking);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Phone Banking", PhoneBanking);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Branch", Branch);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Mobile Banking", MobileBanking);
			basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "ATM/POS", ATMPOS);
			
			basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		
		
		}

}
