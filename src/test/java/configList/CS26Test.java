package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CS26Test extends BaseTest {
private static final Logger LOGGER = Logger.getLogger(CS26Test.class);
	
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
			homePage.navigatetoFastPath("CS26");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CS26 screen")
	public void CS26(Method method, String PolicyCode, String PolicyName, String PolicyDescription, String BankCode, String BankName, 
			String CaptureTransactingPartyDetailsforCashTransactions,String AMLCashAmountThreshold, String Currency, String SelfServiceLoginPreferences,String UnprintedPeriodTermDays, String UnprintedPeriodTermMonths,
			String EnableAccountingatPayableBranch, String SCRABenefitApplicable, String BackdatedSCRABenefitPermissibleDays, 
			String BasisofDelinquencycounterforarrears, String EnablecaptureofCommission, 
			String InterfacewithExternalCommissionSystem, String BrokerIDGenerationLogic, String IntroducerIDGenerationLogic, String UnclaimedProcess, String CheckActivityinAccountsPartofDependentOffer, String UnclaimedTermDepositProcessing, 
			String CheckActivityinAccountsPartofOffset, String UnclaimedProcessingFrequency, String FirstReminderPriorDays, 
			String UnclaimedProcessingStartMonth, String SecondReminderPriordays, String ConsiderExpiryPeriod, String ExpiryperiodofManualTask, 
			String ProcessonExpiryPeriod, String GarnishmentApplicabletoProductGroups, String CurrentandSavingsAccounts, 
			String TermDeposits, String AccountOwnershipforGarnishment, String SoleOwner, String JointFormer, String JointOthers)
			throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of CS26 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String div = "//label[.='__LABEL__']/../following-sibling::td//div/div[.='__DATA__']";
		String fdDays = "//label[.='__LABEL__']/../following-sibling::td//label[.='Days']/../following-sibling::td//span/span[.='__DATA__']";
		String fdMonths = "//label[.='__LABEL__']/../following-sibling::td//label[.='Months']/../following-sibling::td//span/span[.='__DATA__']";
		// *************PAGE ELEMENTS********************	
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
			
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Policy Name", PolicyName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Code",BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name",BankName);
		
		basepage.verifyCheckBox(true,chkField2Level,"Capture Transacting Party Details for Cash Transactions",CaptureTransactingPartyDetailsforCashTransactions);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","AML Cash Amount Threshold",AMLCashAmountThreshold);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency",Currency);
			
		basepage.verifyTableRow(true,fdTable1,SelfServiceLoginPreferences);
		basepage.verifyElementPresent(true,fdDays,"Unprinted Period Term",UnprintedPeriodTermDays);
		basepage.verifyElementPresent(true,fdMonths,"Unprinted Period Term",UnprintedPeriodTermMonths);
		basepage.verifyCheckBox(true,chkField2Level,"Enable Accounting at Payable Branch",EnableAccountingatPayableBranch);
		basepage.verifyCheckBox(true,chkField2Level,"Enable capture of commission",EnablecaptureofCommission);
		basepage.verifyCheckBox(true,chkField2Level,"Interface with External Commission System",InterfacewithExternalCommissionSystem);
		basepage.verifyElementPresent(true,div,"Broker ID Generation Logic",BrokerIDGenerationLogic);
		basepage.verifyElementPresent(true,div,"Introducer ID Generation Logic",IntroducerIDGenerationLogic);
		basepage.verifyElementPresent(true,div,"Unclaimed Processing",UnclaimedProcess);
		basepage.verifyCheckBox(true,chkField2Level,"Check Activity in Accounts Part of Dependent Offer",CheckActivityinAccountsPartofDependentOffer);
		
		basepage.verifyElementPresent(true,div,"Unclaimed Term Deposit Processing",UnclaimedTermDepositProcessing);
		basepage.verifyCheckBox(true,chkField2Level,"Check Activity in Accounts Part of Offset",CheckActivityinAccountsPartofOffset);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Unclaimed Processing Frequency",UnclaimedProcessingFrequency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","First Reminder Prior Days",FirstReminderPriorDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Unclaimed Processing Start Month",UnclaimedProcessingStartMonth);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Second Reminder Prior Days",SecondReminderPriordays);
		basepage.verifyCheckBox(true,chkField2Level,"Consider Expiry Period",ConsiderExpiryPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Expiry Period of Manual Task (In Days)",ExpiryperiodofManualTask);
		basepage.verifyCheckBox(true,chkField2Level,"Process on Expiry Period",ProcessonExpiryPeriod);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField3LevelContains"),"Current and Savings Account" ,CurrentandSavingsAccounts);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField3LevelContains"),"Term Deposits" ,TermDeposits);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField3LevelContains"),"Sole Owner",SoleOwner);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField3LevelContains"),"Joint & First",JointFormer);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField3LevelContains"),"Joint & Other",JointOthers);
		
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
		}
}
