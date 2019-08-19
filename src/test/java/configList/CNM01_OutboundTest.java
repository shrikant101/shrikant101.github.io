package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CNM01_OutboundTest extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CNM01_OutboundTest.class);
	
	// *************WEB ELEMENTS********************** }
	//
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
			homePage.navigatetoFastPath("CNM01");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(dataProvider = "superman", priority = 2, description = "Start verification of CNM01 outbound screen")
	public void CNM01_Outbound(Method method, String DocumentType, String DocumentTypeDescription, 
			String DocumentTypeClassification, String PermissibleDeliveryChannel_1, String DefaultDeliveryChannel, String AcceptanceRequired, 
			String ProtectWithPassword, String Mandatory, String ExecutionRequired, String UploadableVersionAllowed, 
			String ReferenceNumberValidationRequired,String IndexType_1, String InbounddocumentInsert) 
					throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(DocumentType, "Start verification of CNM01 outbound screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable = "//span[.='__LABEL__']";
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Document Type",DocumentType);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		//multi entry
		basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Document Type",DocumentType);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type",DocumentType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type Description",DocumentTypeDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type Classification",DocumentTypeClassification);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Protect With Password", ProtectWithPassword);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Acceptance Required", AcceptanceRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Mandatory", Mandatory);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Execution Required", ExecutionRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Reference Number Validation Required", ReferenceNumberValidationRequired);
		
		basepage.verifyElementWithDataAndValue(true,locatorProp.getProperty("tableIndexType"),"Primary Index Type",IndexType_1);
		basepage.verifyElementWithData(true,fdTable,InbounddocumentInsert);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}