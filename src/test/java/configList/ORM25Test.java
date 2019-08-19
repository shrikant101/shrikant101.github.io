package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class ORM25Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(ORM25Test.class);

	// *************WEB ELEMENTS********************** }
	//
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
			homePage.navigatetoFastPath("ORM25");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of ORM25 screen")
	public void ORM25(Method method, String FundingCode, String FundingCodeDescription, String FundingType,
			String Purpose) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(FundingCode, "Start verification of ORM25 screen");

		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		//

		// *************PAGE METHODS********************
		// basepage.clearScreen();
		basepage.readyAUT(false, locatorProp.getProperty("clearConfig"), locatorProp.getProperty("clearConfig"));
		basepage.enter(true, locatorProp.getProperty("inputFieldL1"), "Funding Code", FundingCode);
		basepage.clickusingjs(true, locatorProp.getProperty("searchLink"));
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Funding Code Description",
				FundingCodeDescription);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Funding Type", FundingType);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Purpose", Purpose);
		basepage.click(false, locatorProp.getProperty("clearConfig"));

	}
}
