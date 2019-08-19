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

public class NP001Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(NP001Test.class);
	
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
			homePage.launchBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("NP001");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of NP001 screen")
	public void NP001(Method method, String BankCode, String Description, String ApplicabilityLevel, String z, 
			String Thespecificruleidtobeusedforclassificationismentionedhere, String z1, String ToselectODInterestArrearsclawbackflag, String ToselectODSC,
			String z2, String ToselectLoanInterestArrearsclawbackflag, String ToselectLoanOutgoingsArrearsclawbackflag, String ToselectLoanSC, 
			String ToselectLoanPremiumArrearsclawbackflag, String ToselectLoanLegalFeesArrearsclawbackflag) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(BankCode, "Start verification of NP001 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		String verifyElementWithRadio = "//input[@type='radio' and @value=0]/../following-sibling::label[.='Account']";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Bank Code",BankCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Code",BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name", Description);
		basepage.verifyElementWithData(true,locatorProp.getProperty("radioField1Level"), ApplicabilityLevel);
		
		basepage.verifyElementPresent(true,verifyElementWithRadio , ApplicabilityLevel);
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
