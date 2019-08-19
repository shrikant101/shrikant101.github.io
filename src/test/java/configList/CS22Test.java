package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS22Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS22Test.class);
	
	
	
	//builds a new report using the html template 
    
    //helps to generate the logs in test report.
	// Extra information:
	// 1) @BeforeClass we declared driver and wait variables
	// 2) We send these driver and wait variables to the page class with below
	// declaration
	// Homepage homepage = new HomePage(driver,wait);
	// 3) super () method in page class transfer the driver and wait variables
	// values to the BasePage class.

	// *************WEB ELEMENTS********************** }

	String fastpathForConfig = "//INPUT[@id='pt1:fastPathSubForm:it4::content']";
	String fastpathSearch = "//IMG[@id='pt1:fastPathSubForm:cil2::icon']";

	String addNewConfig = "(//a/img[contains(@src,'add')])[1]";
	String clearConfig = "(//a/img[contains(@src,'clear')])[1]";
	String closeConfig = "(//a/img[contains(@src,'close')])[3]";
	String exitConfig = "//span/span[text()='x']";

	String searchLink = "//a[contains(@title,'Search: ')]";
	String txtDocumentType = "//label[.='__LABEL__']/../following-sibling::td/span/input";

	String lblDocumentTypeClassification = "//label[.='__LABEL__']/../following-sibling::td/span/span[.='__DATA__']";

	String closeSearchBox = "//div[text()='Search and Result Dialog']/ancestor::table//a[@title='Close']";
	String lblDocumentTypeDescription = "//label[.='Document Type Description']/../following-sibling::td/span";

	String lblPermissibleDeliveryChannel = "//label[.='Permissible Delivery Channel']/../following-sibling::td//span[.='__DATA__']/../span/img[@alt='Checked']";
	String lblDefaultDeliveryChannel = "//label[.='Default Delivery Channel']/../following-sibling::td//label[.='__DATA__']/../span/input[@checked=\"\"]";
	String chkField2Level = "//label[text()='__LABEL__']/../following-sibling::td//img[@alt='__DATA__']";
	String chkField1Level = "//label[text()='__LABEL__']/../following-sibling::td//input[@type='checkbox' and @checked=\"\"]";
	String tableIndexType = "//div[@aria-label='__DATA__']//span/span/span[.='__DATA__']";

	String textAreaLevel2 = "//label[.='__LABEL__']/../../..//ancestor::tr//textarea";
	String spanButtonL2 = "//label[.='__LABEL__']/ancestor::tr//span[.='__DATA__']";
	
	String typedesc = "//img[contains(@alt,'type description')]";
	String imgL1 = "//img[contains(@alt,'__LABEL__')]";
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
			homePage.navigatetoFastPath("CS22");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS22 screen")
	public void CS22(Method method, String TypeID, String ViewabletoParty, String TypeName,
			String AlerttobeSentonCompletion, String TypeDescription, String External,
			String ContextualVerificationApplicable,String a,String b, String c, String d, String e, String f, 
			String ElectronicVerificationRequired, String g, String CategoryID, String NumberOfMandatoryDocuments,
			String Nature, String IndexType) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(TypeID, "Start verification of CS22 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String L2Element = "//label[.='__LABEL__']/ancestor::tbody//span[.='__DATA__']";
		
		// *************PAGE METHODS********************		
		//basepage.clearScreen();
		basepage.readyAUT(false,searchLink,clearConfig);
		basepage.enter(true,txtDocumentType,"Type ID",TypeID);
		basepage.clickusingjs(true,searchLink);
		//multi entry
		basepage.SelectFirstRow2(locatorProp.getProperty("closeSearchBox"),"Type ID",TypeID);
		basepage.verifyCheckBox(true,chkField2Level, "Viewable to Party", ViewabletoParty);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Type Name",TypeName);
		basepage.verifyCheckBox(true,chkField2Level, "Alert to be Sent on Completion", AlerttobeSentonCompletion);
	
		basepage.clickusingjs(true,typedesc);
		basepage.verifyEquals(true,textAreaLevel2,"value", "Type Description", TypeDescription);
		basepage.click(true,spanButtonL2, "Type Description","OK");
		
		basepage.verifyCheckBox(true,chkField2Level, "External", External);
		basepage.verifyCheckBox(true,chkField2Level, "Contextual Verification Applicable", ContextualVerificationApplicable);
			
		basepage.verifyCheckBox(true,chkField2Level, "Electronic Verification Required", ElectronicVerificationRequired);
		basepage.verifyElementPresent(false,locatorProp.getProperty("lblGenericFieldL2"),"Category ID",CategoryID);
		basepage.verifyElementPresent(false,locatorProp.getProperty("lblGenericFieldL2"),"Number Of Mandatory Documents",NumberOfMandatoryDocuments);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Nature",Nature);
		
		basepage.click(false,clearConfig);
		
	}

}
