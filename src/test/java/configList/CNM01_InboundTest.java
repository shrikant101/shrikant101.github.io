package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CNM01_InboundTest extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CNM01_InboundTest.class);
	
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

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CNM01 inbound screen")
	public void CNM01_Inbound(Method method, String NewDocumentType, String DocumentTypeDescription, String IdentificationCategoryOld, 
			String IdentificationCategory, String DocumentTypeClassification, String ExpiryTrackingMethod, String Period_YY, 
			String Period_MM, String Period_DD, String IssueDateAliasExpiryDateAlias, String ScrutinyMode,String PrimaryIndexType) 
					throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(NewDocumentType, "Start verification of CNM01 inbound screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdyearCheck = "(//label[.='Period']/../following-sibling::td//span)[2]";
		String fdmonthCheck = "(//label[.='Period']/../following-sibling::td//span)[3]";
		String fddayCheck = "(//label[.='Period']/../following-sibling::td//span)[4]";
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Document Type",NewDocumentType);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		//multi entry
		basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Document Type",NewDocumentType);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type",NewDocumentType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type Description",DocumentTypeDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Identification Category",IdentificationCategory);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Document Type Classification",DocumentTypeClassification);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Expiry Tracking Method",ExpiryTrackingMethod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Scrutiny Mode",ScrutinyMode);
		
		basepage.verifyEquals(true,fdyearCheck,"innerText",Period_YY);
		basepage.verifyEquals(true,fdmonthCheck,"innerText",Period_MM);
		basepage.verifyEquals(true,fddayCheck,"innerText",Period_DD);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Issue Date Alias",IssueDateAliasExpiryDateAlias);
		
		basepage.verifyElementWithDataAndValue(true,locatorProp.getProperty("tableIndexType"),"Primary Index Type",PrimaryIndexType);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}
}
