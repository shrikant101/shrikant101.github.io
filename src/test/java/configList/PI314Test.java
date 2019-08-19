package configList;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PI314Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PI314Test.class);
	
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
			homePage.navigatetoFastPath("PI314");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PI314 screen")
	public void PI314(Method method,String PolicyCode, String PolicyName, String PolicyDescription, String BankCode, String BankName, String Parameters, 
			String ResidentStability, String MinorMajorTransition, String LegalMajorAge, String AddonCreditCardHolderMinimumAge, String OperationalMajor, 
			String OperationalMajorAge, String EmploymentStability, String FinancialYearStartDay, String FinancialYearEndDay, String FinancialYearStartMonth, 
			String FinancialYearEndMonth, String GroupRelationshipManager, String EnableMasking, String EnableTokenization, String EnableConsentforDataCapture, 
			String EnableConsentdefaulting, String Accesschanneloptinenabledformembers, String RestrictedMinorMaintenance, String MinorAgeRange, 
			String AccessTypes, String RelationRequiredforChequeBook, String AffiliateRelationshipCode, String AffiliateRelationshipName, 
			String UnrestrictedMinorMaintenance, String UnrestrictedMinorAgeRange, String AccessTypes2, String RelationRequiredforChequeBook2, 
			String AffiliateRelationshipCode2, String AffiliateRelationshipName2, String DueDiligence, String DueDiligencePreference, 
			String DueDiligenceDocumentsRequired, String DisplayIdentificationPanelonInitiate, String DueDiligence2, String IdentityVerification, 
			String ExpiryApplicable, String ValidityPeriod, String LeadDaysforExpiryTracking, String Action, String RuleMaintenance, 
			String BrokerIntroducerManagerAssignmentRule, String DueDiligenceRule, String PartyRelationshipManager) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PI314 screen");
	
		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		
		String fdTable1 = "//td/span[.='__LABEL__']/../../..//span[text()='__LABEL__']/ancestor::td/..//span/span/span/span/img[@alt='__LABEL__']";
		String chkfield = "(//label[text()='__LABEL__']/preceding-sibling::span//img[@alt='__DATA__'])[1]";
		String partyName = "//label[.='Policy Name']/../following-sibling::td//span/span[.='Party']";
		// *************PAGE METHODS********************		

		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));
		basepage.enter(true,locatorProp.getProperty("inputFieldL1"),"Policy Code",PolicyCode);
		basepage.clickusingjs(true,locatorProp.getProperty("searchLink"));
		//basepage.tab(xpTabLink);

		//basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Role ID",RoleID);	--skipped as span and input both come
		basepage.click(false,partyName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Policy Name",PolicyName);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Policy Description",PolicyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Bank Code",BankCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Bank Name",BankName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Resident Stability (In Months)",ResidentStability);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Minor-Major Transition",MinorMajorTransition);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Legal Major Age",LegalMajorAge);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Add-on Credit Card Holder Minimum Age",AddonCreditCardHolderMinimumAge);
		
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Operational Major",OperationalMajor);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Operational Major Age",OperationalMajorAge);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Employment Stability (In Months)",EmploymentStability);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Financial Year Start Day",FinancialYearStartDay);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Financial Year End Day",FinancialYearEndDay);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Financial Year Start Month",FinancialYearStartMonth);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Financial Year End Month",FinancialYearEndMonth);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Group Relationship Manager",GroupRelationshipManager);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Enable Masking",EnableMasking);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Enable Tokenization",EnableTokenization);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Enable Consent for Data Capture",EnableConsentforDataCapture);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Enable Consent Defaulting",EnableConsentdefaulting);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level2"), "Access channel opt-in enabled for members",Accesschanneloptinenabledformembers);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Minor Age Range",MinorAgeRange);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Access Types",AccessTypes);
		
		basepage.verifyCheckBox(true,chkfield, "Relation Required for Cheque Book",RelationRequiredforChequeBook);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Affiliate Relationship Code",AffiliateRelationshipCode);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Affiliate Relationship Name",AffiliateRelationshipName);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Due Diligence Preference",DueDiligencePreference);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Due Diligence Documents Required",DueDiligenceDocumentsRequired);
		
		basepage.verifyTableRow(true,fdTable1,DisplayIdentificationPanelonInitiate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Broker/Introducer Manager Assignment Rule",BrokerIntroducerManagerAssignmentRule);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Due Diligence Rule",DueDiligenceRule);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL3txt"),"innerText", "Party Relationship Manager",PartyRelationshipManager);
		
		basepage.click(false,locatorProp.getProperty("clearConfig"));
	}

}
