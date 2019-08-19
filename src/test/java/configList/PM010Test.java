package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM010Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM010Test.class);
	
	// *************WEB ELEMENTS********************** }
	//
	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
			String fdrowGroup = "//div[.='__LABEL__']/../../.././/a[@title='Manage']";
			String fdProductLink = "//a/span[.='__LABEL__']";
			
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			basepage.click(false, "//a[@aria-label='Product Groups']");
			basepage.click(true, fdrowGroup,"HOPG001");
			basepage.click(true, fdProductLink,"Define Product Group");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM010 screen")
	public void PM010(Method method, String ProductGroupCode, String Description, String ProductGroupNature, String LinkageType, 
			String GroupType, String ProductType, String OriginationWorkflowBehaviour, String ISPGForOfficeAccount, 
			String IsPGforInvestmentType, String IsExternal, String AllowedCurrencies, String Currency, 
			String OriginationParameter, String DebitBureauCheckRequired, String FastRefinanceApplicable, String QuickRefinanceApplicable,
			String MaximumPermissibleLVRForManualAllocation, String SettlementRequired, String MultipleOffersallowedinasingleApplication, String ApplicantEligibilityRuleID, 
			String ApplicantEligibilityRuleName, String CoSignorApplicable, String WhetherCoApplicantisapplicableforCreditCard, String AllowedTerm, 
			String MinimumTermYearsinYears,String MinimumTermYearsinMonths, String MaximumTerminYears,String MaximumTerminMonths, 
			String DefaultTerminYears,String DefaultTerminMonths, String DrawPeriodRepaymentPeriod,
			String DrawPeriod, String MinimumDrawPeriodYears, String MinimumDrawPeriodMonths, String MaximumDrawPeriodYears, 
			String MaximumDrawPeriodMonths, String DefaultDrawPeriodYears, String DefaultDrawPeriodMonths, String RepaymentPeriod, 
			String MinimumRepaymentPeriodYears, String MinimumRepaymentPeriodMonths, String MaximumRepaymentPeriodYears, String MaximumRepaymentPeriodMonths, 
			String DefaultRepaymentYears, String DefaultRepaymentPeriodMonths, String AllowedProductGroups, String AllowedProductGroups2, 
			String CreditPolicy, String TargetUnit, String CreditPolicy2, String RegulatoryRequirementIndicators, 
			String MortgagorLoanOriginatorInformationApplicable, String GovernmentMonitoringInformationApplicable, String CRAAddressisApplicable, String HardshipPolicy, 
			String TargetUnit2, String HardshipRelief, String RegulatoryRequirementQuestionnaireLinkage, String QuestionSetID, 
			String Description2) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(ProductGroupCode, "Start verification of PM010 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdcurrency = "(//label[text()='Currency']/../following-sibling::td//input[@type='checkbox'])[2]";
		String fdMinTermYr = "(//label[.='Minimum Term']/../following-sibling::td//span)[2]";
		String fdMinTermMonth = "(//label[.='Minimum Term']/../following-sibling::td//span)[4]";
		String fdMaxTermYr = "(//label[.='Maximum Term']/../following-sibling::td//span)[2]";
		String fdMaxTermMonth = "(//label[.='Maximum Term']/../following-sibling::td//span)[4]";
		String fdDefaultTermYr = "(//label[.='Default Term']/../following-sibling::td//span)[2]";
		String fdDefaultTermMonth = "(//label[.='Default Term']/../following-sibling::td//span)[4]";
		String fdRow1Data =	"(//th[.='__LABEL__']/../../../../.././/span/span/span)[1]";
		String fdRow2Data =	"(//th[.='__LABEL__']/../../../../.././/span/span/span)[2]";
		String fdRow3Data =	"(//th[.='__LABEL__']/../../../../.././/span/span/span)[3]";
		
		
		String currencyPMScreen = "//label[text()='Currency']/../following-sibling::td//input[@type='checkbox']/../..//label[.='__DATA__']";
		String fdlblGenericFieldL2 = "//label[.='__LABEL__']/../following-sibling::td//div/div";
		// *************PAGE METHODS********************		
		
		basepage.readyPMAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Product Group Code",ProductGroupCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Group Code",ProductGroupCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Description",Description);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Linkage Type",LinkageType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Group Type",GroupType);
	
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Type",ProductType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Origination Workflow Behavior",OriginationWorkflowBehaviour);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Is PG For Office Account?", ISPGForOfficeAccount);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Is PG For Investment?", IsPGforInvestmentType);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Is External", IsExternal);
		
		basepage.verifyElementPresent(true,currencyPMScreen,Currency);
		
		//basepage.verifyEquals(true,fdcurrency);
		
		basepage.verifyEquals(true,fdlblGenericFieldL2, "innerText","Fast Refinance Applicable",FastRefinanceApplicable);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Maximum Permissible LVR For Manual Allocation",MaximumPermissibleLVRForManualAllocation);
		
		basepage.verifyEquals(true,fdlblGenericFieldL2, "innerText","Settlement Required",SettlementRequired);
	
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Multiple Offers Allowed in Single Application", MultipleOffersallowedinasingleApplication);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3divtxt"), "innerText","Co-Signer Applicable",CoSignorApplicable);
		
		basepage.verifyEquals(true, fdMinTermYr,"innerText",MinimumTermYearsinYears);
		basepage.verifyEquals(true, fdMinTermMonth,"innerText",MinimumTermYearsinMonths);
		
		basepage.verifyEquals(true, fdMaxTermYr,"innerText",MaximumTerminYears);
		basepage.verifyEquals(true, fdMaxTermMonth,"innerText",MaximumTerminMonths);
		
		basepage.verifyEquals(true,fdDefaultTermYr,"innerText",DefaultTerminYears);
		basepage.verifyEquals(true, fdDefaultTermMonth,"innerText",DefaultTerminMonths);
		
		basepage.verifyEquals(true,fdRow1Data,"innerText","Target Unit",TargetUnit);
		basepage.verifyEquals(true,fdRow2Data,"innerText","Credit Policy",CreditPolicy2);
		
		basepage.verifyEquals(true,fdRow3Data,"innerText","Target Unit", TargetUnit2);
		basepage.verifyEquals(true,fdRow2Data,"innerText","Hardship Policy",HardshipRelief);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
