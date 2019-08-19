package configList;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class OR090Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(OR090Test.class);
	
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
			homePage.navigatetoFastPath("OR090");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "superman", priority = 1, description = "Start verification of OR090 screen")
	public void OR090(Method method, String ProductType, String CalculatorType, String CalculatorParameters, String DefaultOffer, 
			String DefaultLVR, String DefaultLVRwithLMI, String DSCR, String NextSteps, 
			String FinancialTemplateRuleID, String IncomeFrequency, String ExpenseFrequency, String IncomeType, 
			String AssumptionsText, String InquiryValidityPeriod) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductType, "Start verification of OR090 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
			String xpathArea = "//label[.='Assumption']/../..//textarea[contains(.,'__LABEL__')]";
			String dummyPresenceCheck = "//label[.='DSCR']/../following-sibling::td//span/span";
		// *************PAGE VARIABLES********************
		
		// *************PAGE METHODS********************
		
		//basepage.clearScreen();
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
	
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Type",CalculatorType);
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Product Type",ProductType);
		
		new WebDriverWait(driver, basepage.implicitWait).until(ExpectedConditions.presenceOfElementLocated(By.xpath(dummyPresenceCheck)));
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Default Offer", DefaultOffer);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Default LVR", DefaultLVR);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Default LVR with LMI", DefaultLVRwithLMI);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","DSCR", DSCR);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Next Steps", NextSteps);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Financial Template Rule ID", FinancialTemplateRuleID);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Income Frequency", IncomeFrequency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Income Type", IncomeType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Expense Frequency", ExpenseFrequency);
		basepage.verifyElementPresent(true,xpathArea, AssumptionsText);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Inquiry Validity Period", InquiryValidityPeriod);
		
		basepage.click(false,locatorProp.getProperty("cancelConfig"));
		
	}

}
