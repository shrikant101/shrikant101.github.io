package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM040Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCM040Test.class);
	
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
			homePage.navigatetoFastPath("LCM040");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM040 screen")
	public void LCM040(Method method,String AgentID, String InterfaceName, String TitleVerification, String RuleID, String RuleName)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(AgentID, "Start verification of LCM040 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
				
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Agent ID",AgentID);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Interface Name", InterfaceName);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Title Verification",TitleVerification);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Rule id", RuleID);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Rule Name", RuleName);
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
