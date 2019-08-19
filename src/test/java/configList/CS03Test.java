package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS03Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CS03Test.class);
	
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
			homePage.navigatetoFastPath("CS03");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS03 screen")
	public void CS03(Method method, String BankCode, String BankName, String BankGroupCode, String BankShortName, 
			String AddressDetails, String Line1, String Line2, String Line3, 
			String Line4, String Country, String State, String City, 
			String ZipCode, String Line5, String Line6, String Line7, 
			String Line8, String Line9, String Line10, String Line11, 
			String Line12, String PhoneNumber, String FaxNo, String BankDefaultCurrency, 
			String BankCurrency, String OtherDetails, String CentralBankCode, String WeekDay, 
			String WeekStartDay, String CurrentYearStartMonth, String DenominationTrackingRequired, String DenominationTrackingRequiredFor,
			String DenominationTrackingCurrency, String CreditorIdentificationCode, String PropertyExchangeMemberID, String BusinessNumber,
			String DeclareWeekendDay, String DeclareWeekendDays, String RuleforregulatedLoandecision, String RuleID, 
			String RuleName, String RuleforregulatedODdecision, String RuleID2, String RuleName2) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(BankCode, "Start verification of CS03 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathRuleID2 =  "(//label[.='Rule ID']/../following-sibling::td//span/span)[2]";
		String xpathRuleName2  = "(//label[.='Rule Name']/../following-sibling::td//span/span)[2]";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Bank  Code",BankCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank  Code",BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name",BankName);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Group Code", BankGroupCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Short Name", BankShortName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Current Address", AddressDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Phone Number", PhoneNumber);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Fax Number", FaxNo);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Default Currency", BankDefaultCurrency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Currency", BankCurrency);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Central Bank Code", CentralBankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Weekday", WeekDay);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Week Start Day", WeekStartDay);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Current Year Start Month", CurrentYearStartMonth);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Denomination Tracking Required", DenominationTrackingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Denomination Tracking Required For", DenominationTrackingRequiredFor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Denomination Tracking Currency", DenominationTrackingCurrency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Creditor Identification Code", CreditorIdentificationCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Property Exchange Member ID ", PropertyExchangeMemberID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Business Number ", BusinessNumber);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkFieldMultiOption"), "Declare Weekend Day(s)",DeclareWeekendDays);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rule ID", RuleID);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rule Name", RuleName);
		
		basepage.verifyEquals(true,xpathRuleID2,"innerText", RuleID2);
		basepage.verifyEquals(true,xpathRuleName2,"innerText", RuleName2);
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
