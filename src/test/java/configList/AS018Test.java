package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class AS018Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AS018Test.class);
	
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
			homePage.navigatetoFastPath("AS018");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of AS018 screen")
	public void AS018(Method method, String ProductCode, String ProductDescription, String StartDate, 
			String EndDate, String AccountRoleMapping, String AccountRole) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductCode, "Start verification of AS018 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Code",ProductCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Description",ProductDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Start Date",StartDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","End Date",EndDate);
		
		
		basepage.verifyTableRow(true,fdTable1,AccountRoleMapping);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
