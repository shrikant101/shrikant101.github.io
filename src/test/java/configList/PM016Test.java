package configList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM016Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM016Test.class);
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
			String fdrowGroup = "//div[.='__LABEL__']/../../.././/a[@title='Manage']";
			String fdProductLink = "//a/span[.='__LABEL__']";
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			basepage.click(false, locatorProp.getProperty("PMHeader"),"Products");
			basepage.click(false, locatorProp.getProperty("PMButton"),"New Product");
			basepage.click(true, locatorProp.getProperty("PMSelectRow"),"Define Credit Card");
			basepage.click(true, locatorProp.getProperty("cancelConfig"));
			basepage.click(true, locatorProp.getProperty("ConfirmPopupOKButton"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM016 screen")
	public void PM016(Method method, String ProductCode, String ProductName, String ProductRemarks, String ProductStartDate,
			String ProductExpiryDate, String ProductGroupCode, String Currency, String RuleID,
			String RuleName, String CardType) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductCode, "Start verification of PM016 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		
		String currencyPMScreen = "//label[text()='Currency']/../following-sibling::td//input[@type='checkbox']/../..//label[.='__DATA__']";
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Code",ProductCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Code",ProductCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Name",ProductName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Group Code",ProductGroupCode);
		basepage.verifyElementPresent(true,currencyPMScreen,Currency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rule ID",RuleID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rule Name",RuleName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Card Type",CardType);
				
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
