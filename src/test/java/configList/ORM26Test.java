package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class ORM26Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(ORM26Test.class);
	
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
			homePage.navigatetoFastPath("ORM26");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of ORM26 screen")
	public void ORM26(Method method, String FundingTemplate, String FundingTemplateDescription, String LinkedProductGroup, String ProductGroup, 
			String Purpose, String LinkedParametercodes, String FundingType, String Parametercode) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(FundingTemplate, "Start verification of ORM26 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String verifyElementWithRadio = "//label[.='__LABEL__']/../..//input";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Funding Template", FundingTemplate);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Funding Template", FundingTemplate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Funding Template Description", FundingTemplateDescription);
		String fdTable1 = "//td[.='" + ProductGroup + "']/following-sibling::td[.='__LABEL__']";
		
		String fdTable2 = "//td[.='__LABEL__']/following-sibling::td[.='__LABEL__']";
		basepage.verifyTableRow(true,fdTable1,Purpose);
		basepage.verifyTableRow(true,fdTable2,Parametercode);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
