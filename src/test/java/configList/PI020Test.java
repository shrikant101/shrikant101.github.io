package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI020Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PI020Test.class);
	
	// *************WEB ELEMENTS********************** }
	//
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
			homePage.navigatetoFastPath("PI020");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI020 screen")
	public void PI020(Method method, String RelationshipCode, String RelationshipName, String EffectiveDate, String ConstitutionRelationshipDetails, 
			String RelationshipType, String RelationshipClass, String Inactive, String AddApplicableConstitution, 
			String ParentPartyType, String ApplicableConstitution, String Action, String DirectRelationDetail, 
			String CaptureNewDirectRelation, String DirectRelationCode, String DirectRelationName, String InverseRelationDetail, 
			String CaptureNewInverseRelation, String InverseRelationCode, String InverseRelationName, String CaptureNewInverseRelation2, 
			String InverseRelationCode2, String InverseRelationName2, String RelationshipFeatures, String ShareCollateral, 
			String ShareFinancials, String ShareExposure, String AllowopeningSubsequentAccounts, String PartyAttributes, 
			String AllowedPartyTypeforRelationshipClass, String FacilityAttributes, String StatementAllowed, String ATMPOS,
			String AlertsAllowed, String AccessAttributes, String Issignatoryinbranch, String InternetBankingAccess, 
			String MobileBankingAccess, String PhoneBankingAccess, String MandatedAuthorityLinkage, String MandatedAuthorityLinkage2,
			String DefaultValue, String Actions) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(RelationshipName, "Start verification of PI020 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		String verifyElementWithRadio = "//span[.='__LABEL__']/../following-sibling::td/span//input";
		
		// *************PAGE METHODS********************		
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Relationship Code", RelationshipCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		
		//multi entry
		basepage.sortAndSelectFirstRow(locatorProp.getProperty("closeSearchBox"),"Effective Date",RelationshipCode);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Relationship Code", RelationshipCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Relationship Name", RelationshipName);
		
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Relationship Type", RelationshipType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Relationship Class", RelationshipClass);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Inactive", Inactive);
			
		basepage.verifyTableRow(true,fdTable1,AddApplicableConstitution);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Capture New Direct Relation", CaptureNewDirectRelation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Direct Relation Code", DirectRelationCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Direct Relation Name", DirectRelationName);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Capture New Inverse Relation", CaptureNewInverseRelation);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Inverse Relation Code", InverseRelationCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Inverse Relation Name", InverseRelationName);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Share Collateral", ShareCollateral);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Share Financials", ShareFinancials);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Share Exposure", ShareExposure);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allow Opening Subsequent Accounts", AllowopeningSubsequentAccounts);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Allowed Party Type for Relationship Class", AllowedPartyTypeforRelationshipClass);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Statement Allowed", StatementAllowed);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"ATM/POS", ATMPOS);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Alerts Allowed", AlertsAllowed);

		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Is Signatory in Branch", Issignatoryinbranch);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Internet Banking Access", InternetBankingAccess);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Mobile Banking Access", MobileBankingAccess);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Phone Banking Access", PhoneBankingAccess);
		
		if (DefaultValue.equalsIgnoreCase("Checked")) {
			basepage.verifyEquals(true,verifyElementWithRadio, "aria-checked",MandatedAuthorityLinkage2,"true");
		}else {
			basepage.verifyEquals(true,verifyElementWithRadio, "aria-checked",MandatedAuthorityLinkage2,"false");
		}
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
		
		}

}
