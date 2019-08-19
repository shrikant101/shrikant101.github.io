package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS21Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS21Test.class);
	
	// *************WEB ELEMENTS********************** }
	String chkField2Level = "//label[text()='__LABEL__']/../following-sibling::td//img[@alt='__DATA__']";
	String textAreaLevel2 = "//label[.='__LABEL__']/../../..//ancestor::tr//textarea[.='__DATA__']";
	String spanButtonL2 = "//label[.='__LABEL__']/ancestor::tr//span[.='__DATA__']";
	
	String typedesc = "//img[contains(@alt,'Enter category description up to 150 characters.')]";

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
			homePage.navigatetoFastPath("CS21");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS21 screen")
	public void CS21(Method method, String CategoryID, String CategoryDesc, String External, String AllowVerificationOutsideTask, String VerificationType)
			throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(CategoryID, "Start verification of CS21 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		//String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		//String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../..//img[@alt='__LABEL__']";
		//V String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../..//img[@alt='__LABEL__']/ancestor::td/..//span/span/span[.='__LABEL__']";
		
		String fdTable1 = "//td/span[.='__LABEL__']/../../..//span[text()='__LABEL__']/ancestor::td/..//span/span/span/span/img[@alt='__LABEL__']/ancestor::td/following-sibling::td/span/span/span[.='__LABEL__']";
		// *************PAGE ELEMENTS********************	
		//	
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Category ID",CategoryID);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.click(true,typedesc);
		basepage.verifyElementPresent(true,textAreaLevel2, "Category Description", CategoryDesc);
		basepage.click(true,spanButtonL2, "Category Description","OK");
		
		
		basepage.verifyCheckBox(true,chkField2Level, "External", External);
		basepage.verifyCheckBox(true,chkField2Level, "Allow verification outside verification task", AllowVerificationOutsideTask);

		
		basepage.verifyTableRow(true,fdTable1,VerificationType);
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
		}

}
