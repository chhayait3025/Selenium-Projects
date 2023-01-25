package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.basepage.BasePage;

public class HomePage extends BasePage{
	
	
		public LoginPage goToLogin() {
			
			    click("logInbtn_XPATH");
			    
			return new LoginPage();
		}
		
		
		public void goToSignUp() {
			
			driver.findElement(By.xpath("//div[@class='signupcontainer']//a[@class='signUp']")).click();
		}
		
		public void goToSearch() {
			
			
		}
		public void goToLanguage() {
			
		}
		
		public void goToGetStartedForFree() {
	}
		
		
}

	


	


