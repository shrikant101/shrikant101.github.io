package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM52Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCM52Test.class);
	
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
			homePage.navigatetoFastPath("LCM52");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM52 screen")
	public void LCM52(Method method,String LTVMatrixID, String LTVMatrixDetails)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(LTVMatrixID, "Start verification of LCM52 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";	
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		//basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"LTV Matrix ID",LTVMatrixID);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyTableRow(true,fdTable1,LTVMatrixDetails);
		/*basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "LTV Matrix Details", LTVMatrixDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Serial No",SerialNo);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","LTV Code",LTVCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Loan to Bank Value Ratio",LoanToBankValueRatio);*/
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
