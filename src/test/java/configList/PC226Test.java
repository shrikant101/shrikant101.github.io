package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PC226Test extends BaseTest{
private static final Logger LOGGER = Logger.getLogger(PC226Test.class);
	
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
			homePage.navigatetoFastPath("PC226");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PC226 screen")
	public void PC226(Method method, String BankCode, String BankName,	String BranchCode, String BranchName, String RegionCode, String	InstitutionID)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(BankCode, "Start verification of PC226 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String OkButton = "(//span[text()='OK']/parent::a)[2]";
		
		// *************PAGE ELEMENTS********************	
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		basepage.selectFirstRow4(locatorProp.getProperty("closeSearchBox"),"Bank Code",BankCode);	
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"),"Bank Name	",BankName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Branch Code",BranchCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Branch Name",BranchName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Region Code ",RegionCode);
		
		basepage.verifyTableRow(true,fdTable1,InstitutionID);
						
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
		}

}
