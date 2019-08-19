package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS16Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS16Test.class);
	
	// *************WEB ELEMENTS********************** }
	String locator_taskCode = "//*[.='Linked Tasks']/../../../../..//li";
	String locator_taskCode2 = "//span/span[.='__LABEL__']";
	String subheader = "//a[@role='button' and text()='__LABEL__']";
	
	
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
			homePage.navigatetoFastPath("CS16");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS16 screen")
	public void CS16(Method method, String PrimaryReasonCode,String PrimaryReasonDescription,String TaskCode,String SecondaryReasons,
			String TaskCode2,String SecondaryReasonCode,String SecondaryReasonDescription,String ApplicableCategories,
			String CategoryName,String CategoryDescription,String SuggestedActions,String OutboundDocumentationRequired,
			String NegativeInformationReportingRequired,String TaskCategory,String SystemtohavetofactoryshippedRiskIndicators,
			String SecondaryReasonDetails,String SecondaryReasonCode2,String SecondaryReasonDescription2,String TaskCode3
) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PrimaryReasonCode, "Start verification of CS16 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		//	
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Primary Reason Code",PrimaryReasonCode);
		basepage.clickusingjs(false,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Primary Reason Code",PrimaryReasonCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Description",PrimaryReasonDescription);
		
		//basepage.click(true,subheader,"Task Code");
		basepage.verifyEquals(true,locator_taskCode,"innerText",TaskCode);
		if(!SecondaryReasonCode.equalsIgnoreCase("NA")) {
			basepage.click(true,subheader,"Secondary Reasons");
			basepage.verifyTableRow2(true,locator_taskCode2,SecondaryReasonCode);
		}
		
//		basepage.verifyElementPresent(true,locator_taskCode2,SecondaryReasonCode+", "+SecondaryReasonDescription);
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
