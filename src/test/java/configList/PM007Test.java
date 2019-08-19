package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM007Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM007Test.class);
	
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
		
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("PM007");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM007 screen")
	public void PM007(Method method, String PolicyCode, String PolicyDescription, String GeneralParameters, String DeliveryMode, String AllowCustomertooptoutofStatements, 
			String FrequencyParameters, String BillingStatement, String StatementFrequency, String StatementGeneration, String DeferredStatementGenerationDate, 
			String StatementGenerationStartMonth, String PermittedFrequenciesatAccount, String EventFrequencyDefinition, String OtherParameters, 
			String StatementwithoutanyFinancialTransaction, String AccountClosureStatement, String YeartoDateStatementNumber, 
			String StatementUpdationDate, String BlockAccountStatuses, String SystemDefinedStatus, String UserDefinedStatus, 
			String PrintNominationReferenceNumber) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM007 screen");
		
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable2 = "//img[@alt='Checked']/../following-sibling::span[.='__LABEL__']";
		// *************PAGE ELEMENTS********************
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyTableRow(true,fdTable2,DeliveryMode);
		//basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Delivery Mode",DeliveryMode);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Customer to opt out of Statements", AllowCustomertooptoutofStatements);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Billing Statement", BillingStatement);
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Statement Frequency", StatementFrequency);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"Statement Generation",StatementGeneration);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Deferred Statement Generation Date",DeferredStatementGenerationDate);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Statement Generation Start Month",StatementGenerationStartMonth);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Permitted Frequencies at Account",PermittedFrequenciesatAccount);
		
		//basepage.verifyTableRow(true,fdTable1,EventFrequencyDefinition);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Statement without any Financial Transaction", StatementwithoutanyFinancialTransaction);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Account Closure Statement", AccountClosureStatement);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Year to Date Statement Number", YeartoDateStatementNumber);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Statement Updation Date",StatementUpdationDate);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Block Account Statuses", BlockAccountStatuses);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"System Defined Status",SystemDefinedStatus);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"User Defined Status",UserDefinedStatus);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Print Nomination Reference Number", PrintNominationReferenceNumber);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
