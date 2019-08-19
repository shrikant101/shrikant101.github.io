package configList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM013Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM013Test.class);
	
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
			basepage.click(false, locatorProp.getProperty("PMHeader"),"Products");
			basepage.click(false, locatorProp.getProperty("PMButton"),"New Product");
			basepage.click(true, locatorProp.getProperty("PMSelectRow"),"Define CASA");
			basepage.click(true, locatorProp.getProperty("cancelConfig"));
			basepage.click(true, locatorProp.getProperty("ConfirmPopupOKButton"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM013 screen")
	public void PM013(Method method, String ProductCode, String ProductName, String ProductRemarks, String ProductStartDate, 
			String ProductExpiryDate, String ProductGroupCode, String AllowedCurrencies, String AllowedCurrencies2,
			String ControlParameters, String DebitBalanceAllowed, String FundUtilizationSequence, String AppropriationSequence, 
			String SCRABenefitGracePeriod, String LongestOverdueFirst, String AllowedIncomingPaymentonClosed, String CASAClosureSimulationAllowedDays,
			String InterestComputationBalanceMethod, String AppropriationSequenceForClosed, String BackdatedAccountopeningallowedperiod, String PrincipalOffsetAllowedFor, 
			String MilitaryLendingActApplicable, String military, String NoticePeriodForWithdrawalunchecked, String PenaltyRoutine, String AlignchargingofFeeswithStatementCycle,
			String AlignchargingofInterestwithStatementCycle, String Graceperiodforchargingofoverlinefees, String Agebasedwithdrawal, String OverlineFeeTreatment,
			String LatePaymentFeeTreatment, String RegCCApplicable, String RegCCThresholdBalanceAmount, String AllowedTerm, 
			String MinimumTermYears, String Months, String MaximumTermYears, String Months2,
			String BillingParameters, String BillingRequired, String BillingDateChangeAllowed, String RateRefreshBasis, 
			String MADCalculationmethod, String Percent, String MinimumDaysinCycleforGenerationofBill, String ToleranceLimitforconsideringMADPaymentRegular,
			String UpfrontgenerationofBilldate, String UpfrontgenerationofDuedate, String Numberofdaystocomputeduedate, String Numberofdaystocomputebilldate,
			String InterestonlyMADmethodforinitialNoofbills, String IncludeFeeinPaymentTolerance, String OtherArrears, String ArrearsTreatementPreferences, 
			String ArrearsfieldwillspecifythelistofArrears, String ArrearTreatment, String BillingAmountParameters, String Currency, 
			String MinimumBillAmountforMADComputation, String ThresholdlimitforBilling, String MinimumAmountDueasFlatAmount, String AccountOverduedaystoapplydebitblock, 
			String MADDueDays, String GraceDayfieldreplacedbyRepaymentGracedays, String DelinquencyParameters, String IsDelinquencyTrackingRequired, 
			String DelinquencyTrackingMethod, String Days, String Payments, String FromDay, 
			String ToDays, String FromNoofPayment, String ToNoofPayment, String PenalInterest, 
			String PenalInterestApplicable, String NoofDaysAccountwasinOverline, String NoofConsecutivebillingcycleforwhichMADisnotpaid, String NoofConsecutivebillingcyclestobecheckedforlimitbreachinginstancesorthedayofOverline, 
			String CountofLimitBreachingInstances, String NoofConsecutiveBillingcyclesforwhichtheAccountisRegular, String Noticedayspostswhichpenalyinterestisapplicable, String FeeTreatmentPreferences, 
			String EventID, String EventDescription, String FeeTreatment, String EconomicCostParameters, 
			String CurrencyCode, String EconomicCostQuoteValidityPeriodInDays, String EconomicCostThresholdToleranceAmount, String CurrencySpecificParameters, 
			String MinimumBalanceType, String MinimumBalanceBreachChargeBasis, String CurrencyCode2, String MinimumBalanceAmount, 
			String ATMWithdrawalLimit, String LinkageParameters, String DormancyPolicyCode, String DormancyPolicyDescription, 
			String StatementPolicyCode, String StatementPolicyDescription, String DebitCardFeature, String BankInitiatedAccountClosureParameters, 
			String AllowBankInitiatedAccountClosure, String Currency2, String InactivePeriod, String FromAmount, 
			String ToAmount, String ClosureRuleID, String AddButton, String DeleteButton,
			String AccountClosureFrequency, String AccountClosureStartMonth, String ExpiryPeriodfortask, String AssetClassificationParameters, 
			String AssetClassificationPlan, String NPAAppropriationSequence, String LongestOverdueFirst2, String CurrencyCode3,
			String MinimumQualifyingAmount, String AlertOutboundDocumentationParameters, String EventName, String LeadDays, 
			String LagDays, String AdditionInformation, String OwnerName, String BrowseImage) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductCode, "Start verification of PM013 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		
		String multiCheckbox = "//label[text()='__LABEL__']/input[@type='checkbox']";
		
		
		String fdTable1 ="//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		
		String fdTable2 = "//span[.='__LABEL__']/../following-sibling::td/span/span[.='__LABEL__']/../../following-sibling::td/span/span[.='__LABEL__']";
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Code",ProductCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Code", ProductCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Name", ProductName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Remarks", ProductRemarks);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Start Date", ProductStartDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Expiry Date", ProductExpiryDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Group Code", ProductGroupCode);
		basepage.verifyDisabledElementPresent(true,multiCheckbox,AllowedCurrencies2);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Debit Balance Allowed", DebitBalanceAllowed);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Fund Utilization Sequence", FundUtilizationSequence);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Appropriation Sequence", AppropriationSequence);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","SCRA Benefit Grace Period (in days)", SCRABenefitGracePeriod);
		//basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Longest Overdue First", LongestOverdueFirst);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Longest Overdue First", LongestOverdueFirst);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allowed Incoming Payment on Closed/Written Off Accounts ", AllowedIncomingPaymentonClosed);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","CASA Closure Simulation Allowed Days", CASAClosureSimulationAllowedDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Backdated Account Opening Allowed Period( In days )", BackdatedAccountopeningallowedperiod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Principal Offset Allowed For", PrincipalOffsetAllowedFor);
		
		basepage.verifyTableRow(true,fdTable1,FeeTreatmentPreferences);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Balance Type", MinimumBalanceType);
		basepage.verifyTableRow(true,fdTable2,CurrencySpecificParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Dormancy Policy Code", DormancyPolicyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Dormancy Policy Description", DormancyPolicyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Statement Policy Code", StatementPolicyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Statement Policy Description", StatementPolicyDescription);
		basepage.verifyDisabledElementPresent(true,multiCheckbox,DebitCardFeature);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Asset Classification Plan", AssetClassificationPlan);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","NPA Appropriation Sequence", NPAAppropriationSequence);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Longest Overdue First (for NPA)", LongestOverdueFirst2);
		
	/*	
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Military Lending Act Applicable");
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Recession");
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Notice Period For Withdrawal unchecked", NoticePeriodForWithdrawalunchecked);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Penalty Routine ", PenaltyRoutine);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Align charging of Fees with Statement Cycle", AlignchargingofFeeswithStatementCycle);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Align charging of Interest with Statement Cycle", AlignchargingofInterestwithStatementCycle);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Grace period for charging of over line fees", Graceperiodforchargingofoverlinefees);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", Agebasedwithdrawal);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText",OverlineFeeTreatment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", LatePaymentFeeTreatment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Reg CC Applicable", RegCCApplicable);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Reg CC Threshold Balance Amount", RegCCThresholdBalanceAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Allowed Term ", AllowedTerm);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Term Years", MinimumTermYears);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Months", Months);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Maximum Term Years ", MaximumTermYears);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Months", Months);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Billing Parameters", BillingParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Billing Required", BillingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Billing Date Change Allowed", BillingDateChangeAllowed);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rate Refresh Basis", RateRefreshBasis);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","MAD Calculation method", MADCalculationmethod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Percent (%)", Percent);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Days in Cycle for Generation of Bill", MinimumDaysinCycleforGenerationofBill);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Tolerance Limit for considering MAD Payment Regular (in % Terms)", ToleranceLimitforconsideringMADPaymentRegular);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Upfront generation of Bill date", UpfrontgenerationofBilldate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Upfront generation of Due date", UpfrontgenerationofDuedate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number of days to compute due date", Numberofdaystocomputeduedate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number of days to compute bill date", Numberofdaystocomputebilldate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Interest only MAD method for initial 'X' No of bills", InterestonlyMADmethodforinitialNoofbills);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Include Fee in Payment Tolerance", IncludeFeeinPaymentTolerance);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText",OtherArrears);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Arrears Treatement Preferences", ArrearsTreatementPreferences);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText",ArrearsfieldwillspecifythelistofArrears);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText",ArrearTreatment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Billing Amount Parameters", BillingAmountParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency", Currency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Bill Amount for MAD Computation ", MinimumBillAmountforMADComputation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Threshold limit for Billing", ThresholdlimitforBilling);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Amount Due as Flat Amount", MinimumAmountDueasFlatAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Account Overdue days to apply debit block", AccountOverduedaystoapplydebitblock);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","MAD Due Days", MADDueDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Grace Day");
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Delinquency Parameters ", DelinquencyParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Is Delinquency Tracking Required", IsDelinquencyTrackingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Delinquency Tracking Method", DelinquencyTrackingMethod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Days", Days);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payments", Payments);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","From Day", FromDay);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","To Days", ToDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","From No of Payment", FromNoofPayment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","To No of Payment", ToNoofPayment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Penal Interest  ", PenalInterest);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Penal Interest Applicable", PenalInterestApplicable);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","No of Days Account was in Overline/ TOD", NoofDaysAccountwasinOverline);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","No of Consecutive billing cycle for which MAD is not paid", NoofConsecutivebillingcycleforwhichMADisnotpaid);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","No of Consecutive billing  cycles to be checked for limit breaching instances or the day of Overline", NoofConsecutivebillingcyclestobecheckedforlimitbreachinginstancesorthedayofOverline);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Count of Limit Breaching Instances", CountofLimitBreachingInstances);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","No of Consecutive Billing cycles for which the Account is Regular", NoofConsecutiveBillingcyclesforwhichtheAccountisRegular);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Notice days posts which penaly interest is applicable", Noticedayspostswhichpenalyinterestisapplicable);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Event ID", EventID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Event Description", EventDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Fee Treatment", FeeTreatment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Economic Cost Parameters", EconomicCostParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Economic Cost Quote Validity Period In Days", EconomicCostQuoteValidityPeriodInDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Economic Cost Threshold Tolerance Amount", EconomicCostThresholdToleranceAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Specific Parameters", CurrencySpecificParameters);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Balance Breach Charge Basis", MinimumBalanceBreachChargeBasis);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Balance Amount", MinimumBalanceAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","ATM Withdrawal Limit", ATMWithdrawalLimit);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Linkage Parameters", LinkageParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Initiated Account Closure Parameters", BankInitiatedAccountClosureParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Allow Bank Initiated Account Closure", AllowBankInitiatedAccountClosure);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency", Currency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Inactive Period (in Months) ", InactivePeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","From Amount ", FromAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","To Amount", ToAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Closure Rule ID ", ClosureRuleID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Add Button/Icon", AddButton);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Delete Button/Icon", DeleteButton);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Account Closure Frequency", AccountClosureFrequency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Account Closure Start Month", AccountClosureStartMonth);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Expiry Period for task (In Days)", ExpiryPeriodfortask);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Asset Classification Parameters", AssetClassificationParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Qualifying Amount", MinimumQualifyingAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alert/Outbound Documentation Parameters", AlertOutboundDocumentationParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText",EventName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Lead Days", LeadDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Lag Days", LagDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Addition Information", AdditionInformation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Owner Name", OwnerName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Browse Image", BrowseImage);
*/
				
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
