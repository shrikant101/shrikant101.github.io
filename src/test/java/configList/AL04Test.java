package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class AL04Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AL04Test.class);
	
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
			homePage.navigatetoFastPath("AL04");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of AL04 screen")
	public void AL04(Method method, String AlertName, String ActivityandEventDescription, String ActivityName, String ExpiryDate, 
			String EventName, String AlertType, String RetriesRequired, String AlertNature, 
			String NumberofRetries, String AlertDispatchType, String RecipientCategory, String Recipients, 
			String Modeofdelivery, String TemplateRule, String MessageTemplate, String RuleID, 
			String RuleEffectiveDate, String SendUnsecureMessage, String UnsecureMessageID, String RuleMessageTemplates, 
			String Rule, String MessageTemplate2, String TemplateName, String SubjectBuffer, 
			String MessageData, String DataAttributes) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(AlertName, "Start verification of AL04 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../..//img/../../../../../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable3 = "//div[.='Data Attribute']/../../../../../..//span/span/span[.='__LABEL__']/../../../../td//span/span/span[.='__LABEL__']/../../../../td//span/span/span[.='__LABEL__']";
		String xpathRead = "(//span[.='Read'])[2]";
		String xpathdataAttrib = "//a/span[.='__LABEL__']";
		String fdTableForMessage = "//p[contains(text(),'__LABEL__')]";
		String xpathOKAttrib = "(//a/span[.='__LABEL__'])[2]";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Alert Name", AlertName);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alert Name", AlertName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Activity and Event Description", ActivityandEventDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Activity Name", ActivityName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Expiry Date", ExpiryDate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Event Name", EventName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alert Type", AlertType);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Retries Required", RetriesRequired);
		//basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Retries Required", RetriesRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alert Nature", AlertNature);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number of Retries", NumberofRetries);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Alert Dispatch Type", AlertDispatchType);
		
		String AttributeMask = RecipientCategory + ":" + Recipients + ":" + Modeofdelivery + ":" + TemplateRule + ":" + MessageTemplate + ":" + RuleID + ":" + RuleEffectiveDate + ":" + UnsecureMessageID + ":" +RuleMessageTemplates ;  
		basepage.verifyTableRow(true,fdTable1,AttributeMask);


//		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Send Unsecure Message", SendUnsecureMessage);
		
		basepage.click(true, xpathRead);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Template Name", TemplateName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Subject Buffer", SubjectBuffer);
		
		basepage.verifyTableRow(true,fdTableForMessage,MessageData);//needs more analysis for automation
		
		basepage.click(true,xpathdataAttrib,"Data Attributes");		
		basepage.verifyTableRow(true,fdTable3,DataAttributes);
		//new method needed to check the presence of D also next to the values of data attribute 

		basepage.clickusingjs(true,xpathOKAttrib,"OK");
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
