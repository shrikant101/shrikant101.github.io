package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS15Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PI014Test.class);
	
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
			homePage.navigatetoFastPath("CS15");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS15 screen")
	public void CS15(Method method,String PaymentCode, String PaymentDescription, String PaymentType, String CompositeClearingPaymentCalendar, 
			String CalendarTypeName) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PaymentCode, "Start verification of CS15 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathRuleID2 =  "(//label[.='Rule ID']/../following-sibling::td//span/span)[2]";
		String xpathRuleName2  = "(//label[.='Rule Name']/../following-sibling::td//span/span)[2]";
		String xpSearchLink = "(//a[contains(@title,'Search')])[2]";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Payment Code",PaymentCode);
		basepage.clickusingjs(true,xpSearchLink);

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payment Code",PaymentCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payment Description",PaymentDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payment Type",PaymentType);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Composite Clearing/Payment Calendar", CompositeClearingPaymentCalendar);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Calendar Type Name",CalendarTypeName);
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}
}
