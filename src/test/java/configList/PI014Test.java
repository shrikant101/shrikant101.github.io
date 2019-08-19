package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI014Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PI014Test.class);
	
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
			homePage.navigatetoFastPath("PI014");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI014 screen")
	public void PI014(Method method,String RoleID, String RoleName, String RoleDescription, String RoleType, 
			String PartyType) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(RoleName, "Start verification of PI014 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathRuleID2 =  "(//label[.='Rule ID']/../following-sibling::td//span/span)[2]";
		String xpathRuleName2  = "(//label[.='Rule Name']/../following-sibling::td//span/span)[2]";
		String xpTabLink = "//label[.='Role ID']/../following-sibling::td//input";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Role ID",RoleID);
		basepage.tab(xpTabLink);

		//basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Role ID",RoleID);	--skipped as span and input both come
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL4txt"), "innerText","Role Name",RoleName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Role Description",RoleDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Role Type",RoleType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Party Type",PartyType);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
