package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM48Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCM48Test.class);
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);

			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("LCM48");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM48 screen")
	public void LCM48(Method method,String BankName, String CapitalizationAmountPercentage, String CurrencyConversionRateType, String DecreaseHaircutAllowed, 
			String HolidayTreatment, String CollateralDedupe, String AutoclosureofNonRevolvingcreditFacilities, String ChargeFeesonExpiredFacility, 
			String AllowlinkageofAffliateCollaterals, String GraceDaysForFacilityExpiry, String LVRMethod, String LoantoValueRatiomethods, String SLTVRule, 
			String SLTVRuleID, String FamilyGuarantee, String GuaranteeAamountThreshold, String GAT_FirstRegisteredMortgagePercentage, 
			String GAT_InternalTermDepositPercentage, String GuarantorLoanValueRatioThreshold, String GLVRT_FirstRegisteredMortgagePercentage, 
			String InvestmentsPercentage, String InvestmentsandGuarantorsassociatedexposurePercentage, String LowDocloanPercentage, 
			String GLVRT_InternalTermDepositPercentage, String DueDiligenceRuleAuthor, String Event)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(BankName, "Start verification of LCM48 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String dueDeligenceRule = "//a/span[.='Due Diligence Decision Rules']";
		String div="//label[.='__LABEL__']/../following-sibling::td//div/div[.='__DATA__ ']";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
			
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Bank Name", BankName);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Capitalization Amount Percentage ",CapitalizationAmountPercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Currency Conversion Rate Type", CurrencyConversionRateType);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Decrease Haircut Allowed", DecreaseHaircutAllowed);
		basepage.verifyElementPresent(true,div, "Holiday Treatment", HolidayTreatment);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Collateral Dedupe", CollateralDedupe);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Auto Closure of Non Revolving Credit Facility", AutoclosureofNonRevolvingcreditFacilities);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Charge Fees on Expired Facility", ChargeFeesonExpiredFacility);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow linkage of Affliate Collaterals", AllowlinkageofAffliateCollaterals);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Grace Days For Facility Expiry", GraceDaysForFacilityExpiry);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "SLTV Rule ID", SLTVRuleID);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "First Registered Mortgage Percentage ", GAT_FirstRegisteredMortgagePercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Internal Term Deposit Percentage ", GAT_InternalTermDepositPercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "First Registered Mortgage Percentage ", GLVRT_FirstRegisteredMortgagePercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "First Registered Mortgage over an Inner City Apartment - Investments Percentage ", InvestmentsPercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "First Registered Mortgage over an Inner City Apartment - Investments and Guarantors Associated Exposure Low Doc Loan Percentage ", InvestmentsandGuarantorsassociatedexposurePercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "First Registered Mortgage and Guarantors Associated Exposure Low Doc Loan Percentage ", LowDocloanPercentage);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Internal Term Deposit Percentage ", GLVRT_InternalTermDepositPercentage);
		basepage.clickusingjs(true,dueDeligenceRule);		
		
		
	}
}
