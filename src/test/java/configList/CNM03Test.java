package configList;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CNM03Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(CNM03Test.class);
	
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
			homePage.navigatetoFastPath("CNM03");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CNM03 screen")
	public void CNM03(Method method, String DocumentPolicyCode, String Description, String EntityLinkageLevel, String ProductGroupDetails, 
			String SelectAllProductGroupsorOffers, String ProductGroupID, String ProductGroupName, String SelectRecord, 
			String EventRuleMapping, String EventName, String InboundRule, String OutboundRule, 
			String RuleTypes, String DecisionTable, String GuidedRuleEditor
) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(DocumentPolicyCode, "Start verification of CNM03 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
			
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		
		String fdTable3 = "//span[.='__LABEL__']/../following-sibling::td/span/..//img[contains(@title,'Outbound')]/../../../..//img[contains(@title,'Inbound')]";
		String verifyInboundTable = "//span[.='__LABEL__']/../following-sibling::td/span/..//img[contains(@title,'Inbound')]";
		String verifyOutboundTable = "//span[.='__LABEL__']/../following-sibling::td/span/..//img[contains(@title,'Outbound')]";
		String decisionTableInAndOutbound =  "//div[contains(@id,'headerGridLayout')]";
		String OkButton = "//span[text()='OK']";
		// *************PAGE VARIABLES********************
		
		
		// *************PAGE METHODS********************
		
		//basepage.clearScreen();
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Document Policy Code",DocumentPolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Policy Code", DocumentPolicyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Description", Description);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Entity Linkage Level", EntityLinkageLevel);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Group Details", ProductGroupDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Select All Product Groups or Offers", SelectAllProductGroupsorOffers);
		
		if (!(ProductGroupID.equalsIgnoreCase("NA") || ProductGroupName.equalsIgnoreCase("NA"))) {
			String tableContent  = ProductGroupID + ":" + ProductGroupName;
			basepage.verifyTableRow(true,fdTable1,tableContent);
		}
		
		basepage.verifyTableRow(true,fdTable3,EventName);
		
		//1st locator is generic, 2nd locator is replacement text and DECISION YES or NO. 3rd locator is decision table xpath
		if(!InboundRule.equalsIgnoreCase("")) {
			basepage.verifyDecisionTablePresence(true,verifyInboundTable,InboundRule,decisionTableInAndOutbound);
		}
		if(!OutboundRule.equalsIgnoreCase("")) {
			basepage.verifyDecisionTablePresence(true,verifyOutboundTable,OutboundRule,decisionTableInAndOutbound);
		}
		basepage.click(false,clearConfig);
		
	}

}
