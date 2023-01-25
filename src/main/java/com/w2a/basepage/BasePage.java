package com.w2a.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.Utilities;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("testLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//excel//testdata.xlsx");
	public ExtentReports rep = ExtentManager.getInstance();
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static CRMTopMenu topmenu;
	
	
	public BasePage() {	
		
		if (driver == null) {
	
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "//src//test//resources//properties//Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		config.load(fis);
		log.debug("Config file loaded");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		fis = new FileInputStream(System.getProperty("user.dir")
									+ "//src//test//resources//properties//OR.properties");
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		OR.load(fis);
		log.debug("OR file loaded");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	if(config.getProperty("browser").equals("Firefox")) {
		
		driver = new FirefoxDriver();
		log.debug("Firefox browser launched..");
		
	}
	else if(config.getProperty("browser").equals("chrome")) {
		
		driver = new ChromeDriver();
		log.debug("Chrome browser launched..");
		
	}
		
	
	driver.get(config.getProperty("testurl"));
	log.debug("Navigated to :"+config.getProperty("testurl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	topmenu = new CRMTopMenu(driver);	
		
	}
	}
		
public static void click(String locator) {
	
	if(locator.endsWith("_CSS")) {
	    driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	
	}else if(locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		
	}else if(locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
	}
	//test.log(LogStatus.INFO, "Clicking on:"+ locator);
	
	
}

public static void type(String locator,String value) {
	
	if(locator.endsWith("_CSS")) {
	    driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	}
	  else if(locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	}
		else if(locator.endsWith("_ID")) {
	    driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}	
	//test.log(LogStatus.INFO, "Typing in:"+ locator+" entering value as:"+ value);
}

static WebElement dropdown;

public void select(String locator,String value) {
	
	if(locator.endsWith("_CSS")) {
	    dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
	}
	  else if(locator.endsWith("_XPATH")) {
		  dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
	}
		else if(locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}	
	
	Select select = new Select(dropdown);
	select.selectByVisibleText(value);
	//test.log(LogStatus.INFO, "Select from dropdown:"+ locator+" value as:"+ value);
}



    public static void verifyEquals(String expected,String actual) throws IOException {
	
	   try {
		   Assert.assertEquals(expected,actual);
	   }
	
    catch(Throwable t) {
    	
    	Utilities.captureScreenshot();
    
    //Extent report
    test.log(LogStatus.FAIL, "Verification failed with exception:"+ t.getMessage());
	test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
	
	//ReportNG
	Reporter.log("<br>"+"Verification failed:"+t.getMessage()+"<br>");
	Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");

    	
    }
	
	
}




public static void tearDown() {
	
	if(driver!=null) {
		driver.quit();
	}
	
	log.debug("Execution completed");
	
	
}


	}
		
	