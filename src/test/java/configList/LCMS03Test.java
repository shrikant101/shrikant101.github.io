package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCMS03Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(LCMS03Test.class);
	
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
			homePage.navigatetoFastPath("LCMS03");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCMS03 screen")
	public void LCMS03(Method method,String CodeType, String Code, String Description, String Details, String Type, String View, String External, 
			String RevalidateCompliance, String Monitoring, String MonitoringType, String StartDays, String Monitoringfrequency, String MaxStartDaysVariance, 
			String GraceDays, String NoticeDays, String MaxGraceDays, String MaxMonitoringDays, String MonitoringDays)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(Code, "Start verification of LCMS03 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		
		String radioField1Level = "//input[@type='radio']/../..//label[.='"+CodeType+"']";
		String search = "//a[@title='Search']";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
			
		basepage.clickusingjs(true,radioField1Level);
		
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Code",Code);
		basepage.clickusingjs(true,search);
			
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Description",Description);
		basepage.verifyElementPresent(true,locatorProp.getProperty("textAreaLevel2"), "Details", Details);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Type", Type+" ");
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "View", View);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "External", External);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Revalidate Compliance", RevalidateCompliance);
		basepage.click(true,locatorProp.getProperty("clearConfig"));
			
		
	}
}
