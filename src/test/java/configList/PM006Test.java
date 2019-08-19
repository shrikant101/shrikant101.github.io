package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM006Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM006Test.class);
	
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
			homePage.navigatetoFastPath("PM006");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM006 screen")
	public void PM006(Method method, String PolicyCode, String ProductClass, String PolicyDescription, String Parameters, 
			String WaiveArrears, String WaiveInterest, String WaiveRepayment, String RestructureLoan, 
			String FreezeDaysPastDueCalculation, String RolloverInterest, String ChangeInterestRate, String ChangeTerm, 
			String WaiveFees, String ConsolidateLoan, String FreezeInterest, String FreezeRepayment, 
			String RolloverRepayment, String ReduceInstallment, String RevisedInstallmentAmount, String Deferment) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM006 screen");
		
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//td/span[.='__LABEL__']/../../..//span[text()='__LABEL__']/ancestor::td/..//span/span/span/span/img[@alt='__LABEL__']";
		String fdTable2 = "((//span[.='__LABEL__'])[3]//following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']//following::td[1]//span[.='__LABEL__'])[3]";
		String fdTable3 = "//span[.='__LABEL__']/../following-sibling::td/span/span/span/span/img[@alt='__LABEL__']";
		String fdTable4 = "///span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE ELEMENTS********************
		// *************PAGE METHODS********************
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
			
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Code",PolicyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Class",ProductClass);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Waive Arrears", WaiveArrears);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Waive Interest", WaiveInterest);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Waive Repayment",WaiveRepayment);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Restructure Loan", RestructureLoan);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Freeze Days Past Due Calculation",FreezeDaysPastDueCalculation);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Rollover Interest", RolloverInterest);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Change Interest Rate", ChangeInterestRate);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Change Term", ChangeTerm);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Waive Fees",WaiveFees );
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Consolidate Loan", ConsolidateLoan);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Freeze Interest", FreezeInterest);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Freeze Repayment", FreezeRepayment);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Rollover Repayment", RolloverRepayment);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Reduce Installment", ReduceInstallment);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Revised Installment Amount", RevisedInstallmentAmount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Deferment", Deferment);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
