package com.w2a.basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.pages.CRMAccountsPage;

public class CRMTopMenu {
	
	WebDriver driver;
	
	public CRMTopMenu(WebDriver driver) {
		
		this.driver = driver;
	}

	
       public void goToLeads() {
		
	}
	
       public void goToContacts() {
		
	}


       public CRMAccountsPage goToAccounts() {
	
	   driver.findElement(By.xpath("//div[@class=' lyteItem']//a[contains(text(),'Accounts')]")).click();
	     
	   return new CRMAccountsPage();
	
}



         public void goToDeals() {
	
}



        public void goToTasks() {
	
}



        public void goToMeetings() {
	
}



       public void goToCalls() {
	
}



        public void goToReports() {
	
}



        public void goToAnalytics() {
	
}

}


