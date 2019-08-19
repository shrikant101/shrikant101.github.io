package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class AS017Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AS017Test.class);
	
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
			homePage.navigatetoFastPath("AS017");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of AS017 screen")
	public void AS017(Method method, String ProductGroupCode, String ProductGroupDescription, String ProductGroupLevelAccountRoleMapping, 
			String AccountRole, String Description, String AccountHead, String Description1, String SuspendedAccountHead, String Description2) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductGroupCode, "Start verification of AS017 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Group Code",ProductGroupCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Group Description",ProductGroupDescription);
		basepage.verifyTableRow(true,fdTable1,ProductGroupLevelAccountRoleMapping);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
