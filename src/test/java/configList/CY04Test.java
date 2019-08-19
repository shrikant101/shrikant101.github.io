package configList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class CY04Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CY04Test.class);
	
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
			homePage.navigatetoFastPath("CY04");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CY04 screen")
	public void CY04(Method method, String BankCode, String BankName, String BranchCode, String BranchName, 
			String CurrencyCode, String CurrencyDescription, String SpotDays, String PaymentMessageDays, 
			String ReceiveMessageDays) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(BranchCode, "Start verification of CY04 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		String xpathassetClassificationTable = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String verifyElementWithRadio = "//label[.='__LABEL__']/../span/input[@value=0]";
		// *************PAGE METHODS********************

		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Branch Code", BranchCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		//multi entry
		basepage.selectFirstRow(locatorProp.getProperty("closeSearchBox"),"Branch Code", BranchCode);
		
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Currency Code", CurrencyCode);
		basepage.clickusingjs(true,"("+locatorProp.getProperty("searchLink")+")[1]",CurrencyCode);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Code", BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Bank Name", BankName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Branch Code", BranchCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Branch Name", BranchName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Description", CurrencyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Spot Days", SpotDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payment Message Days", PaymentMessageDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Receive Message Days", ReceiveMessageDays);

		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
