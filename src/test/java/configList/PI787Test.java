package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI787Test extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(PI787Test.class);
	
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
			homePage.navigatetoFastPath("PI787");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI787 screen")
	public void PI787(Method method,String PartyType, String ID, String Name, String Description, String Priority, String EmploymentLinkage, 
			String EntitySelfEmployed, String EntitySalaried, String EntityOthers, String NewEntity, String EntityOthers2, 
			String FinancialStatementTemplateLinkages, String StatementTemplateID, String StatementName, String StatementType, String PreviousYearsTotal, 
			String PreviousYearsMandatory, String ProjectedYearsTotal, String ProjectedYearsMandatory, String Sections, String PersonalAssets, 
			String PersonalLiabilities, String PersonalIncomes, String PersonalExpenses, String CurrentPosition, String Assets, String Liabilities, 
			String FinancialParametersLinks, String Asset, String Liability, String Income, String Expense)throws InterruptedException {

		
		// ExtentReports Description
		ExtentTestManager.startTest(ID, "Start verification of PI787 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);
		String fdTable1 = "//span[.='__LABEL__']//following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']";
		String fdTable2 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable3 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/following::td[1]//img[@alt='__LABEL__']/following::td[1]//img[@alt='__LABEL__']";
		
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Party Type",PartyType);
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Id",ID);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		//basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Nature",Nature);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Name", Name);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText", "Description", Description);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL3"), "Priority", Priority);
		basepage.verifyTableRow(true,fdTable1,EmploymentLinkage);
		basepage.verifyTableRow(true,fdTable2,FinancialStatementTemplateLinkages);
		basepage.verifyTableRow(true,fdTable3,PersonalAssets);
		basepage.verifyTableRow(true,fdTable3,PersonalLiabilities);
		basepage.verifyTableRow(true,fdTable3,PersonalIncomes);
		basepage.verifyTableRow(true,fdTable3,PersonalExpenses);
		basepage.verifyTableRow(true,fdTable3,Assets);
		basepage.verifyTableRow(true,fdTable3,Liabilities);
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
	}
}
