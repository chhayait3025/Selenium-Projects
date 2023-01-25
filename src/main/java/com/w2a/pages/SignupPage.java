package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.basepage.BasePage;

public class SignupPage extends BasePage{
	
	public void doSignUp(String email,String password) {
		    
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		WebElement tncCheckbox = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		
		if(!tncCheckbox.isSelected()) {
			
			tncCheckbox.click();
		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
