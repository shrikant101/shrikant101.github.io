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

public class CY01Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CY01Test.class);
	
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
			homePage.navigatetoFastPath("CY01");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of CY01 screen")
	public void CY01(Method method, String CurrencyCode, String ISONumericCurrencyCode, String CurrencyDescription, String Locale, 
			String WorkingDaysDetails, String CountryCode, String Receivedmessagedays, String SpotDays, 
			String DecimalUnit, String PaymentMessageDays, String CalendarTypeName, String RoundingDetails, 
			String RoundingRule, String RoundingUnit, String AmountFormatMask, String AllowableForeignCurrenciesTransaction, 
			String TravellersCheque, String CountryMapping, String CountryCode2, String Description
) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(CurrencyCode, "Start verification of CY01 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************
		String xpathassetClassificationTable = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String assetClassificationTable  = CountryCode2 + ":" + Description;
		String verifyElementWithRadio = "//label[.='__LABEL__']/../span/input[@value=0]";
		// *************PAGE METHODS********************
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Currency Code", CurrencyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Code", CurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","ISO Numeric Currency Code", ISONumericCurrencyCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Currency Description", CurrencyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Locale", Locale);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Working Days Details", WorkingDaysDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Country Code", CountryCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Receive Message Days", Receivedmessagedays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Spot Days", SpotDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Decimal Unit", DecimalUnit);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Payment Message Days", PaymentMessageDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Calendar Type Name", CalendarTypeName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rounding Details", RoundingDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rounding Rule", RoundingRule);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Rounding Unit", RoundingUnit);

		basepage.verifyDisabledElementPresent(true,verifyElementWithRadio , AmountFormatMask);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Traveller's Cheque", TravellersCheque);
		basepage.verifyTableRow(true,xpathassetClassificationTable,CountryCode2);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
