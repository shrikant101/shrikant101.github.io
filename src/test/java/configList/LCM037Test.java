package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM037Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCM037Test.class);
	
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
			homePage.navigatetoFastPath("LCM037");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM037 screen")
	public void LCM037(Method method,String ValuerID, String ValuationInterface, String RuleID, String RuleName, String Documentlistruleforinterface, 
			String DL_RuleName, String InterfaceServices, String Services)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(ValuerID, "Start verification of LCM037 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 ="//td//img[@alt='__LABEL__']//following::td//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
			
		//basepage.clickusingjs(true,radioField1Level);
		
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Valuer ID",ValuerID);
		//basepage.clickusingjs(true,search);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
			
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Valuation Interface",ValuationInterface);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Rule ID", RuleID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rule Name",RuleName);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Document list rule for interface", Documentlistruleforinterface);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Rule Name", DL_RuleName);
		basepage.verifyTableRow(true,fdTable1,Services);
		basepage.click(true,locatorProp.getProperty("clearConfig"));
			
		
	}
}
