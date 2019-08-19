package com.ofss.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import pages.BasePage;
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
	public static DataFormatter formatter = new DataFormatter();
	public static Properties locatorProp;
	public static Properties browserProp;
	public static String scenarioName;
	public File locatorFile;
	public File browserFile;
	public String currentDriver;
	private static String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
	private static boolean isUnix = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 || OS.indexOf("sunos") >= 0);
    public WebDriver getDriver() {
        return driver;
    }
    
    @BeforeClass
    public void setup () {
    	
        //Create a Chrome driver. All test classes use this.
    	if(isUnix) {
    		LOGGER.info("Running unix instance of webdriver");
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator  +"Resources"+ File.separator + "chromedriver");
    	}else {
    		LOGGER.info("Running windows instance of webdriver");
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator  +"Resources"+ File.separator + "chromedriver.exe");
    	}
    	
    	Proxy proxy = new Proxy();
    	//proxy.setProxyType(ProxyType.AUTODETECT);
    	proxy.setProxyType(ProxyType.DIRECT);
    	 try {
	    	locatorProp = new Properties();
	    	browserProp = new Properties();
	  
	        locatorFile = new File(System.getProperty("user.dir") + File.separator + "Settings" + File.separator +"locator.properties");
	        browserFile = new File(System.getProperty("user.dir") + File.separator + "Settings" + File.separator +"browser.properties");
			locatorProp.load(new FileInputStream(locatorFile));
			browserProp.load(new FileInputStream(browserFile));
			
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.fatal("Error loading properties file");
			System.exit(0);
		}
    	try {
    		currentDriver = browserProp.getProperty("browser").toUpperCase();
    		switch(currentDriver)
    		{
    		case "CHROME":
    			driver = new ChromeDriver();
    			break;
    		
    		case "REMOTECHROME":
    			driver = new RemoteWebDriver(new URL(browserProp.getProperty("gridURL")),DesiredCapabilities.chrome());
    			break;
    		default:
    			LOGGER.fatal("Invalid browser option specified, Possible options are CHROME and REMOTECHROME in locator.properties");
    			System.exit(-1);
    		}
		} catch (Exception e1) {	//MalformedURLException for remotedriver
			// TODO Auto-generated catch block
			LOGGER.fatal("Unable to launch browser. Please check property : '" + browserProp.getProperty("browser") + "' in locator.properties");
			System.exit(-1);
		}
        driver.manage().window().maximize();
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);
        
        
        //Maximize Window
        //driver.manage().window().maximize();
    }

    @AfterClass
	public void teardown() throws InterruptedException {
		// MANDATORY STEPS FOR GRID TO UNBLOCK DRIVER INSTANCES
		try {
			driver.findElement(By.xpath("//span/span[text()='x']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
		} finally {
			WebElement element = driver.findElement(By.xpath("//a[contains(@id,'cmdToolBtnCommon::popEl')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			Thread.sleep(2000);
			WebElement element2 = driver
					.findElement(By.xpath("//div[contains(@id,'menuCommonGlb::ScrollBox')]//td[.='Log Out']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

			Thread.sleep(2000);
			driver.quit();
		}
	}


	@DataProvider(name = "superman")
	public static Object[][] ReadVariant(Method method) {

		FileInputStream fileInputStream;
		try {
			scenarioName = method.getName();
			
			String file_location = System.getProperty("user.dir") + "/InputData/"+scenarioName+".xlsx";
			fileInputStream = new FileInputStream(file_location);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // get my workbook
		worksheet = workbook.getSheetAt(0);// get my sheet from workbook
		XSSFRow Row = worksheet.getRow(0); // get my Row which start from 0
		
		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum
		LOGGER.info("Input data sheet is  " +worksheet.getSheetName() + " from  " + scenarioName + " with " + RowNum + " rows and " + ColNum + " columns.");
		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			XSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
					}
				}
			}
		}

		return Data;
	}

}
