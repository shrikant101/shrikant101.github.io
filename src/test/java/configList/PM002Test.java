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

public class PM002Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM002Test.class);
	
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
			homePage.navigatetoFastPath("PM002");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM002 screen")
	public void PM002(Method method, String BankCode, String BankName, String PolicyCode, String PolicyName, String PolicyDescription, String ControlParameters, 
			String HolidayProcessingforPeriodicFundTransfers, String CarryForwardCampaignBenefitMargin, String FeeDisplayinStatement, 
			String InclusionintheNetBalanceFormulae,  String BackdatedRateLockGracePeriod, String RateLockQuoteRetentionPeriod, 
			String UpdateLastActivityDateBasedOn, String SweepIn, String ReopenReversalofCharge, String BeneficiaryAccountHolders, 
			String ReinstateInstructionsasoflastperiod, String AllowedBackdatingbeyondrebookingTerm, 
			String TermforminimumpaymentWarning, String RepriceparametersforOD, String Event, String RepriceifAccountisinFixedRatePeriod, 
			String RepriceifAccountisinVariableRatePeriod, String MarginEvaluationCriteria, String UserDiscretionaryMarginPersistencyParameters, 
			String EventCode, String CarryForwardUDM, String AllowedAccessChannelsforServicing, String InternetBanking, String PhoneBanking, String Branch, 
			String MobileBanking, String ATMPOS, String DueDeligenceRule, String CreateDecisionTable) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM002 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		String updateActivity = "//label[.='__LABEL__']/../following-sibling::td//span/img[@alt='Checked']/../../span[.='__DATA__']";
		String fdTable2 = "((//span[.='__LABEL__'])[3]//following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']//following::td[1]//span[.='__LABEL__'])[3]";
		
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable3 = "//span[.='Manual Rollover']//following::td[1]//img[@alt='Unchecked']";
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Code",BankCode);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Name",BankName);
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Policy Name",PolicyName);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Policy Description",PolicyDescription);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Holiday Processing for Periodic Fund Transfers",HolidayProcessingforPeriodicFundTransfers);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Carry Forward Campaign Benefit Margin ",CarryForwardCampaignBenefitMargin);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Fee Display in Statement",FeeDisplayinStatement);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Inclusion in the Net Balance Formulae",InclusionintheNetBalanceFormulae);
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Backdated Rate Lock Grace Period",BackdatedRateLockGracePeriod);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Rate Lock Quote Retention Period (in Days)",RateLockQuoteRetentionPeriod);
		basepage.verifyElementPresent(true,updateActivity,"Update Last Activity Date Based On",UpdateLastActivityDateBasedOn);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"Sweep In",SweepIn);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Re-open/Reversal of Charge off allowed in Days",ReopenReversalofCharge);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Beneficiary Account Holders  same as Offset Provider Account",BeneficiaryAccountHolders);
		
		basepage.verifyTableRow(true,fdTable2,RepriceparametersforOD);
		basepage.verifyTableRow(true,fdTable3,CarryForwardUDM);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Internet Banking", InternetBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Phone Banking", PhoneBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Branch", Branch);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Mobile Banking", MobileBanking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "ATM/POS", ATMPOS);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
