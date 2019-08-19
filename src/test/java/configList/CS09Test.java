package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS09Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS09Test.class);
	
	// *************WEB ELEMENTS********************** }
	
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
			homePage.navigatetoFastPath("CS09");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS09 screen")
	public void CS09(Method method, String CountryCode, String AlternateCountryCode, String CountryName, String Regioncode, 
			String Blacklisted, String IBANMandatoryforPaymentMessages) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(CountryCode, "Start verification of CS09 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathRuleID2 =  "(//label[.='Rule ID']/../following-sibling::td//span/span)[2]";
		String xpathRuleName2  = "(//label[.='Rule Name']/../following-sibling::td//span/span)[2]";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Country Code",CountryCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Country Code",CountryCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alternate Country Code",AlternateCountryCode);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Country Name", CountryName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Region code", Regioncode);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Blacklisted", Blacklisted);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "IBAN Mandatory for payment messages", IBANMandatoryforPaymentMessages);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
