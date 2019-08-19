package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS10Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS10Test.class);
	
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
			homePage.navigatetoFastPath("CS10");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS10 screen")
	public void CS10(Method method, String BankCode, String BranchCode, String FinancialCycle, String FinancialCycleDescription, 
			String StartDate, String EndDate, String PeriodCodeDetails, String PeriodCode, 
			String StartDate2, String EndDate2) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(BranchCode, "Start verification of CS10 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathRuleID2 =  "(//label[.='Rule ID']/../following-sibling::td//span/span)[2]";
		String xpathRuleName2  = "(//label[.='Rule Name']/../following-sibling::td//span/span)[2]";
		String fdTable3 = "//span[.='__LABEL__']/../following-sibling::td//span[.='__LABEL__']/../../../following-sibling::td//span[.='__LABEL__']";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Branch Code",BranchCode);
		basepage.tab("//label[.='Branch Code']/../following-sibling::td/span/input");
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Financial Cycle",FinancialCycle);
		basepage.clickusingjs(true,"("+locatorProp.getProperty("searchLink")+")[1]");
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Financial Cycle Description", FinancialCycleDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Start Date", StartDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","End Date", EndDate);
		
		basepage.verifyDateTableRow(true,fdTable3,PeriodCodeDetails);		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
