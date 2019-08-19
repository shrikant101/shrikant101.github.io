package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM005Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM005Test.class);
	
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
			homePage.navigatetoFastPath("PM005");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM005 screen")
	public void PM005(Method method, String BankCode, String BankName, String PolicyCode, String PolicyName, String PolicyDescription, String Parameters, 
			String ApplyBenefitsIf, String BundleOwnerIdentificationStrategy, String ApplyBenefitsifBundleSubscriptionFeesNotCollected, 
			String BundleRecommendationStrategy, String ApplyFeesBenefitsToExistingFixedRateAccount, 
			String RevokeBenefitsonDelinkingorClosingAccountsOpenedUnderMandatoryOffers, String IsBundleEligibilityapplicable, 
			String CheckBundleEligibilityfor, String Openallaccounts) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM005 screen");
		String div= "//label[.='__LABEL__']/../following-sibling::td//div/div[.='__DATA__']";
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Code",BankCode);
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name",BankName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Policy Name", PolicyName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyElementPresent(true,div,"Apply Benefits If ",ApplyBenefitsIf);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bundle Owner(s) Identification Strategy",BundleOwnerIdentificationStrategy);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Apply Benefits (Interest and Fees) if Bundle Subscription Fees Not Collected", ApplyBenefitsifBundleSubscriptionFeesNotCollected);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bundle Recommendation Strategy",BundleRecommendationStrategy);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Apply Fees Benefits To Existing  Fixed Rate Account(s)", ApplyFeesBenefitsToExistingFixedRateAccount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Revoke Benefits (Interest and Fees) on Delinking or Closing Accounts Opened Under Mandatory Offers", RevokeBenefitsonDelinkingorClosingAccountsOpenedUnderMandatoryOffers);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Is Bundle Eligibility applicable", IsBundleEligibilityapplicable);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Check Bundle Eligibility for",CheckBundleEligibilityfor);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Open all account(s)", Openallaccounts);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
