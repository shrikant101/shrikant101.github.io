package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCMS53Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCMS53Test.class);
	
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
			homePage.navigatetoFastPath("LCMS53");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCMS53 screen")
	public void LCMS53(Method method,String FacilityCategoryCode, String Description, String EffectiveLimitAmountBasis, String Revolving, 
			String DefaultNumberofDaysforFirstAvailment, String DefaultNumberofDaysforLastAvailment,String DefaultExpiryPeriodforRevolvinginYears, String DefaultExpiryPeriodforRevolvinginMonths, 
			String NatureofFacility, String DisableSublineCreation, String NoticeDays, String FacilityInitiatedFrom, String LoantoValueDetails, 
			String LTVGenerationType, String DefaultLTV, String MinimumLTV, String Remarks, String BasisforLTVCode, String FacilityReviewParameters, 
			String FacilityReviewRequired, String AutoReviewApplicable, String Periodicity, String AutoReviewRuleID, String Frequency, String AlertsRequired, 
			String Leaddays, String Lagdays, String ExtensionofLimitExpiryDate, String ExtensionofExpiryDateApplicable, String MaximumperiodallowedinDays, 
			String BusinessRuleID, String MaximumNoofExtensionsAllowed, String AlertMessages, String FluctuationThresholdPercentageforLVR, 
			String LimitUtilizationThreshold)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(FacilityCategoryCode, "Start verification of LCMS53 screen");
	
		// *************PAGE INSTANTIATIONS*************
		
		BasePage basepage = new BasePage(driver, wait);
		String textAreaLevel2 = "//label[.='__LABEL__']/../../..//ancestor::tr//textarea[.='__DATA__']";
		String OKButton = "(//span[text()='OK']/parent::a)[2]";
		String Desc = "//label[.='Facility Category Code']";
		String typedesc = "//img[contains(@alt,'Description')]";
		String fdDefaultExpYr = "(//label[.='Default Expiry Period for Revolving in Years and Months']/../following-sibling::td//span)[2]";
		String fdDefaultExpMonth = "(//label[.='Default Expiry Period for Revolving in Years and Months']/../following-sibling::td//span)[4]";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Facility Category Code",FacilityCategoryCode);
		basepage.clickusingjs(true,Desc);
		
		
		basepage.click(true,typedesc);
		basepage.verifyElementPresent(true,textAreaLevel2, "Facility Category Description", Description);
		basepage.click(true,OKButton);
		
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Effective Limit Amount Basis", EffectiveLimitAmountBasis);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Revolving", Revolving);

		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Default Number of Days for First Availment", DefaultNumberofDaysforFirstAvailment);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Default Number of Days for Last Availment", DefaultNumberofDaysforLastAvailment);
		basepage.verifyEquals(true, fdDefaultExpYr,"innerText",DefaultExpiryPeriodforRevolvinginYears);
		basepage.verifyEquals(true, fdDefaultExpMonth,"innerText",DefaultExpiryPeriodforRevolvinginMonths);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Nature of Facility", NatureofFacility);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Disable Subline Creation", DisableSublineCreation);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Notice Days", NoticeDays);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Facility Initiated From", FacilityInitiatedFrom);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "LTV Generation Type", LTVGenerationType);
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Default LTV", DefaultLTV);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Minimum LTV", MinimumLTV);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Remarks", Remarks);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Basis for LTV Code", BasisforLTVCode);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Facility Review Required", FacilityReviewRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Auto Review Applicable", AutoReviewApplicable);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Periodicity", Periodicity);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Auto Review Rule ID", AutoReviewRuleID);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Frequency", Frequency);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Alerts Required", AlertsRequired);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Lead Days", Leaddays);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Lag Days", Lagdays);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Extension of Expiry Date Applicable", ExtensionofExpiryDateApplicable);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Maximum Period Allowed in Days", MaximumperiodallowedinDays);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Business Rule ID", BusinessRuleID);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Maximum No of Extensions Allowed", MaximumNoofExtensionsAllowed);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Fluctuation Threshold Percentage for LVR", FluctuationThresholdPercentageforLVR);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Limit Utilization Threshold", LimitUtilizationThreshold);
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
			
		
	}
}
