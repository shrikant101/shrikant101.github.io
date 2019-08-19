package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class OR276Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(OR276Test.class);
	
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
			homePage.navigatetoFastPath("OR276");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of OR276 screen")
	public void OR276(Method method, String ReasonCode, String Description, String Category, String Classification,
			String External, String Details, String DisplayinCreditMemorandum) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ReasonCode, "Start verification of OR276 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathtextAreaLevel2txt = "(//label[.='__LABEL__']/../../..//ancestor::tr//textarea)[2]";
		
		// *************PAGE METHODS********************		
		//basepage.clearScreen();
		basepage.readyAUT(false,locatorProp.getProperty("clearConfig"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Reason Code",ReasonCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		basepage.verifyEquals(true,xpathtextAreaLevel2txt,"value", "Description", Description);
		basepage.verifyEquals(true,locatorProp.getProperty("textAreaLevel2txt"),"value", "Details", Details);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "External", External);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Display in Credit Memorandum", DisplayinCreditMemorandum);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Category",Category);
		if (!Classification.equalsIgnoreCase("NA")) {
			basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Classification",Classification);
		}
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
