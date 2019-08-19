package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI790Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(PI790Test.class);
	
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
			homePage.navigatetoFastPath("PI790");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI790 screen")
	public void PI790(Method method,String NatureCode,String Nature, String Name, String DataType,String DefaultValue,String Mandatory,String AutoRow)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(Nature, "Start verification of PI790 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Nature",Nature);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Nature",Nature);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Description", Nature);
		if(Mandatory.equalsIgnoreCase("Optional")) {
			Mandatory = "false";
		} else if(Mandatory.equalsIgnoreCase("Mandatory")) {
			Mandatory = "true";
		} 
		AutoRow.replaceAll("Optional", "false");
		AutoRow.replaceAll("Mandatory", "true");
		basepage.verifyTableRow(true,fdTable1,AutoRow);
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
