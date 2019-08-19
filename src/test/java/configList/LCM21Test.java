package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM21Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCM21Test.class);
	
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
			homePage.navigatetoFastPath("LCM21");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM21 screen")
	public void LCM21(Method method,String CollateralType, String CollateralCategory, String SerialNumber, String Attributes, String IncludeforProbableMatchCheck)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(CollateralCategory, "Start verification of LCM21 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span/span/span[.='__LABEL__']";
		String fdTable2 = "//span[.='__LABEL__']/../following-sibling::td/span/span/span/span/img[@alt='Checked']";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("selectFieldL1"),"Collateral Type",locatorProp.getProperty("clearConfig"));
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Collateral Type",CollateralType);
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Collateral Category",CollateralCategory);
		basepage.verifyTableRow(true,fdTable1,Attributes);
		basepage.verifyTableRow(true,fdTable2,IncludeforProbableMatchCheck);
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
