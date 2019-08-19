package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class LCM07Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(LCM07Test.class);
	
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
			homePage.navigatetoFastPath("LCM07");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of LCM07 screen")
	public void LCM07(Method method, String CollateralType, String CollateralCategory, String ChargeApplicable, 
			String ValuationRequired, String TitleSearchRequired, String TitleSearchValidityDays, String DefaultBankHaircutValue, 
			String CategorizationHaircutValue, String InternationalAddressRequired, String Insurable, 
			String AllowModificationofHaircutValue, String HaircutVarianceRange, String ApplicableFinancialStatements, 
			String ChargeDetails, String NatureofExclusiveCharge, String ChargeRegistration, String StampingRequired, 
			String AVMEnabled, String CollateralExpiryNoticeDays, String LVRCalculationBasis, String LowRiskCollateral, 
			String DocumentsMandatoryforFulfillment, String ChargeType, String ChargeType2, String DefaultFlag, 
			String RenewalFrequencyUnit, String RenewalFrequencyValue, String FilingLeadDays,
			String ValuationDetails,String ValuationFrequency, String BasistoUpdateAssessedValue, String MinimumNumberofValuationsRule, 
			String ValuationMode, String ValuationEscalation, String ExternalValuationVerificationinOrigination, 
			String ValuationType, String ValuationType2, String ValuationValidityDays
)
			throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(CollateralCategory, "Start verification of LCM07 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String fdTable = "//table[.='Charge Type']/../div//span/span[.='__LABEL__']/../../../td//input[@aria-checked='__LABEL__']";
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("selectFieldL1"),"Collateral Type",locatorProp.getProperty("clearConfig"));
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Collateral Type",CollateralType);
		basepage.selectByLabel(true,locatorProp.getProperty("selectFieldL1"),"Collateral Category",CollateralCategory);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"),"innerText", "Collateral Type", CollateralType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Collateral Category", CollateralCategory);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Charge Applicable", ChargeApplicable);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Valuation Required", ValuationRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Title Search Required", TitleSearchRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Title Search Validity Days", TitleSearchValidityDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Default Bank Haircut Value", DefaultBankHaircutValue);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Categorisation Haircut Value", CategorizationHaircutValue);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "International Address Required", InternationalAddressRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Insurable", Insurable);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Allow Modification of Haircut Value", AllowModificationofHaircutValue);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Haircut Variance Range", HaircutVarianceRange);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Applicable Financial Statements", ApplicableFinancialStatements);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Charge Details", ChargeDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Nature of Exclusive Charge", NatureofExclusiveCharge);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Charge Registration", ChargeRegistration);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Stamping Required", StampingRequired);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","AVM Enabled", AVMEnabled);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Collateral Expiry Notice Days", CollateralExpiryNoticeDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","LVR Calculation Basis", LVRCalculationBasis);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Low Risk Collateral", LowRiskCollateral);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Documents Mandatory for Fulfillment", DocumentsMandatoryforFulfillment);
		basepage.verifyTableRow(true,fdTable, ChargeType2);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Renewal Frequency - Unit", RenewalFrequencyUnit);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Renewal Frequency - Value", RenewalFrequencyValue);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Filing Lead Days", FilingLeadDays);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Valuation Details", ValuationDetails);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Valuation Frequency", ValuationFrequency);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"), "innerText","Basis to Update Assessed Value ", BasistoUpdateAssessedValue);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Minimum Number of Valuations Rule", MinimumNumberofValuationsRule);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2divtxt"), "innerText","Valuation Mode", ValuationMode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Valuation Escalation (In Days)", ValuationEscalation);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "External Valuation Verification", ExternalValuationVerificationinOrigination);
		basepage.verifyTableRow(true,fdTable1,ValuationType);
		
		basepage.click(true,locatorProp.getProperty("clearConfig"));
		
		}

}
