package configList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class AS009Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AS009Test.class);
	
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
			homePage.launchBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("AS009");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of AS009 screen")
	public void AS009(Method method, String LedgerCode, String LedgerAccountDescription, String ProductLedgerDetails, String LedgerDetails, 
			String ProductLedgerLevel, String AverageBalanceRequired, String ProductLedgerCategory, String PositioningRequired, 
			String ProductLedgerType, String ProductLedgerSubtype, String ParentLedgerCode, String ParentLedgerAccountDescription, 
			String UltimateParentLedgerAccountCode, String Restrictions, String Blocked, String BackPeriodEntryAllowed, 
			String PostingRestrictions, String LedgerClassification, String Revaluation, String RevaluationRequired, 
			String RevaluationSplitRequired, String Reconciliation, String ReconciliationType, String ReconciliationIncrement, 
			String MultiRecordOffsetAllowed, String YearEndProfitandLossAccounts, String BranchRuleId, String CurrencyRuleId, 
			String ProfitLedgerAccountCode, String ProfitLedgerAccountDescription, String LossLedgerAccountCode, String LossLedgerAccountDescription, 
			String PositionDetails, String CurrencyPositionDetails, String CurrencyCode, String PositionLedgerAccountCode, 
			String PositionEquivalentLedgerAccountCode, String HierarchyDetails, String PLlinkedwithParentPLofCurrentPL, 
			String LedgerCode2, String LedgerDescription, String ChildLedgerDetails, String LedgerCode3, String LedgerDescription3
) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(LedgerCode, "Start verification of AS009 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		String xpathsearch = "//span[.='Search']";
		String xpathReset = "//span[.='Reset']";
		String tableExists = "//span[contains(text(),'Ledger Code')]/ancestor::div[2]/following-sibling::div[1]//table//tr[1]/td[1]/span";
		String fieldsPresenceCheck = "//label[.='Product Ledger Subtype']";
		String xpathinputFieldL1 = "//label[.='__LABEL__']/../following-sibling::td//span/input";
		String xpathselectFieldL1 = "//label[.='__LABEL__']/../following-sibling::td//span/select";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("cancelConfig"));
		basepage.click(true, xpathReset);
		basepage.enter(true,xpathinputFieldL1,"Ledger Code", LedgerCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		//multi entry
		basepage.selectFirstRow4(locatorProp.getProperty("closeSearchBox"),"Ledger Code", LedgerCode);
		
		
		basepage.selectByLabel(true,xpathselectFieldL1,"Product Ledger Level", ProductLedgerLevel);
		basepage.selectByLabel(true,xpathselectFieldL1,"Product Ledger Category", ProductLedgerCategory);
		basepage.selectByLabel(true,xpathselectFieldL1,"Product Ledger Type", ProductLedgerType);
		basepage.click(true, xpathsearch);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(tableExists)));
		Actions actions = new Actions(driver);

		WebElement tableRow = driver.findElement(By.xpath(tableExists));
		actions.doubleClick(tableRow).perform();
		actions.perform();
		//driver.findElement(By.xpath(tableExists)).submit();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(fieldsPresenceCheck)));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Code", LedgerCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Account Description", LedgerAccountDescription);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2divcontains"), "innerText","Product Ledger Level", ProductLedgerLevel);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2LevelContains"), "Average Balance Required", AverageBalanceRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Product Ledger Category", ProductLedgerCategory);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2LevelContains"), "Positioning Required", PositioningRequired);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2divcontains"), "innerText","Product Ledger Type", ProductLedgerType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3contains"), "innerText","Product Ledger Subtype", ProductLedgerSubtype);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3contains"), "innerText","Parent Ledger Code", ParentLedgerCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3contains"), "innerText","Parent Ledger Account Description", ParentLedgerAccountDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3contains"), "innerText","Ultimate Parent Ledger Account Code", UltimateParentLedgerAccountCode);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2LevelContains"),"Blocked", Blocked);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2LevelContains"), "Back Period Entry Allowed", BackPeriodEntryAllowed);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3contains"), "innerText","Posting Restriction", PostingRestrictions);
		/*
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Revaluation Required", RevaluationRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Revaluation Split Required", RevaluationSplitRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Reconciliation", Reconciliation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Reconciliation Type", ReconciliationType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Reconciliation Increment", ReconciliationIncrement);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Multi Record Offset Allowed", MultiRecordOffsetAllowed);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Year End Profit and Loss Accounts", YearEndProfitandLossAccounts);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Branch Rule Id", BranchRuleId);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Currency Rule Id", CurrencyRuleId);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Profit Ledger Account Code", ProfitLedgerAccountCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Profit Ledger Account Description", ProfitLedgerAccountDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Loss Ledger Account Code", LossLedgerAccountCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Loss Ledger Account Description", LossLedgerAccountDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Position Details", PositionDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Currency Position Details", CurrencyPositionDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Position Ledger Account Code", PositionLedgerAccountCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Position Equivalent Ledger Account Code", PositionEquivalentLedgerAccountCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Hierarchy Details", HierarchyDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","PL's linked with Parent PL of Current PL", PLlinkedwithParentPLofCurrentPL);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Code", LedgerCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Description", LedgerDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Child Ledger Details", ChildLedgerDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Code", LedgerCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2contains"), "innerText","Ledger Description", LedgerDescription);


		basepage.verifyElementPresent(true,verifyElementWithRadio , ApplicabilityLevel);
		
	*/
		basepage.click(false,locatorProp.getProperty("cancelConfig"));
		
		}

}
