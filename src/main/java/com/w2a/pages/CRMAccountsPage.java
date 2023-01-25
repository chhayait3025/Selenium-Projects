package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.basepage.BasePage;

public class CRMAccountsPage extends BasePage{
	
	
	public CreateAccountsPage goToCreateAccount() {
		
	 click("createaccountbtn_XPATH");
		
		return new CreateAccountsPage();
	}
    public void goToImportAccounts() {
		
	}
    
    public void goToDisableModule() {
    	
    	
    }
}
