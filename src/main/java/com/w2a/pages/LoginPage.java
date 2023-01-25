package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.basepage.BasePage;

public class LoginPage extends BasePage{
	
	
	
	public ZohoAppPage doLogin(String username,String password) {
		
		type("logintext_XPATH",username);
		click("nextbtn_XPATH");
		type("pwdtext_XPATH",password);
        click("signInbtn_XPATH");
		
		return new ZohoAppPage();
	
		

	}
	
	public void goToForgotPwd() {
}
	
	public void goToLearnMore() {
		
	}
	
	}

