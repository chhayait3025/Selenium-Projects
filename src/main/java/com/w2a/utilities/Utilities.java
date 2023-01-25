package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.basepage.BasePage;

public class Utilities extends BasePage {
	
	public static String screenshotPath;
	public static String screenshotName;
	
	
	public static void captureScreenshot() throws IOException {
		
		TakesScreenshot src = ((TakesScreenshot)driver);
		
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotName = d.toString().replace(":","_").replace(" ","_")+".jpg";
		
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//target//surefire-reports//html//"+screenshotName));
	}
	
	@DataProvider(name="dp")
	public Object[][] getdata(Method m){
		
		String SheetName= m.getName();
		
		int rows = excel.getRowCount(SheetName);
		int cols = excel.getColumnCount(SheetName);
		
	    Object[][] obj = new Object[rows-1][1];
	    
	    Hashtable<String,String> table = null;
	    
	    for(int rowNum=2;rowNum<= rows;rowNum++) {
	    	
	    	table = new Hashtable<String,String>();
	    	
	    	for(int colNum=0; colNum< cols;colNum++) {
	    		
	    		table.put(excel.getCellData(SheetName, colNum, 1), excel.getCellData(SheetName, colNum, rowNum));
	    		
	    		obj[rowNum-2][0]= table;
	    		
	    	}
	    }
		
		return obj;
		
		
	}
	
    public static boolean isTestRunnable(String testName,ExcelReader excel) {
		
		String sheetName = "Test-Suite";
		int rows = excel.getRowCount(sheetName);
		
		for(int rNum = 0;rNum<=rows ;rNum++) {
			
			String testcase = excel.getCellData(sheetName, "TCID", rNum);
			
		   if(testcase.equalsIgnoreCase(testName)) {
			   
			   String runMode = excel.getCellData(sheetName, "RunMode", rNum);
			   
			   if(runMode.equalsIgnoreCase("Y")) {
				   return true;
			   }
			   else {
				   return false;
			   }
			   
		   } 
		     }
		return false;
		   }

}
