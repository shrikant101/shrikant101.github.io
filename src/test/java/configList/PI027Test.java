package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI027Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(PI027Test.class);
	
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
			homePage.navigatetoFastPath("PI027");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI027 screen")
	public void PI027(Method method,String CategoryID, String CategoryName)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(CategoryID, "Start verification of PI027 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
				
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		//basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Bank Code",BankCode);
		basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Category ID",CategoryID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Category Name", CategoryName);
		//basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Name",BankName);
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
