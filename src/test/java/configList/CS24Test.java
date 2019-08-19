package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS24Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS24Test.class);
	
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
			homePage.navigatetoFastPath("CS24");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS24 screen")
	public void CS24(Method method, String PurposeCode, String PurposeName, String PurposeDescription, String PurposeType)
			throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PurposeCode, "Start verification of CS24 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		//	
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Purpose Code",PurposeCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		//multi entry OR no entry
		basepage.sortAndSelectFirstRow(locatorProp.getProperty("closeSearchBox"),"Effective Date",PurposeCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Purpose Name",PurposeName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Purpose Type",PurposeType);
		
		basepage.click(true,locatorProp.getProperty("imgL1"),"Purpose Description");
		basepage.verifyElementPresent(true,locatorProp.getProperty("textAreaLevel2"), "Purpose Description", PurposeDescription);
		basepage.click(true,locatorProp.getProperty("spanButtonL2"), "Purpose Description","OK");
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
		}

}
