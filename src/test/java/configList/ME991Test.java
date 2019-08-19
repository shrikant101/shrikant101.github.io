package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class ME991Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(ME991Test.class);
	
	// *************WEB ELEMENTS********************** }
	//
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
			homePage.navigatetoFastPath("ME991");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of ME991 screen")
	public void ME991(Method method, String MarketEntityCode, String MarketEntityName, String BankCode, String BankName, 
			String BusinessUnit, String BusinessUnitCode, String BusinessUnitName, String MultiEntityAlertsConfiguration, 
			String MultiEntityLevel, String DestinationType, String AlertType, String FromAddress) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(MarketEntityCode, "Start verification of ME991 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String xpathinputFieldL1 = "(//label[.='__LABEL__']/../../td//input)[2]";
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable2 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String popupSort = "label[.='__LABEL__']/../input";
		// *************PAGE METHODS********************		
		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,xpathinputFieldL1,"Market Entity Code", MarketEntityCode);
		basepage.clickusingjs(false,locatorProp.getProperty("searchLink"));
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Market Entity Code", MarketEntityCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Market Entity Name", MarketEntityName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Bank Code", BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Bank Name", BankName);
		
		basepage.verifyTableRow(true,fdTable1,BusinessUnitCode + ":" + BusinessUnitName);
		basepage.verifyTableRow(true,fdTable1,MultiEntityLevel + ":" + DestinationType  + ":" + AlertType + ":" + FromAddress);
		LOGGER.info("Current heap size is : " + Runtime.getRuntime().totalMemory() + " and available is : " + Runtime.getRuntime().freeMemory());
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
