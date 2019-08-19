package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM004Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM004Test.class);
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
		
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("PM004");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM004 screen")
	public void PM004(Method method, String BankCode, String BankName, String PolicyCode, String PolicyName, String PolicyDescription, String ControlParameters, 
			String BackdatedTransactionAllowed, String FeeDisplayinStatement, String AllowedBackdatedTerm, String CarryForwardCampaignBenefitMargin, 
			String RateLockQuoteRetentionPeriod, String BackdatedRateLockGracePeriod, String AllowLoanConsolidationWhenArrearsExist, 
			String CapitalizeArrearsOnConsolidation, String AllowOfferSwapWhenArrearsExist, String CapitalizeArrearsOnOfferSwap, 
			String AllowRestructureWhenArrearsExist, String BeneficiaryAccountHolderssameasOffsetProviderAccount, String CapitalizeArrearsonRestructure, 
			String CurrentMonthChargingforCalendarTypeWhereDisbursementOnorBefore, String UpdateLastActivityDateBasedOn, String APRComputationMethod, 
			String ReopenReversalofChargeoffallowedinDays, String AllowMaturityRolloverwherearrearexists, String CapitalizeArrearsonMaturityRollover, 
			String AllowedBackdatingbeyondRebookingTerm, String QuestionnaireTemplateID, String AccountVariationsthatrequireCreditAssessment, String EventName,
			String RequiredFor, String RecalculateCCIPremiumOn, String RepriceParameters, String UserDiscretionaryMarginPersistencyParameters, String DueDiligenceRule, String DecisionTable, 
			String AllowedAccessChannelsforServicing, String InternetBanking, String PhoneBanking, String MobileBanking, String Branch) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM004 screen");
		
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//td/span[.='__LABEL__']/../../..//span[text()='__LABEL__']/ancestor::td/..//span/span/span/span/img[@alt='__LABEL__']";
		String fdTable2 = "((//span[.='__LABEL__'])[3]//following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']//following::td[1]//span[.='__LABEL__'])[3]";
		String fdTable3 = "//span[.='__LABEL__']/../following-sibling::td/span/span/span/span/img[@alt='__LABEL__']";
		//String fdTable4 = "///span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE ELEMENTS********************
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Code",BankCode);
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
			
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name",BankName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Name",PolicyName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Backdated Transaction Allowed", BackdatedTransactionAllowed);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Allowed  Backdated Term (In Days)",AllowedBackdatedTerm);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Carry Forward Campaign Benefit Margin ", CarryForwardCampaignBenefitMargin);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rate Lock Retention Period (in days)",RateLockQuoteRetentionPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Back dated Rate Lock Grace Period",BackdatedRateLockGracePeriod);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Loan Consolidation when Arrears Exist", AllowLoanConsolidationWhenArrearsExist);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Capitalize Arrears on Consolidation", CapitalizeArrearsOnConsolidation);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Offer Swap When Arrears Exist", AllowOfferSwapWhenArrearsExist);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Capitalize Arrears on Offer Swap", CapitalizeArrearsOnOfferSwap);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Restructure When Arrears Exist", AllowRestructureWhenArrearsExist);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Beneficiary Account Holders same as Offset Provider Account",BeneficiaryAccountHolderssameasOffsetProviderAccount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Capitalize Arrears on Restructure", CapitalizeArrearsonRestructure);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Current Month Charging For Calendar Type Where Disbursement On Or Before", CurrentMonthChargingforCalendarTypeWhereDisbursementOnorBefore);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Update Last Activity Based on", UpdateLastActivityDateBasedOn);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "APR Computation Method", APRComputationMethod);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Re-opening/Reversal of Charge off allowed in Days",ReopenReversalofChargeoffallowedinDays);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Maturity Roll-over where arrears exists", AllowMaturityRolloverwherearrearexists);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Captialize Arrears on Maturity Rollover", CapitalizeArrearsonMaturityRollover);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Allowed Backdating beyond re-booking Term (in days)", AllowedBackdatingbeyondRebookingTerm);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Questionnaire Template ID",QuestionnaireTemplateID);
			
		basepage.verifyTableRow(true,fdTable1,RecalculateCCIPremiumOn);
		basepage.verifyTableRow(true,fdTable2,RepriceParameters);
		basepage.verifyTableRow(true,fdTable3,UserDiscretionaryMarginPersistencyParameters);
		//basepage.verifyTableRow(true,fdTable4,DecisionTable);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Internet Banking ", InternetBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Phone Banking", PhoneBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Mobile Banking", MobileBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Branch", Branch);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
