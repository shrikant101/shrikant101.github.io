package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class AL03Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AL03Test.class);
	
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
			homePage.navigatetoFastPath("AL03");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of AL03 screen")
	public void AL03(Method method, String TemplateId, String TemplateName, String DestinationType, String SubjectLine, 
			String MessageData, String DataAttribute, String AttributeMask) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(TemplateId, "Start verification of AL03 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable3 = "//div[.='Data Attributes']/../../../../../../..//span/span/span[.='__LABEL__']";
		String xpathdataAttrib = "//a/span[.='__LABEL__']";
		String xpathOKAttrib = "(//a/span[.='__LABEL__'])[2]";
		String fdTableForMessage = "//p[contains(text(),'__LABEL__')]";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Template ID",TemplateId);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Template ID",TemplateId);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Template Name",TemplateName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Destination Type",DestinationType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Template ID",TemplateId);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Subject Line",SubjectLine);
		
		basepage.verifyTableRow(true,fdTableForMessage,MessageData);//needs more analysis for automation 
		
		
		basepage.click(true,xpathdataAttrib,"Data Attributes");
			
		basepage.verifyTableRow(true,fdTable3,DataAttribute);
		//new method needed to check the presence of D also next to the values of data attribute 
		
		basepage.verifyTableRow(true,fdTable3,AttributeMask);
		basepage.clickusingjs(true,xpathOKAttrib,"OK");
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
