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

public class PM017Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM017Test.class);
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
						
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("PM017");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM017 screen")
	public void PM017(Method method, String Productcode, String ProductDescription, String ProductStartDate, String ProductEnddate, String ProductClass, String InterestRuleDetails, String ProductInterestLinkage, String CurrencyCode, 
			String InterestRuleID, String ClassCode, String DivisionCode, String RuleVersion, String Action, String InterestRuleDetails2, String CurrencyCode2, String InterestRuleID2, String ClassCode2, String DivisionCode2, String RuleVersion2, 
			String ProductClass2) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(Productcode, "Start verification of PM017 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Code",Productcode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Description",ProductDescription);
			
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Start Date",ProductStartDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product End Date",ProductEnddate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Class",ProductClass);
		basepage.verifyTableRow(true,fdTable1,ProductInterestLinkage);
			
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
