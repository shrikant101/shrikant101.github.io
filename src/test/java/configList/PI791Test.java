package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI791Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PI791Test.class);
	
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
			homePage.navigatetoFastPath("PI791");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI791 screen")
	public void PI791(Method method, String FinancialParameterCode, String BaseType, String FinancialParameterName, String Category, 
			String Nature, String ValueType, String MonthlySplitRequired, String IncludeforDSO, 
			String IncludeforSOE, String CalculationType, String RatioEditor, String MandatoryValue, 
			String OriginalAmount, String CurrentOutstanding, String BorrowingPowerCalculatorUse, String OriginalAmount2, 
			String CurrentOutstanding2, String ForeignSources, String OwnershipApplicable, String Formula, 
			String AdditionalDetails, String FieldCode, String FieldName, String Datatype, String Mandatory) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(FinancialParameterCode, "Start verification of PI791 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String verifyElementWithRadio = "//label[.='__LABEL__']/../..//input";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Financial Parameter Code",FinancialParameterCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Financial Parameter Code", FinancialParameterCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Base Type", BaseType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Financial Parameter Name", FinancialParameterName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Category", Category);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Nature", Nature);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Value Type", ValueType);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Monthly Split Required", MonthlySplitRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Include For DSO", IncludeforDSO);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Include For SOE", IncludeforSOE);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Foreign Sources", ForeignSources);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Ownership% Applicable", OwnershipApplicable);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Original  Amount", OriginalAmount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Current Outstanding", CurrentOutstanding);		
		basepage.verifyEquals(true,verifyElementWithRadio, "aria-checked","Original  Amount",OriginalAmount2);
		basepage.verifyEquals(true,verifyElementWithRadio, "aria-checked","Current Outstanding",CurrentOutstanding2);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
