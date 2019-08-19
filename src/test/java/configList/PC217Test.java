package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PC217Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PC217Test.class);

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
			homePage.navigatetoFastPath("PC217");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PC217 screen")
	public void PC217(Method method, String CategoryID, String TrxCategoryDescription, String TransactionType,
			String CollectionType, String TransferType, String RecallCategoryID, String RejectCategoryID,
			String ReverseCategoryID, String NameandAddressRequired, String CharacterSet, String MaximumNameLength,
			String MaximumAddressLength, String MandateValidationRequired, String CounterpartyBank,
			String ActivationDate, String CounterpartyAccount, String InstrumentNumber, String CustomerAccount,
			String Amount, String CounterpartyName, String InstrumentDate, String CustomerReferencenumber,
			String ChannelReferenceNumber, String Description, String BookTransactionTemplate,
			String InternalTransactionTemplate, String ExternalTransactionTemplate, String EndPointParticipation)
			throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(CategoryID, "Start verification of PC217 screen");

		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";

		// *************PAGE ELEMENTS********************
		//

		// *************PAGE METHODS********************
		basepage.readyAUT(false, locatorProp.getProperty("searchLink"), locatorProp.getProperty("clearConfig"));
		basepage.enter(true, locatorProp.getProperty("inputFieldL1"), "Category ID", CategoryID);
		basepage.clickusingjs(true, locatorProp.getProperty("searchLink"));

		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Description",
				TrxCategoryDescription);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Transaction Type",
				TransactionType);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Collection Type",
				CollectionType);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Transfer Type",
				TransferType);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Recall Category ID",
				RecallCategoryID);

		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Reject Category ID",
				RejectCategoryID);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Reverse Category ID",
				ReverseCategoryID);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Name and Address Required",
				NameandAddressRequired);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Character Set",
				CharacterSet);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Maximum Name Length",
				MaximumNameLength);
		basepage.verifyElementPresent(true, locatorProp.getProperty("lblGenericFieldL2"), "Maximum Address Length",
				MaximumAddressLength);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Mandate Validation Required",
				MandateValidationRequired);

		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Counterparty Bank",
				CounterpartyBank);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Activation Date", ActivationDate);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Counterparty Account",
				CounterpartyAccount);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Instrument Number",
				InstrumentNumber);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Customer Account", CustomerAccount);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Amount", Amount);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Counterparty Name",
				CounterpartyName);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Instrument Date", InstrumentDate);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Customer Reference Number",
				CustomerReferencenumber);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Channel Reference Number",
				ChannelReferenceNumber);
		basepage.verifyCheckBox(true, locatorProp.getProperty("chkField2Level2"), "Description", Description);

		basepage.verifyTableRow(true, fdTable1, BookTransactionTemplate);
		basepage.verifyTableRow(true, fdTable1, InternalTransactionTemplate);
		basepage.verifyTableRow(true, fdTable1, ExternalTransactionTemplate);
		basepage.verifyTableRow(true, fdTable1, EndPointParticipation);

		basepage.click(true, locatorProp.getProperty("clearConfig"));

	}
}
