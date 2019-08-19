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

public class PM014Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM014Test.class);
	
	@Test(priority = 0, description ="Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(),"Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
			String fdrowGroup ="//div[.='__LABEL__']/../../.././/a[@title='Manage']";
			String fdProductLink ="//a/span[.='__LABEL__']";
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			basepage.click(false, locatorProp.getProperty("PMHeader"),"Products");
			basepage.click(false, locatorProp.getProperty("PMButton"),"New Product");
			basepage.click(true, locatorProp.getProperty("PMSelectRow"),"Define Loan");
			basepage.clickusingjsMajor(true, locatorProp.getProperty("cancelConfig"));
			basepage.click(true, locatorProp.getProperty("ConfirmPopupOKButton"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider ="superman", priority = 1, description ="Start verification of PM014 screen")
	public void PM014(Method method, String ProductCode, String ProductName, String ProductRemarks, String ProductStartDate, 
			String ProductExpiryDate, String ProductGroupCode, String AllowedCurrencies, String AllowedCurrencies2, 
			String ControlParameters, String MinimumTermforDebtConsolidation, String MinimumPeriodforInterestinAdvance, String AppropriationSequence, 
			String LongestOverdueFirst, String PayoffBenefit, String InterestComputationBalanceMethod, String InterestComputationBalanceMethod2, 
			String UpdateUtilizationonCapitalization, String AllowedIncomingpaymenttoClosedWrittenoffAccounts, String AppropriationSequenceForwrittenoffClosedaccounts, String EFSSimulationPermissibleupto,
			String CapitalizeEconomicCostForPPF, String DefaultRescheduleDateDueToPeriodicFeeChange, String APRApplicable, String MilitaryLendingActApplicable, 
			String IsPyramidingofLateFeesApplicable, String DaysbeforeMaturityRollover, String SCRABenefitGracePeriod, String MaximumMaturityRolloverperiod,
			String MaximumNumberofMaturityRolloverallowedfortheloan, String Valuationrequiredduringsubsequentdisbursement, String MaximumNoofDefermentAllowedfortheloan, String MaximumNoofDefermentAllowedduringtheCalendaryear, 
			String LatePaymentFeeTreatment, String DaystoFirstPaymentafterfirstDisbursement, String AllowedTerm, String MinimumTermYears, 
			String MinimumTermMonths, String MaximumTermYears, String MaximumTermMonths, String FixedPeriodVariablePeriodParameters, 
			String RedrawAllowedFor, String PrincipalOffsetAllowedFor, String SubsequentDisbursementAllowedFor, String AllowRepaymentHolidayPeriod,
			String IncreaseLoanAmount, String IncreaseLoanTerm, String DecreaseLoanTerm, String AcceleratedPaymentAllowedFor, 
			String DefermentAllowedFor, String EconomicCostParameters, String CurrencyCode, String EconomicCosttobeLevied, 
			String AdvancePaymentThresholdTolerance, String EconomicCostQuoteValidityPeriod, String EconomyCostThresholdFor, String AutoDebitforInstalment, 
			String NSFBehaviourinCASA, String MaxRetriesforAutoDebits, String IncludeUnbilledPenalty, String ChargePenaltyonRetry, 
			String HolidayProcessing, String AutoDebitAmount, String IgnoreRPAforAutoDebit, String AllowedSanctionedAmountRevision, 
			String AllowUpwards, String AllowDownwards, String FeeTreatmentPreferencesOrigination, String EventID, 
			String EventsBelowneweventsaddedinLoanProduct, String EventDescription, String FeeTreatment, String FeeTreatmentforBill, 
			String FeeTreatmentincludedforDelinquencyTracking, String CurrencySpecificParameters, String CurrencyCode2, String MinimumSplitLoanAmount, 
			String MinimumAmountforDebtConsolidation, String SmallbalanceWaiverLimit, String SmallbalanceForfeitureLimit, String OverdueAgingParameter, 
			String FromDays, String ToDays, String DelinquencyParameters, String IsDelinquencyTrackingRequired, 
			String DelinquencyTrackingMethod, String PaymentTolerancebasedonAmount, String PeriodBased, String NumberofPaymentsBased, 
			String FromDays2, String ToDays2, String FromNoofPayment, String ToNoofPayment,
			String AllowedFacility, String DefaultRescheduleMode, String AllowDecreaseInInstallment, String MinimumHolidayRepaymentPeriod, 
			String MaximumHolidayRepaymentPeriod, String MinimumnoofInstalmentsforPPF, String MinimumLockinPeriod, String MinimumNoticePeriodforEarlySettlement,
			String RescissionPeriod, String MinimumRedrawReserve, String AutoClosureofAccount, String RefreshFixedRateonFirstDisbursement,
			String LinkageParameters, String StatementParameter, String StatementPolicyCode, String StatementPolicyDescription,
			String AssetClassificationCCYParameters, String AssetClassificationParameters, String NPAAppropriationSequence, String LongestOverdueFirst2,
			String CurrencyCode3, String MinimumQualifyingAmount, String AlertOutboundDocumentationParameters, String EventName,
			String LeadDays, String LagDays, String BillingParametes, String IsBillingRequired, 
			String BillingPostMaturityLagDays, String RepaymentFrequency, String MaximumLeadDays, String LeadDays2,
			String AdditionInformation, String ProductOwner, String BrowseImage ) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductCode,"Start verification of PM014 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		
		String multiCheckbox ="//label[text()='__LABEL__']/input[@type='checkbox']";
		String tabEconomicCostParameters = "//table[.='Economic Cost Parameters']/../div//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td//span/span/span[.='__LABEL__']";
		String tabFeeTreatmentPreferences = "//table[.='Fee Treatment Preferences']/../div//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String tabCurrencySpecificParameters = "//table[.='Currency Specific Parameters']/../div//span[.='__LABEL__']/../following-sibling::td//span/span[.='__LABEL__']/../../following-sibling::td//span/span/span[.='__LABEL__']/../../../following-sibling::td//span/span/span[.='__LABEL__']/../../../following-sibling::td//span/span/span[.='__LABEL__']";
		String tabOverDueAging = "//table[.='Overdue Aging Parameter']/../div//span/span/span[.='__LABEL__']/../../../following-sibling::td//span/span/span[.='__LABEL__']";
		String tabAssetClassificationCCYParameters = "//table[.='Asset Classification CCY Parameters']/../div//span/span/span[.='__LABEL__']/../../../following-sibling::td//span/span/span[.='__LABEL__']";
		String tabDelinquencyParameter = "//table[.='Overdue Aging Parameter']/../div//span/span/span[.='__LABEL__']/../../../following-sibling::td//span/span/span[.='__LABEL__']";
		String fdTable2 ="//span[.='__LABEL__']/../following-sibling::td/span/span[.='__LABEL__']/../../following-sibling::td/span/span[.='__LABEL__']";
		String tabAlertParameter ="//table[.='Alert/Outbound Documentation Parameters']/../div//span/span/span[.='Repayment Review']/../../../following-sibling::td//span/span/span[.='1']/../../../following-sibling::td//span/span/span[.='1']";
		String verifyElementWithRadio = "//label[.='__LABEL__']/../span/input[@value=0]";
		String xpathTerm = "//label[.='__LABEL__']/../../div[1]//td/label[.='__LABEL__']/../../td/span";
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Code",ProductCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Product Code", ProductCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Product Name", ProductName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Product Remarks", ProductRemarks);
		
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Product Group Code", ProductGroupCode);
		
		basepage.verifyDisabledElementPresent(true,multiCheckbox,AllowedCurrencies2);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Term for Debt Consolidation(Months)", MinimumTermforDebtConsolidation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Period for Interest in Advance(Months)", MinimumPeriodforInterestinAdvance);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Appropriation Sequence", AppropriationSequence);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Longest Overdue First", LongestOverdueFirst);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Payoff Benefit", PayoffBenefit);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Interest Computation Balance Method", InterestComputationBalanceMethod);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Update Utilization on Capitalization", UpdateUtilizationonCapitalization);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allowed Incoming payment to Closed/Written off Accounts", AllowedIncomingpaymenttoClosedWrittenoffAccounts);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Appropriation Sequence For written off/Closed accounts", AppropriationSequenceForwrittenoffClosedaccounts);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","EFS Simulation  Permissible up to (Days)", EFSSimulationPermissibleupto);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Capitalize Economic Cost For PPF", CapitalizeEconomicCostForPPF);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Default Reschedule Date Due To Periodic Fee Change", DefaultRescheduleDateDueToPeriodicFeeChange);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"APR Applicable", APRApplicable);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Is Pyramiding of Late Fees Applicable", IsPyramidingofLateFeesApplicable);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Days before Maturity Roll over", DaysbeforeMaturityRollover);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Maximum Maturity Roll over period (in months)", MaximumMaturityRolloverperiod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Maximum Number of Maturity Roll over allowed for the loan", MaximumNumberofMaturityRolloverallowedfortheloan);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Valuation required during subsequent disbursement", Valuationrequiredduringsubsequentdisbursement);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Late Payment Fee Treatment", LatePaymentFeeTreatment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Days to first payment after first disbursement", DaystoFirstPaymentafterfirstDisbursement);
		
		
		basepage.verifyEquals(true,xpathTerm,"innerText","Minimum Term","Years", MinimumTermYears);
		basepage.verifyEquals(true,xpathTerm,"innerText","Minimum Term","Months", MinimumTermMonths);
		basepage.verifyEquals(true,xpathTerm,"innerText","Maximum Term","Years", MaximumTermYears);
		basepage.verifyEquals(true,xpathTerm,"innerText","Maximum Term","Months", MaximumTermMonths);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Redraw Allowed For", RedrawAllowedFor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Principal Offset Allowed For", PrincipalOffsetAllowedFor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Subsequent Disbursement Allowed For", SubsequentDisbursementAllowedFor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Allow Repayment Holiday Period", AllowRepaymentHolidayPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Increase Loan Amount", IncreaseLoanAmount);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Increase Loan Term", IncreaseLoanTerm);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Decrease Loan Term", DecreaseLoanTerm);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Accelerated Payment Allowed For", AcceleratedPaymentAllowedFor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Deferment Allowed For", DefermentAllowedFor);
		
		
		basepage.verifyTableRow(true,tabEconomicCostParameters,CurrencyCode +":"+ EconomicCosttobeLevied +":"+ AdvancePaymentThresholdTolerance +":"+ EconomicCostQuoteValidityPeriod +":"+ EconomyCostThresholdFor);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","NSF Behavior in CASA", NSFBehaviourinCASA);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Maximum Retries for Auto Debits", MaxRetriesforAutoDebits);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Include Unbilled Penalty", IncludeUnbilledPenalty);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Charge Penalty on Retry", ChargePenaltyonRetry);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Holiday Processing", HolidayProcessing);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Auto Debit Amount", AutoDebitAmount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Ignore RPA for Auto Debit", IgnoreRPAforAutoDebit);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allow Upwards", AllowUpwards);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allow Downwards", AllowDownwards);
		
		basepage.verifyTableRow(true,tabFeeTreatmentPreferences, FeeTreatmentPreferencesOrigination);
		basepage.verifyTableRow(true,tabCurrencySpecificParameters ,CurrencyCode +":"+ MinimumSplitLoanAmount +":"+ MinimumAmountforDebtConsolidation +":"+ SmallbalanceWaiverLimit +":"+ SmallbalanceForfeitureLimit);
		basepage.verifyTableRow(true,tabOverDueAging ,OverdueAgingParameter);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Is Delinquency Tracking Required", IsDelinquencyTrackingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Payment Tolerance based on", PaymentTolerancebasedonAmount);
		
		if (PeriodBased.equalsIgnoreCase("0")) {
			basepage.verifyElementPresent(true,verifyElementWithRadio , "Period Based");	
		}
		if (NumberofPaymentsBased.equalsIgnoreCase("0")) {
			basepage.verifyElementPresent(true,verifyElementWithRadio , "Number of Payments Based");	
		}
		
		basepage.verifyTableRow(true,tabDelinquencyParameter,DelinquencyParameters);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Default Reschedule Mode", DefaultRescheduleMode);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allow Decrease In Installment", AllowDecreaseInInstallment);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Holiday Repayment Period", MinimumHolidayRepaymentPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Maximum Holiday Repayment Period", MaximumHolidayRepaymentPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum No. of Installments for PPF", MinimumnoofInstalmentsforPPF);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Lock-in Period (Initial Period)", MinimumLockinPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Notice Period for Early Settlement", MinimumNoticePeriodforEarlySettlement);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Rescission Period (in Days)", RescissionPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Minimum Redraw Reserve", MinimumRedrawReserve);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Auto Closure of Account", AutoClosureofAccount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Refresh Fixed Rate on First Disbursement", RefreshFixedRateonFirstDisbursement);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Statement Policy Code", StatementPolicyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Statement Policy Description", StatementPolicyDescription);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Asset Classification Parameters", AssetClassificationParameters);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","NPA Appropriation Sequence", NPAAppropriationSequence);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Longest Overdue First (for NPA)", LongestOverdueFirst);
		
		basepage.verifyTableRow(true,tabAssetClassificationCCYParameters ,CurrencyCode3 +":"+ MinimumQualifyingAmount);
		basepage.verifyTableRow(true,tabAlertParameter ,EventName +":"+ LeadDays +":"+ LagDays);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Is Billing Required", IsBillingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Billing Post Maturity Lag Days", BillingPostMaturityLagDays);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText","Product Owner", ProductOwner);				
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		}

}
