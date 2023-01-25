package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.basepage.BasePage;

public class ZohoAppPage extends BasePage{
	
	
	public CRMHomePage goToCRM() {
		
	click("crmbtn_XPATH");
	
	  return new CRMHomePage();
	}
	
	public CRMHomePage goToAccessZohoCRM() {
		
		click("accesscrmbtn_XPATH");
		
		return new CRMHomePage();
	}
	
	public void goToMail() {
	
	}
	
	public void goToDesk() {
		
	}
	
	public void goToAssist() {
		
	}
	
	
	public void goToBooks() {
		
	}
	
	
	public void goToAnalytics() {
		
	}
	
	
	public void goToCreator() {
		
	}
	
	
	public void goToSocial() {
		
	}
	
	public void verifyHeaders() {
		
	}

}
