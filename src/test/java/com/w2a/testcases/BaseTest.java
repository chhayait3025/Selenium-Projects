package com.w2a.testcases;

import org.testng.annotations.AfterSuite;

import com.w2a.basepage.BasePage;

public class BaseTest {
	
	@AfterSuite
	public void tearDown() {
		
		BasePage.tearDown();
		
		
	}

}
