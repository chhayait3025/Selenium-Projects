package com.w2a.pages;


import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.w2a.basepage.BasePage;

public class CreateAccountsPage extends BasePage{
	
	
	public void createAccount(Hashtable<String,String> data) {
		
		//type("actnametext_XPATH",data.get("AccountName"));	
		//type("actsitetext_XPATH",data.get("actsite"));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"Crm_Accounts_RATING\"]"))));
		element.click();
		
		//WebElement dropdown = null;
//		Select select = new Select(dropdown);
//		select.selectByVisibleText("Acquired");
		
		//sendKeys(data.get("rating"));
		//type("ratingdrp_XPATH",data.get("rating"));
//		type("phonetext_XPATH",data.get("phone"));
//		type("actnumbtext_XPATH",data.get("actnumber"));
//		select("acttype_XPATH",data.get("acttype"));
//		select("industry_XPATH",data.get("industry"));
//		type("annualrev_XPATH",data.get("annualrev"));
//		type("tickersym_XPATH",data.get("ticketsymbol"));
//		select("ownership_XPATH",data.get("ownership"));
//		type("employees_XPATH",data.get("employee"));
//		type("sidcode_XPATH",data.get("sidcode"));
	}

}
