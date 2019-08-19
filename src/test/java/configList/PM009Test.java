package configList;


import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ofss.runner.BaseTest;

import pages.BasePage;
import pages.HomePage;
import utils.ExtentReports.ExtentTestManager;

public class PM009Test extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(PM009Test.class);

	String clearConfig = "(//a/img[contains(@src,'clear')])[1]";
	String searchLink = "//a[contains(@title,'Search: ')]";
	String txtDocumentType = "//label[.='__LABEL__']/../following-sibling::td/span/input";

	@Test(priority = 0, description = "Login to OBP and navigate to FastPath")
	public void loginOBP(Method method) throws InterruptedException {
		// ExtentReports Description

		ExtentTestManager.startTest(method.getName(), "Login to OBP and navigate to FastPath");
		try {
			// *************PAGE INSTANTIATIONS*************
			HomePage homePage = new HomePage(driver, wait);
			BasePage basepage = new BasePage(driver, wait);
			
			// *************PAGE ELEMENTS********************
		
			// *************PAGE METHODS********************
			// Open OBP HomePage -- > login to OBP -- > nagivate fastpath			
			homePage.launchPMBrowser();
			homePage.goToLoginPage();
			homePage.navigatetoFastPath("PM009");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "superman", priority = 1, description = "Start verification of PM009 screen")
	public void PM009(Method method,String PolicyCode, String PolicyDescription, String LinkageType, String GroupType, String ProductType,
			String OriginationWorkflowBehaviour, String LowDocument, String CollateralRequired, String IsGovernmentGrantapplicable, 
			String FacilityCategoryCode, String RequireGeneralInsurance, String LVRVariationTolerancePercentage, String CoveredbyConsumerProtection, 
			String NumberOfDaysForFirstDisbursement, String NumberOfDaysForAccountOpening, String NumberOfDaysForFirstDisbursementAccountOpening, 
			String AllowMoratoriumInterest, String AllowedCollateralTypesAndCategories, String CreditDecisionProductGroup, String BehaviouralDecisionProductGroup, String DebtServicingPeriodbasedon,
			String NominalTenor, String DebtServicingCalculationMethod, String PercentageofPrincipalAmount, String AdditionalAllowanceValidityPeriod, 
			String FixedAmountCreditCushion, String PercentageCreditCushion, String MaximumCalculatedCreditCushionAmount, String DebtServiceNominalRate, 
			String RequestedLimitRequired, String InterestSensitivityThresholdRate, String InterestSensitivityBufferRate, String LRMApplicable, 
			String CCIApplicable, String InterestRefreshApplicable, String CustomerLRMLVRThresholdPercentage, String SpecialCollateralLRMLVRThresholdPercentage, 
			String EmployeeLRMLVRThresholdPercentage, String LowDocLRMLVRThresholdPercentage, String CrossSellInsurance, 
			String TypeofInsuranceallowedforCrossSell) throws InterruptedException {

		// ExtentReports Description
		ExtentTestManager.startTest(PolicyCode, "Start verification of PM009 screen");

		// *************PAGE INSTANTIATIONS*************
		BasePage basepage = new BasePage(driver, wait);

		// *************PAGE ELEMENTS********************	
		String L2Element = "//label[.='__LABEL__']/ancestor::tbody//span[.='__DATA__']";
		String fdTable1 = "//span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']/../following-sibling::td/span[.='__LABEL__']";
		// *************PAGE METHODS********************		
		//basepage.clearScreen();
		basepage.readyAUT(false,locatorProp.getProperty("searchLink"),locatorProp.getProperty("clearConfig"));

		basepage.enter(true,txtDocumentType,"Policy Code",PolicyCode);
		basepage.clickusingjs(true,searchLink);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Policy Description",PolicyDescription);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Linkage Type",LinkageType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Group Type",GroupType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Linkage Type",LinkageType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Product Type",ProductType);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Origination Workflow Behavior",OriginationWorkflowBehaviour);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"Low Document",LowDocument);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"Collateral Required",CollateralRequired);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Is FHOG Applicable", IsGovernmentGrantapplicable);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Facility Category Code",FacilityCategoryCode);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"), "Require General Insurance", RequireGeneralInsurance);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","LVR Variation Tolerance Percentage", LVRVariationTolerancePercentage);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Covered by Consumer Protection", CoveredbyConsumerProtection);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number Of Days For First Disbursement",NumberOfDaysForFirstDisbursement);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number Of Days For Account Opening",NumberOfDaysForAccountOpening);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Number Of Days For First Disbursement/Account Opening",NumberOfDaysForFirstDisbursementAccountOpening);
		basepage.verifyCheckBox(true,locatorProp.getProperty("chkField2Level"),"Allow Moratorium Interest",AllowMoratoriumInterest);
		
		basepage.verifyTableRow(true,fdTable1,AllowedCollateralTypesAndCategories);
		
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Credit Decision Product Group",CreditDecisionProductGroup);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Behavioral Decision Product Group",BehaviouralDecisionProductGroup);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Debt Servicing Calculation Method",DebtServicingCalculationMethod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Additional Allowance Validity Period (in Days)",AdditionalAllowanceValidityPeriod);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Interest Sensitivity Threshold Rate",InterestSensitivityThresholdRate);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Interest Sensitivity Buffer Rate",InterestSensitivityBufferRate);
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"LRM Applicable",LRMApplicable);
		
		basepage.verifyElementPresent(true,locatorProp.getProperty("lblGenericFieldL2div"),"CCI Applicable",CCIApplicable);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Customer LRM LVR Threshold Percentage ",CustomerLRMLVRThresholdPercentage);

		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Special Collateral LRM LVR Threshold Percentage ",SpecialCollateralLRMLVRThresholdPercentage);
		basepage.verifyEquals(true,locatorProp.getProperty("lblGenericFieldL2txt"), "innerText","Employee LRM LVR Threshold Percentage",EmployeeLRMLVRThresholdPercentage);
		

		basepage.click(false,clearConfig);

	}

}
