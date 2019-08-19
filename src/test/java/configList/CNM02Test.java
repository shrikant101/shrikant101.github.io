package configList;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CNM02Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(CNM02Test.class);
	
	String clearConfig = "(//a/img[contains(@src,'clear')])[1]";
	String searchLink = "//a[contains(@title,'Search: ')]";
	String txtDocumentType = "//label[.='__LABEL__']/../following-sibling::td/span/input";
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		// ExtentReports Description
		
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);

			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("CNM02");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CNM02 screen")
	public void CNM02(Method method, String CategoryId, String Description, String NoOfMandatoryDocuments,
			String Details) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(CategoryId, "Start verification of CNM02 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
			
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String OkButton = "//span[text()='OK']";
		// *************PAGE METHODS********************		
		//basepage.clearScreen();
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Category ID",CategoryId);
		basepage.clickusingjs(true,"("+locatorProp.getProperty("searchLink")+")[1]",CategoryId);
		basepage.SelectFirstRow3(locatorProp.getProperty("closeSearchBox"),"Category ID", "Code", CategoryId);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Description",Description);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number of Mandatory Documents",NoOfMandatoryDocuments);
		basepage.verifyTableRow(true,fdTable1,Details);
		
		basepage.click(false,clearConfig);
		
	}

}
